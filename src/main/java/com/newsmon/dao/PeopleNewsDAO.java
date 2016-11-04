package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleNewsVO;

public interface PeopleNewsDAO {
	
	public void create(PeopleNewsVO vo) throws Exception;
	
	public PeopleNewsVO today() throws Exception;
	
	public PeopleNewsVO read(Integer pno) throws Exception;
	
	public void update(PeopleNewsVO vo) throws Exception;
	
	public void delete(Integer pno) throws Exception;
	
	public List<PeopleNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public void uptReplyCnt(Integer pno, int amount) throws Exception;
	
	public void uptViewCnt(Integer pno) throws Exception;
	
	public void uptTodayViewCnt() throws Exception;
	
	public void uptVoteCnt_positive(Integer pno, int amount) throws Exception;
	
	public void uptVoteCnt_negative(Integer pno, int amount) throws Exception;
	
	public void addAttach(String fullName) throws Exception;
	
	public List<String> getAttach(Integer pno) throws Exception;
	
	public void delAttach(Integer pno) throws Exception;
	
	public void replaceAttach(String fullName, Integer pno) throws Exception;
	

}
