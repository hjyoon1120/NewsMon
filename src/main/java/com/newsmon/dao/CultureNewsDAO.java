package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureNewsVO;

public interface CultureNewsDAO {

	public void create(CultureNewsVO vo) throws Exception;

	public CultureNewsVO today() throws Exception;

	public CultureNewsVO read(Integer cno) throws Exception;

	public void update(CultureNewsVO vo) throws Exception;

	public void delete(Integer cno) throws Exception;

	public List<CultureNewsVO> list(Criteria_ten cri_ten) throws Exception;

	public int cntPaging(Criteria_ten cri_ten) throws Exception;

	public void uptReplyCnt(Integer cno, int amount) throws Exception;

	public void uptViewCnt(Integer cno) throws Exception;

	public void uptTodayViewCnt() throws Exception;

	public void uptVoteCnt_positive(Integer cno, int amount) throws Exception;

	public void uptVoteCnt_negative(Integer cno, int amount) throws Exception;

	public void addAttach(String fullName) throws Exception;

	public List<String> getAttach(Integer cno) throws Exception;

	public void delAttach(Integer cno) throws Exception;

	public void replaceAttach(String fullName, Integer cno) throws Exception;

}
