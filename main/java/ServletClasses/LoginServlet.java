package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import HelperClasses.HelpingClass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail = req.getParameter("email");
		String psswrd = req.getParameter("password");
		String uname = HelpingClass.authenticateUser(mail,psswrd);
		resp.setContentType("text/html");
		
		PrintWriter notepad = resp.getWriter();
		notepad.print("<h1 style=\"color:red;\">sorry user not found try again!</h1>");
		RequestDispatcher dispatcher = null;
		req.setAttribute("uname", uname);
		
		if(uname.isEmpty())
			dispatcher=	req.getRequestDispatcher("login.jsp");
		else
		{
		
			Cookie cookie= new Cookie("LoginCookie", uname+123);
			
			resp.addCookie(cookie);
			
			
			dispatcher=req.getRequestDispatcher("Home.jsp");
}
		
		
		if(uname.isEmpty())
			dispatcher.include(req, resp);
		else
			dispatcher.forward(req, resp);
	}

}
