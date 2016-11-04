package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureNewsVO;

public interface CultureNewsService {
	
	public void register(CultureNewsVO vo) throws Exception;
	
	public CultureNewsVO today() throws Exception;
	
	public CultureNewsVO read(Integer cno) throws Exception;
	
	public void modify(CultureNewsVO vo) throws Exception;
	
	public void remove(Integer cno) throws Exception;
	
	public List<CultureNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public List<String> getAttach(Integer cno) throws Exception;
}
