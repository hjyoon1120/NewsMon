package com.newsmon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.SocietyVoteVO;

@Repository
public class SocietyVoteDAOImpl implements SocietyVoteDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.SocietyVoteDAO";

	@Override
	public List<SocietyVoteVO> showAll(Integer sno) throws Exception {

		return session.selectList(namespace + ".showAll", sno);
	}

	@Override
	public void vote(SocietyVoteVO vo) throws Exception {

		session.insert(namespace + ".vote", vo);
	}

	@Override
	public void revote(SocietyVoteVO vo) throws Exception {

		session.update(namespace + ".revote", vo);
	}

	@Override
	public int cntVote(SocietyVoteVO vo) throws Exception {

		return session.selectOne(namespace + ".cntVote", vo);
	}

	@Override
	public int getSno(Integer vno) throws Exception {

		return session.selectOne(namespace + ".getSno", vno);
	}

}
