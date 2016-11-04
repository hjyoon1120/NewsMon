package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.SportsNewsDAO;
import com.newsmon.dao.SportsVoteDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsVoteVO;

@Service
public class SportsVoteServiceImpl implements SportsVoteService {

	@Inject
	private SportsVoteDAO voteDAO;

	@Inject
	private SportsNewsDAO newsDAO;

	@Override
	public List<SportsVoteVO> showAll(Integer sno) throws Exception {

		return voteDAO.showAll(sno);
	}

	@Override
	public List<SportsVoteVO> voteList(Integer sno, Criteria_ten cri_ten) throws Exception {

		return voteDAO.voteList(sno, cri_ten);
	}

	@Transactional
	@Override
	public void vote(SportsVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_positive(vo.getSno(), 1);
		} else {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_negative(vo.getSno(), 1);
		}
	}

	@Transactional
	@Override
	public void revote(SportsVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getSno(), -1);
			newsDAO.uptVoteCnt_positive(vo.getSno(), 1);
		} else {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getSno(), 1);
			newsDAO.uptVoteCnt_positive(vo.getSno(), -1);
		}
	}

	@Override
	public int cntVote(Integer sno) throws Exception {

		return voteDAO.cntVote(sno);

	}

	@Override
	public int cntPositive(Integer sno) throws Exception {

		return voteDAO.cntPositive(sno);
	}

	@Override
	public int cntNegative(Integer sno) throws Exception {

		return voteDAO.cntNegative(sno);
	}

}
