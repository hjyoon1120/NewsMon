package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmReplyVO;

public interface EnmReplyDAO {
	
	public List<EnmReplyVO> showAll(Integer eno) throws Exception;
	
	public void create(EnmReplyVO vo) throws Exception;
	
	public void update(EnmReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	public List<EnmReplyVO> list(Integer eno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer eno) throws Exception;
	
	public int getEno(Integer rno) throws Exception;
}
