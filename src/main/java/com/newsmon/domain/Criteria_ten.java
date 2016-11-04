package com.newsmon.domain;

public class Criteria_ten {

	private int page; // 페이지
	private int perPageNum; // 한 페이지당 보여줄 게시물 갯수
	
	private String keyword;
	
	public Criteria_ten() {
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

	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Criteria_ten [page=" + page + ", perPageNum=" + perPageNum + ", keyword=" + keyword + "]";
	}

	
	
	
	
}
