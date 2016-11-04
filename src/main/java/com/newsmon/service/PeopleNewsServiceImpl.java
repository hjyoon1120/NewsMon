package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.PeopleNewsDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PeopleNewsVO;

@Service
public class PeopleNewsServiceImpl implements PeopleNewsService {

	@Inject
	private PeopleNewsDAO dao;

	@Transactional
	@Override
	public void register(PeopleNewsVO vo) throws Exception {

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
	public PeopleNewsVO today() throws Exception {

		dao.uptTodayViewCnt();
		return dao.today();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public PeopleNewsVO read(Integer pno) throws Exception {

		dao.uptViewCnt(pno);
		return dao.read(pno);
	}

	@Transactional
	@Override
	public void modify(PeopleNewsVO vo) throws Exception {

		dao.update(vo);
		Integer pno = vo.getPno();

		dao.delAttach(pno);
		String[] files = vo.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, pno);
		}

	}

	@Transactional
	@Override
	public void remove(Integer pno) throws Exception {

		dao.delAttach(pno);
		dao.delete(pno);
	}

	@Override
	public List<PeopleNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return dao.list(cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {
		
		return dao.cntPaging(cri_ten);
	}

	@Override
	public List<String> getAttach(Integer pno) throws Exception {

		return dao.getAttach(pno);

	}

}
