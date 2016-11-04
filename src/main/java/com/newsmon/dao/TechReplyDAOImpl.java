package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechReplyVO;

@Repository
public class TechReplyDAOImpl implements TechReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.TechReplyDAO";

	@Override
	public List<TechReplyVO> showAll(Integer tno) throws Exception {

		return session.selectList(namespace + ".showAll", tno);

	}

	@Override
	public void create(TechReplyVO vo) throws Exception {

		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(TechReplyVO vo) throws Exception {

		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {

		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<TechReplyVO> list(Integer tno, Criteria_ten cri_ten) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("tno", tno);
		paramMap.put("cri_ten", cri_ten);

		return session.selectList(namespace + ".list", paramMap);
	}

	@Override
	public int cntReply(Integer tno) throws Exception {

		return session.selectOne(namespace + ".cntReply", tno);
	}

	@Override
	public int getTno(Integer rno) throws Exception {

		return session.selectOne(namespace + ".getTno", rno);
	}

}
