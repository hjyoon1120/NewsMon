package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

public interface SocietyNewsDAO {
	
	public void create(SocietyNewsVO vo) throws Exception;
	
	public SocietyNewsVO today() throws Exception;

	public SocietyNewsVO read(Integer sno) throws Exception;
	
	public void update(SocietyNewsVO vo) throws Exception;
	
	public void delete(Integer sno) throws Exception;
	
	public List<SocietyNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public void uptReplyCnt(Integer sno, int amount) throws Exception;
	
	public void uptViewCnt(Integer sno) throws Exception;
	
	public void uptTodayViewCnt() throws Exception;
	
	public void uptVoteCnt_positive(Integer sno, int amount) throws Exception;
	
	public void uptVoteCnt_negative(Integer sno, int amount) throws Exception;
	
	public void addAttach(String fullName) throws Exception;
	
	public List<String> getAttach(Integer sno) throws Exception;
	
	public void deleteAttach(Integer sno) throws Exception;
	
	public void replaceAttach(String fullName, Integer sno) throws Exception;
	
}
