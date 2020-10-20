
package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.ItemVO;
import com.misonamoo.smileway.domain.SearchCriteria;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.misonamoo.smileway.mapper.ItemMapper";
	
	//카테고리 등록
	@Override
	public void insertCataGory(ItemVO vo) throws Exception {
		session.insert(namespace+".insertCatagory",vo);

	}
	
	//카테고리 조회
	@Override
	public List<ItemVO> catagoryList(ItemVO vo) throws Exception {
		
		return session.selectList(namespace+".catagoryList",vo);
	}

	//상품 등록
	@Override
	public void registItem(ItemVO vo) throws Exception {
		session.insert(namespace+".registItem",vo);
		
	}

	/**
	//상품 조회
	@Override
	public List<ItemVO> listItem(int page) throws Exception {
		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page -1) * 10;
		
		return session.selectList(namespace+".listItem");
	}
	*/
	
	/**
	// 페이징 처리 상품 목록
	@Override
	public List<ItemVO> listItem(Criteria cri) throws Exception {
		
		return session.selectList(namespace+".listItem", cri);
	}

	@Override
	public int countItem(Criteria cri) throws Exception {
		
		return session.selectOne(namespace+".countItem", cri);
	}
	*/
	
	// 상품 조회 +페이징 + 검색
	@Override
	public List<ItemVO> listItem(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace+".listItem",cri);
	}

	@Override
	public int countItem(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace+".countItem", cri);
	}
	
	// 상품 삭제
	@Override
	public void removeItemList(int ITEM_NO) throws Exception {
		session.delete(namespace+".removeItemList",ITEM_NO);
		
	}
	
	// 상품 목록 수정 조회
	@Override
	public ItemVO itemRead(int ITEM_NO) throws Exception {
		
		return session.selectOne(namespace+".itemRead",ITEM_NO);
	}
	
	//상품 수정
	@Override
	public void modifyItem(ItemVO vo) throws Exception {
		
		session.update(namespace+".modifyItem",vo);
	}

	//상품 팝업 조회
	@Override
	public List<ItemVO> listItemPop(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listItemPop",cri);
	}

}
