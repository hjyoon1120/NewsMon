package com.newsmon.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.newsmon.dao.UserDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.UserVO;
import com.newsmon.dto.LoginDTO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {

		return dao.login(dto);
	}

	@Override
	public void keepLogin(int uid, String sessionId, Date next) throws Exception {

		dao.keepLogin(uid, sessionId, next);
	}

	@Override
	public UserVO checkLoginBefore(String value) {

		return dao.checkUserWithSessionKey(value);
	}

	@Override
	public void addAccount(UserVO vo) throws Exception {

		dao.addAccount(vo);
	}

	@Override
	public UserVO readAccount(Integer uid) throws Exception {
		return dao.readAccount(uid);
	}

	@Override
	public void uptAccount(UserVO vo) throws Exception {

		dao.uptAccount(vo);
	}

	@Override
	public void delAccount(Integer uid) throws Exception {

		dao.delAccount(uid);
	}

/*	@Override
	public List<UserVO> listAccount(Criteria_ten cri_ten) throws Exception {

		return dao.listAccount(cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {

		return dao.cntPaging(cri_ten);
	}*/

}
