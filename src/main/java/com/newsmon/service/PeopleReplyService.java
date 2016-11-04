package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleReplyVO;

public interface PeopleReplyService {
	
	public List<PeopleReplyVO> showAll(Integer pno) throws Exception;
	
	public void addReply(PeopleReplyVO vo) throws Exception;
	
	public void modifyReply(PeopleReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<PeopleReplyVO> listReply(Integer pno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer pno) throws Exception;

}
