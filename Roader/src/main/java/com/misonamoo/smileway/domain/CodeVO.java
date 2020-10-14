package com.misonamoo.smileway.domain;

public class CodeVO {
	private String secNo;
	private String secCode;
	
	public String getSecNo() {
		return secNo;
	}

	public void setSecNo(String secNo) {
		this.secNo = secNo;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	@Override
	public String toString() {
		return "CodeVO [secNo=" + secNo + ", secCode=" + secCode + "]";
	}

}
