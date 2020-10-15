package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.ReviewDAO;
import com.misonamoo.smileway.domain.DetailReviewVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.BaseCriteria;
import com.misonamoo.smileway.domain.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Inject
	private ReviewDAO reviewDAO;

	
	@Override
	public List<ReviewVO> reviewRead(ReviewVO vo) throws Exception {
		return reviewDAO.reviewRead(vo);
	}
	@Override
	public int countReview(ReviewVO vo) throws Exception {
		
		return reviewDAO.countReview(vo);
	}
	@Override
	public RUserVO ruserRead(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.ruserRead(vo);
	}
}
