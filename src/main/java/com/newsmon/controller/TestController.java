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
import com.newsmon.domain.CultureNewsVO;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.CultureNewsService;

@Controller
@RequestMapping("/test")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(CultureNewsController.class);

	@Inject
	private CultureNewsService service;

	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public void registerGET(CultureNewsVO vo, Model model) throws Exception {

		logger.info("Register...GET.... in culture news test");
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String registerPOST(CultureNewsVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("Register POST.. in culture news test");
		logger.info(vo.toString());

		service.register(vo);
		rttr.addFlashAttribute("msg", "reg");

		return "redirect:/test/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model) throws Exception {

		logger.info(cri_ten.toString());
		model.addAttribute("list", service.list(cri_ten));
		PageMaker_ten pageMaker_ten = new PageMaker_ten();

		pageMaker_ten.setCri_ten(cri_ten);
		pageMaker_ten.setTotalCnt(service.cntPaging(cri_ten));

		model.addAttribute("pageMaker_ten", service.today());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void today(Model model) throws Exception {

		model.addAttribute("cultureNewsVO", service.today());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("cno") int cno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {
		
		model.addAttribute("cultureNewsVO", service.read(cno));

	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("cno") int cno, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		service.remove(cno);
		
		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());
		
		rttr.addFlashAttribute("msg", "modify");
		
		return "redirect:/culture/";
	}
	
	@RequestMapping("/getAttach/{cno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("cno") Integer cno) throws Exception {
		return service.getAttach(cno);
	}
}
