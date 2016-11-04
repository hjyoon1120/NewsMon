package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmReplyVO;

public interface EnmReplyService {
	
	public List<EnmReplyVO> showAll(Integer eno) throws Exception;
	
	public void addReply(EnmReplyVO vo) throws Exception;
	
	public void modifyReply(EnmReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<EnmReplyVO> listReply(Integer eno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer eno) throws Exception;

}
