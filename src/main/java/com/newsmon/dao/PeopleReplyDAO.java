package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleReplyVO;

public interface PeopleReplyDAO {

	public List<PeopleReplyVO> showAll(Integer pno) throws Exception;

	public void create(PeopleReplyVO vo) throws Exception;

	public void update(PeopleReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;

	public List<PeopleReplyVO> list(Integer pno, Criteria_ten cri_ten) throws Exception;

	public int cntReply(Integer pno) throws Exception;

	public int getPno(Integer rno) throws Exception;
}
