package com.misonamoo.smileway.service;

import java.util.List;

import com.misonamoo.smileway.domain.DeliveryListVO;
import com.misonamoo.smileway.domain.DeliveryVO;

public interface DeliveryService {
	/**
	 * 배송 목록을 조회하는 인터페이스
	 * @return
	 * @throws Exception
	 */
	public List<DeliveryListVO> deliveryList()throws Exception;
	
	/**
	 * 위도 경도를 구하기 위한 메서드
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public List<DeliveryListVO> selectPoint(DeliveryListVO vo)throws Exception;

	public DeliveryVO deliveryDetail(int deliveryNumber) throws Exception;

	public void requestDelivery(DeliveryVO deliveryVO) throws Exception;

	public void deliveryHistory(DeliveryVO deliveryVO) throws Exception;

	public void pickupHistory(DeliveryVO deliveryVO) throws Exception;
	
	public void updatePickupDelState(DeliveryVO deliveryVO) throws Exception;

	public void completeDelHistory(DeliveryVO deliveryVO) throws Exception;

	public void updatecompleteDelState(DeliveryVO deliveryVO) throws Exception;

	public void reviewKindly(DeliveryVO deliveryVO) throws Exception;

	public void reviewPromise(DeliveryVO deliveryVO) throws Exception;

	public void reviewTotal(DeliveryVO deliveryVO) throws Exception;

	public void reviewDelState(DeliveryVO deliveryVO) throws Exception;

	public void updateReviewDelState(DeliveryVO deliveryVO) throws Exception;

	public void updateTotalReview(DeliveryVO deliveryVO) throws Exception;
	

}
