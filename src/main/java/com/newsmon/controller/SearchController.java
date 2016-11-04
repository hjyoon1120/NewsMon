package com.newsmon.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.SearchService;

@Controller
@RequestMapping("/search/")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Inject
	private SearchService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public void societyList(@ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model) throws Exception {
		
		logger.info(cri_ten.toString());
		
		model.addAttribute("societyList", service.societyList(cri_ten));
		
		PageMaker_ten pageMaker_ten= new PageMaker_ten();
		
		pageMaker_ten.setCri_ten(cri_ten);
		
		pageMaker_ten.setTotalCnt(service.societyCnt(cri_ten));
		
		model.addAttribute("pageMaker", pageMaker_ten);
	}
}
