package com.misonamoo.smileway.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.UserDAO;
import com.misonamoo.smileway.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO UserDao;

	@Override
	public UserVO login(UserVO userVO) throws Exception {
		return UserDao.login(userVO);
	}

	@Override
	public int checkId(UserVO userVO) throws Exception {
		int result = UserDao.checkId(userVO);
		return result;
	}

	@Override
	public int checkEmail(UserVO userVO) throws Exception {

		int result = UserDao.checkEmail(userVO);
		return result;
	}

	@Override
	public void signUp(UserVO userVO) throws Exception {

		// String pass = userVO.getUSER_PW();
		// PasswordEncoder encoder = new BCryptPasswordEncoder();
		// userVO.setUSER_PW(encoder.encode(pass));

		UserDao.signUp(userVO);
	}

	@Override
	public void modify(UserVO userVO) throws Exception {
		UserDao.update(userVO);
	}
	
	@Override
	public UserVO read(String SUSER_ID) throws Exception {
		return UserDao.read(SUSER_ID);
	}

}
