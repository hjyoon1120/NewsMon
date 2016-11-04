package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.PeopleNewsDAO;
import com.newsmon.dao.PeopleReplyDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleReplyVO;

@Service
public class PeopleReplyServiceImpl implements PeopleReplyService {

	@Inject
	private PeopleReplyDAO replyDAO;

	@Inject
	private PeopleNewsDAO newsDAO;

	@Override
	public List<PeopleReplyVO> showAll(Integer pno) throws Exception {

		return replyDAO.showAll(pno);
	}

	@Transactional
	@Override
	public void addReply(PeopleReplyVO vo) throws Exception {

		replyDAO.create(vo);
		newsDAO.uptReplyCnt(vo.getPno(), 1);
	}

	@Override
	public void modifyReply(PeopleReplyVO vo) throws Exception {

		replyDAO.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {

		int pno = replyDAO.getPno(rno);

		replyDAO.delete(rno);
		newsDAO.uptReplyCnt(pno, -1);

	}

	@Override
	public List<PeopleReplyVO> listReply(Integer pno, Criteria_ten cri_ten) throws Exception {

		return replyDAO.list(pno, cri_ten);
	}

	@Override
	public int cntReply(Integer pno) throws Exception {

		return replyDAO.cntReply(pno);
	}

}
