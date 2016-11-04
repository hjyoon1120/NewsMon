package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsReplyVO;

public interface SportsReplyService {
	
	public List<SportsReplyVO> showAll(Integer sno) throws Exception;
	
	public void addReply(SportsReplyVO vo) throws Exception;
	
	public void modifyReply(SportsReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<SportsReplyVO> listReply(Integer sno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer sno) throws Exception;

}
