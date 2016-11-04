package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.SocietyVoteVO;

public interface SocietyVoteService {
	
	public List<SocietyVoteVO> showAll(Integer sno) throws Exception;
	
	public void vote(SocietyVoteVO vo) throws Exception;
	
	public void revote(SocietyVoteVO vo) throws Exception;
	
	public int cntVote(SocietyVoteVO vo) throws Exception;
}
