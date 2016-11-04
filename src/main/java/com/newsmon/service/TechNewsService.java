package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechNewsVO;

public interface TechNewsService {
	
	public void register(TechNewsVO vo) throws Exception;
	
	public TechNewsVO today() throws Exception;
	
	public TechNewsVO read(Integer tno) throws Exception;
	
	public void modify(TechNewsVO vo) throws Exception;
	
	public void remove(Integer tno) throws Exception;
	
	public List<TechNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public List<String> getAttach(Integer tno) throws Exception;
}
