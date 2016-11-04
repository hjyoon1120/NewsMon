package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsVoteVO;

@Repository
public class SportsVoteDAOImpl implements SportsVoteDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.SportsVoteDAO";

	@Override
	public List<SportsVoteVO> showAll(Integer sno) throws Exception {

		return session.selectList(namespace + ".showAll", sno);
	}
	
	@Override
	public List<SportsVoteVO> voteList(Integer sno, Criteria_ten cri_ten) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("sno", sno);
		paramMap.put("cri_ten", cri_ten);
		
		return session.selectList(namespace + ".voteList", paramMap);
	}

	@Override
	public void vote(SportsVoteVO vo) throws Exception {
		session.insert(namespace + ".vote", vo);
	}

	@Override
	public void revote(SportsVoteVO vo) throws Exception {
		session.update(namespace + ".revote", vo);
	}

	@Override
	public int cntVote(Integer sno) throws Exception {

		return session.selectOne(namespace + ".cntVote", sno);
	}

	@Override
	public int cntPositive(Integer sno) throws Exception {

		return session.selectOne(namespace + ".cntPositive", sno);
	}

	@Override
	public int cntNegative(Integer sno) throws Exception {

		return session.selectOne(namespace + ".cntNegative", sno);
	}

	@Override
	public int getSno(Integer vno) throws Exception {
		return session.selectOne(namespace + ".getSno", vno);
	}

}
