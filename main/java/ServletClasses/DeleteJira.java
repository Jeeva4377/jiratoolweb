package ServletClasses;

import java.io.IOException;
import java.io.PrintWriter;

import HelperClasses.HelpingClass;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteJira extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=0;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message="";
		boolean result=false;
		if(id!=0)
			result= HelpingClass.deleteJira(id);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/viewJira");
		if(result)
			message= "delete is successfull!";
		else
			message="delete is unsuccessfull pls try again!";
		
		req.setAttribute("msg", message);
		dispatcher.forward(req, resp);
		
	}

}
