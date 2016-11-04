package com.newsmon.service;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechReplyVO;

public interface TechReplyService {
	
	public List<TechReplyVO> showAll(Integer tno) throws Exception;
	
	public void addReply(TechReplyVO vo) throws Exception;
	
	public void modifyReply(TechReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
	
	public List<TechReplyVO> listReply(Integer tno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer tno) throws Exception;

}
