package com.newsmon.dao;

import java.util.Date;
import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.UserVO;
import com.newsmon.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(int uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
	
	public void addAccount(UserVO vo) throws Exception;
	
	public UserVO readAccount(Integer uid) throws Exception;
	
	public void uptAccount(UserVO vo) throws Exception;
	
	public void delAccount(Integer uid) throws Exception;
	
	/*public List<UserVO> listAccount(Criteria_ten cri_ten) throws Exception;*/
	
	/*public int cntPaging(Criteria_ten cri_ten) throws Exception;*/
}
