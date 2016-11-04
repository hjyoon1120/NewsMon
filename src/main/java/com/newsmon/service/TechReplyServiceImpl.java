package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.TechNewsDAO;
import com.newsmon.dao.TechReplyDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechReplyVO;

@Service
public class TechReplyServiceImpl implements TechReplyService {

	@Inject
	private TechReplyDAO replyDAO;

	@Inject
	private TechNewsDAO newsDAO;

	@Override
	public List<TechReplyVO> showAll(Integer tno) throws Exception {

		return replyDAO.showAll(tno);
	}

	@Transactional
	@Override
	public void addReply(TechReplyVO vo) throws Exception {

		replyDAO.create(vo);
		newsDAO.uptReplyCnt(vo.getTno(), 1);
	}

	@Override
	public void modifyReply(TechReplyVO vo) throws Exception {

		replyDAO.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {

		int tno = replyDAO.getTno(rno);

		replyDAO.delete(rno);
		newsDAO.uptReplyCnt(tno, -1);

	}

	@Override
	public List<TechReplyVO> listReply(Integer tno, Criteria_ten cri_ten) throws Exception {

		return replyDAO.list(tno, cri_ten);
	}

	@Override
	public int cntReply(Integer tno) throws Exception {
		
		return replyDAO.cntReply(tno);
	}

}
