package com.misonamoo.smileway.dao;

import java.util.List;

import com.misonamoo.smileway.domain.DetailReviewVO;

public interface DetailReviewDAO {

	
	public List<DetailReviewVO>  detailReviewRead(int detailNumber) throws Exception;

}
