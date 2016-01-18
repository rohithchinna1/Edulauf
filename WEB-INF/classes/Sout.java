import java.sql.*; 
import java.io.*;
import oracle.jdbc.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Sout extends HttpServlet
{ 
     public void doGet(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException
     {
           PrintWriter out = response.getWriter (); 
           response.setContentType("text/html");
           try
	      {
           HttpSession session = request.getSession(false); 
		   if(session!=null)
			  {
			   session.invalidate();
			   
			   
		   }
		   response.sendRedirect("sloreg.html");
		  		  }
		    catch (Exception e)
        {
        out.println(e);
        }
	 }
}