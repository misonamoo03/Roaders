package com.misonamoo.smileway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.misonamoo.smileway.domain.PointVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.service.RUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PointController {
	@Inject
	private RUserService RUserService;

	private static final Logger logger = LoggerFactory.getLogger(PointController.class);

	@RequestMapping(value = "/PointPage", method = RequestMethod.GET)
	public String pointPage(@RequestParam("ruserId") String ruserId) {
		return "Point/PointPage";
	}

	@RequestMapping(value = "/pointRead", method = RequestMethod.GET)
	@ResponseBody
	public Map pointRead(@RequestParam("ruserId") String ruserId) throws Exception {
		RUserVO vo = new RUserVO();
		vo.setRuserId(ruserId);
		vo.setRuserPoint(RUserService.pointRead(vo.getRuserId()));
		int ruserPoint = Integer.parseInt(vo.getRuserPoint());
		Map result = new HashMap<String, Object>();
		result.put("ruserId", ruserId);
		result.put("ruserPoint", ruserPoint);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "/pointUpdate", method = RequestMethod.POST)
	public void pointUpdate(@RequestBody RUserVO vo) throws Exception {
		RUserVO rvo = new RUserVO();
		rvo.setRuserId(vo.getRuserId());
		rvo.setRuserPoint(vo.getRuserPoint());
		RUserService.pointUpdate(rvo);
	}
	@ResponseBody
	@RequestMapping(value = "/reviewUpdate", method = RequestMethod.POST)
	public void reviewUpdate(@RequestBody PointVO vo) throws Exception {
		System.out.println("reason:::::::"+vo.getReason());
		RUserService.insertReview(vo);
	}
	@ResponseBody
	@RequestMapping(value = "/reviewHistory", method = RequestMethod.POST)
	public List<PointVO> reviewHistory(@RequestBody Map<String, Object> param) throws Exception {
		String ruserId = param.get("ruserId").toString();
		PointVO pvo = new PointVO();
		pvo.setRuserId(ruserId);
		return RUserService.getReviewHistory(pvo.getRuserId().toString());
	}
}
