package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsNewsVO;

public interface SportsNewsService {
	
	public void register(SportsNewsVO vo) throws Exception;
	
	public SportsNewsVO today() throws Exception;
	
	public SportsNewsVO read(Integer sno) throws Exception;
	
	public void modify(SportsNewsVO vo) throws Exception;
	
	public void remove(Integer sno) throws Exception;
	
	public List<SportsNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public List<String> getAttach(Integer sno) throws Exception;
}
