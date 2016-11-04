package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleNewsVO;

public interface PeopleNewsService {
	
	public void register(PeopleNewsVO vo) throws Exception;
	
	public PeopleNewsVO today() throws Exception;
	
	public PeopleNewsVO read(Integer pno) throws Exception;
	
	public void modify(PeopleNewsVO vo) throws Exception;
	
	public void remove(Integer pno) throws Exception;
	
	public List<PeopleNewsVO> list(Criteria_ten cri_ten) throws Exception;
	
	public int cntPaging(Criteria_ten cri_ten) throws Exception;
	
	public List<String> getAttach(Integer pno) throws Exception;
}
