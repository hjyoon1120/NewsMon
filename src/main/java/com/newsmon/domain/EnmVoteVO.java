package com.newsmon.domain;

import java.util.Date;

public class EnmVoteVO {

	private Integer vno, eno, voter_id;
	private String result;
	private boolean isVote;
	private Date regdate;
	private Date uptdate;

	private String nickname;

	public Integer getVno() {
		return vno;
	}

	public void setVno(Integer vno) {
		this.vno = vno;
	}

	public Integer getEno() {
		return eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public Integer getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(Integer voter_id) {
		this.voter_id = voter_id;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUptdate() {
		return uptdate;
	}

	public void setUptdate(Date uptdate) {
		this.uptdate = uptdate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "EnmVoteVO [vno=" + vno + ", eno=" + eno + ", voter_id=" + voter_id + ", result=" + result + ", isVote="
				+ isVote + ", regdate=" + regdate + ", uptdate=" + uptdate + ", nickname=" + nickname + "]";
	}

}
