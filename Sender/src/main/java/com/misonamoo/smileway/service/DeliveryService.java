package com.misonamoo.smileway.service;

import java.util.List;

import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.DeliveryVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.ReviewVO;
import com.misonamoo.smileway.domain.SearchCriteria;

public interface DeliveryService {

	public void registDelItem(DeliveryVO deliveryVO) throws Exception;
	
	public void registDelLocationDepart(DeliveryVO deliveryVO) throws Exception;
	
	public void registDelLocationArrival(DeliveryVO deliveryVO) throws Exception;

	public void registDelInfo(DeliveryVO deliveryVO) throws Exception;

	public void registDelMethod(DeliveryVO deliveryVO) throws Exception;

	public List<DeliveryVO> deliveryList(Criteria cri) throws Exception;

	public int countDelivery(SearchCriteria cri) throws Exception;

	public DeliveryVO deliveryDetail(int DELIVERY_NUMBER) throws Exception;
	
	public RUserVO deliveryRoder(int dELIVERY_NUMBER) throws Exception;

	public void deleteDelItem(int DELIVERY_NUMBER) throws Exception;

	public void deleteDelLocation(int dELIVERY_NUMBER) throws Exception;


	public void deleteDelInfo(int dELIVERY_NUMBER) throws Exception;

	public void updateDelItem(DeliveryVO deliveryVO) throws Exception;

	public void updateDelLocationDepart(DeliveryVO deliveryVO) throws Exception;

	public void updateDelLocationArrival(DeliveryVO deliveryVO) throws Exception;

	public void updateDelInfo(DeliveryVO deliveryVO) throws Exception;

	public void updateDelMethod(DeliveryVO deliveryVO) throws Exception;

	
	//로더 지원 목록 팝업
	public List<RUserVO> openApplyRoaderPop(RUserVO vo) throws Exception;

	
	//배송 타임라인 팝업(회원)
	public DeliveryVO readSuser(DeliveryVO vo) throws Exception;
	
	//배송 타임라인 팝업(타임라인 관리)
	public List<DeliveryVO> delHistory(DeliveryVO vo) throws Exception;

	//히스토리에 픽업요청 히스토리 추가
	public void regRequestPickUp(DeliveryVO deliveryVO) throws Exception;

	//배송정보에 배송상태 변경
	public void updateDelRequestPickUp(DeliveryVO deliveryVO) throws Exception;

	//DELIVERY_CANDIDATE 배송상태 수정
	public void updateRoderRequestPickUp(DeliveryVO deliveryVO) throws Exception;

	//DEL_STATE_HISTORY 픽업 승인 히스토리 추가
	public void regApprovePickUp(DeliveryVO deliveryVO) throws Exception;

	//DELIVERY_MAN 배송상태 수정
	public void updateApprovePickUp(DeliveryVO deliveryVO) throws Exception;

	//DETAIL_REVIEW_MAN 등록
	public void registTotalReview(DeliveryVO deliveryVO) throws Exception;

	//DETAIL_REVIEW_MAN 친절평점 등록
	public void registKindlyReview(DeliveryVO deliveryVO) throws Exception;

	//DETAIL_REVIEW_MAN 약속평점 등록
	public void registPromiseReview(DeliveryVO deliveryVO) throws Exception;

	//DETAIL_REVIEW_MAN 속도 등록
	public void registSpeedReview(DeliveryVO deliveryVO) throws Exception;

	//REVIEW_MAN - totalStart 업데이트
	public void updateTotalReview(DeliveryVO deliveryVO) throws Exception;

	//DEL_STATE_HISTORY 배송완료승인 히스토리 추가
	public void regConfirmDelHistory(DeliveryVO deliveryVO) throws Exception;
	
	//DELIVERY_MAN 배송상태 수정 -> 6으로
	public void updateConfirmDelHistory(DeliveryVO deliveryVO) throws Exception;
}
