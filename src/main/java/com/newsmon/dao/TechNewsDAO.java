package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechNewsVO;

public interface TechNewsDAO {
	
	public void create(TechNewsVO vo) throws Exception;
	
	public TechNewsVO today() throws Exception;
	
	public TechNewsVO read(Integer tno) throws Exception;
	
	public void update(TechNewsVO vo) throws Exception;
	
	public void delete(Integer tno) throws Exception;
	
	public List<TechNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public void uptReplyCnt(Integer tno, int amount) throws Exception;
	
	public void uptViewCnt(Integer tno) throws Exception;
	
	public void uptTodayViewCnt() throws Exception;
	
	public void uptVoteCnt_positive(Integer tno, int amount) throws Exception;
	
	public void uptVoteCnt_negative(Integer tno, int amount) throws Exception;
	
	public void addAttach(String fullName) throws Exception;
	
	public List<String> getAttach(Integer tno) throws Exception;
	
	public void delAttach(Integer tno) throws Exception;
	
	public void replaceAttach(String fullName, Integer tno) throws Exception;
	

}
