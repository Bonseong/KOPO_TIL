package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MemberController {
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}

	
	@RequestMapping("/join.do")
	public String join(MemberVO member, Model model) {
		model.addAttribute("member", member);
		return "form/memberInfo";
		
		
		/*
		 * ModelAndView mav = new ModelAndView(); mav.setViewName("form/memberInfo");
		 * mav.addObject("member", member);
		 */
		
		//@mode@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name, HttpServletRequest request
		// RequestParam : request.getParameter 역할, String id 에 id에서 받아온 객체를 넣음
		// 파라미터 인자의 순서는 중요하지 않음

		/*
		 * MemberVO member = new MemberVO(); member.setId(id);
		 * member.setPassword(password); member.setName(name);
		 * 
		 * request.setAttribute("member", member);
		 */
		
		
		// MemberVO member만 쓰면 -> MemberVO 객체에 알아서 mapping 됨
		// @ModelAttribute("member") MemberVO member -> member를 공유영역에 올림
		

	}
	/*
	 * public String join(HttpServletRequest request) { // 메소드 호출시 스프링이 원하는 파라미터를
	 * 요청할수도 있음 // 원래는 인코딩 해줘야하지만 filter에서 되어있는 상태
	 * 
	 * String id = request.getParameter("id"); String password =
	 * request.getParameter("password"); String name = request.getParameter("name");
	 * 
	 * MemberVO member = new MemberVO(); member.setId(id);
	 * member.setPassword(password); member.setName(name);
	 * 
	 * request.setAttribute("member", member); return "form/memberInfo";
	 * 
	 * 
	 * }
	 */
}

/*
 * 실제 uri : /spring-mvc/form/joinForm.do 매번 상위 주소를 써주는 것이 아니라 클래스 위에 상위 주소를 선언함
 */