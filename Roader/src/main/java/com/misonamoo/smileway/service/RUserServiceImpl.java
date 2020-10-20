package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.RUserDAO;
import com.misonamoo.smileway.domain.CodeVO;
import com.misonamoo.smileway.domain.PointVO;
import com.misonamoo.smileway.domain.RUserVO;

@Service
public class RUserServiceImpl implements RUserService {
	@Inject
	private RUserDAO RUserDao;

	@Override
	public RUserVO login(RUserVO vo) throws Exception {
		return RUserDao.login(vo);
	}

	@Override
	public int checkId(RUserVO vo) throws Exception {
		int result = RUserDao.checkId(vo);
		return result;
	}
	
	@Override
	public int checkPw(RUserVO vo) throws Exception {
		int result = RUserDao.checkPw(vo);
		return result;
	}

	@Override
	public int checkEmail(RUserVO vo) throws Exception {
		int result = RUserDao.checkEmail(vo);
		return result;
	}

	@Override
	public void signUp(RUserVO vo) throws Exception {
		RUserDao.signUp(vo);
	}

	@Override
	public RUserVO read(String ruserId) throws Exception {
		return RUserDao.read(ruserId);
	}
	
	@Override
	public void modify(RUserVO vo) throws Exception {
		RUserDao.update(vo);
	}
	
	
	@Override
	public RUserVO idChk(RUserVO vo) throws Exception {
		return RUserDao.idChk(vo);
	}

	@Override
	public RUserVO getPw(RUserVO vo) throws Exception {
		return RUserDao.getPw(vo);
	}

	@Override
	public String pointRead(String id) throws Exception {
		return RUserDao.pointRead(id);
	}

	@Override
	public void pointUpdate(RUserVO vo) throws Exception {
		// TODO Auto-generated method stub
		RUserDao.pointUpdate(vo);
	}

	@Override
	public String getRuserNo(String id) throws Exception {
		return RUserDao.getRuserNo(id);
	}

	@Override
	public List<PointVO> getReviewHistory(String id) throws Exception {
		// TODO Auto-generated method stub
		return RUserDao.getReviewHistory(id);
	}

	@Override
	public void insertReview(PointVO vo) throws Exception {
		// TODO Auto-generated method stub
		RUserDao.insertReview(vo);
	}

	@Override
	public int cheackNo(CodeVO cv) throws Exception {
		int result = RUserDao.cheackNo(cv);
		return result;
	}

	@Override
	public void insertCode(CodeVO cv) {
		RUserDao.insertCode(cv);
	}

	@Override
	public CodeVO readCode(CodeVO cv) throws Exception {
		// TODO Auto-generated method stub
		return RUserDao.readCode(cv);
	}
	@Override
	public String getSecNo(String cv) throws Exception {
		// TODO Auto-generated method stub
		return RUserDao.getSecNo(cv);
	}
	
	@Override
	public int cheackCode(CodeVO cv) throws Exception {
		// TODO Auto-generated method stub
		int result = RUserDao.cheackCode(cv);
		return result;
	}
	

	@Override
	public void updatePw(RUserVO rvo) throws Exception {
		// TODO Auto-generated method stub
		RUserDao.updatePw(rvo);
	}

	@Override
	public String orgPw(String secNo) throws Exception {
		// TODO Auto-generated method stub\
		
		return RUserDao.orgPw(secNo);
	}
}
