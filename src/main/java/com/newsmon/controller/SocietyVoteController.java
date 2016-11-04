package com.newsmon.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsmon.domain.SocietyVoteVO;
import com.newsmon.service.SocietyVoteService;

@RestController
@RequestMapping("/society_vote")
public class SocietyVoteController {

	@Inject
	private SocietyVoteService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> vote(@RequestBody SocietyVoteVO vo) {

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

	@RequestMapping(value = "/all/{sno}", method = RequestMethod.GET)
	public ResponseEntity<List<SocietyVoteVO>> list(@PathVariable("sno") Integer sno) {

		ResponseEntity<List<SocietyVoteVO>> entity = null;

		try {
			entity = new ResponseEntity<>(service.showAll(sno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value="/{vno}", method = {RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> revote(@PathVariable("vno") Integer vno, @RequestBody SocietyVoteVO vo) {
		
		ResponseEntity<String> entity = null;
		
		try{
			vo.setVno(vno);
			service.revote(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	

}
