package com.newsmon.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker_ten {

	private int totalCnt;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 5; // 페이지 번호의 숫자 ex) << 1 ~ 10 >>
	
	private Criteria_ten cri_ten;

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		
		calcData();
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

	public Criteria_ten getCri_ten() {
		return cri_ten;
	}

	public void setCri_ten(Criteria_ten cri_ten) {
		this.cri_ten = cri_ten;
	}
	
	private void calcData(){
		
		endPage = (int) (Math.ceil(cri_ten.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCnt / (double) cri_ten.getPerPageNum()));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;

		next = endPage * cri_ten.getPerPageNum() >= totalCnt ? false : true;
	}

	@Override
	public String toString() {
		return "PageMaker_ten [totalCnt=" + totalCnt + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri_ten=" + cri_ten + "]";
	}
	
	// makeQuery : page+perPageNum
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri_ten.getPerPageNum()).build();

		return uriComponents.toUriString();
		
	}
	
	public String makeSearch(int page) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri_ten.getPerPageNum()).queryParam("keyword", cri_ten.getKeyword()).build();

		return uriComponents.toUriString();
	}
	
	
	


}
