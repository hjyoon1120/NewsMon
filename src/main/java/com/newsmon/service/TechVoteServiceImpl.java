package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.TechNewsDAO;
import com.newsmon.dao.TechVoteDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechVoteVO;

@Service
public class TechVoteServiceImpl implements TechVoteService {

	@Inject
	private TechVoteDAO voteDAO;

	@Inject
	private TechNewsDAO newsDAO;

	@Override
	public List<TechVoteVO> showAll(Integer tno) throws Exception {

		return voteDAO.showAll(tno);
	}

	@Override
	public List<TechVoteVO> voteList(Integer tno, Criteria_ten cri_ten) throws Exception {

		return voteDAO.voteList(tno, cri_ten);
	}

	@Transactional
	@Override
	public void vote(TechVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_positive(vo.getTno(), 1);
		} else {
			voteDAO.vote(vo);
			newsDAO.uptVoteCnt_negative(vo.getTno(), 1);
		}
	}

	@Transactional
	@Override
	public void revote(TechVoteVO vo) throws Exception {

		if (vo.isPositive()) {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getTno(), -1);
			newsDAO.uptVoteCnt_positive(vo.getTno(), 1);
		} else {
			voteDAO.revote(vo);
			newsDAO.uptVoteCnt_negative(vo.getTno(), 1);
			newsDAO.uptVoteCnt_positive(vo.getTno(), -1);
		}
	}

	@Override
	public int cntVote(Integer tno) throws Exception {

		return voteDAO.cntVote(tno);

	}

	@Override
	public int cntPositive(Integer tno) throws Exception {

		return voteDAO.cntPositive(tno);
	}

	@Override
	public int cntNegative(Integer tno) throws Exception {

		return voteDAO.cntNegative(tno);
	}

}
