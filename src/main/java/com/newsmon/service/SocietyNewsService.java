package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

public interface SocietyNewsService {
	
	public void register(SocietyNewsVO vo) throws Exception;
	
	public SocietyNewsVO today() throws Exception;
	
	public SocietyNewsVO read(Integer sno) throws Exception;
	
	public void modify(SocietyNewsVO vo) throws Exception;
	
	public void remove(Integer sno) throws Exception;
	
	public List<SocietyNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public List<String> getAttach(Integer sno) throws Exception;
	
}
