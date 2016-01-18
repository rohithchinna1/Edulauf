import java.sql.*; 
import java.io.*;
import oracle.jdbc.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class Slog extends HttpServlet
{ 
     public void doGet(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException
     {
        
           PrintWriter out = response.getWriter (); 
           String n1 = request.getParameter ("username");
           String n2 = request.getParameter ("password");
		   response.setContentType("text/html");
           try
	      {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		   Statement stmt = con.createStatement (); 
           ResultSet rs = stmt.executeQuery ("select * from stu_tab ");        
           while(rs.next()) 
			 {
 		  if(
			   (!(n1.equals ("null")) && n1.equals(rs.getString ("username"))) 
		   && (!(n2.equals ("null")) && n2.equals(rs.getString ("password")))) 
		   {
		   HttpSession session = request.getSession(true); 
		   session.setAttribute("username",n1);
		   out.println("<html><body>");
		   out.println("<font face=arial>");
           out.println("<h2>");
		   //out.println("Hi Guest!");
		   out.print("<form align=left method=get action=Sout>");
		   out.print("Welcome:\t\t\t"+n1+"&nbsp;&nbsp;&nbsp<input type=submit value=Logout>");
		   out.print("</form>");

		   out.println("</h2>");
		   out.println("</font>");
		   out.println("</body></html>");
		   out.println("<html><body bgcolor=#00ffff><style type=text/css>h1{color:white;background:#663333;font-size:20pt;}</style><h1><marquee behavior=scroll direction=right>Courses</marquee></h1><font face=arial size=4><p>    The following course materials can be accessed  <br><br>		> Computer Organisation and Architecture&nbsp;&nbsp;&nbsp;<a href=servlet/DownloadServlet1>Download</a><br><br>		> Design and Analysis of Algorithms&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=servlet/DownloadServlet2>Download</a> 		<br>		<br>				> Programing Principles&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=servlet/DownloadServlet3>Download</a> 		<br>		<br>			> Compiler Design&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=servlet/DownloadServlet4>Download</a> 		<br>		<br>				> Computer Networks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=servlet/DownloadServlet5>Download</a> 		<br>		<br>		</font></p></body></html>");
		   }
		   	}
		  		  }
		    catch (Exception e)
        {
        out.println(e);
        }
	 }
}







