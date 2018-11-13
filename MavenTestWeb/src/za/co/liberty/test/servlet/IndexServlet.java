package za.co.liberty.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		writer.println("</html>");
	}

}