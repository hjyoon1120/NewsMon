package com.newsmon.domain;

public class Criteria_one {

	private int page;
	private int perPageNum;

	private String keyword;

	public Criteria_one() {
		this.page = 1;
		this.perPageNum = 1;
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
			this.perPageNum = 1;
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
		return "Criteria_one [page=" + page + ", perPageNum=" + perPageNum + ", keyword=" + keyword + "]";
	}

}
