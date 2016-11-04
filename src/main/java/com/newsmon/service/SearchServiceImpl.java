package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.newsmon.dao.SearchDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Inject
	private SearchDAO dao;
	
	@Override
	public List<SocietyNewsVO> societyList(Criteria_ten cri_ten) throws Exception {
		
		return dao.societyList(cri_ten);
	}
	
	@Override
	public int societyCnt(Criteria_ten cri_ten) throws Exception {
		return dao.societyCnt(cri_ten);
	}

}
