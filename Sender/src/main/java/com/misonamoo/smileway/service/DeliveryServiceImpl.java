package com.misonamoo.smileway.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.misonamoo.smileway.dao.DeliveryDAO;
import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.DeliveryVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.ReviewVO;
import com.misonamoo.smileway.domain.SearchCriteria;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	private static final String DELIVERY_NUMBER = null;
	@Inject
	private DeliveryDAO deliveryDao;

	@Override
	public void registDelItem(DeliveryVO deliveryItemVO) throws Exception {
		deliveryDao.registDelItem(deliveryItemVO);
		
	}
	
	@Override
	public void registDelLocationDepart(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.registDelLocationDepart(deliveryVO);
	}

	@Override
	public void registDelLocationArrival(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.registDelLocationArrival(deliveryVO);
	}

	@Override
	public void registDelInfo(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.registDelInfo(deliveryVO);
	}

	@Override
	public void registDelMethod(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.registDelMethod(deliveryVO);
	}

	@Override
	public List<DeliveryVO> deliveryList(Criteria cri) throws Exception {
		
		return deliveryDao.deliveryList(cri);
	}

	@Override
	public int countDelivery(SearchCriteria cri) throws Exception {
		
		return deliveryDao.countDelivery(cri);
	}

	@Override
	public DeliveryVO deliveryDetail(int DELIVERY_NUMBER) throws Exception {
		
		return deliveryDao.deliveryDetail(DELIVERY_NUMBER);
	}


	@Override
	public RUserVO deliveryRoder(int DELIVERY_NUMBER) throws Exception {

		return deliveryDao.deliveryRoder(DELIVERY_NUMBER);
	}

	@Override
	public void deleteDelItem(int DELIVERY_NUMBER) throws Exception {
		deliveryDao.deleteDelItem(DELIVERY_NUMBER);
	}

	@Override
	public void deleteDelLocation(int DELIVERY_NUMBER) throws Exception {
		deliveryDao.deleteDelLocation(DELIVERY_NUMBER);
	}

	@Override
	public void deleteDelInfo(int DELIVERY_NUMBER) throws Exception {
		deliveryDao.deleteDelInfo(DELIVERY_NUMBER);
	}
	
	//로더 지원목록 팝업
	@Override
	public List<RUserVO> openApplyRoaderPop(RUserVO vo) throws Exception {
		
		return deliveryDao.openApplyRoaderPop(vo);
	}
	
	//배송 타임라인 팝업(타임라인 부분)
	@Override
	public List<DeliveryVO> delHistory(DeliveryVO vo) throws Exception {
		
		return deliveryDao.delHistory(vo);
	}
	
	/**
	 * 배송 타임라인 팝업(회원부분)
	 */
	@Override
	public DeliveryVO readSuser(DeliveryVO vo) throws Exception {
		
		return deliveryDao.readSuser(vo);
	}

	@Override
	public void updateDelItem(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateDelItem(deliveryVO);
	}

	@Override
	public void updateDelLocationDepart(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateDelLocationDepart(deliveryVO);
	}

	@Override
	public void updateDelLocationArrival(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateDelLocationArrival(deliveryVO);
	}

	@Override
	public void updateDelInfo(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateDelInfo(deliveryVO);
	}

	@Override
	public void updateDelMethod(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateDelMethod(deliveryVO);
	}

	//히스토리에 픽업요청 히스토리 추가
	@Override
	public void regRequestPickUp(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.regRequestPickUp(deliveryVO);
	}
	
	//배송정보에 배송상태 변경
	@Override
	public void updateDelRequestPickUp(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateDelRequestPickUp(deliveryVO);
	}

	//DELIVERY_CANDIDATE 배송상태 수정
	@Override
	public void updateRoderRequestPickUp(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateRoderRequestPickUp(deliveryVO);
	}

	//DEL_STATE_HISTORY 픽업 승인 히스토리 추가
	@Override
	public void regApprovePickUp(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.regApprovePickUp(deliveryVO);
	}

	//DELIVERY_MAN 배송상태 수정
	@Override
	public void updateApprovePickUp(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.updateApprovePickUp(deliveryVO);
	}

	//DETAIL_REVIEW_MAN 등록
	@Override
	public void registTotalReview(DeliveryVO deliveryVO) throws Exception {
		deliveryDao.registTotalReview(deliveryVO);
	}

}
