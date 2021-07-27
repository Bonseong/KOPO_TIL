package kr.ac.kopo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.HandlerMapping;

public class FrontControllerServlet extends HttpServlet {
	
	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String propLoc = config.getInitParameter("propertyLocation");
		//해당 이름을 가지고 있는 value를 가져옴 
		
		if(propLoc != null)
			mappings = new HandlerMapping(propLoc);
		else
			mappings = new HandlerMapping();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// 1. 클라이언트로부터 요청을 받음
		String context = request.getContextPath();
		
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());
		
//	 	System.out.println("요청 URI : " + uri);
		System.out.println(mappings.prop.getProperty(uri)); // <----
		
		try {
			// 2. 클라이언트의 uri를 HandlerMapping 쪽으로 전송
			Controller control = mappings.getController(uri); // <----
			System.out.println(control);

			// 3. HandlerMapping으로부터 요청에 맞는 Controller 객체를 받아옴
			String callPage = control.handleRequest(request, response);
			

			if(callPage.startsWith("redirect:")) {
				// callPage = "redirect:/index.jsp"
				callPage = callPage.substring("redirect:".length());
				response.sendRedirect(request.getContextPath() + callPage);
			} else {
				// 4. 만약 HandlerMapping 에서 callPage 객체가 있다면 해당하는 Controller로 request
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}

		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}



