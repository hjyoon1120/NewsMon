package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleVoteVO;

public interface PeopleVoteService {
	
	public List<PeopleVoteVO> showAll(Integer pno) throws Exception;
	
	public List<PeopleVoteVO> voteList(Integer pno, Criteria_ten cri_ten) throws Exception;
	
	public void vote(PeopleVoteVO vo) throws Exception;
	
	public void revote(PeopleVoteVO vo) throws Exception;
	
	public int cntVote(Integer pno) throws Exception;
	
	public int cntPositive(Integer pno) throws Exception;
	
	public int cntNegative(Integer pno) throws Exception;

}
