package com.misonamoo.smileway.dao;

import java.util.List;

import com.misonamoo.smileway.domain.DetailReviewVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.BaseCriteria;
import com.misonamoo.smileway.domain.ReviewVO;

public interface ReviewDAO {

	
	public List<ReviewVO>  reviewRead(ReviewVO vo) throws Exception;

	public int countReview(ReviewVO vo)throws Exception;
	
	public RUserVO  ruserRead(ReviewVO vo) throws Exception;
}
