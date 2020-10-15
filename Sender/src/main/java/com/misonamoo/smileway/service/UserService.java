package com.misonamoo.smileway.service;

import com.misonamoo.smileway.domain.UserVO;

public interface UserService {
	
	public UserVO login(UserVO uservo) throws Exception;

	public int checkId(UserVO userVO) throws Exception;

	public int checkEmail(UserVO userVO) throws Exception;

	public void signUp(UserVO userVO) throws Exception;
	
	public UserVO read(String SUSER_ID) throws Exception;
	
	public void modify(UserVO userVO) throws Exception;
}
