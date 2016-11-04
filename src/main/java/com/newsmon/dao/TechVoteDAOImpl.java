package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechVoteVO;

@Repository
public class TechVoteDAOImpl implements TechVoteDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.TechVoteDAO";

	@Override
	public List<TechVoteVO> showAll(Integer tno) throws Exception {

		return session.selectList(namespace + ".showAll", tno);
	}

	@Override
	public List<TechVoteVO> voteList(Integer tno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("tno", tno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".voteList", paramMap);
	}

	@Override
	public void vote(TechVoteVO vo) throws Exception {
		session.insert(namespace + ".vote", vo);
	}

	@Override
	public void revote(TechVoteVO vo) throws Exception {
		session.update(namespace + ".revote", vo);
	}

	@Override
	public int cntVote(Integer tno) throws Exception {

		return session.selectOne(namespace + ".cntVote", tno);
	}

	@Override
	public int cntPositive(Integer tno) throws Exception {

		return session.selectOne(namespace + ".cntPositive", tno);
	}

	@Override
	public int cntNegative(Integer tno) throws Exception {

		return session.selectOne(namespace + ".cntNegative", tno);
	}

	@Override
	public int getTno(Integer vno) throws Exception {
		return session.selectOne(namespace + ".getTno", vno);
	}

}
