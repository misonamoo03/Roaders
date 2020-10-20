package com.misonamoo.smileway.controller;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.domain.UserVO;
import com.misonamoo.smileway.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService UserService;

	/**
	 * 
	 * @param 로그인함수
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute UserVO svo, HttpServletRequest req, RedirectAttributes rttr,
			HttpServletResponse response) throws Exception {
		UserVO vo = new UserVO();
		vo.setSUSER_ID(svo.getSUSER_ID().toString());
		vo.setSUSER_PW(svo.getSUSER_PW().toString());
		// HttpSession session = req.getSession();
		UserVO login = UserService.login(vo);
		ModelAndView mav;
		if (login == null) {
			// session.setAttribute("User", null);
			rttr.addFlashAttribute("msg", false);
			mav = new ModelAndView("redirect:/");
			return mav;
		} else {
			// session.setAttribute("User", login);
			Cookie loginCookie = new Cookie("id", login.getSUSER_ID());
			loginCookie.setPath("/");
			loginCookie.setMaxAge(-1);
			response.addCookie(loginCookie);
			mav = new ModelAndView("redirect:/");
			return mav;
		}
	}

	@RequestMapping(value = "*/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout2(HttpServletResponse response, HttpServletRequest request,
			HttpSession session/*@CookieValue(value="id",required=false)Cookie genderCookie */) throws Exception {
		System.out.println("로그아웃중@!!@!@!@");
		// session.invalidate();
		Cookie[] cookies = request.getCookies(); // 모든 쿠키의 정보를 cookies에 저장
		if (cookies != null) { // 쿠키가 한개라도 있으면 실행
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
				response.addCookie(cookies[i]); // 응답 헤더에 추가
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp() {
		return "/User/signup";
	}

	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@RequestBody Map<String, Object> params, UserVO userVO) throws Exception {
		UserVO uservo = new UserVO();

		uservo.setSUSER_ID(params.get("SUSER_ID").toString());
		uservo.setSUSER_PW(params.get("SUSER_PW").toString());
		uservo.setSUSER_EMAIL(params.get("SUSER_EMAIL").toString());
		uservo.setSPHONE(params.get("SPHONE").toString());
		uservo.setSUSER_NAME(params.get("SUSER_NAME").toString());
		uservo.setSUSER_ADDRESS(params.get("SUSER_ADDRESS").toString());
		uservo.setSUSER_POSTCODE(params.get("SUSER_POSTCODE").toString());
		uservo.setSUSER_AGRE_ESSEN(params.get("SUSER_AGRE_ESSEN").toString());
		uservo.setSUSER_AGRE_OPTION(params.get("SUSER_AGRE_OPTION").toString());

		logger.info(uservo.getSUSER_ID());
		logger.info(uservo.getSUSER_PW());
		logger.info(uservo.getSUSER_NAME());
		logger.info(uservo.getSPHONE());

		// uservo.setSUSER_ID(params.get("SUSER_ID").toString());
		UserService.signUp(uservo);
		return "/index";
	}

	@ResponseBody
	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody Map<String, Object> params) throws Exception {

		UserVO uservo = new UserVO();
		uservo.setSUSER_ID(params.get("SUSER_ID").toString());
		int result = UserService.checkId(uservo);

		return result;
	}

	@RequestMapping(value = "emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public int emailCheck(@RequestBody UserVO uservo) throws Exception {
		int result = UserService.checkEmail(uservo);

		return result;
	}

	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String Login() {
		return "User/loginform";
	}

	@RequestMapping(value = "/essenPopup", method = RequestMethod.GET)
	public String EssenPopup() {
		return "User/essenPopup";
	}

	@RequestMapping(value = "/optionPopup", method = RequestMethod.GET)
	public String OptionPopoup() {
		return "User/optionPopup";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET) // GET 방식으로 페이지 호출
	public String read(@RequestParam("SUSER_ID") String SUSER_ID, Model model) throws Exception {
		// 인자값은 파라미터 값으로 기본키 ID를 기준으로 Model을 사용하여 불러옴
		model.addAttribute(UserService.read(SUSER_ID)); // read 서비스 호출
		return "User/read";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(UserVO uservo, RedirectAttributes rttr) throws Exception {
		UserService.modify(uservo); // 회원정보수정 서비스 호출
		return "redirect:/"; // 수정이 완료된 후, 홈목록페이지로 리턴
	}

}
