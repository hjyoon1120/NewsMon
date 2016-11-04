package com.newsmon.domain;

import java.util.Date;

public class SocietyVoteVO {

	private Integer vno;
	private Integer sno;
	private Integer voter_id;
	private String choice;
	private Date regdate;
	private Date uptdate;

	public Integer getVno() {
		return vno;
	}

	public void setVno(Integer vno) {
		this.vno = vno;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(Integer voter_id) {
		this.voter_id = voter_id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
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

	@Override
	public String toString() {
		return "SocietyVoteVO [vno=" + vno + ", sno=" + sno + ", voter_id=" + voter_id + ", choice=" + choice
				+ ", regdate=" + regdate + ", uptdate=" + uptdate + "]";
	}

}
