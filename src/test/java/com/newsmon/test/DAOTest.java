package com.newsmon.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newsmon.dao.SocietyNewsDAO;
import com.newsmon.domain.SocietyNewsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class DAOTest {

	@Inject
	private SocietyNewsDAO dao;

	private static Logger logger = LoggerFactory.getLogger(DAOTest.class);

	@Test
	public void testCreate() throws Exception {

		SocietyNewsVO vo = new SocietyNewsVO();

		vo.setTitle("뉴스 제목입니다...");
		vo.setSubtitle("소제목입니다....");
		vo.setContent("뉴스 기사 내용입니다......");
		vo.setReporter_id(0);
		vo.setPress("뉴스몬");
		dao.create(vo);
	}

	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}

	@Test
	public void testUpdate() throws Exception {

		SocietyNewsVO vo = new SocietyNewsVO();
		vo.setSno(1);
		vo.setTitle("수정된 제목입니다...");
		vo.setSubtitle("수정된 소제목입니다...");
		vo.setContent("수정된 기사내용입니다...");
		vo.setReporter_id(0);
		vo.setPress("오버워치");
		dao.update(vo);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
}
