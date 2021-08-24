package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes("userVO") // 얘는 request 영역이 아니라 session영역에 등록됨
@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/login")
	public String loginForm() {
		return "login/login";
	}

	@PostMapping("/login")
	public String login(MemberVO member, Model model, HttpSession session) {
		MemberVO userVO = service.login(member);

		if (userVO == null) {
			String msg = "아이디 또는 패스워드가 잘못되었습니다.";
			model.addAttribute("msg", msg);
			return "login/login";
		}
		
		// 로그인 성공
		model.addAttribute("userVO", userVO);
		
		String dest = (String)session.getAttribute("dest");
		if(dest!=null) { // 로그인 인터셉터를 거쳐왔다면
			session.removeAttribute("dest");
			return "redirect:"+ dest;
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		System.out.println(sessionStatus.isComplete());
		sessionStatus.setComplete();
		System.out.println(sessionStatus.isComplete());
		return "redirect:/";
	}

}
