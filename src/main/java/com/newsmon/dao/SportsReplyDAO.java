package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsReplyVO;

public interface SportsReplyDAO {

	public List<SportsReplyVO> showAll(Integer sno) throws Exception;

	public void create(SportsReplyVO vo) throws Exception;

	public void update(SportsReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;

	public List<SportsReplyVO> list(Integer sno, Criteria_ten cri_ten) throws Exception;

	public int cntReply(Integer sno) throws Exception;

	public int getSno(Integer rno) throws Exception;
}
