package com.misonamoo.smileway.domain;

public class RUserVO {
	private String ruserNo;
	private String ruserId;
	private String ruserPw;
	private String ruserEmail;
	private String[] ruserEmail1;
	private String rPhone;
	private String ruserName;
	private String ruserAddress1;
	private String ruserAddress2;
	private String ruserPostCode;
	private String ruserPhoto;
	private String ruserPoint;
	private String ruserAgreEssen;
	private String ruserAgreOption;

	public String getRuserNo() {
		return ruserNo;
	}

	public void setRuserNo(String ruserNo) {
		this.ruserNo = ruserNo;
	}

	public String getRuserId() {
		return ruserId;
	}

	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}

	public String getRuserPw() {
		return ruserPw;
	}

	public void setRuserPw(String ruserPw) {
		this.ruserPw = ruserPw;
	}

	public String getRuserEmail() {
		return ruserEmail;
	}

	public void setRuserEmail(String ruserEmail) {
		this.ruserEmail = ruserEmail;
	}


	public String[] getRuserEmail1() {
		return ruserEmail1;
	}

	public void setRuserEmail1(String[] ruserEmail1) {
		this.ruserEmail1 = ruserEmail1;
	}

	public String getrPhone() {
		return rPhone;
	}

	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}

	public String getRuserName() {
		return ruserName;
	}

	public void setRuserName(String ruserName) {
		this.ruserName = ruserName;
	}

	public String getRuserAddress1() {
		return ruserAddress1;
	}

	public void setRuserAddress1(String ruserAddress1) {
		this.ruserAddress1 = ruserAddress1;
	}

	public String getRuserAddress2() {
		return ruserAddress2;
	}

	public void setRuserAddress2(String ruserAddress2) {
		this.ruserAddress2 = ruserAddress2;
	}

	public String getRuserPostCode() {
		return ruserPostCode;
	}

	public void setRuserPostCode(String ruserPostCode) {
		this.ruserPostCode = ruserPostCode;
	}

	public String getRuserPhoto() {
		return ruserPhoto;
	}

	public void setRuserPhoto(String ruserPhoto) {
		this.ruserPhoto = ruserPhoto;
	}

	public String getRuserPoint() {
		return ruserPoint;
	}

	public void setRuserPoint(String ruserPoint) {
		this.ruserPoint = ruserPoint;
	}

	public String getRuserAgreEssen() {
		return ruserAgreEssen;
	}

	public void setRuserAgreEssen(String ruserAgreEssen) {
		this.ruserAgreEssen = ruserAgreEssen;
	}

	public String getRuserAgreOption() {
		return ruserAgreOption;
	}

	public void setRuserAgreOption(String ruserAgreOption) {
		this.ruserAgreOption = ruserAgreOption;
	}

	@Override
	public String toString() {
		return "RUserVO [ruserNo=" + ruserNo + ", ruserId=" + ruserId + ", ruserPw=" + ruserPw + ", ruserEmail="
				+ ruserEmail + ", rPhone=" + rPhone + ", ruserName=" + ruserName + ", ruserAddress1=" + ruserAddress1
				+ ", ruserAddress2=" + ruserAddress2 + ", ruserPostCode=" + ruserPostCode + ", ruserPhoto=" + ruserPhoto
				+ ", ruserPoint=" + ruserPoint + ", ruserAgreEssen=" + ruserAgreEssen + ", ruserAgreOption="
				+ ruserAgreOption + "]";
	}

}
