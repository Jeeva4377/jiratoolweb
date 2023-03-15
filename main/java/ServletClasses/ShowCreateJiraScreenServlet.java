package ServletClasses;

import java.io.IOException;
import java.util.ArrayList;

import HelperClasses.HelpingClass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowCreateJiraScreenServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		ArrayList<String> arrayList = HelpingClass.viewUsers();
		
		req.setAttribute("userList", arrayList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("CreateJira.jsp");
		
		dispatcher.forward(req, resp);
		
	}

}
