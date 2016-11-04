package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechNewsVO;

@Repository
public class TechNewsDAOImpl implements TechNewsDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.TechNewsDAO";

	@Override
	public void create(TechNewsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public TechNewsVO today() throws Exception {
		return session.selectOne(namespace + ".today");
	}

	@Override
	public TechNewsVO read(Integer tno) throws Exception {

		return session.selectOne(namespace + ".read", tno);
	}

	@Override
	public void update(TechNewsVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer tno) throws Exception {

		session.delete(namespace + ".delete", tno);
	}

	@Override
	public List<TechNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return session.selectList(namespace + ".list", cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {

		return session.selectOne(namespace + ".cntPaging", cri_ten);
	}

	@Override
	public void uptReplyCnt(Integer tno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("tno", tno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptReplyCnt", paramMap);
	}

	@Override
	public void uptViewCnt(Integer tno) throws Exception {

		session.update(namespace + ".uptViewCnt", tno);
	}

	@Override
	public void uptTodayViewCnt() throws Exception {

		session.update(namespace + ".uptTodayViewCnt");
	}

	@Override
	public void uptVoteCnt_positive(Integer tno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("tno", tno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_positive", paramMap);
	}

	@Override
	public void uptVoteCnt_negative(Integer tno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("tno", tno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_negative", paramMap);
	}

	@Override
	public void addAttach(String fullName) throws Exception {

		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(Integer tno) throws Exception {

		return session.selectList(namespace + ".getAttach", tno);
	}

	@Override
	public void delAttach(Integer tno) throws Exception {

		session.delete(namespace + ".delAttach", tno);
	}

	@Override
	public void replaceAttach(String fullName, Integer tno) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("tno", tno);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);
	}

}
