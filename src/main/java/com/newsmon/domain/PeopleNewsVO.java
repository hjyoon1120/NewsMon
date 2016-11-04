package com.newsmon.domain;

import java.util.Arrays;
import java.util.Date;

public class PeopleNewsVO {

	private Integer pno, reporter_id;
	private String title, subtitle, content, press, query;
	private int viewcnt, likecnt, replycnt, votecnt_positive, votecnt_negative, vote_rate;
	private Date regdate, uptdate;

	private String[] files;
	private String nickname;

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public Integer getReporter_id() {
		return reporter_id;
	}

	public void setReporter_id(Integer reporter_id) {
		this.reporter_id = reporter_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public int getVotecnt_positive() {
		return votecnt_positive;
	}

	public void setVotecnt_positive(int votecnt_positive) {
		this.votecnt_positive = votecnt_positive;
	}

	public int getVotecnt_negative() {
		return votecnt_negative;
	}

	public void setVotecnt_negative(int votecnt_negative) {
		this.votecnt_negative = votecnt_negative;
	}

	public int getVote_rate() {
		return vote_rate;
	}

	public void setVote_rate(int vote_rate) {
		this.vote_rate = vote_rate;
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

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "PeopleNewsVO [pno=" + pno + ", reporter_id=" + reporter_id + ", title=" + title + ", subtitle="
				+ subtitle + ", content=" + content + ", press=" + press + ", query=" + query + ", viewcnt=" + viewcnt
				+ ", likecnt=" + likecnt + ", replycnt=" + replycnt + ", votecnt_positive=" + votecnt_positive
				+ ", votecnt_negative=" + votecnt_negative + ", vote_rate=" + vote_rate + ", regdate=" + regdate
				+ ", uptdate=" + uptdate + ", files=" + Arrays.toString(files) + ", nickname=" + nickname + "]";
	}

	private void calcRate() {
		if ((votecnt_positive == 0) && (votecnt_negative == 0)) {
			vote_rate = 50;
		} else {

			vote_rate = (int) ((votecnt_positive * 100) / (votecnt_positive + votecnt_negative));

		}

	}

}
