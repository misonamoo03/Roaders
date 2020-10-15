package com.misonamoo.smileway.domain;

import java.util.List;

public class ReviewVO extends BaseCriteria {
	private int reviewNumber;
	private String ruserId;
	private String suserName;
	private int	totalStar;
	private String reviewRegDate;
	private String reviewContent;
	private String StarSun;
	private String starCount;
	private List<DetailReviewVO> starScoreList;
	
	private String reviewCode;
	private String reviewStart;
	
	private String reviewRegistor;
	
	public int getReviewNumber() {
		return reviewNumber;
	}
	public void setReviewNumber(int reviewNumber) {
		this.reviewNumber = reviewNumber;
	}
	public String getRuserId() {
		return ruserId;
	}
	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}
	public String getSuserName() {
		return suserName;
	}
	public void setSuserName(String suserName) {
		this.suserName = suserName;
	}
	public String getReviewRegDate() {
		return reviewRegDate;
	}
	public void setReviewRegDate(String reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getStarSun() {
		return StarSun;
	}
	public void setStarSun(String starSun) {
		StarSun = starSun;
	}
	public String getStarCount() {
		return starCount;
	}
	public void setStarCount(String starCount) {
		this.starCount = starCount;
	}
	
	public List<DetailReviewVO> getStarScoreList() {
		return starScoreList;
	}
	public void setStarScoreList(List<DetailReviewVO> starScoreList) {
		this.starScoreList = starScoreList;
	}
	
	public int getTotalStar() {
		return totalStar;
	}
	public void setTotalStar(int totalStar) {
		this.totalStar = totalStar;
	}
	
	public String getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getReviewStart() {
		return reviewStart;
	}
	public void setReviewStart(String reviewStart) {
		this.reviewStart = reviewStart;
	}
	
	public String getReviewRegistor() {
		return reviewRegistor;
	}
	public void setReviewRegistor(String reviewRegistor) {
		this.reviewRegistor = reviewRegistor;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNumber=" + reviewNumber + ", ruserId=" + ruserId + ", suserName=" + suserName
				+ ", totalStar=" + totalStar + ", reviewRegDate=" + reviewRegDate + ", reviewContent=" + reviewContent
				+ ", StarSun=" + StarSun + ", starCount=" + starCount + ", starScoreList=" + starScoreList
				+ ", reviewCode=" + reviewCode + ", reviewStart=" + reviewStart + ", reviewRegistor=" + reviewRegistor
				+ "]";
	}
	
}