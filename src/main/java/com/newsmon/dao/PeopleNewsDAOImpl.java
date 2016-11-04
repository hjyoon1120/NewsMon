package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleNewsVO;

@Repository
public class PeopleNewsDAOImpl implements PeopleNewsDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.PeopleNewsDAO";

	@Override
	public void create(PeopleNewsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public PeopleNewsVO today() throws Exception {
		return session.selectOne(namespace + ".today");
	}

	@Override
	public PeopleNewsVO read(Integer pno) throws Exception {

		return session.selectOne(namespace + ".read", pno);
	}

	@Override
	public void update(PeopleNewsVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer pno) throws Exception {

		session.delete(namespace + ".delete", pno);
	}

	@Override
	public List<PeopleNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return session.selectList(namespace + ".list", cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {

		return session.selectOne(namespace + ".cntPaging", cri_ten);
	}

	@Override
	public void uptReplyCnt(Integer pno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("pno", pno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptReplyCnt", paramMap);
	}

	@Override
	public void uptViewCnt(Integer pno) throws Exception {

		session.update(namespace + ".uptViewCnt", pno);
	}

	@Override
	public void uptTodayViewCnt() throws Exception {

		session.update(namespace + ".uptTodayViewCnt");
	}

	@Override
	public void uptVoteCnt_positive(Integer pno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("pno", pno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_positive", paramMap);
	}

	@Override
	public void uptVoteCnt_negative(Integer pno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("pno", pno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_negative", paramMap);
	}

	@Override
	public void addAttach(String fullName) throws Exception {

		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(Integer pno) throws Exception {

		return session.selectList(namespace + ".getAttach", pno);
	}

	@Override
	public void delAttach(Integer pno) throws Exception {

		session.delete(namespace + ".delAttach", pno);
	}

	@Override
	public void replaceAttach(String fullName, Integer pno) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("pno", pno);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);
	}

}
