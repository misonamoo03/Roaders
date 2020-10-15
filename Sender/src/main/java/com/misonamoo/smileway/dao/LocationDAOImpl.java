package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.LocationVO;
import com.misonamoo.smileway.domain.UserVO;

@Repository
public class LocationDAOImpl implements LocationDAO {
	@Inject
	private SqlSession session;
	private static String namespace = "com.misonamoo.smileway.mapper.LocationManMapper";

	
	@Override
	public void insertLocation(LocationVO VO) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insertLocation", VO);
	}

	@Override
	public void updateLocation(LocationVO VO) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateLocation", VO);
	}

	@Override
	public LocationVO selectLocation(String locationNumber) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".selectLocation", locationNumber);
	}

	@Override
	public List<LocationVO> listLocation(LocationVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listLocation", vo);
	}
	
	@Override
	public int countPaging(LocationVO vo) throws Exception {
		return session.selectOne(namespace +".countPaging", vo);
	}

	@Override
	public void delete(Integer locationNumber) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", locationNumber);
	}

}
