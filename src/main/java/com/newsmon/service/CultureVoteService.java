package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureVoteVO;

public interface CultureVoteService {
	
	public List<CultureVoteVO> showAll(Integer cno) throws Exception;
	
	public List<CultureVoteVO> voteList(Integer cno, Criteria_ten cri_ten) throws Exception;
	
	public void vote(CultureVoteVO vo) throws Exception;
	
	public void revote(CultureVoteVO vo) throws Exception;
	
	public int cntVote(Integer cno) throws Exception;
	
	public int cntPositive(Integer cno) throws Exception;
	
	public int cntNegative(Integer cno) throws Exception;

}
