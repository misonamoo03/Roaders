package com.misonamoo.smileway.dao;

import java.util.List;

import com.misonamoo.smileway.domain.LocationVO;

public interface LocationDAO {

	public void insertLocation(LocationVO VO) throws Exception;

	public void updateLocation(LocationVO VO) throws Exception;

	public LocationVO selectLocation(String locationNumber) throws Exception;

	public List<LocationVO> listLocation(LocationVO vo);

	public int countPaging(LocationVO vo) throws Exception;

	public void delete(Integer locationNumber) throws Exception;

}
