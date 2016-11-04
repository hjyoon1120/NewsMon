package com.newsmon.domain;

import java.util.Date;

public class CultureVoteVO {

	private Integer vno, cno, voter_id;
	private boolean isPositive;
	private Date regdate;
	private Date uptdate;

	private String nickname;

	public Integer getVno() {
		return vno;
	}

	public void setVno(Integer vno) {
		this.vno = vno;
	}

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Integer getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(Integer voter_id) {
		this.voter_id = voter_id;
	}

	public boolean isPositive() {
		return isPositive;
	}

	public void setPositive(boolean isPositive) {
		this.isPositive = isPositive;
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
		return "CultureVoteVO [vno=" + vno + ", cno=" + cno + ", voter_id=" + voter_id + ", isPositive=" + isPositive
				+ ", regdate=" + regdate + ", uptdate=" + uptdate + ", nickname=" + nickname + "]";
	}

}
