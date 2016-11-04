package com.newsmon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

@Repository
public class SocietyNewsDAOImpl implements SocietyNewsDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.SocietyNewsDAO";

	@Override
	public void create(SocietyNewsVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public SocietyNewsVO today() throws Exception {
		return session.selectOne(namespace + ".today");
	}

	@Override
	public SocietyNewsVO read(Integer sno) throws Exception {
		return session.selectOne(namespace + ".read", sno);
	}

	@Override
	public void update(SocietyNewsVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer sno) throws Exception {
		session.delete(namespace + ".delete", sno);
	}

	@Override
	public List<SocietyNewsVO> list(Criteria_ten cri_ten) throws Exception {
		return session.selectList(namespace + ".list", cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {
		return session.selectOne(namespace + ".cntPaging", cri_ten);
	}

	@Override
	public void uptReplyCnt(Integer sno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("sno", sno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptReplyCnt", paramMap);
	}

	@Override
	public void uptViewCnt(Integer sno) throws Exception {

		session.update(namespace + ".uptViewCnt", sno);
	}
	
	@Override
	public void uptTodayViewCnt() throws Exception {
		session.update(namespace + ".uptTodayViewCnt");
	}

	@Override
	public void uptVoteCnt_positive(Integer sno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("sno", sno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_positive", paramMap);
	}

	@Override
	public void uptVoteCnt_negative(Integer sno, int amount) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("sno", sno);
		paramMap.put("amount", amount);

		session.update(namespace + ".uptVoteCnt_negative", paramMap);
	}

	@Override
	public void addAttach(String fullName) throws Exception {

		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(Integer sno) throws Exception {

		return session.selectList(namespace + ".getAttach", sno);
	}

	@Override
	public void deleteAttach(Integer sno) throws Exception {

		session.delete(namespace + ".deleteAttach", sno);
	}

	@Override
	public void replaceAttach(String fullName, Integer sno) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("sno", sno);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);

	}
}
