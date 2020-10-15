package com.misonamoo.smileway.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.misonamoo.smileway.domain.DetailReviewVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.ReviewPageMaker;
import com.misonamoo.smileway.domain.ReviewVO;
import com.misonamoo.smileway.service.DetailReviewService;
import com.misonamoo.smileway.service.ReviewService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReviewController {
	@Inject
	ReviewService reviewService;
	@Inject
	DetailReviewService detailReviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@RequestMapping(value="review/reviewPopup", method = RequestMethod.GET)
	public String detailRead(@ModelAttribute ReviewVO vo,  Model model) throws Exception {
		logger.info("작동"+vo.getRuserId());
		
		//로더ID롷 로더정보 조회
		 RUserVO ruvo = reviewService.ruserRead(vo);
		 model.addAttribute("ruvo",ruvo);
		//로더ID로 리뷰리스트 조회
		List<ReviewVO> list = reviewService.reviewRead(vo);

		//리뷰 별점을 조회하기 위해서 리뷰목록을 루프함
		for(ReviewVO lst : list) {
			//리뷰번호로 리뷰별점리스트를 조회
			List<DetailReviewVO> detailReviewVOList = detailReviewService.detailReviewRead(lst.getReviewNumber());
			//리뷰별점리스트를 ReviewVO의 StarScoreList에 담는다.
			lst.setStarScoreList(detailReviewVOList);
			
			logger.info("vvvvvvvvvvvv"+lst.getReviewContent());
		}
		logger.info("///"+list.size());
		model.addAttribute("review", list);
		ReviewPageMaker pageMaker = new ReviewPageMaker(vo.getPage(), vo.getPerPageNum());
		//pageMaker.setCri(vo.getCri());
		pageMaker.setTotalCount(reviewService.countReview(vo));
		model.addAttribute("pageMaker",pageMaker);
		model.addAttribute("ruserId",vo.getRuserId());
		//logger.info("$$$$$$$$$$$$$"+ model.getAttribute("review").toString());
		return "/review/reviewPopup";
	}

}
