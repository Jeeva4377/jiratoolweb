package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Cookie[] arrcookie = req.getCookies();
		String name="";
		boolean result = false;
		if(arrcookie !=null) {
		for (Cookie cookie : arrcookie) {
			if (cookie.getName().equals("LoginCookie")) {
				name =cookie.getValue();
				result = true;
				break;
			}

		}}
		if(!name.isEmpty()){
			
		int index= name.indexOf("1");
		
		name=name.substring(0, index);
		req.setAttribute("uname", name);
		}
		RequestDispatcher dispatcher=null;
		if(result) {
			dispatcher = req.getRequestDispatcher("Home.jsp");
			dispatcher.forward(req, resp);
			}
		
		else {
			
			req.setAttribute("msg", "Sorry session timed out!");
			dispatcher= req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);
			}
			

	}

}
