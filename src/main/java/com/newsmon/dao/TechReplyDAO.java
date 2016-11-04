package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechReplyVO;

public interface TechReplyDAO {
	
	public List<TechReplyVO> showAll(Integer tno) throws Exception;
	
	public void create(TechReplyVO vo) throws Exception;
	
	public void update(TechReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	public List<TechReplyVO> list(Integer tno, Criteria_ten cri_ten) throws Exception;
	
	public int cntReply(Integer tno) throws Exception;
	
	public int getTno(Integer rno) throws Exception;
}
