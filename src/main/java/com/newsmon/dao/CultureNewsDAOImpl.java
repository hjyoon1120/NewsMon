package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureNewsVO;

@Repository
public class CultureNewsDAOImpl implements CultureNewsDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.CultureNewsDAO";

	@Override
	public void create(CultureNewsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public CultureNewsVO today() throws Exception {
		return session.selectOne(namespace + ".today");
	}

	@Override
	public CultureNewsVO read(Integer cno) throws Exception {

		return session.selectOne(namespace + ".read", cno);
	}

	@Override
	public void update(CultureNewsVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer cno) throws Exception {

		session.delete(namespace + ".delete", cno);
	}

	@Override
	public List<CultureNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return session.selectList(namespace + ".list", cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {

		return session.selectOne(namespace + ".cntPaging", cri_ten);
	}

	@Override
	public void uptReplyCnt(Integer cno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("cno", cno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptReplyCnt", paramMap);
	}

	@Override
	public void uptViewCnt(Integer cno) throws Exception {

		session.update(namespace + ".uptViewCnt", cno);
	}

	@Override
	public void uptTodayViewCnt() throws Exception {

		session.update(namespace + ".uptTodayViewCnt");
	}

	@Override
	public void uptVoteCnt_positive(Integer cno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("cno", cno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_positive", paramMap);
	}

	@Override
	public void uptVoteCnt_negative(Integer cno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("cno", cno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_negative", paramMap);
	}

	@Override
	public void addAttach(String fullName) throws Exception {

		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(Integer cno) throws Exception {

		return session.selectList(namespace + ".getAttach", cno);
	}

	@Override
	public void delAttach(Integer cno) throws Exception {

		session.delete(namespace + ".delAttach", cno);
	}

	@Override
	public void replaceAttach(String fullName, Integer cno) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("cno", cno);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);
	}

}
