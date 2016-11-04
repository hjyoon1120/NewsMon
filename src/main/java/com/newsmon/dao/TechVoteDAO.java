package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechVoteVO;

public interface TechVoteDAO {
	
	//투표하기
	public void vote(TechVoteVO vo) throws Exception;
	
	//전체 투표내역 보기	
	public List<TechVoteVO> showAll(Integer tno) throws Exception;
	
	//투표내역 페이징
	public List<TechVoteVO> voteList(Integer tno, Criteria_ten cri_ten) throws Exception;
		
	// 재투표
	public void revote(TechVoteVO vo) throws Exception;
	
	// 총 투표수
	public int cntVote(Integer tno) throws Exception;
	
	// 찬성 투표수
	public int cntPositive(Integer tno) throws Exception;
	
	// 반대 투표수
	public int cntNegative(Integer tno) throws Exception;
	
/*	// 투표율 (찬성율)
	public int calcRate(TechVoteVO vo) throws Exception;
	*/
	
	public int getTno(Integer vno) throws Exception;
	

}
