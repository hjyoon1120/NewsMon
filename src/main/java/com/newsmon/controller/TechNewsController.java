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
import com.newsmon.domain.TechNewsVO;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.service.TechNewsService;

@Controller
@RequestMapping("/tech/")
public class TechNewsController {

	private static final Logger logger = LoggerFactory.getLogger(TechNewsController.class);

	@Inject
	private TechNewsService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(TechNewsVO vo, Model model) throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(TechNewsVO vo, RedirectAttributes rttr) throws Exception {

		logger.info(vo.toString());

		service.register(vo);
		rttr.addFlashAttribute("msg", "register");

		return "redirect:/tech/";
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

		/* model.addAttribute("techNewsVO", service.read(tno)); */
		model.addAttribute("techNewsVO", service.today());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("tno") int tno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {

		model.addAttribute("techNewsVO", service.read(tno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("tno") int tno, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		service.remove(tno);

		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());
		rttr.addFlashAttribute("msg", "remove");

		return "redirect:/tech/";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("tno") int tno, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {

		model.addAttribute("techNewsVO", service.read(tno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(TechNewsVO vo, Criteria_ten cri_ten, RedirectAttributes rttr) throws Exception {

		logger.info("tech mod post.....");
		service.modify(vo);

		rttr.addAttribute("page", cri_ten.getPage());
		rttr.addAttribute("perPageNum", cri_ten.getPerPageNum());
		rttr.addAttribute("keyword", cri_ten.getKeyword());

		rttr.addFlashAttribute("msg", "modify");

		return "redirect:/tech/";
	}

	@RequestMapping("/getAttach/{tno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("tno") Integer tno) throws Exception {

		return service.getAttach(tno);
	}

}
