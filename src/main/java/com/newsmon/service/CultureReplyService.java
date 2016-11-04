package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureReplyVO;

public interface CultureReplyService {
	
	public List<CultureReplyVO> showAll(Integer cno) throws Exception;
	
	public void addReply(CultureReplyVO vo) throws Exception;
	
	public void modifyReply(CultureReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<CultureReplyVO> listReply(Integer cno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer cno) throws Exception;

}
