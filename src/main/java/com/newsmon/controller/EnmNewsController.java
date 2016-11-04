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
import com.newsmon.domain.EnmNewsVO;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.EnmNewsService;

@Controller
@RequestMapping("/enm/")
public class EnmNewsController {

	private static final Logger logger = LoggerFactory.getLogger(EnmNewsController.class);

	@Inject
	private EnmNewsService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(EnmNewsVO vo, Model model) throws Exception {

		logger.info("Register GET... in ENM News");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(EnmNewsVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("Register POST.... in ENM news");
		logger.info(vo.toString());

		service.register(vo);
		rttr.addFlashAttribute("msg", "register");

		return "redirect:/enm/";
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

		/* model.addAttribute("enmNewsVO", service.read(eno)); */
		model.addAttribute("enmNewsVO", service.today());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("eno") int eno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {

		model.addAttribute("enmNewsVO", service.read(eno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("eno") int eno, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		service.remove(eno);

		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());
		rttr.addFlashAttribute("msg", "remove");

		return "redirect:/enm/";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("eno") int eno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {

		model.addAttribute("enmNewsVO", service.read(eno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(EnmNewsVO vo, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		logger.info("enm mod post.....");
		service.modify(vo);

		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());

		rttr.addFlashAttribute("msg", "modify");

		return "redirect:/enm/";
	}

	@RequestMapping("/getAttach/{eno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("eno") Integer eno) throws Exception {

		return service.getAttach(eno);
	}

}
