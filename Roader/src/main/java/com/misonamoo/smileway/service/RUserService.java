package com.misonamoo.smileway.service;

import java.util.List;

import com.misonamoo.smileway.domain.CodeVO;
import com.misonamoo.smileway.domain.PointVO;
import com.misonamoo.smileway.domain.RUserVO;

public interface RUserService {
	public RUserVO login(RUserVO vo) throws Exception;

	public int checkId(RUserVO vo) throws Exception;

	public int checkEmail(RUserVO vo) throws Exception;

	public void signUp(RUserVO vo) throws Exception;
	
	public RUserVO read(String ruserId) throws Exception;
	
	public void modify(RUserVO vo) throws Exception;

	public RUserVO idChk(RUserVO vo) throws Exception;

	public RUserVO getPw(RUserVO vo) throws Exception;

	public String pointRead(String id) throws Exception;

	public void pointUpdate(RUserVO vo) throws Exception;

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
