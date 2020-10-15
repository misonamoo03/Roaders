package com.misonamoo.smileway.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "com.misonamoo.smileway.mapper.UserMapper";

	@Override
	public UserVO login(UserVO VO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".login", VO);
	}

	@Override
	public int checkId(UserVO VO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkId", VO);
	}

	@Override
	public int checkEmail(UserVO VO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkEmail", VO);
	}

	@Override
	public void signUp(UserVO VO) throws Exception {
		session.insert(namespace + ".signUp", VO);

	}

	@Override
	public void update(UserVO VO) throws Exception {
		session.update(namespace + ".update", VO);
	}

	@Override
	public UserVO read(String SUSER_ID) throws Exception {
		return session.selectOne(namespace + ".read", SUSER_ID);
	}

}
