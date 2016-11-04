package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

public interface SearchDAO {
	
	public List<SocietyNewsVO> societyList(Criteria_ten cri_ten) throws Exception;
	
	public int societyCnt (Criteria_ten cri_ten) throws Exception;

}
