import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ireg extends HttpServlet
	{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
        try
			{
      String username = request.getParameter("t1");
      String password = request.getParameter("t2");
	  String email = request.getParameter("t4");
	  String phone = request.getParameter("t5");
      String country = request.getParameter("t6");
	  String languages = request.getParameter("t7");
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
      PreparedStatement pst = con.prepareStatement("insert into ins_tab values(?,?,?,?,?,?)");
      pst.setString(1,username);
      pst.setString(2,password);
	  pst.setString(3,email);
      pst.setString(4,phone);
	  pst.setString(5,country);
      pst.setString(6,languages);
      int i = pst.executeUpdate();
      if(i!=0)
	{
      out.println("<html><body align=center bgcolor=#C0C0C0 text=black>");
      out.println("<h3>!.. Registration Successful !..</h3>");
	  out.println("<a href=Ilogin.html style=text-decoration:none>click here</a>&nbsp;to go back to login page");
      out.println("</body></html>");
      }
      else
	{
       out.println("<html><body align=center bgcolor=#C0C0C0 text=black>");
       out.println("<h3>!.. Registration Failed !..</h3>");
	   out.println("<a href=Ilogin.html style=text-decoration:none>click here</a>&nbsp;to go back to login page");
       out.println("</body></html>");
      }
    }
    catch (Exception e)
	{
      out.println(e);
    }
  }
}