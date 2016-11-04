package com.newsmon.dao;

import java.util.List;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsNewsVO;

public interface SportsNewsDAO {

	public void create(SportsNewsVO vo) throws Exception;

	public SportsNewsVO today() throws Exception;

	public SportsNewsVO read(Integer eno) throws Exception;

	public void update(SportsNewsVO vo) throws Exception;

	public void delete(Integer eno) throws Exception;

	public List<SportsNewsVO> list(Criteria_ten cri_ten) throws Exception;

	public int cntPaging(Criteria_ten cri_ten) throws Exception;

	public void uptReplyCnt(Integer sno, int amount) throws Exception;

	public void uptViewCnt(Integer sno) throws Exception;

	public void uptTodayViewCnt() throws Exception;

	public void uptVoteCnt_positive(Integer sno, int amount) throws Exception;

	public void uptVoteCnt_negative(Integer sno, int amount) throws Exception;

	public void addAttach(String fullName) throws Exception;

	public List<String> getAttach(Integer sno) throws Exception;

	public void delAttach(Integer sno) throws Exception;

	public void replaceAttach(String fullName, Integer sno) throws Exception;

}
