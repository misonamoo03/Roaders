package com.misonamoo.smileway.domain;
/**
 * 배송목록을 출력하기 위한 VO
 * @param
 */
public class DeliveryListVO {
	
	private String deliveryNumber = "", 			// 배송번호
				   delContentPicture = "", 			// 상품 사진
				   delContentName = "", 			// 상품 이름
				   suserId = "",					// 센더 ID
				   suserName = "",					// 센더 이름
				   suserPhoto = "",					// 센더 사진
				   totalStar = "",					// 별그리기 위한 변수
				   candiNum = "",					// 상품에 대한 지원자수
				   sendAvrPoint = "",				// 센더 평점
				   delicnt = "",					// 센더 회원 배송횟수
				   suserNo = "",					// 센더 회원 번호
				   maxPickupTime = "",				// 픽업 시간
				   maxArriveTime = "",				// 도착 시간
				   deliveryPrice = "",				// 배송비
				   deliveryState = "",				// 배송 상태
				   gradeCode = "",					// 회원 등급 코드
				   startPlace = "",					// 배송 출발 장소
				   arrivePlace = "",				// 배송 도착 장소
				   loLati = "",						// 배송 지점 위도
				   loLongi = "",					// 배송 지점 경도
				   loType = "";						// 배송 타입
	
	
	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}


	public String getDelContentPicture() {
		return delContentPicture;
	}

	public void setDelContentPicture(String delContentPicture) {
		this.delContentPicture = delContentPicture;
	}

	public String getDelContentName() {
		return delContentName;
	}

	public void setDelContentName(String delContentName) {
		this.delContentName = delContentName;
	}

	public String getSuserId() {
		return suserId;
	}

	public void setSuserId(String suserId) {
		this.suserId = suserId;
	}

	public String getSuserName() {
		return suserName;
	}

	public void setSuserName(String suserName) {
		this.suserName = suserName;
	}

	public String getSuserPhoto() {
		return suserPhoto;
	}

	public void setSuserPhoto(String suserPhoto) {
		this.suserPhoto = suserPhoto;
	}

	public String getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(String totalStar) {
		this.totalStar = totalStar;
	}

	public String getCandiNum() {
		return candiNum;
	}

	public void setCandiNum(String candiNum) {
		this.candiNum = candiNum;
	}

	public String getSendAvrPoint() {
		return sendAvrPoint;
	}

	public void setSendAvrPoint(String sendAvrPoint) {
		this.sendAvrPoint = sendAvrPoint;
	}

	public String getDelicnt() {
		return delicnt;
	}

	public void setDelicnt(String delicnt) {
		this.delicnt = delicnt;
	}

	public String getSuserNo() {
		return suserNo;
	}

	public void setSuserNo(String suserNo) {
		this.suserNo = suserNo;
	}

	public String getMaxPickupTime() {
		return maxPickupTime;
	}

	public void setMaxPickupTime(String maxPickupTime) {
		this.maxPickupTime = maxPickupTime;
	}

	public String getMaxArriveTime() {
		return maxArriveTime;
	}

	public void setMaxArriveTime(String maxArriveTime) {
		this.maxArriveTime = maxArriveTime;
	}

	public String getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(String deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public String getLoLati() {
		return loLati;
	}

	public void setLoLati(String loLati) {
		this.loLati = loLati;
	}

	public String getLoLongi() {
		return loLongi;
	}

	public void setLoLongi(String loLongi) {
		this.loLongi = loLongi;
	}

	public String getLoType() {
		return loType;
	}

	public void setLoType(String loType) {
		this.loType = loType;
	}
	
	
				   
}
