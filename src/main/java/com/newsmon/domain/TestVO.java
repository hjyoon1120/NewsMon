package com.newsmon.domain;

public class TestVO {

	private Integer id;
	private String result;
	private boolean isVote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isVote() {
		return isVote;
	}

	public void setVote(boolean isVote) {
		this.isVote = isVote;
	}

	@Override
	public String toString() {
		return "TestVO [id=" + id + ", result=" + result + ", isVote=" + isVote + "]";
	}

}
