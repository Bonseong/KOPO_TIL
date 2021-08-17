package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MemeberController {
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}
	
	
	@RequestMapping("/join.do")
	public String join(MemberVO member, Model model) {
		
		model.addAttribute("member", member);
				
		return "form/memberInfo";
	}
/*	
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo");
		mav.addObject("member", member);
		
		return mav;
	}
*/	
/*	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member") MemberVO member) {
		
		
		return "form/memberInfo";
	}
*/	
/*	
	@RequestMapping("/join.do")
	public String join(@RequestParam("id") String id, 
			@RequestParam("password") String password, 
			@RequestParam("name") String name,
			HttpServletRequest request) {
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}
*/	
/*	
	@RequestMapping("/join.do")
	public String join(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}
*/	
}











