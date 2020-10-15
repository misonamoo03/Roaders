package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.DetailReviewVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.BaseCriteria;
import com.misonamoo.smileway.domain.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Inject
	private SqlSession session;
	
/*
	private static String namespace = "com.misonamoo.smileway.mapper.ReviewMapper";
	@Override
	public List<DetailReviewVO> reviewRead(String ruserId) throws Exception {
		
		return session.selectList(namespace + ".reviewRead", ruserId);
	}*/
	private static String namespace = "com.misonamoo.smileway.mapper.ReviewMapper";
	@Override
	public List<ReviewVO> reviewRead(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".reviewRead", vo);
	}
	
	
	@Override
	public int countReview(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countReview", vo);
	}


	@Override
	public RUserVO ruserRead(ReviewVO vo) throws Exception {
		// 
		return session.selectOne(namespace + ".ruserRead", vo);
	}




}
