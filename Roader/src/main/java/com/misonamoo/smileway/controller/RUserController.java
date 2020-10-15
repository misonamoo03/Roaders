package com.misonamoo.smileway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.misonamoo.smileway.domain.CodeVO;
import com.misonamoo.smileway.domain.Email;
import com.misonamoo.smileway.domain.EmailSender;
import com.misonamoo.smileway.domain.RUserVO;
import com.misonamoo.smileway.service.RUserService;

@Controller
public class RUserController {
	private static final Logger logger = LoggerFactory.getLogger(RUserController.class);

	@Inject
	private RUserService RUserService;

	// 로그인 처리 ID값을 불러와 있을경우 RUser세션에 담는다.
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute RUserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info(vo.getRuserId());
		logger.info(vo.getRuserPw());
		HttpSession session = req.getSession();
		RUserVO login = RUserService.login(vo);

		logger.info("받은값");

		if (login == null) {
			session.setAttribute("RUser", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("RUser", login);
			logger.info(login.getRuserId());
			logger.info(login.getRuserPw());
		}
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginChk", method = RequestMethod.GET)
	public Map loginChk(HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		Map<String,String> result = new HashMap<String, String>();
		HttpSession session = req.getSession();
		String ruserId = "";
		String loginYN = "N";
		if(session != null && session.getAttribute("RUser")!=null ) {
			ruserId = ((RUserVO)session.getAttribute("RUser")).getRuserId();
			loginYN = "Y";
		}
		result.put("ruserId", ruserId);
		result.put("loginYN", loginYN);
		return result;
	}
	// 로그아웃
	@RequestMapping(value = "*/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	// 로그아웃2
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout2(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	// 로그인 폼이동
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String Login() {
		return "RUser/loginform";
	}

	// 회원정보 수정창 읽어오기
	@RequestMapping(value = "/read", method = RequestMethod.GET) // GET 방식으로 페이지 호출
	public String read(@RequestParam("ruserId") String ruserId, Model model) throws Exception {
		// 인자값은 파라미터 값으로 기본키 ID를 기준으로 Model을 사용하여 불러옴
		RUserVO vo = new RUserVO();
		vo = RUserService.read(ruserId);
		String[] ruserEmailsplit = vo.getRuserEmail().toString().split("@");
		vo.setRuserEmail1(ruserEmailsplit);
		System.out.println(ruserEmailsplit[0]);
		System.out.println(ruserEmailsplit[1]);
		System.out.println("/////"+vo.getRuserEmail1()[0]);
		System.out.println("/////"+vo.getRuserEmail1()[1]);
		model.addAttribute(vo); // read 서비스 호출
		return "RUser/read";
	}

	// 회원정보 수정 완료
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(RUserVO vo, RedirectAttributes rttr) throws Exception {
		RUserService.modify(vo); // 회원정보수정 서비스 호출
		return "redirect:/"; // 수정이 완료된 후, 홈목록페이지로 리턴
	}

	// 회원가입 화면 띄우기
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp() {
		return "/RUser/signup";
	}

	// 회원가입 인설트 DB추가
	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@RequestBody Map<String, Object> params, RUserVO ruserVO) throws Exception {
		RUserVO ruservo = new RUserVO();

		ruservo.setRuserId(params.get("ruserId").toString());
		ruservo.setRuserPw(params.get("ruserPw").toString());
		ruservo.setRuserEmail(params.get("ruserEmail").toString());
		ruservo.setrPhone(params.get("rPhone").toString());
		ruservo.setRuserName(params.get("ruserName").toString());
		ruservo.setRuserAddress1(params.get("ruserAddress1").toString());
		ruservo.setRuserAddress2(params.get("ruserAddress2").toString());
		ruservo.setRuserPostCode(params.get("ruserPostCode").toString());
		ruservo.setRuserAgreEssen(params.get("ruserAgreEssen").toString());
		ruservo.setRuserAgreOption(params.get("ruserAgreOption").toString());

		logger.info(ruservo.getRuserId());
		logger.info(ruservo.getRuserPw());
		logger.info(ruservo.getRuserName());
		logger.info(ruservo.getrPhone());

		// uservo.setSUSER_ID(params.get("SUSER_ID").toString());
		RUserService.signUp(ruservo);
		return "/index";
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody Map<String, Object> params) throws Exception {
		RUserVO ruservo = new RUserVO();
		ruservo.setRuserId(params.get("ruserId").toString());
		int result = RUserService.checkId(ruservo);

		return result;
	}

//	// 뷰 통신 연습
//	@ResponseBody
//	@RequestMapping(value = "/idCheckJson", method = RequestMethod.GET)
//	public Map idCheckJson(@RequestParam("ruserId") String ruserId) throws Exception {
//
//		RUserVO ruservo = new RUserVO();
//		ruservo.setRuserId(ruserId);
//		int result = RUserService.checkId(ruservo);
//		Map resultMap = new HashMap<String, Object>();
//
//		resultMap.put("result", result);
//
//		return resultMap;
//	}

	// 이메일 중복 체크

	@RequestMapping(value = "emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public int emailCheck(@RequestBody RUserVO ruservo) throws Exception {
		int result = RUserService.checkEmail(ruservo);

		return result;
	}

	// 팝업화면 띄우기-필수
	@RequestMapping(value = "/essenPopup", method = RequestMethod.GET)
	public String EssenPopup() {
		return "RUser/essenPopup";
	}

	// 팝업화면 띄우기-옵션
	@RequestMapping(value = "/optionPopup", method = RequestMethod.GET)
	public String OptionPopoup() {
		return "RUser/optionPopup";
	}

	// 아이디찾기 화면 띄우기
	@RequestMapping(value = "/idchk", method = RequestMethod.GET)
	public String idchk() {
		return "/RUser/idchk";
	}

	// 이메일 값을 받아와아이디로 리턴
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public String idChk(@ModelAttribute RUserVO ruservo, HttpServletRequest req, RedirectAttributes rttr)
			throws Exception {
		logger.info(ruservo.getRuserEmail());
		HttpSession session = req.getSession();
		RUserVO idChk = RUserService.idChk(ruservo);
		if (idChk == null) {
			logger.info("아이디나 이메일이 없을때");
			session.setAttribute("idChk", null);
			rttr.addFlashAttribute("no", false);
		} else {
			logger.info("있을 때");
			session.setAttribute("idChk", idChk);

		}

		return "redirect:/idchk";
	}

	// 비밀번호 찾기 화면 띄우기
	@RequestMapping(value = "/pwSearch", method = RequestMethod.GET)
	public String pwSearch() {
		return "/RUser/pwSearch";
	}

	// 입력한 아이디와 이메일 값으로 비밀번호를 찾은 뒤 이메일로 전송
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;

	// 비밀번호 찾기 버튼을 누르면 실행
	@RequestMapping(value = "/pwc", method = RequestMethod.POST)
	public ModelAndView sendEmailAction(@ModelAttribute RUserVO ruservo, ModelMap model) throws Exception {
		logger.info(ruservo.getRuserId());
		logger.info(ruservo.getRuserEmail());
		String codeBuf = "";
		String cc = "";
		String url = "http://localhost:8080/pwReset?secCode=";
		ModelAndView mav;
		RUserVO vo = RUserService.getPw(ruservo);
		String pw = (String) vo.getRuserPw();
		System.out.println(pw);
		String id = (String) vo.getRuserId();
		String e_mail = (String) vo.getRuserEmail();

		CodeVO cv = new CodeVO();
		System.out.println(vo.getRuserNo() + "회원번호!!!!@@@@@@@");
		cv.setSecNo(vo.getRuserNo());// RUSER_NO를 가져와서 보안코드랑 일치시킨다.
		System.out.println("담은회원번호" + cv.getSecNo());
		int result = RUserService.cheackNo(cv);
		System.out.println(result);
		if (result == 0) {
			Random rnd = new Random(); // 랜덤코드를 씌우기 위해서
			StringBuffer buf = new StringBuffer();// 보안코드 값을
			for (int i = 0; i < 8; i++) {
				// rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한
				// 숫자를 StringBuffer 에 append 한다.
				if (rnd.nextBoolean()) {
					buf.append((char) ((int) (rnd.nextInt(26)) + 97));
				} else {
					buf.append((rnd.nextInt(10)));
				}
				codeBuf = buf.toString();
				logger.info(codeBuf);
			}
			cv.setSecCode(codeBuf);
			RUserService.insertCode(cv);// 코드 등록
		} else {
			cv = this.RUserService.readCode(cv);
			cc = cv.getSecCode();
		}

		logger.info(pw);
		if (pw != null) {
			email.setContent("찾는 페이지입니다." + url + codeBuf + cc);
			email.setReceiver(e_mail);
			email.setSubject(id + "님 비밀번호 찾기 메일입니다.");
			emailSender.SendEmail(email);
			mav = new ModelAndView("/index");
			return mav;
		} else {
			mav = new ModelAndView("/index");
			return mav;
		}
	}
	// 로그인 폼이동
		@RequestMapping(value = "/notCode", method = RequestMethod.GET)
		public String notCode() {
			return "RUser/notCode";
		}
	
	// 비밀번호+보안코드 입력 화면 띄우기
	@RequestMapping(value = "/pwReset", method = RequestMethod.GET)
	public ModelAndView pwReset(@RequestParam("secCode") String secCode, Model model) throws Exception {
		ModelAndView mav = null;
		// 보안코드체크
		CodeVO cv = new CodeVO();
		cv.setSecCode(secCode);
		cv.setSecNo(RUserService.getSecNo(cv.getSecCode()));
		int result = RUserService.cheackCode(cv);
		// 보안코드가 있을경우
		if (result == 1) {
			// ==>비밀번호 찾기 페이지로 이동
			RUserVO opwvo = new RUserVO();
			opwvo.setRuserNo(cv.getSecNo());
			String orgpw = RUserService.orgPw(cv.getSecNo());
			opwvo.setRuserPw(orgpw);
			mav = new ModelAndView("RUser/pwReset");
			mav.addObject("codeVO", cv);
			mav.addObject("RuserVO", opwvo);
			return mav;
		} else {
			// 보안코드가 없을경우
			System.out.println("잘못된 접근입니다.");
			mav = new ModelAndView("RUser/notCode");
			return mav;
		}
	}

	// 비밀번호 업데이트
	@ResponseBody
	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	public ModelAndView changePw(@ModelAttribute RUserVO vo, @RequestParam("secNo") String secNo) throws Exception {
		ModelAndView mav = null;
		RUserVO rvo = new RUserVO();
		System.out.println(secNo + "::::::::::회원번호");
		System.out.println(vo.getRuserPw() + ":::::::::비밀번호");
		rvo.setRuserNo(secNo);
		
		rvo.setRuserPw(vo.getRuserPw());
		RUserService.updatePw(rvo);
		mav = new ModelAndView("/index");
		return mav;
	}
}
