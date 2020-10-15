package com.misonamoo.smileway.dao;

import java.util.List;

import com.misonamoo.smileway.domain.UserVO;

public interface UserDAO {

	public UserVO login(UserVO VO) throws Exception;
	
	public int checkId(UserVO VO) throws Exception;

	public int checkEmail(UserVO VO) throws Exception;
	
	public void signUp(UserVO VO)throws Exception;

	public void update(UserVO VO) throws Exception;
	
	public UserVO read(String SUSER_ID) throws Exception;

}
