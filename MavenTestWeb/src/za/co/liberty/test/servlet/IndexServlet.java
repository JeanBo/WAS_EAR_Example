package za.co.liberty.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.liberty.test.view.HelloBeanLocal;

@WebServlet("/hello")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        
        System.out.println("Passed parameters =======================================");
       for (String s : request.getParameterMap().keySet()) {
    	   System.out.println(" -- " + s);
       }
       System.out.println("=======================================");
       if (request.getParameter("myButton") != null) {
    	   System.out.println("  -- button 1 was clicked");
    	   writeButton1(request, response);
       }
    }

	private void writeButton1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Button 1 was clicked</h1>");
		String answer = callHelloBean("button1");
		writer.println("<p>Called bean and returned " + answer + "</p>");
		writer.println("</html>");
	}

	private String callHelloBean(String string) {
		
		try {
			InitialContext ic = new InitialContext();
			HelloBeanLocal local =  (HelloBeanLocal) ic.lookup("ejblocal:za.co.liberty.test.view.HelloBeanLocal");
			return (local.testMe(string))?"Call succeeded" : "Call returned false";
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERR: " + e.getMessage();
		}
		
	}

}