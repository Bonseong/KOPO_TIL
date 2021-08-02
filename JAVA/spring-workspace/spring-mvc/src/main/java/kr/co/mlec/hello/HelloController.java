package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
   
   @RequestMapping("/hello/hello.do")
   public ModelAndView hello() {
      ModelAndView mav = new ModelAndView("hello/hello"); //forward시킬 jsp주소
      mav.addObject("msg", "hi spring");
      return mav;
   }
}