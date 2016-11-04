package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.SocietyVoteVO;

public interface SocietyVoteDAO {
	
	// 투표하기
	public void vote(SocietyVoteVO vo) throws Exception;
	
	// 투표 내역 보기
	public List<SocietyVoteVO> showAll(Integer sno) throws Exception;
	
	// 재투표 (
	public void revote(SocietyVoteVO vo) throws Exception;
	
	// 
	public int cntVote(SocietyVoteVO vo) throws Exception;
	
	
	public int getSno(Integer vno) throws Exception;
	
}
