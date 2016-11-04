package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmNewsVO;

public interface EnmNewsService {
	
	public void register(EnmNewsVO vo) throws Exception;
	
	public EnmNewsVO today() throws Exception;
	
	public EnmNewsVO read(Integer eno) throws Exception;
	
	public void modify(EnmNewsVO vo) throws Exception;
	
	public void remove(Integer eno) throws Exception;
	
	public List<EnmNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public List<String> getAttach(Integer eno) throws Exception;
}
