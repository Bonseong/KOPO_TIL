package kr.ac.kopo.framework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping mappings;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String ctrlNames = config.getInitParameter("controllers");
		// System.out.println(ctrlNames);
		try {
			mappings = new HandlerMapping(ctrlNames);
		} catch (Exception e) {
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		System.out.println("요청 URI : " + uri);

		String view = "";
		try {
			CtrlAndMethod cam = mappings.getCtrlAndMethod(uri);
			if (cam == null) {
				throw new ServletException("해당 uri는 존재하지 않습니다");
			}

			Object target = cam.getTarget();
			Method method = cam.getMethod();

			/*
			 * /board/list.do 요청 target = new BoardController(); Method method = public
			 * STring list(HttpServletRequest request, HttpServletResponse response) throws
			 * Exception; String callPage = taget.list(request, response);
			 * 
			 */

			ModelAndView mav = (ModelAndView) method.invoke(target, request, response);
			view = mav.getView();
			
			// request 공유영역 등록
			Map<String, Object> model = mav.getModel();
			Set<String> keys = model.keySet();
			for(String key : keys) {
				request.setAttribute(key,  model.get(key));
				System.out.println("---");
				System.out.println(key);
				System.out.println();
				System.out.println(model.get(key));
				System.out.println("---");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 응답을 위한 JSP 이동, sendRedirect 요청

		if (view.startsWith("redirect:")) {
			view = view.substring("redirect:".length());
			response.sendRedirect(request.getContextPath()+view); // response.sendRedirect("/Mission-Web-MVC02/login.do")
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		}
	}
}
