package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmVoteVO;

public interface EnmVoteDAO {
	
	//투표하기
	public void vote(EnmVoteVO vo) throws Exception;
	
	//전체 투표내역 보기	
	public List<EnmVoteVO> showAll(Integer eno) throws Exception;
	
	//투표내역 페이징
	public List<EnmVoteVO> voteList(Integer eno, Criteria_ten cri_ten) throws Exception;
		
	// 재투표
	public void revote(EnmVoteVO vo) throws Exception;
	
	// 총 투표수
	public int cntVote(Integer eno) throws Exception;
	
	// 찬성 투표수
	public int cntPositive(Integer eno) throws Exception;
	
	// 반대 투표수
	public int cntNegative(Integer eno) throws Exception;
	
/*	// 투표율 (찬성율)
	public int calcRate(EnmVoteVO vo) throws Exception;
	*/
	
	public int getEno(Integer vno) throws Exception;
	

}
