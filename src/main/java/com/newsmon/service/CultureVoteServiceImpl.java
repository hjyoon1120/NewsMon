package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.CultureNewsDAO;
import com.newsmon.dao.CultureVoteDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureVoteVO;

@Service
public class CultureVoteServiceImpl implements CultureVoteService {

	@Inject
	private CultureVoteDAO voteDAO;

	@Inject
	private CultureNewsDAO newsDAO;

	@Override
	public List<CultureVoteVO> showAll(Integer cno) throws Exception {

		return voteDAO.showAll(cno);
	}

	@Override
	public List<CultureVoteVO> voteList(Integer cno, Criteria_ten cri_ten) throws Exception {

		return voteDAO.voteList(cno, cri_ten);
	}

	@Transactional
	@Override
	public void vote(CultureVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_positive(vo.getCno(), 1);
		} else {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_negative(vo.getCno(), 1);
		}
	}

	@Transactional
	@Override
	public void revote(CultureVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getCno(), -1);
			newsDAO.uptVoteCnt_positive(vo.getCno(), 1);
		} else {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getCno(), 1);
			newsDAO.uptVoteCnt_positive(vo.getCno(), -1);
		}
	}

	@Override
	public int cntVote(Integer cno) throws Exception {

		return voteDAO.cntVote(cno);

	}

	@Override
	public int cntPositive(Integer cno) throws Exception {

		return voteDAO.cntPositive(cno);
	}

	@Override
	public int cntNegative(Integer cno) throws Exception {

		return voteDAO.cntNegative(cno);
	}

}
