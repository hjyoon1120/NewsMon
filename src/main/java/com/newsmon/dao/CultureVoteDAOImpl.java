package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureVoteVO;

@Repository
public class CultureVoteDAOImpl implements CultureVoteDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.CultureVoteDAO";

	@Override
	public List<CultureVoteVO> showAll(Integer cno) throws Exception {

		return session.selectList(namespace + ".showAll", cno);
	}

	@Override
	public List<CultureVoteVO> voteList(Integer cno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("cno", cno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".voteList", paramMap);
	}

	@Override
	public void vote(CultureVoteVO vo) throws Exception {
		session.insert(namespace + ".vote", vo);
	}

	@Override
	public void revote(CultureVoteVO vo) throws Exception {
		session.update(namespace + ".revote", vo);
	}

	@Override
	public int cntVote(Integer cno) throws Exception {

		return session.selectOne(namespace + ".cntVote", cno);
	}

	@Override
	public int cntPositive(Integer cno) throws Exception {

		return session.selectOne(namespace + ".cntPositive", cno);
	}

	@Override
	public int cntNegative(Integer cno) throws Exception {

		return session.selectOne(namespace + ".cntNegative", cno);
	}

	@Override
	public int getCno(Integer vno) throws Exception {
		return session.selectOne(namespace + ".getCno", vno);
	}

}
