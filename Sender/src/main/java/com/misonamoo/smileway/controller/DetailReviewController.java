package com.misonamoo.smileway.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.misonamoo.smileway.domain.DetailReviewVO;
import com.misonamoo.smileway.service.DetailReviewService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DetailReviewController {
	@Inject
	DetailReviewService detailReviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(DetailReviewController.class);
	
	@RequestMapping(value="detailReview/detailReviewPopup", method = RequestMethod.GET)
	public String detailRead(@RequestParam("reviewNumber") int reviewNumber, Model model) throws Exception {
		
		logger.info("작동"+reviewNumber);
		/*DetailReviewVO detailReviewVO = detailReviewService.detailReviewRead(reviewNumber);
		if(detailReviewVO != null) {
			model.addAttribute(detailReviewVO);
		}*/
		List<DetailReviewVO> list = detailReviewService.detailReviewRead(reviewNumber);
		logger.info("///"+list.size());
		model.addAttribute("review", list);
		logger.info("$$$$$$$$$$$$$"+ model.getAttribute("review").toString());
		
		return "/detailReview/detailReviewPopup";
	}

}
