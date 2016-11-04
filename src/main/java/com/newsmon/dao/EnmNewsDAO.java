package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmNewsVO;

public interface EnmNewsDAO {
	
	public void create(EnmNewsVO vo) throws Exception;
	
	public EnmNewsVO today() throws Exception;
	
	public EnmNewsVO read(Integer eno) throws Exception;
	
	public void update(EnmNewsVO vo) throws Exception;
	
	public void delete(Integer eno) throws Exception;
	
	public List<EnmNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public void uptReplyCnt(Integer eno, int amount) throws Exception;
	
	public void uptViewCnt(Integer eno) throws Exception;
	
	public void uptTodayViewCnt() throws Exception;
	
	public void uptVoteCnt_positive(Integer eno, int amount) throws Exception;
	
	public void uptVoteCnt_negative(Integer eno, int amount) throws Exception;
	
	public void addAttach(String fullName) throws Exception;
	
	public List<String> getAttach(Integer eno) throws Exception;
	
	public void delAttach(Integer eno) throws Exception;
	
	public void replaceAttach(String fullName, Integer eno) throws Exception;
	
	public void uptVoteRate(EnmNewsVO vo) throws Exception;

}
