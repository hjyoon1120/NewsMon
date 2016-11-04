package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureVoteVO;

public interface CultureVoteDAO {
	
	//투표하기
	public void vote(CultureVoteVO vo) throws Exception;
	
	//전체 투표내역 보기	
	public List<CultureVoteVO> showAll(Integer cno) throws Exception;
	
	//투표내역 페이징
	public List<CultureVoteVO> voteList(Integer cno, Criteria_ten cri_ten) throws Exception;
		
	// 재투표
	public void revote(CultureVoteVO vo) throws Exception;
	
	// 총 투표수
	public int cntVote(Integer cno) throws Exception;
	
	// 찬성 투표수
	public int cntPositive(Integer cno) throws Exception;
	
	// 반대 투표수
	public int cntNegative(Integer cno) throws Exception;
	
/*	// 투표율 (찬성율)
	public int calcRate(CultureVoteVO vo) throws Exception;
	*/
	
	public int getCno(Integer vno) throws Exception;
	

}
