package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.DetailReviewVO;

@Repository
public class DetailReviewDAOImpl implements DetailReviewDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.misonamoo.smileway.mapper.DetailReviewMapper";
	@Override
	public List<DetailReviewVO> detailReviewRead(int detailNumber) throws Exception {
		
		return session.selectList(namespace + ".deTailReviewRead", detailNumber);
	}

	

}
