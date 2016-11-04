package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechVoteVO;

public interface TechVoteService {
	
	public List<TechVoteVO> showAll(Integer tno) throws Exception;
	
	public List<TechVoteVO> voteList(Integer tno, Criteria_ten cri_ten) throws Exception;
	
	public void vote(TechVoteVO vo) throws Exception;
	
	public void revote(TechVoteVO vo) throws Exception;
	
	public int cntVote(Integer tno) throws Exception;
	
	public int cntPositive(Integer tno) throws Exception;
	
	public int cntNegative(Integer tno) throws Exception;

}
