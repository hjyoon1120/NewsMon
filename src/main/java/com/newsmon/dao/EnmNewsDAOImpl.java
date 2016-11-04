package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmNewsVO;

@Repository
public class EnmNewsDAOImpl implements EnmNewsDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.EnmNewsDAO";

	@Override
	public void create(EnmNewsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public EnmNewsVO today() throws Exception {
		return session.selectOne(namespace + ".today");
	}

	@Override
	public EnmNewsVO read(Integer eno) throws Exception {

		return session.selectOne(namespace + ".read", eno);
	}

	@Override
	public void update(EnmNewsVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer eno) throws Exception {

		session.delete(namespace + ".delete", eno);
	}

	@Override
	public List<EnmNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return session.selectList(namespace + ".list", cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {

		return session.selectOne(namespace + ".cntPaging", cri_ten);
	}

	@Override
	public void uptReplyCnt(Integer eno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("eno", eno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptReplyCnt", paramMap);
	}

	@Override
	public void uptViewCnt(Integer eno) throws Exception {

		session.update(namespace + ".uptViewCnt", eno);
	}

	@Override
	public void uptTodayViewCnt() throws Exception {

		session.update(namespace + ".uptTodayViewCnt");
	}

	@Override
	public void uptVoteCnt_positive(Integer eno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("eno", eno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_positive", paramMap);
	}

	@Override
	public void uptVoteCnt_negative(Integer eno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("eno", eno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_negative", paramMap);
	}

	@Override
	public void addAttach(String fullName) throws Exception {

		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(Integer eno) throws Exception {

		return session.selectList(namespace + ".getAttach", eno);
	}

	@Override
	public void delAttach(Integer eno) throws Exception {

		session.delete(namespace + ".delAttach", eno);
	}

	@Override
	public void replaceAttach(String fullName, Integer eno) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("eno", eno);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);
	}
	
	@Override
	public void uptVoteRate(EnmNewsVO vo) throws Exception {
		
		session.update(namespace + ".uptVoteRate", vo);
	}
}
