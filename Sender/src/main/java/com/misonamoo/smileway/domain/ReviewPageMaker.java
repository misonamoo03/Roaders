package com.misonamoo.smileway.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ReviewPageMaker {
	
	private int criPage = 1;
	private int criPerPageNum;
	
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int displayPageNum = 10;
    
    
    
    public ReviewPageMaker(int page, int perPageNum) {
    	this.criPage = page;
    	this.criPerPageNum = perPageNum;
	}
    

    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }
    
    private void calcData() {
        
        endPage = (int) (Math.ceil(criPage / (double) displayPageNum) * displayPageNum);
 
        startPage = (endPage - displayPageNum) + 1;
        if(startPage <= 0) startPage = 1;
        
        int tempEndPage = (int) (Math.ceil(totalCount / (double) criPerPageNum));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
 
        prev = startPage == 1 ? false : true;
        next = endPage * criPerPageNum < totalCount ? true : false;
        
    }
    
    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
    public boolean isPrev() {
        return prev;
    }
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setNext(boolean next) {
        this.next = next;
    }
    public int getDisplayPageNum() {
        return displayPageNum;
    }
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }

    public String makeQuery(int page) {

	    UriComponents uriComponents 
	    	= UriComponentsBuilder.newInstance()
	    						  .queryParam("page", page)
	    						  .queryParam("perPageNum", criPerPageNum)
	    						  .build();
	    String strTemp = uriComponents.toUriString();
	    return uriComponents.toUriString();
	}


	public int getCriPage() {
		return criPage;
	}


	public void setCriPage(int criPage) {
		this.criPage = criPage;
	}


	public int getCriPerPageNum() {
		return criPerPageNum;
	}


	public void setCriPerPageNum(int criPerPageNum) {
		this.criPerPageNum = criPerPageNum;
	}
    
    
    
}
