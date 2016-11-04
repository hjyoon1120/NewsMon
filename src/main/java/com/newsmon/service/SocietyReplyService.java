package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyReplyVO;

public interface SocietyReplyService {

	public List<SocietyReplyVO> showAll(Integer sno) throws Exception;
	
	public void addReply(SocietyReplyVO vo) throws Exception;

	public void modifyReply(SocietyReplyVO vo) throws Exception;

	public void removeReply(Integer rno) throws Exception;
	
	public List<SocietyReplyVO> listReply(Integer sno, Criteria_ten cri_ten) throws Exception;

	public int cntReply(Integer sno) throws Exception;
}

