package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import HelperClasses.HelpingClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String mob = req.getParameter("mob");
		
		String mail = req.getParameter("email");
		String psswrd = req.getParameter("password");
		
		boolean temp= HelpingClass.insertNewUser(fname,lname,mob,mail,psswrd);
		resp.setContentType("text/html");
		
		PrintWriter notepad = resp.getWriter();
		if(temp)
		{
			resp.sendRedirect("http://localhost:8080/JiraTool/Login.jsp");
		}else
			notepad.print("sorry something went wrong pls try again");
		
			
	}

}
