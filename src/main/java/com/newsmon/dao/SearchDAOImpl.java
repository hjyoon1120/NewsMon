package com.newsmon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

@Repository
public class SearchDAOImpl implements SearchDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.SearchDAO";
	
	@Override
	public List<SocietyNewsVO> societyList(Criteria_ten cri_ten) throws Exception {
		return session.selectList(namespace + ".societyList", cri_ten);
	}

	@Override
	public int societyCnt(Criteria_ten cri_ten) throws Exception {
		return session.selectOne(namespace + ".societyCnt", cri_ten);
	}
	

}
