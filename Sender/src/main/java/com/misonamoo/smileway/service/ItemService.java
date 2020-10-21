package com.misonamoo.smileway.service;

import java.util.List;

import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.SearchCriteria;

public interface ItemService {
	
	//카테고리 등록
	public void registCatagory(ItemVO item)throws Exception;
	
	//카테고리 조회
	public List<ItemVO> catagoryList(ItemVO vo)throws Exception;
	
	//상품 등록
	public void registItem(ItemVO item)throws Exception;
	
	/**
	//상품 조회
	public List<ItemVO> listItem()throws Exception;
	*/
	
	/**
	//페이징 처리 상품 조회
	public List<ItemVO> listItem(Criteria cri)throws Exception;
	
	//전체 상품수 세기
	public int countItem(Criteria cri)throws Exception;
	*/
	
	//페이징 처리 상품 조회 + 검색
	public List<ItemVO> listItem(SearchCriteria cri)throws Exception;
		
	//전체 상품수 세기 + 검색
	public int countItem(SearchCriteria cri)throws Exception;
	
	//상품 삭제
	public void removeItemList(int ITEM_NO)throws Exception;
	
	//상품 목록 수정페이지 (조회)
	public ItemVO itemRead(int ITEM_NO) throws Exception;
	
	//상품 수정
	public void modifyItem(ItemVO item)throws Exception;

	//상품 팝업 리스트
	public List<ItemVO> listItemPop(SearchCriteria cri) throws Exception;

}
