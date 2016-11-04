package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.CultureNewsDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureNewsVO;

@Service
public class CultureNewsServiceImpl implements CultureNewsService {

	@Inject
	private CultureNewsDAO dao;

	@Transactional
	@Override
	public void register(CultureNewsVO vo) throws Exception {

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
	public CultureNewsVO today() throws Exception {

		dao.uptTodayViewCnt();
		return dao.today();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public CultureNewsVO read(Integer cno) throws Exception {

		dao.uptViewCnt(cno);
		return dao.read(cno);
	}

	@Transactional
	@Override
	public void modify(CultureNewsVO vo) throws Exception {

		dao.update(vo);
		Integer cno = vo.getCno();

		dao.delAttach(cno);
		String[] files = vo.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, cno);
		}

	}

	@Transactional
	@Override
	public void remove(Integer cno) throws Exception {

		dao.delAttach(cno);
		dao.delete(cno);
	}

	@Override
	public List<CultureNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return dao.list(cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {
		
		return dao.cntPaging(cri_ten);
	}

	@Override
	public List<String> getAttach(Integer cno) throws Exception {

		return dao.getAttach(cno);

	}

}
