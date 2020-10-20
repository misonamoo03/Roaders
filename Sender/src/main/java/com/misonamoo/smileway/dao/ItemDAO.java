package com.misonamoo.smileway.dao;


import java.util.List;

import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.SearchCriteria;

public interface ItemDAO {

	//카테고리 등록
	public void insertCataGory(ItemVO vo)throws Exception;
	
	//카테고리 목록 출력
	public List<ItemVO> catagoryList()throws Exception;	
	
	//상품 등록
	public void registItem(ItemVO vo)throws Exception;
	
	/**
	//상품 목록
	public List<ItemVO> listItem(int page)throws Exception;
	*/
	
	/**
	//페이징처리 상품 목록
	public List<ItemVO> listItem(Criteria cri)throws Exception;
	
	//페이징을 위해서 전체 등록 상품수 세기
	public int countItem(Criteria cri)throws Exception;
	*/
	
	//페이징처리 상품 목록 +검색
	public List<ItemVO> listItem(SearchCriteria cri)throws Exception;
		
	//페이징을 위해서 전체 등록 상품수 세기 +검색
	public int countItem(SearchCriteria cri)throws Exception;
	
	//상품 목록 수정
	public ItemVO itemRead(int ITEM_NO)throws Exception;
	
	//상품 수정
	public void modifyItem(ItemVO vo)throws Exception;
	
	//상품 목록 삭제
	public void removeItemList(int ITEM_NO)throws Exception;

	//상품 팝업 조회
	public List<ItemVO> listItemPop(SearchCriteria cri) throws Exception;

	
}
