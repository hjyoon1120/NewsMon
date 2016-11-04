package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleVoteVO;

public interface PeopleVoteDAO {
	
	//투표하기
	public void vote(PeopleVoteVO vo) throws Exception;
	
	//전체 투표내역 보기	
	public List<PeopleVoteVO> showAll(Integer pno) throws Exception;
	
	//투표내역 페이징
	public List<PeopleVoteVO> voteList(Integer pno, Criteria_ten cri_ten) throws Exception;
		
	// 재투표
	public void revote(PeopleVoteVO vo) throws Exception;
	
	// 총 투표수
	public int cntVote(Integer pno) throws Exception;
	
	// 찬성 투표수
	public int cntPositive(Integer pno) throws Exception;
	
	// 반대 투표수
	public int cntNegative(Integer pno) throws Exception;
	
/*	// 투표율 (찬성율)
	public int calcRate(PeopleVoteVO vo) throws Exception;
	*/
	
	public int getPno(Integer vno) throws Exception;
	

}
