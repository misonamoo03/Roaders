package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.DetailReviewDAO;
import com.misonamoo.smileway.domain.DetailReviewVO;

@Service
public class DetailReviewServiceImpl implements DetailReviewService {

	@Inject
	private DetailReviewDAO detailReviewDAO;

	
	@Override
	public List<DetailReviewVO> detailReviewRead(int reviewNumber) throws Exception {
		return detailReviewDAO.detailReviewRead(reviewNumber);
	}

}
