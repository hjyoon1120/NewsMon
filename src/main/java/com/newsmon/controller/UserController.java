package com.newsmon.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.newsmon.domain.Criteria_ten;
import com.newsmon.domain.PageMaker_ten;
import com.newsmon.domain.UserVO;
import com.newsmon.dto.LoginDTO;
import com.newsmon.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {

		UserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("userVO", vo);

		if (dto.isUseCookie()) {

			int amount = 60 * 60 * 24 * 7;

			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

			service.keepLogin(vo.getUid(), session.getId(), sessionLimit);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("login");

		if (obj != null) {
			UserVO vo = (UserVO) obj;

			session.removeAttribute("login");
			session.invalidate();

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {

				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getUid(), session.getId(), new Date());
			}
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(UserVO vo, Model model) throws Exception {

		logger.info("register account get....");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("user register post.....");
		logger.info(vo.toString());

		service.addAccount(vo);

		rttr.addFlashAttribute("msg", "reg");
		return "redirect:/";
	}

	/*
	 * @RequestMapping(value="/list", method = RequestMethod.GET) public void
	 * userList(@ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
	 * throws Exception {
	 * 
	 * logger.info("show all user list with paging");
	 * logger.info(cri_ten.toString());
	 * 
	 * model.addAttribute("list", service.listAccount(cri_ten));
	 * 
	 * PageMaker_ten pageMaker_ten = new PageMaker_ten();
	 * 
	 * pageMaker_ten.setCri_ten(cri_ten);
	 * pageMaker_ten.setTotalCnt(service.cntPaging(cri_ten));
	 * 
	 * model.addAttribute("pageMaker", pageMaker_ten); }
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("uid") int uid, @ModelAttribute("cri_ten") Criteria_ten cri_ten, Model model)
			throws Exception {
		model.addAttribute("userVO", service.readAccount(uid));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("uid") int uid, RedirectAttributes rttr) throws Exception {

		service.delAccount(uid);

		rttr.addFlashAttribute("msg", "del");

		return "redirect:/";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int uid, Model model) throws Exception {

		model.addAttribute("userVO", service.readAccount(uid));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(UserVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("user modify post....");
		service.uptAccount(vo);

		rttr.addFlashAttribute("msg", "mod");

		return "redirect:/";

	}

}
