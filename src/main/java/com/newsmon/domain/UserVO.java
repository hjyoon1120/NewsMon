package com.newsmon.domain;

import java.util.Arrays;
import java.util.Date;

public class UserVO {

	private Integer uid;
	private String pw, email, nickname;
	private int userpoint, expoint, level, votecnt;
	private Date regdate, uptdate, deldate;
	private boolean isreporter;

	private String[] files;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getUserpoint() {
		return userpoint;
	}

	public void setUserpoint(int userpoint) {
		this.userpoint = userpoint;
	}

	public int getExpoint() {
		return expoint;
	}

	public void setExpoint(int expoint) {
		this.expoint = expoint;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getVotecnt() {
		return votecnt;
	}

	public void setVotecnt(int votecnt) {
		this.votecnt = votecnt;
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

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public boolean isIsreporter() {
		return isreporter;
	}

	public void setIsreporter(boolean isreporter) {
		this.isreporter = isreporter;
	}

	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", pw=" + pw + ", email=" + email + ", nickname=" + nickname + ", userpoint="
				+ userpoint + ", expoint=" + expoint + ", level=" + level + ", votecnt=" + votecnt + ", regdate="
				+ regdate + ", uptdate=" + uptdate + ", deldate=" + deldate + ", isreporter=" + isreporter + ", files="
				+ Arrays.toString(files) + "]";
	}

}
