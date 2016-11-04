package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyReplyVO;

public interface SocietyReplyDAO {

	public List<SocietyReplyVO> showAll(Integer sno) throws Exception;

	public void create(SocietyReplyVO vo) throws Exception;

	public void update(SocietyReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;

	public List<SocietyReplyVO> list(Integer sno, Criteria_ten cri_ten) throws Exception;

	public int cntReply(Integer sno) throws Exception;

	public int getSno(Integer rno) throws Exception;

}
