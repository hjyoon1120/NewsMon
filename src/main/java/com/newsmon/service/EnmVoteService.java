package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmVoteVO;

public interface EnmVoteService {
	
	public List<EnmVoteVO> showAll(Integer eno) throws Exception;
	
	public List<EnmVoteVO> voteList(Integer eno, Criteria_ten cri_ten) throws Exception;
	
	public void vote(EnmVoteVO vo) throws Exception;
	
	public void revote(EnmVoteVO vo) throws Exception;
	
	public int cntVote(Integer eno) throws Exception;
	
	public int cntPositive(Integer eno) throws Exception;
	
	public int cntNegative(Integer eno) throws Exception;

}
