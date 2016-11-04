package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsReplyVO;

@Repository
public class SportsReplyDAOImpl implements SportsReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.SportsReplyDAO";

	@Override
	public List<SportsReplyVO> showAll(Integer sno) throws Exception {

		return session.selectList(namespace + ".showAll", sno);

	}

	@Override
	public void create(SportsReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(SportsReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {

		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<SportsReplyVO> list(Integer sno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("sno", sno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".list", paramMap);
	}

	@Override
	public int cntReply(Integer sno) throws Exception {

		return session.selectOne(namespace + ".cntReply", sno);
	}

	@Override
	public int getSno(Integer rno) throws Exception {

		return session.selectOne(namespace + ".getSno", rno);
	}

}
