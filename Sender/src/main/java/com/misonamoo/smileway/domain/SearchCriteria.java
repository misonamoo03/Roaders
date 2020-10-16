package com.misonamoo.smileway.domain;

public class SearchCriteria extends Criteria {
	
	private String searchType;
	private String keyword;	
	
	//리스트 노출시 센더유저일때만 보이도록 - 센더 유저 추가 (여기에 추가하는게 맞는지는 모르겠음;)
	private String suserId;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getSuserId() {
		return suserId;
	}
	public void setSuserId(String suserId) {
		this.suserId = suserId;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", suserId=" + suserId + "]";
	}
	
}
