package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.EnmNewsDAO;
import com.newsmon.dao.EnmVoteDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmNewsVO;
import com.newsmon.domain.EnmVoteVO;

@Service
public class EnmVoteServiceImpl implements EnmVoteService {

	@Inject
	private EnmVoteDAO voteDAO;

	@Inject
	private EnmNewsDAO newsDAO;

	@Override
	public List<EnmVoteVO> showAll(Integer eno) throws Exception {

		return voteDAO.showAll(eno);
	}

	@Override
	public List<EnmVoteVO> voteList(Integer eno, Criteria_ten cri_ten) throws Exception {

		return voteDAO.voteList(eno, cri_ten);
	}

	@Transactional
	@Override
	public void vote(EnmVoteVO vo) throws Exception {

		voteDAO.vote(vo);
		if (vo.getResult().equals("positive")) {
			newsDAO.uptVoteCnt_positive(vo.getEno(), 1);
		} else if(vo.getResult().equals("negative")) {
			newsDAO.uptVoteCnt_negative(vo.getEno(), 1);
		}
		
		EnmNewsVO enmNewsVO = new EnmNewsVO();
		newsDAO.uptVoteRate(enmNewsVO);
		
	}

	@Transactional
	@Override
	public void revote(EnmVoteVO vo) throws Exception {
		System.out.println("start to revote: ");
		voteDAO.revote(vo);
		System.out.println(vo);
		if (vo.getResult().equals("positive")) {
			newsDAO.uptVoteCnt_negative(vo.getEno(), -1);
			newsDAO.uptVoteCnt_positive(vo.getEno(), 1);
			System.out.println("from negative to positive");
		} else if(vo.getResult().equals("negative")){
			System.out.println("from positive to negative");
			newsDAO.uptVoteCnt_negative(vo.getEno(), 1);
			newsDAO.uptVoteCnt_positive(vo.getEno(), -1);
		}
	}

	@Override
	public int cntVote(Integer eno) throws Exception {

		return voteDAO.cntVote(eno);

	}

	@Override
	public int cntPositive(Integer eno) throws Exception {

		return voteDAO.cntPositive(eno);
	}

	@Override
	public int cntNegative(Integer eno) throws Exception {

		return voteDAO.cntNegative(eno);
	}

}
