import java.io.*;
 import javax.servlet.ServletException;
 import javax.servlet.http.*;
public class DownloadServlet2 extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String filename = "daa.rar";
 String filepath = "C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 8.0\\webapps\\data\\";
 response.setContentType("APPLICATION/OCTET-STREAM");
 response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
 FileInputStream fileInputStream = new FileInputStream(filepath + filename);
 int i;
 while ((i=fileInputStream.read()) != -1) {
 out.write(i);
 }
 fileInputStream.close();
 out.close();
 }
}