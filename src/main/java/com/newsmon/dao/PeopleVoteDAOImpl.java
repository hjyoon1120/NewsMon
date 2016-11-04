package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleVoteVO;

@Repository
public class PeopleVoteDAOImpl implements PeopleVoteDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.PeopleVoteDAO";

	@Override
	public List<PeopleVoteVO> showAll(Integer pno) throws Exception {

		return session.selectList(namespace + ".showAll", pno);
	}

	@Override
	public List<PeopleVoteVO> voteList(Integer pno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("pno", pno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".voteList", paramMap);
	}

	@Override
	public void vote(PeopleVoteVO vo) throws Exception {
		session.insert(namespace + ".vote", vo);
	}

	@Override
	public void revote(PeopleVoteVO vo) throws Exception {
		session.update(namespace + ".revote", vo);
	}

	@Override
	public int cntVote(Integer pno) throws Exception {

		return session.selectOne(namespace + ".cntVote", pno);
	}

	@Override
	public int cntPositive(Integer pno) throws Exception {

		return session.selectOne(namespace + ".cntPositive", pno);
	}

	@Override
	public int cntNegative(Integer pno) throws Exception {

		return session.selectOne(namespace + ".cntNegative", pno);
	}

	@Override
	public int getPno(Integer vno) throws Exception {
		return session.selectOne(namespace + ".getPno", vno);
	}

}
