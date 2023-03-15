package ServletClasses;

import java.io.IOException;
import java.util.ArrayList;

import HelperClasses.HelpingClass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Jira;

public class EditServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ArrayList<Jira> arraylist=HelpingClass.viewOneTicket(id);
		
		Jira jira=arraylist.get(0);
		
		req.setAttribute("jiraDetail", jira);
		ArrayList<String> arrayList1 = HelpingClass.viewUsers();
		
		req.setAttribute("userList", arrayList1);
		RequestDispatcher dispatcher=req.getRequestDispatcher("UpdateJira.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}
