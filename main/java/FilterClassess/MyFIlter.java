package FilterClassess;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFIlter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Reached Filter class");
		
		String mail= req.getParameter("email");
		String psswrd= req.getParameter("password");
		
		boolean result=false;
		
		if(mail.contains("<")||mail.contains("insert"))
			result=false;
		else 
			result=true;
		
		if(result)
			chain.doFilter(req, resp);
		else
			throw new ArithmeticException("something bad happends");
		
		
	}

}
