package com.newsmon.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.SportsNewsVO;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.SportsNewsService;

@Controller
@RequestMapping("/sports/")
public class SportsNewsController {

	private static final Logger logger = LoggerFactory.getLogger(SportsNewsController.class);

	@Inject
	private SportsNewsService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(SportsNewsVO vo, Model model) throws Exception {

		logger.info("Register GET... in ENM News");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(SportsNewsVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("Register POST.... in ENM news");
		logger.info(vo.toString());

		service.register(vo);
		rttr.addFlashAttribute("msg", "register");

		return "redirect:/sports/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model) throws Exception {

		logger.info(cri_ten.toString());
		model.addAttribute("list", service.list(cri_ten));
		PageMaker_ten pageMaker_ten = new PageMaker_ten();

		pageMaker_ten.setCri_ten(cri_ten);
		pageMaker_ten.setTotalCnt(service.cntPaging(cri_ten));

		model.addAttribute("pageMaker_ten", pageMaker_ten);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void today(Model model) throws Exception {

		/* model.addAttribute("sportsNewsVO", service.read(sno)); */
		model.addAttribute("sportsNewsVO", service.today());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("sno") int sno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {

		model.addAttribute("sportsNewsVO", service.read(sno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("sno") int sno, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		service.remove(sno);

		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());
		rttr.addFlashAttribute("msg", "remove");

		return "redirect:/sports/";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("sno") int sno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {

		model.addAttribute("sportsNewsVO", service.read(sno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(SportsNewsVO vo, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		logger.info("sports mod post.....");
		service.modify(vo);

		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());

		rttr.addFlashAttribute("msg", "modify");

		return "redirect:/sports/";
	}

	@RequestMapping("/getAttach/{sno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("sno") Integer sno) throws Exception {

		return service.getAttach(sno);
	}

}
