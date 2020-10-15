package com.misonamoo.smileway.domain;

public class LocationVO {
	private String locationNumber;

	private String locationName;
	private String charher;
	private String locationCellphone;
	private String locationPhone;
	private String locationPost;
	private String locationAddress1;
	private String locationAddress2;
	private String defaultLocationChk;

	private int page;
	private int perPageNum;

	public LocationVO() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	// method for MyBatis SQL Mapper -
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	// method for MyBatis SQL Mapper
	public int getPerPageNum() {
		return this.perPageNum;
	}

	public String getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCharher() {
		return charher;
	}

	public void setCharher(String charher) {
		this.charher = charher;
	}

	public String getLocationCellphone() {
		return locationCellphone;
	}

	public void setLocationCellphone(String locationCellphone) {
		this.locationCellphone = locationCellphone;
	}

	public String getLocationPhone() {
		return locationPhone;
	}

	public void setLocationPhone(String locationPhone) {
		this.locationPhone = locationPhone;
	}

	public String getLocationPost() {
		return locationPost;
	}

	public void setLocationPost(String locationPost) {
		this.locationPost = locationPost;
	}

	public String getLocationAddress1() {
		return locationAddress1;
	}

	public void setLocationAddress1(String locationAddress1) {
		this.locationAddress1 = locationAddress1;
	}

	public String getLocationAddress2() {
		return locationAddress2;
	}

	public void setLocationAddress2(String locationAddress2) {
		this.locationAddress2 = locationAddress2;
	}

	public String getDefaultLocationChk() {
		return defaultLocationChk;
	}

	public void setDefaultLocationChk(String defaultLocationChk) {
		this.defaultLocationChk = defaultLocationChk;
	}

	@Override
	public String toString() {
		return "LocationVO [locationNumber=" + locationNumber + ", locationName=" + locationName + ", charher="
				+ charher + ", locationCellphone=" + locationCellphone + ", locationPhone=" + locationPhone
				+ ", locationPost=" + locationPost + ", locationAddress1=" + locationAddress1 + ", locationAddress2="
				+ locationAddress2 + ", defaultLocationChk=" + defaultLocationChk + "]";
	}

}