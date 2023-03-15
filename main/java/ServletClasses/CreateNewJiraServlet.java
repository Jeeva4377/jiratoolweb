package ServletClasses;

import java.io.IOException;

import HelperClasses.HelpingClass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateNewJiraServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String assignee=req.getParameter("assignee");
		String reportee=req.getParameter("reportee");
		String problem=req.getParameter("problem");
		String status=req.getParameter("status");
		String notify=req.getParameter("notify");
		
		boolean result= HelpingClass.createNewJira(assignee, reportee, problem, status, notify);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/showCreateJiraScreen");
		
		if(result) {
			req.setAttribute("msg", "successfully created please go back to Home page!");			
			
		}else
		{
			req.setAttribute("msg", "something went wrong try again please!");
		}
			
		dispatcher.forward(req, resp);
		}

}
