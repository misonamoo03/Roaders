package com.misonamoo.smileway.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.misonamoo.smileway.domain.DeliveryListVO;
import com.misonamoo.smileway.domain.DeliveryVO;

@Repository
public class DeliveryDAOImpl implements DeliveryDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.misonamoo.smileway.mapper.DeliveryMapper";
	
	/**
	 * 배송 목록 출력하기
	 */
	@Override
	public List<DeliveryListVO> deliveryList() throws Exception {
		
		return session.selectList(namespace+".deliveryList");
	}
	
	/**
	 * 위도 경도를 조회하는 메서드
	 */
	@Override
	public List<DeliveryListVO> selectPoint(DeliveryListVO vo) throws Exception {
		
		return session.selectList(namespace+".selectPoint",vo);
	}
	
	
	@Override
	public DeliveryVO deliveryDetail(int deliveryNumber) throws Exception {

		return session.selectOne(namespace+".deliveryDetail", deliveryNumber);
	}

	@Override
	public void requestDelivery(DeliveryVO deliveryVO) throws Exception {
		
		session.insert(namespace+".requestDelivery",deliveryVO);
	}

	@Override
	public void deliveryHistory(DeliveryVO deliveryVO) throws Exception {
		
		session.insert(namespace+".deliveryHistory",deliveryVO);
	}

	@Override
	public void pickupHistory(DeliveryVO deliveryVO) throws Exception {
		
		session.insert(namespace+".pickupHistory",deliveryVO);
	}

	@Override
	public void updatePickupDelState(DeliveryVO deliveryVO) throws Exception {
		
		session.update(namespace+".updatePickupDelState",deliveryVO);
	}

	@Override
	public void completeDelHistory(DeliveryVO deliveryVO) throws Exception {

		session.insert(namespace+".completeDelHistory",deliveryVO);
	}

	@Override
	public void updatecompleteDelState(DeliveryVO deliveryVO) throws Exception {
		
		session.update(namespace+".updatecompleteDelState",deliveryVO);
	}

	@Override
	public void reviewKindly(DeliveryVO deliveryVO) throws Exception {

		session.insert(namespace+".reviewKindly",deliveryVO);
	}

	@Override
	public void reviewPromise(DeliveryVO deliveryVO) throws Exception {

		session.insert(namespace+".reviewPromise",deliveryVO);
	}

	@Override
	public void reviewTotal(DeliveryVO deliveryVO) throws Exception {

		session.insert(namespace+".reviewTotal",deliveryVO);
	}

	@Override
	public void reviewDelState(DeliveryVO deliveryVO) throws Exception {

		session.insert(namespace+".reviewDelState",deliveryVO);
	}

	@Override
	public void updateReviewDelState(DeliveryVO deliveryVO) throws Exception {

		session.update(namespace+".updateReviewDelState",deliveryVO);
	}

	@Override
	public void updateTotalReview(DeliveryVO deliveryVO) throws Exception {

		session.update(namespace+".updateTotalReview",deliveryVO);
	}

	@Override
	public void updateDeliveryState(DeliveryVO deliveryVO) throws Exception {

		session.update(namespace+".updateDeliveryState",deliveryVO);
	}
	
	

}
