package com.newsmon.domain;

import java.util.Date;

public class PeopleReplyVO {

	private Integer rno;
	private Integer pno;
	private String replytext;
	private Integer replyer_id;
	private Date regdate;
	private Date uptdate;
	private Date deldate;

	private String nickname;

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public Integer getReplyer_id() {
		return replyer_id;
	}

	public void setReplyer_id(Integer replyer_id) {
		this.replyer_id = replyer_id;
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

	public Date getDeldate() {
		return deldate;
	}

	public void setDeldate(Date deldate) {
		this.deldate = deldate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "PeopleReplyVO [rno=" + rno + ", pno=" + pno + ", replytext=" + replytext + ", replyer_id=" + replyer_id
				+ ", regdate=" + regdate + ", uptdate=" + uptdate + ", deldate=" + deldate + ", nickname=" + nickname
				+ "]";
	}

}
