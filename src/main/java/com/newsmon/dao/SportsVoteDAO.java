package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsVoteVO;

public interface SportsVoteDAO {
	
	//투표하기
	public void vote(SportsVoteVO vo) throws Exception;
	
	//전체 투표내역 보기	
	public List<SportsVoteVO> showAll(Integer sno) throws Exception;
	
	//투표내역 페이징
	public List<SportsVoteVO> voteList(Integer sno, Criteria_ten cri_ten) throws Exception;
		
	// 재투표
	public void revote(SportsVoteVO vo) throws Exception;
	
	// 총 투표수
	public int cntVote(Integer sno) throws Exception;
	
	// 찬성 투표수
	public int cntPositive(Integer sno) throws Exception;
	
	// 반대 투표수
	public int cntNegative(Integer sno) throws Exception;
	
/*	// 투표율 (찬성율)
	public int calcRate(SportsVoteVO vo) throws Exception;
	*/
	
	public int getSno(Integer vno) throws Exception;
	

}
