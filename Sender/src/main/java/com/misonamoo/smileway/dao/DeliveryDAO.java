package com.misonamoo.smileway.dao;

import java.util.List;

import com.misonamoo.smileway.domain.Criteria;
import com.misonamoo.smileway.domain.DeliveryVO;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.ReviewVO;
import com.misonamoo.smileway.domain.SearchCriteria;

public interface DeliveryDAO {

	public void registDelItem(DeliveryVO deliveryVO) throws Exception;
	
	public void registDelLocationDepart(DeliveryVO deliveryVO) throws Exception;

	public void registDelLocationArrival(DeliveryVO deliveryVO) throws Exception;

	public void registDelInfo(DeliveryVO deliveryVO) throws Exception;

	public void registDelMethod(DeliveryVO deliveryVO) throws Exception;

	public List<DeliveryVO> deliveryList(Criteria cri) throws Exception;
	
	//페이징을 위해서 전체 등록 상품수 세기
	public int countDelivery(SearchCriteria cri) throws Exception;

	public DeliveryVO deliveryDetail(int DELIVERY_NUMBER) throws Exception;
	
	public RUserVO deliveryRoder(int DELIVERY_NUMBER) throws Exception;

	public void deleteDelItem(int DELIVERY_NUMBER) throws Exception;

	public void deleteDelInfo(int DELIVERY_NUMBER) throws Exception;


	public void deleteDelLocation(int DELIVERY_NUMBER) throws Exception;

	public void updateDelItem(DeliveryVO deliveryVO) throws Exception;

	public void updateDelLocationDepart(DeliveryVO deliveryVO) throws Exception;

	public void updateDelLocationArrival(DeliveryVO deliveryVO) throws Exception;

	public void updateDelInfo(DeliveryVO deliveryVO) throws Exception;

	public void updateDelMethod(DeliveryVO deliveryVO) throws Exception;

	
	//로더 지원 목록 팝업
	public List<RUserVO> openApplyRoaderPop(RUserVO vo)throws Exception;
	
	//배송 타임라인 팝업(회원정보 부분)
	public DeliveryVO readSuser(DeliveryVO vo)throws Exception;
	
	//배송 타임라인 팝업(타임라인 부분)
	public List<DeliveryVO> delHistory(DeliveryVO vo)throws Exception;

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
	public void registTotalReview(DeliveryVO deliveryVO);

}
