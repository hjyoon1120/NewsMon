package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.SportsNewsDAO;
import com.newsmon.dao.SportsReplyDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsReplyVO;

@Service
public class SportsReplyServiceImpl implements SportsReplyService {

	@Inject
	private SportsReplyDAO replyDAO;

	@Inject
	private SportsNewsDAO newsDAO;

	@Override
	public List<SportsReplyVO> showAll(Integer sno) throws Exception {

		return replyDAO.showAll(sno);
	}

	@Transactional
	@Override
	public void addReply(SportsReplyVO vo) throws Exception {

		replyDAO.create(vo);
		newsDAO.uptReplyCnt(vo.getSno(), 1);
	}

	@Override
	public void modifyReply(SportsReplyVO vo) throws Exception {

		replyDAO.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {

		int sno = replyDAO.getSno(rno);

		replyDAO.delete(rno);
		newsDAO.uptReplyCnt(sno, -1);

	}

	@Override
	public List<SportsReplyVO> listReply(Integer sno, Criteria_ten cri_ten) throws Exception {

		return replyDAO.list(sno, cri_ten);
	}

	@Override
	public int cntReply(Integer sno) throws Exception {
		
		return replyDAO.cntReply(sno);
	}

}
