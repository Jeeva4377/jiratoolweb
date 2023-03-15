package ServletClasses;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] arrcookie = req.getCookies();
		String name="";
		Cookie Org_cookie=null;
		boolean result = false;
		for (Cookie cookie : arrcookie) {
			if (cookie.getName().equals("LoginCookie")) {
				Org_cookie=cookie;
				result = true;
				break;
			}

		}
		Org_cookie.setMaxAge(0);
		
		resp.addCookie(Org_cookie);
		RequestDispatcher dispatcher=null;
		
		if(result) {
			dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);
			
		}
	}

}
