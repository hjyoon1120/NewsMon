package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.SocietyNewsDAO;
import com.newsmon.dao.SocietyReplyDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyReplyVO;

@Service
public class SocietyReplyServiceImpl implements SocietyReplyService {

	@Inject
	private SocietyReplyDAO replyDAO;
	
	@Inject
	private SocietyNewsDAO newsDAO;
	
	@Override
	public List<SocietyReplyVO> showAll(Integer sno) throws Exception {
		
		return replyDAO.showAll(sno);
	}
	
	@Transactional
	@Override
	public void addReply(SocietyReplyVO vo) throws Exception {
		
		replyDAO.create(vo);
		newsDAO.uptReplyCnt(vo.getSno(), 1);
	}

	@Override
	public void modifyReply(SocietyReplyVO vo) throws Exception {
		
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
	public List<SocietyReplyVO> listReply(Integer sno, Criteria_ten cri_ten) throws Exception {
		
		return replyDAO.list(sno, cri_ten);
	}
	
	@Override
	public int cntReply(Integer sno) throws Exception {
		
		return replyDAO.cntReply(sno);
	}
}
