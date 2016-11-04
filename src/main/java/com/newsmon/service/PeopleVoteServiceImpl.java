package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.PeopleNewsDAO;
import com.newsmon.dao.PeopleVoteDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleVoteVO;

@Service
public class PeopleVoteServiceImpl implements PeopleVoteService {

	@Inject
	private PeopleVoteDAO voteDAO;

	@Inject
	private PeopleNewsDAO newsDAO;

	@Override
	public List<PeopleVoteVO> showAll(Integer pno) throws Exception {

		return voteDAO.showAll(pno);
	}

	@Override
	public List<PeopleVoteVO> voteList(Integer pno, Criteria_ten cri_ten) throws Exception {

		return voteDAO.voteList(pno, cri_ten);
	}

	@Transactional
	@Override
	public void vote(PeopleVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_positive(vo.getPno(), 1);
		} else {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_negative(vo.getPno(), 1);
		}
	}

	@Transactional
	@Override
	public void revote(PeopleVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getPno(), -1);
			newsDAO.uptVoteCnt_positive(vo.getPno(), 1);
		} else {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getPno(), 1);
			newsDAO.uptVoteCnt_positive(vo.getPno(), -1);
		}
	}

	@Override
	public int cntVote(Integer pno) throws Exception {

		return voteDAO.cntVote(pno);

	}

	@Override
	public int cntPositive(Integer pno) throws Exception {

		return voteDAO.cntPositive(pno);
	}

	@Override
	public int cntNegative(Integer pno) throws Exception {

		return voteDAO.cntNegative(pno);
	}

}
