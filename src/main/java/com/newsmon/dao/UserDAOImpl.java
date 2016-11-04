package com.newsmon.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.UserVO;
import com.newsmon.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.newsmon.dao.UserDAO";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {

		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void keepLogin(int uid, String sessionId, Date next) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("uid", uid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);

		session.update(namespace + ".keepLogin", paramMap);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {

		return session.selectOne(namespace + ".checkUserWithSessionKey", value);
	}

	@Override
	public void addAccount(UserVO vo) throws Exception {
		session.insert(namespace + ".addAccount", vo);
	}

	@Override
	public UserVO readAccount(Integer uid) throws Exception {

		return session.selectOne(namespace + ".readAccount", uid);
	}

	@Override
	public void uptAccount(UserVO vo) throws Exception {

		session.update(namespace + ".uptAccount", vo);
	}

	@Override
	public void delAccount(Integer uid) throws Exception {

		session.delete(namespace + ".delAccount", uid);
	}

	/*@Override
	public List<UserVO> listAccount(Criteria_ten cri_ten) throws Exception {
		return session.selectList(namespace + ".listAccount", cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {

		return session.selectOne(namespace + ".cntPaging");
	}*/

}
