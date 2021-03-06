package com.newsmon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.CultureVoteVO;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.CultureVoteService;

@RestController
@RequestMapping("/culture_vote")
public class CultureVoteController {

	@Inject
	private CultureVoteService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> vote(@RequestBody CultureVoteVO vo) {
		ResponseEntity<String> entity = null;

		try {
			service.vote(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/all/{cno}", method = RequestMethod.GET)
	public ResponseEntity<List<CultureVoteVO>> list(@PathVariable("cno") Integer cno) {

		ResponseEntity<List<CultureVoteVO>> entity = null;

		try {
			entity = new ResponseEntity<>(service.showAll(cno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/{cno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> voteList(@PathVariable("cno") Integer cno,
			@PathVariable("page") Integer page) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria_ten cri_ten = new Criteria_ten();
			cri_ten.setPage(page);

			PageMaker_ten pageMaker_ten = new PageMaker_ten();
			pageMaker_ten.setCri_ten(cri_ten);

			Map<String, Object> map = new HashMap<String, Object>();
			List<CultureVoteVO> voteList = service.voteList(cno, cri_ten);

			map.put("voteList", voteList);

			int voteCnt = service.cntVote(cno);
			pageMaker_ten.setTotalCnt(voteCnt);

			map.put("pageMaker_ten", pageMaker_ten);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/{vno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> revote(@PathVariable("vno") Integer vno, @RequestBody CultureVoteVO vo) {

		ResponseEntity<String> entity = null;

		try {

			vo.setVno(vno);

			service.revote(vo);

			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
