package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MemeberController {
	
	@RequestMapping("/formForm.do")
	public String formForm() {
		return "form/formForm";
	}
	
	
	@RequestMapping("/form.do")
	public String form(MemberVO member, Model model) {
		
		model.addAttribute("member", member);
				
		return "form/memberInfo";
	}
/*	
	@RequestMapping("/form.do")
	public ModelAndView form(MemberVO member) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form/memberInfo");
		mav.addObject("member", member);
		
		return mav;
	}
*/	
/*	
	@RequestMapping("/form.do")
	public String form(@ModelAttribute("member") MemberVO member) {
		
		
		return "form/memberInfo";
	}
*/	
/*	
	@RequestMapping("/form.do")
	public String form(@RequestParam("id") String id, 
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
	@RequestMapping("/form.do")
	public String form(HttpServletRequest request) {
		
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











