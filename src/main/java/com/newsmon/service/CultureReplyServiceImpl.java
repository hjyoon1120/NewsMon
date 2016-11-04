package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.CultureNewsDAO;
import com.newsmon.dao.CultureReplyDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureReplyVO;

@Service
public class CultureReplyServiceImpl implements CultureReplyService {

	@Inject
	private CultureReplyDAO replyDAO;

	@Inject
	private CultureNewsDAO newsDAO;

	@Override
	public List<CultureReplyVO> showAll(Integer cno) throws Exception {

		return replyDAO.showAll(cno);
	}

	@Transactional
	@Override
	public void addReply(CultureReplyVO vo) throws Exception {

		replyDAO.create(vo);
		newsDAO.uptReplyCnt(vo.getCno(), 1);
	}

	@Override
	public void modifyReply(CultureReplyVO vo) throws Exception {

		replyDAO.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {

		int cno = replyDAO.getCno(rno);

		replyDAO.delete(rno);
		newsDAO.uptReplyCnt(cno, -1);

	}

	@Override
	public List<CultureReplyVO> listReply(Integer cno, Criteria_ten cri_ten) throws Exception {

		return replyDAO.list(cno, cri_ten);
	}

	@Override
	public int cntReply(Integer cno) throws Exception {
		
		return replyDAO.cntReply(cno);
	}

}
