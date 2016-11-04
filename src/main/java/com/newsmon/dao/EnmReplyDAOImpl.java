package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmReplyVO;

@Repository
public class EnmReplyDAOImpl implements EnmReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.EnmReplyDAO";

	@Override
	public List<EnmReplyVO> showAll(Integer eno) throws Exception {

		return session.selectList(namespace + ".showAll", eno);

	}

	@Override
	public void create(EnmReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(EnmReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {

		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<EnmReplyVO> list(Integer eno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("eno", eno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".list", paramMap);
	}

	@Override
	public int cntReply(Integer eno) throws Exception {

		return session.selectOne(namespace + ".cntReply", eno);
	}

	@Override
	public int getEno(Integer rno) throws Exception {

		return session.selectOne(namespace + ".getEno", rno);
	}

}
