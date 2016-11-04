package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.SocietyNewsDAO;
import com.newsmon.dao.SocietyVoteDAO;
import com.newsmon.domain.SocietyVoteVO;

@Service
public class SocietyVoteServiceImpl implements SocietyVoteService {
	
	@Inject
	private SocietyVoteDAO voteDAO;
	
	@Inject
	private SocietyNewsDAO newsDAO;
	
	@Override
	public List<SocietyVoteVO> showAll(Integer sno) throws Exception {
		
		return voteDAO.showAll(sno);
	}
	
	@Transactional
	@Override
	public void vote(SocietyVoteVO vo) throws Exception {
		System.out.println("#####start vote: " + vo);
		System.out.println("#####vo.getChoice()" + vo.getChoice());
		voteDAO.vote(vo);
		System.out.println("@@@@@after vote: " + vo);
		System.out.println("@@@@@vo.getChoice()" + vo.getChoice());
		
		if(vo.getChoice().equals("positive")){
			newsDAO.uptVoteCnt_positive(vo.getSno(), 1);
		} else {
			newsDAO.uptVoteCnt_negative(vo.getSno(), 1);
		}
	}
	
	@Override
	public void revote(SocietyVoteVO vo) throws Exception {
		System.out.println("start revote: " + vo);
		System.out.println("******vo.getChoice()" + vo.getChoice());
		voteDAO.revote(vo);
		System.out.println("after revote: " + vo);
		System.out.println("^^^^^vo.getChoice()" + vo.getChoice());
		if(vo.getChoice().equals("positive")){
			newsDAO.uptVoteCnt_positive(vo.getSno(), 1);
			newsDAO.uptVoteCnt_negative(vo.getSno(), -1);
		} else {
			newsDAO.uptVoteCnt_negative(vo.getSno(), 1);
			newsDAO.uptVoteCnt_positive(vo.getSno(), -1);
		}
	}
	
	@Override
	public int cntVote(SocietyVoteVO vo) throws Exception {
		
		return voteDAO.cntVote(vo);
	}
}
