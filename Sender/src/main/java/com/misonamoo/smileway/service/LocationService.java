package com.misonamoo.smileway.service;

import java.util.List;

import com.misonamoo.smileway.domain.LocationVO;
import com.misonamoo.smileway.domain.UserVO;

public interface LocationService {
	
	public void insertLocation(LocationVO locationVO) throws Exception;
	
	public LocationVO selectLocation(String locationNumber) throws Exception;
	
	public void updateLocation(LocationVO locationVO) throws Exception;

	public List<LocationVO> listLocation(LocationVO vo);
	
	public int listCountLocation(LocationVO vo) throws Exception;

	public void remove(Integer locationNumber) throws Exception;
}
	