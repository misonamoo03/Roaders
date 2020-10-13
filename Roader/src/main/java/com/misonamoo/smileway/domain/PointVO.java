package com.misonamoo.smileway.domain;

public class PointVO {
	private String pointType;
	private String pointUpdate;
	private String ruserId;
	private String reason;
	private String pointInsTime;
	private String ruserPoint;
	
	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public String getPointUpdate() {
		return pointUpdate;
	}

	public void setPointUpdate(String pointUpdate) {
		this.pointUpdate = pointUpdate;
	}

	public String getRuserId() {
		return ruserId;
	}

	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPointInsTime() {
		return pointInsTime;
	}

	public void setPointInsTime(String pointInsTime) {
		this.pointInsTime = pointInsTime;
	}

	public String getRuserPoint() {
		return ruserPoint;
	}

	public void setRuserPoint(String ruserPoint) {
		this.ruserPoint = ruserPoint;
	}

	@Override
	public String toString() {
		return "PointVO [pointType=" + pointType + ", pointUpdate=" + pointUpdate + ", ruserId=" + ruserId + ", reason="
				+ reason + ", pointInsTime=" + pointInsTime + ", ruserPoint=" + ruserPoint + "]";
	}


}
