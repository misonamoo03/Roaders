package com.misonamoo.smileway.domain;

public class UserVO {
	private String SUSER_ID;
	private String SUSER_PW;
	private String SUSER_EMAIL;
	private String SPHONE;
	private String SUSER_NAME;
	private String SUSER_ADDRESS;
	private String SUSER_POSTCODE;
	private String SUSER_AGRE_ESSEN;
	private String SUSER_AGRE_OPTION;

	public String getSUSER_ID() {
		return SUSER_ID;
	}

	public void setSUSER_ID(String SUSER_ID) {
		this.SUSER_ID = SUSER_ID;
	}

	public String getSUSER_PW() {
		return SUSER_PW;
	}

	public void setSUSER_PW(String SUSER_PW) {
		this.SUSER_PW = SUSER_PW;
	}

	public String getSUSER_EMAIL() {
		return SUSER_EMAIL;
	}

	public void setSUSER_EMAIL(String SUSER_EMAIL) {
		this.SUSER_EMAIL = SUSER_EMAIL;
	}

	public String getSPHONE() {
		return SPHONE;
	}

	public void setSPHONE(String SPHONE) {
		this.SPHONE = SPHONE;
	}

	public String getSUSER_NAME() {
		return SUSER_NAME;
	}

	public void setSUSER_NAME(String SUSER_NAME) {
		this.SUSER_NAME = SUSER_NAME;
	}

	public String getSUSER_ADDRESS() {
		return SUSER_ADDRESS;
	}

	public void setSUSER_ADDRESS(String SUSER_ADDRESS) {
		this.SUSER_ADDRESS = SUSER_ADDRESS;
	}

	public String getSUSER_POSTCODE() {
		return SUSER_POSTCODE;
	}

	public void setSUSER_POSTCODE(String SUSER_POSTCODE) {
		this.SUSER_POSTCODE = SUSER_POSTCODE;
	}

	public String getSUSER_AGRE_ESSEN() {
		return SUSER_AGRE_ESSEN;
	}

	public void setSUSER_AGRE_ESSEN(String SUSER_AGRE_ESSEN) {
		this.SUSER_AGRE_ESSEN = SUSER_AGRE_ESSEN;
	}

	public String getSUSER_AGRE_OPTION() {
		return SUSER_AGRE_OPTION;
	}

	public void setSUSER_AGRE_OPTION(String SUSER_AGRE_OPTION) {
		this.SUSER_AGRE_OPTION = SUSER_AGRE_OPTION;
	}

	@Override
	public String toString() {
		return "UserVO [SUSER_ID=" + SUSER_ID + ", SUSER_PW=" + SUSER_PW + ", SUSER_EMAIL=" + SUSER_EMAIL + ", SPHONE="
				+ SPHONE + ", SUSER_NAME=" + SUSER_NAME + ", SUSER_ADDRESS=" + SUSER_ADDRESS + ", SUSER_POSTCODE="
				+ SUSER_POSTCODE + ", SUSER_AGRE_ESSEN=" + SUSER_AGRE_ESSEN + ", SUSER_AGRE_OPTION=" + SUSER_AGRE_OPTION
				+ "]";
	}

}