package com.misonamoo.smileway.dao;

import java.util.List;

import com.misonamoo.smileway.domain.CodeVO;
import com.misonamoo.smileway.domain.PointVO;
import com.misonamoo.smileway.domain.RUserVO;

public interface RUserDAO {
	public RUserVO login(RUserVO VO) throws Exception;

	public int checkId(RUserVO VO) throws Exception;

	public int checkEmail(RUserVO VO) throws Exception;

	public void signUp(RUserVO VO) throws Exception;

	public void update(RUserVO VO) throws Exception;
	
	public RUserVO read(String ruserId) throws Exception;

	public RUserVO idChk(RUserVO vo) throws Exception;

	public RUserVO getPw(RUserVO vo) throws Exception;

	public String pointRead(String id) throws Exception;

	public void pointUpdate(RUserVO VO) throws Exception;

	public String getRuserNo(String id) throws Exception;

	public List<PointVO> getReviewHistory(String id) throws Exception;

	public void insertReview(PointVO vo) throws Exception;

	public int cheackNo(CodeVO cv) throws Exception;

	public void insertCode(CodeVO cv);

	public CodeVO readCode(CodeVO cv) throws Exception;

	public String getSecNo(String cv) throws Exception;

	public int cheackCode(CodeVO cv) throws Exception;

	public void updatePw(RUserVO rvo) throws Exception;
}
