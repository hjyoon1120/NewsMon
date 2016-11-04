package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.SportsNewsDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsNewsVO;

@Service
public class SportsNewsServiceImpl implements SportsNewsService {

	@Inject
	private SportsNewsDAO dao;

	@Transactional
	@Override
	public void register(SportsNewsVO vo) throws Exception {

		dao.create(vo);

		String[] files = vo.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.addAttach(fileName);
		}
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SportsNewsVO today() throws Exception {

		dao.uptTodayViewCnt();
		return dao.today();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SportsNewsVO read(Integer sno) throws Exception {

		dao.uptViewCnt(sno);
		return dao.read(sno);
	}

	@Transactional
	@Override
	public void modify(SportsNewsVO vo) throws Exception {

		dao.update(vo);
		Integer sno = vo.getSno();

		dao.delAttach(sno);
		String[] files = vo.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, sno);
		}

	}

	@Transactional
	@Override
	public void remove(Integer sno) throws Exception {

		dao.delAttach(sno);
		dao.delete(sno);
	}

	@Override
	public List<SportsNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return dao.list(cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {
		
		return dao.cntPaging(cri_ten);
	}

	@Override
	public List<String> getAttach(Integer sno) throws Exception {

		return dao.getAttach(sno);

	}

}
