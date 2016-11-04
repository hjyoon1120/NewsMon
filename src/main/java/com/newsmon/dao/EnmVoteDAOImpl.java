package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmVoteVO;

@Repository
public class EnmVoteDAOImpl implements EnmVoteDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.EnmVoteDAO";

	@Override
	public List<EnmVoteVO> showAll(Integer eno) throws Exception {

		return session.selectList(namespace + ".showAll", eno);
	}
	
	@Override
	public List<EnmVoteVO> voteList(Integer eno, Criteria_ten cri_ten) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("eno", eno);
		paramMap.put("cri_ten", cri_ten);
		
		return session.selectList(namespace + ".voteList", paramMap);
	}

	@Override
	public void vote(EnmVoteVO vo) throws Exception {
		session.insert(namespace + ".vote", vo);
	}

	@Override
	public void revote(EnmVoteVO vo) throws Exception {
		session.update(namespace + ".revote", vo);
	}

	@Override
	public int cntVote(Integer eno) throws Exception {

		return session.selectOne(namespace + ".cntVote", eno);
	}

	@Override
	public int cntPositive(Integer eno) throws Exception {

		return session.selectOne(namespace + ".cntPositive", eno);
	}

	@Override
	public int cntNegative(Integer eno) throws Exception {

		return session.selectOne(namespace + ".cntNegative", eno);
	}

	@Override
	public int getEno(Integer vno) throws Exception {
		return session.selectOne(namespace + ".getEno", vno);
	}

}
