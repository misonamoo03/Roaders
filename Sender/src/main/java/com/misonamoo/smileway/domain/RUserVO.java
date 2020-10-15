package com.misonamoo.smileway.domain;

public class RUserVO {
	private String ruserPhoto;
	private String ruserId;
	private String ruserName;
	private String reviewTotalStar;
	private String reviewCount;
	private double ruserStar;
	private String ruserDeliveryCnt; //배송건수
	private String ruserPoint;
	private String ruserGrade;
	
	//VO 추가(한상희), 로더지원목록 팝업
	private String deliveryNumber, //배송 번호
				   pickupTime,
				   message;

	public String getRuserGrade() {
		return ruserGrade;
	}

	public void setRuserGrade(String ruserGrade) {
		this.ruserGrade = ruserGrade;
	}

	public String getRuserDeliveryCnt() {
		return ruserDeliveryCnt;
	}

	public void setRuserDeliveryCnt(String ruserDeliveryCnt) {
		this.ruserDeliveryCnt = ruserDeliveryCnt;
	}

	public String getRuserPoint() {
		return ruserPoint;
	}

	public void setRuserPoint(String ruserPoint) {
		this.ruserPoint = ruserPoint;
	}

	public String getRuserPhoto() {
		return ruserPhoto;
	}

	public void setRuserPhoto(String ruserPhoto) {
		this.ruserPhoto = ruserPhoto;
	}

	public String getRuserId() {
		return ruserId;
	}

	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}

	public String getRuserName() {
		return ruserName;
	}

	public void setRuserName(String ruserName) {
		this.ruserName = ruserName;
	}

	public String getReviewTotalStar() {
		return reviewTotalStar;
	}

	public void setReviewTotalStar(String reviewTotalStar) {
		this.reviewTotalStar = reviewTotalStar;
	}

	public String getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	public double getRuserStar() {
		ruserStar = Math.round(Integer.parseInt(reviewTotalStar) / Integer.parseInt(reviewCount) * 10) / 10.0;
		System.out.println("ruserStar : " + ruserStar);
		return ruserStar;
	}

	public void setRuserStar(double ruserStar) {
		this.ruserStar = ruserStar;
	}
	
	//getter, setter 및 toString()추가 (한상희)
	
	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}