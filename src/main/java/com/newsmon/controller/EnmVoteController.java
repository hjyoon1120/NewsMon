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
import com.newsmon.domain.EnmVoteVO;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.EnmVoteService;

@RestController
@RequestMapping("/enm_vote")
public class EnmVoteController {

	@Inject
	private EnmVoteService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> vote(@RequestBody EnmVoteVO vo) {
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

	@RequestMapping(value = "/all/{eno}", method = RequestMethod.GET)
	public ResponseEntity<List<EnmVoteVO>> list(@PathVariable("eno") Integer eno) {

		ResponseEntity<List<EnmVoteVO>> entity = null;

		try {
			entity = new ResponseEntity<>(service.showAll(eno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/{eno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> voteList(@PathVariable("eno") Integer eno,
			@PathVariable("page") Integer page) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria_ten cri_ten = new Criteria_ten();
			cri_ten.setPage(page);

			PageMaker_ten pageMaker_ten = new PageMaker_ten();
			pageMaker_ten.setCri_ten(cri_ten);

			Map<String, Object> map = new HashMap<String, Object>();
			List<EnmVoteVO> voteList = service.voteList(eno, cri_ten);

			map.put("voteList", voteList);

			int voteCnt = service.cntVote(eno);
			pageMaker_ten.setTotalCnt(voteCnt);

			map.put("pageMaker_ten", pageMaker_ten);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	@RequestMapping(value = "/{eno}/{vno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> revote(@PathVariable("eno") Integer eno, @PathVariable("vno") Integer vno, @RequestBody EnmVoteVO vo) {

		ResponseEntity<String> entity = null;

		try {
			vo.setEno(eno);	
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
