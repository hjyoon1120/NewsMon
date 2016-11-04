package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsVoteVO;

public interface SportsVoteService {
	
	public List<SportsVoteVO> showAll(Integer sno) throws Exception;
	
	public List<SportsVoteVO> voteList(Integer sno, Criteria_ten cri_ten) throws Exception;
	
	public void vote(SportsVoteVO vo) throws Exception;
	
	public void revote(SportsVoteVO vo) throws Exception;
	
	public int cntVote(Integer sno) throws Exception;
	
	public int cntPositive(Integer sno) throws Exception;
	
	public int cntNegative(Integer sno) throws Exception;

}
