package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.LocationDAO;
import com.misonamoo.smileway.dao.UserDAO;
import com.misonamoo.smileway.domain.LocationVO;
import com.misonamoo.smileway.domain.UserVO;

@Service
public class LocationServiceImpl implements LocationService {

	@Inject
	private LocationDAO locationDAO;


	@Override
	public void insertLocation(LocationVO locationVO) throws Exception {

		// String pass = userVO.getUSER_PW();
		// PasswordEncoder encoder = new BCryptPasswordEncoder();
		// userVO.setUSER_PW(encoder.encode(pass));

		locationDAO.insertLocation(locationVO);
	}

	@Override
	public void updateLocation(LocationVO locationVO) throws Exception {
		locationDAO.updateLocation(locationVO);
	}
	
	@Override
	public LocationVO selectLocation(String locationNumber) throws Exception {
		return locationDAO.selectLocation(locationNumber);
	}

	@Override
	public List<LocationVO> listLocation(LocationVO vo) {
		return locationDAO.listLocation(vo);

	}
	@Override
	public int listCountLocation(LocationVO vo) throws Exception {
		
		return locationDAO.countPaging(vo);
	}

	@Override
	public void remove(Integer locationNumber) throws Exception {
		// TODO Auto-generated method stub
		locationDAO.delete(locationNumber);
	}
	

}
