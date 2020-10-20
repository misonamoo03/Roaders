package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.ItemDAO;
import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.SearchCriteria;

@Service
public class ItemServiceImpl implements ItemService {

	@Inject
	private ItemDAO dao;
	
	//카테고리 등록
	@Override
	public void registCatagory(ItemVO item) throws Exception {
		dao.insertCataGory(item);

	}

	//카테고리 조회
	@Override
	public List<ItemVO> catagoryList(ItemVO vo) throws Exception {
		
		return dao.catagoryList(vo);
	}

	//상품 등록
	@Override
	public void registItem(ItemVO item) throws Exception {
		dao.registItem(item);
		
	}

	/**
	//상품 조회
	@Override
	public List<ItemVO> listItem() throws Exception {
		return dao.listItem();
	}
	*/
	
	/**
	//페이징 처리 상품 조회
	@Override
	public List<ItemVO> listItem(Criteria cri) throws Exception {
		
		return dao.listItem(cri);
	}

	@Override
	public int countItem(Criteria cri) throws Exception {
		
		return dao.countItem(cri);
	}
	*/
	
	//상품 조회 페이징까지
	@Override
	public List<ItemVO> listItem(SearchCriteria cri) throws Exception {
		
		return dao.listItem(cri);
	}

	@Override
	public int countItem(SearchCriteria cri) throws Exception {
		
		return dao.countItem(cri);
	}
	
	//상품 목록 삭제
	@Override
	public void removeItemList(int ITEM_NO) throws Exception {
		dao.removeItemList(ITEM_NO);
	}
	
	//상품 수정 목록 페이지 조회
	@Override
	public ItemVO itemRead(int ITEM_NO) throws Exception {
		
		return dao.itemRead(ITEM_NO);
	}
	
	//상품 수정
	@Override
	public void modifyItem(ItemVO item) throws Exception {
		
		dao.modifyItem(item);
	}

	//상품 팝업 조회
	@Override
	public List<ItemVO> listItemPop(SearchCriteria cri) throws Exception {
		
		return dao.listItemPop(cri);
	}

}
