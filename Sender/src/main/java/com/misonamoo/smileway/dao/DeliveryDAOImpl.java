package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.DeliveryVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.ReviewVO;
import com.misonamoo.smileway.domain.SearchCriteria;

@Repository
public class DeliveryDAOImpl implements DeliveryDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.misonamoo.smileway.mapper.DeliveryMapper";

	@Override
	public void registDelItem(DeliveryVO deliveryItemVO) throws Exception {
		session.insert(namespace+".registDelItem",deliveryItemVO);		
	}

	@Override
	public void registDelLocationDepart(DeliveryVO deliveryVO) throws Exception {
		session.insert(namespace+".registDelLocationDepart",deliveryVO);
	}
	
	@Override
	public void registDelLocationArrival(DeliveryVO deliveryVO) throws Exception {
		session.insert(namespace+".registDelLocationArrival",deliveryVO);
	}


	@Override
	public void registDelInfo(DeliveryVO deliveryVO) throws Exception {
		session.insert(namespace+".registDelInfo",deliveryVO);
	}
	
	@Override
	public void registDelMethod(DeliveryVO deliveryVO) throws Exception {
		session.insert(namespace+".registDelMethod",deliveryVO);
	}

	@Override
	public List<DeliveryVO> deliveryList(Criteria cri) throws Exception {
		return session.selectList(namespace+".deliveryList", cri);
	}

	@Override
	public int countDelivery(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".countDelivery", cri);
	}

	@Override
	public DeliveryVO deliveryDetail(int DELIVERY_NUMBER) throws Exception {
		return session.selectOne(namespace+".deliveryDetail", DELIVERY_NUMBER);
	}

	@Override
	public RUserVO deliveryRoder(int DELIVERY_NUMBER) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".deliveryRoder", DELIVERY_NUMBER);
	}

	@Override
	public void deleteDelItem(int DELIVERY_NUMBER) throws Exception {
		session.delete(namespace+".deleteDelItem",DELIVERY_NUMBER);
	}

	@Override
	public void deleteDelLocation(int DELIVERY_NUMBER) throws Exception {
		session.delete(namespace+".deleteDelLocation",DELIVERY_NUMBER);
	}

	@Override
	public void deleteDelInfo(int DELIVERY_NUMBER) throws Exception {
		session.delete(namespace+".deleteDelItem",DELIVERY_NUMBER);
	}
	
	// 로더 지원 목록 팝업
	@Override
	public List<RUserVO> openApplyRoaderPop(RUserVO vo) throws Exception {
		
		return session.selectList(namespace+".openApplyRoaderPop",vo);
	}
	
	/**
	 * 배송 타임라인 회원정보 출력부분
	 */
	@Override
	public DeliveryVO readSuser(DeliveryVO vo) throws Exception {
		
		return session.selectOne(namespace+".readSuser",vo);
	}
	
	// 배송 타임라인 팝업(히스토리 부분)
	@Override
	public List<DeliveryVO> delHistory(DeliveryVO vo) throws Exception {
		
		return session.selectList(namespace+".delHistory",vo);
	}

	
	
	

	@Override
	public void updateDelItem(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateDelItem",deliveryVO);
	}

	@Override
	public void updateDelLocationDepart(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateDelLocationDepart",deliveryVO);
	}

	@Override
	public void updateDelLocationArrival(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateDelLocationArrival",deliveryVO);
	}

	@Override
	public void updateDelInfo(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateDelInfo",deliveryVO);
	}

	@Override
	public void updateDelMethod(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateDelMethod",deliveryVO);
	}

	//히스토리에 픽업요청 히스토리 추가
	@Override
	public void regRequestPickUp(DeliveryVO deliveryVO) throws Exception {
		session.insert(namespace+".regRequestPickUp",deliveryVO);
	}
	//배송정보에 배송상태 변경
	@Override
	public void updateDelRequestPickUp(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateDelRequestPickUp",deliveryVO);
	}
	
	//DELIVERY_CANDIDATE 배송상태 수정
	@Override
	public void updateRoderRequestPickUp(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateRoderRequestPickUp",deliveryVO);
	}

	//DEL_STATE_HISTORY 픽업 승인 히스토리 추가
	@Override
	public void regApprovePickUp(DeliveryVO deliveryVO) throws Exception {
		session.insert(namespace+".regApprovePickUp",deliveryVO);
	}

	//DELIVERY_MAN 배송상태 수정
	@Override
	public void updateApprovePickUp(DeliveryVO deliveryVO) throws Exception {
		session.update(namespace+".updateApprovePickUp",deliveryVO);
	}
	//DETAIL_REVIEW_MAN 등록
	@Override
	public void registTotalReview(DeliveryVO deliveryVO) {
		session.insert(namespace+".registTotalReview", deliveryVO);
	}
}
