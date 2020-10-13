package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.CodeVO;
import com.misonamoo.smileway.domain.PointVO;
import com.misonamoo.smileway.domain.RUserVO;

@Repository
public class RUserDAOImpl implements RUserDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "com.misonamoo.smileway.mapper.RUserMapper";

	@Override
	public RUserVO login(RUserVO VO) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".login", VO);
	}

	@Override
	public int checkId(RUserVO VO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkId", VO);
	}

	@Override
	public int checkEmail(RUserVO VO) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkEmail", VO);
	}

	@Override
	public void signUp(RUserVO VO) throws Exception {
		session.insert(namespace + ".signUp", VO);
	}
	
	@Override
	public void update(RUserVO VO) throws Exception {
		session.update(namespace + ".update", VO);
	}

	@Override
	public RUserVO read(String ruserId) throws Exception {
		return session.selectOne(namespace + ".read", ruserId);
	}

	@Override
	public RUserVO idChk(RUserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".idChk", vo);
	}

	@Override
	public RUserVO getPw(RUserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getPw", vo);
	}

	@Override
	public String pointRead(String id) throws Exception {
		return session.selectOne(namespace + ".pointRead", id);
	}

	@Override
	public void pointUpdate(RUserVO VO) throws Exception {
		session.update(namespace + ".pointUpdate", VO);
	}

	@Override
	public String getRuserNo(String id) throws Exception {
		return session.selectOne(namespace + ".getRuserNo", id);
	}

	@Override
	public List<PointVO> getReviewHistory(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getReviewHistory", id);
	}

	@Override
	public void insertReview(PointVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insertReview", vo);
	}

	@Override
	public int cheackNo(CodeVO cv) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".cheackNo", cv);
	}

	@Override
	public void insertCode(CodeVO cv) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insertCode", cv);
	}

	@Override
	public CodeVO readCode(CodeVO cv) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".readCode", cv);
	}
	
	@Override
	public String getSecNo(String cv) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getSecNo", cv);
	}
	
	@Override
	public int cheackCode(CodeVO cv) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".cheackCode", cv);
	}


	@Override
	public void updatePw(RUserVO rvo) throws Exception {
		session.update(namespace + ".updatePw", rvo);
	}
}
