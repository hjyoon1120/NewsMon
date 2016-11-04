package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.EnmNewsDAO;
import com.newsmon.dao.EnmReplyDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmReplyVO;

@Service
public class EnmReplyServiceImpl implements EnmReplyService {

	@Inject
	private EnmReplyDAO replyDAO;

	@Inject
	private EnmNewsDAO newsDAO;

	@Override
	public List<EnmReplyVO> showAll(Integer eno) throws Exception {

		return replyDAO.showAll(eno);
	}

	@Transactional
	@Override
	public void addReply(EnmReplyVO vo) throws Exception {

		replyDAO.create(vo);
		newsDAO.uptReplyCnt(vo.getEno(), 1);
	}

	@Override
	public void modifyReply(EnmReplyVO vo) throws Exception {

		replyDAO.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {

		int eno = replyDAO.getEno(rno);

		replyDAO.delete(rno);
		newsDAO.uptReplyCnt(eno, -1);

	}

	@Override
	public List<EnmReplyVO> listReply(Integer eno, Criteria_ten cri_ten) throws Exception {

		return replyDAO.list(eno, cri_ten);
	}

	@Override
	public int cntReply(Integer eno) throws Exception {
		
		return replyDAO.cntReply(eno);
	}

}
