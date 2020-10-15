package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.DeliveryDAO;
import com.misonamoo.smileway.domain.DeliveryListVO;
import com.misonamoo.smileway.domain.DeliveryVO;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Inject
	private DeliveryDAO deliveryDao;
	
	/**
	 * 배송목록을 조회하기 
	 */
	@Override
	public List<DeliveryListVO> deliveryList() throws Exception {
		
		return deliveryDao.deliveryList();
	}
	
	/**
	 * 위도 경도를 조회하기
	 */
	@Override
	public List<DeliveryListVO> selectPoint(DeliveryListVO vo) throws Exception {
		
		return deliveryDao.selectPoint(vo);
	}

	@Override
	public DeliveryVO deliveryDetail(int deliveryNumber) throws Exception {

		return deliveryDao.deliveryDetail(deliveryNumber);
	}

	@Override
	public void requestDelivery(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.requestDelivery(deliveryVO);
	}

	@Override
	public void deliveryHistory(DeliveryVO deliveryVO) throws Exception {
		
		deliveryDao.deliveryHistory(deliveryVO);
	}

	@Override
	public void pickupHistory(DeliveryVO deliveryVO) throws Exception {
		
		deliveryDao.pickupHistory(deliveryVO);
	}

	@Override
	public void updatePickupDelState(DeliveryVO deliveryVO) throws Exception {
		
		deliveryDao.updatePickupDelState(deliveryVO);
	}

	@Override
	public void completeDelHistory(DeliveryVO deliveryVO) throws Exception {
		
		deliveryDao.completeDelHistory(deliveryVO);
	}

	@Override
	public void updatecompleteDelState(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.updatecompleteDelState(deliveryVO);
	}

	@Override
	public void reviewKindly(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.reviewKindly(deliveryVO);
	}

	@Override
	public void reviewPromise(DeliveryVO deliveryVO) throws Exception {
		
		deliveryDao.reviewPromise(deliveryVO);
	}

	@Override
	public void reviewTotal(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.reviewTotal(deliveryVO);
	}

	@Override
	public void reviewDelState(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.reviewDelState(deliveryVO);
	}

	@Override
	public void updateReviewDelState(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.updateReviewDelState(deliveryVO);
	}

	@Override
	public void updateTotalReview(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.updateTotalReview(deliveryVO);
	}

	@Override
	public void updateDeliveryState(DeliveryVO deliveryVO) throws Exception {

		deliveryDao.updateDeliveryState(deliveryVO);
	}
	
	
}
