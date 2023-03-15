package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import HelperClasses.HelpingClass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Jira;

public class ViewTicket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	resp.setContentType("text/html");
	ArrayList<Jira> arrayList= new ArrayList<Jira>();
	
	String search =req.getParameter("search");
	String assgineeCheckBox =req.getParameter("assgineeCheckBox");
	String assignee =req.getParameter("assignee");
	String ReporterCheckBox =req.getParameter("ReporterCheckBox");
	String reportee =req.getParameter("reportee");
	String statusCheckBox =req.getParameter("statusCheckBox");
	String status =req.getParameter("status");
	
	if(req.getParameter("search")==null)
		 arrayList=	HelpingClass.viewAllTicket();
	else
	{
		String query="";
		if(("ON").equalsIgnoreCase(assgineeCheckBox))
		{
			query="select * from jiraDetails where Jira_Assignee=?";
			arrayList = HelpingClass.viewFilteredTicket(query,assignee);
			
		}
		if(("ON").equalsIgnoreCase(ReporterCheckBox)) {
			
			query="select * from jiraDetails where Jira_Reporter=?";
			arrayList = HelpingClass.viewFilteredTicket(query,reportee);
			
		}
		if(("ON").equalsIgnoreCase(statusCheckBox)) {
			
			query="select * from jiraDetails where Jira_Status=?";
			arrayList = HelpingClass.viewFilteredTicket(query,status);
		}
		
	
		
	}
	ArrayList<String> user_arrayList = HelpingClass.viewUsers();
	
	req.setAttribute("userList", user_arrayList);
	req.setAttribute("jiraList", arrayList);
	
	RequestDispatcher dispatcher=req.getRequestDispatcher("View.jsp");
	dispatcher.forward(req, resp);
	
	
	
	}

}
