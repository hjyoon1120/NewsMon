package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureReplyVO;

@Repository
public class CultureReplyDAOImpl implements CultureReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.CultureReplyDAO";

	@Override
	public List<CultureReplyVO> showAll(Integer cno) throws Exception {

		return session.selectList(namespace + ".showAll", cno);

	}

	@Override
	public void create(CultureReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(CultureReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {

		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<CultureReplyVO> list(Integer cno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("cno", cno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".list", paramMap);
	}

	@Override
	public int cntReply(Integer cno) throws Exception {

		return session.selectOne(namespace + ".cntReply", cno);
	}

	@Override
	public int getCno(Integer rno) throws Exception {

		return session.selectOne(namespace + ".getCno", rno);
	}

}
