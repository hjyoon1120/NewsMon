package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleReplyVO;

@Repository
public class PeopleReplyDAOImpl implements PeopleReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.PeopleReplyDAO";

	@Override
	public List<PeopleReplyVO> showAll(Integer pno) throws Exception {

		return session.selectList(namespace + ".showAll", pno);

	}

	@Override
	public void create(PeopleReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(PeopleReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {

		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<PeopleReplyVO> list(Integer pno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("pno", pno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".list", paramMap);
	}

	@Override
	public int cntReply(Integer pno) throws Exception {

		return session.selectOne(namespace + ".cntReply", pno);
	}

	@Override
	public int getPno(Integer rno) throws Exception {

		return session.selectOne(namespace + ".getPno", rno);
	}

}
