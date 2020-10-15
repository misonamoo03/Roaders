package com.misonamoo.smileway.service;

import java.util.List;

import com.misonamoo.smileway.domain.DetailReviewVO;
import com.misonamoo.smileway.domain.LocationVO;

public interface DetailReviewService {

	public List<DetailReviewVO> detailReviewRead(int reviewNumber) throws Exception;
	
}
