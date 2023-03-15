package ServletClasses;

import java.io.IOException;

import HelperClasses.HelpingClass;
import HelperClasses.MailHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateJiraServelt extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String assignee=req.getParameter("assignee");
		String reportee=req.getParameter("reportee");
		String problem=req.getParameter("problem");
		String status=req.getParameter("status");
		String notify=req.getParameter("notify");
		
		boolean sendEmail=false;
		System.out.println("came to mail top");
		System.out.println(("Dev Done").equalsIgnoreCase(status));
		if(("Dev Done").equalsIgnoreCase(status))
			sendEmail=true;
		
		if(sendEmail) {
			System.out.println("inside mail block");
			MailHelper.sendEmailForNotifyMailId(id,notify);
			}
		
		boolean result=HelpingClass.UpdateStringJiraTicket(assignee,reportee,problem,status,notify,id);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/viewJira");
		if(result)
			req.setAttribute("msg", "successfully updated! ");
		else
			req.setAttribute("msg", "something went wrong!");
		
		dispatcher.forward(req, resp);
		
		
	}

}
