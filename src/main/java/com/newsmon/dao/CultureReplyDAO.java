package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureReplyVO;

public interface CultureReplyDAO {
	
	public List<CultureReplyVO> showAll(Integer cno) throws Exception;
	
	public void create(CultureReplyVO vo) throws Exception;
	
	public void update(CultureReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	public List<CultureReplyVO> list(Integer cno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer cno) throws Exception;
	
	public int getCno(Integer rno) throws Exception;
}
