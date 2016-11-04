package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.TechNewsDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.TechNewsVO;

@Service
public class TechNewsServiceImpl implements TechNewsService {

	@Inject
	private TechNewsDAO dao;

	@Transactional
	@Override
	public void register(TechNewsVO vo) throws Exception {

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
	public TechNewsVO today() throws Exception {

		dao.uptTodayViewCnt();
		return dao.today();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public TechNewsVO read(Integer tno) throws Exception {

		dao.uptViewCnt(tno);
		return dao.read(tno);
	}

	@Transactional
	@Override
	public void modify(TechNewsVO vo) throws Exception {

		dao.update(vo);
		Integer tno = vo.getTno();

		dao.delAttach(tno);
		String[] files = vo.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, tno);
		}

	}

	@Transactional
	@Override
	public void remove(Integer tno) throws Exception {

		dao.delAttach(tno);
		dao.delete(tno);
	}

	@Override
	public List<TechNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return dao.list(cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {
		
		return dao.cntPaging(cri_ten);
	}

	@Override
	public List<String> getAttach(Integer tno) throws Exception {

		return dao.getAttach(tno);

	}

}
