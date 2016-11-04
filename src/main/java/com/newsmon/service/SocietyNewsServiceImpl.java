package com.newsmon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.newsmon.dao.SocietyNewsDAO;
import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SocietyNewsVO;

@Service
public class SocietyNewsServiceImpl implements SocietyNewsService {

	@Inject
	private SocietyNewsDAO dao;

	@Transactional
	@Override
	public void register(SocietyNewsVO vo) throws Exception {
		dao.create(vo);
		
		String[] files = vo.getFiles();
		System.out.println("files[] : " + files);
		if(files == null) { return;	}
		
		for (String fileName : files) {
			dao.addAttach(fileName);
			System.out.println("fileName: " + fileName);
			
		}
	}
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SocietyNewsVO today() throws Exception {
		
		dao.uptTodayViewCnt();
		return dao.today();
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public SocietyNewsVO read(Integer sno) throws Exception {
		
		dao.uptViewCnt(sno);
		return dao.read(sno);
	}
	
	@Transactional
	@Override
	public void modify(SocietyNewsVO vo) throws Exception {
		dao.update(vo);
		
		Integer sno = vo.getSno();
		
		dao.deleteAttach(sno);
		
		String[] files = vo.getFiles();
		
		if(files == null) { return; }
		
		for	(String fileName : files) {
			dao.replaceAttach(fileName, sno);
		}
	}
	
	@Transactional
	@Override
	public void remove(Integer sno) throws Exception {
		
		dao.deleteAttach(sno);
		dao.delete(sno);
	}

	@Override
	public List<SocietyNewsVO> list(Criteria_ten cri_ten) throws Exception {
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
