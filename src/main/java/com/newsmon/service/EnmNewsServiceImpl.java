package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.EnmNewsDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.EnmNewsVO;

@Service
public class EnmNewsServiceImpl implements EnmNewsService {

	@Inject
	private EnmNewsDAO dao;

	@Transactional
	@Override
	public void register(EnmNewsVO vo) throws Exception {

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
	public EnmNewsVO today() throws Exception {

		dao.uptTodayViewCnt();
		return dao.today();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public EnmNewsVO read(Integer eno) throws Exception {

		dao.uptViewCnt(eno);
		return dao.read(eno);
	}

	@Transactional
	@Override
	public void modify(EnmNewsVO vo) throws Exception {

		dao.update(vo);
		Integer eno = vo.getEno();

		dao.delAttach(eno);
		String[] files = vo.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, eno);
		}

	}

	@Transactional
	@Override
	public void remove(Integer eno) throws Exception {

		dao.delAttach(eno);
		dao.delete(eno);
	}

	@Override
	public List<EnmNewsVO> list(Criteria_ten cri_ten) throws Exception {

		return dao.list(cri_ten);
	}

	@Override
	public int cntPaging(Criteria_ten cri_ten) throws Exception {
		
		return dao.cntPaging(cri_ten);
	}

	@Override
	public List<String> getAttach(Integer eno) throws Exception {

		return dao.getAttach(eno);

	}

}
