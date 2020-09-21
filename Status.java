import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class Status extends HttpServlet
{	 int j;
	ResultSet rs;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=LIGHTYELLOW text=darkgreen> ");
		pw.println("<h4><b>");
		String vno = req.getParameter("vno");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		   // pw.println("connected"); 
			Statement s=c.createStatement();	
			rs = s.executeQuery("select *  from vehicle where vehicleno='"+vno+"'");
			pw.println("<form action='http://server:8080/servlet/UpdateVehicle'>");
			pw.println("<center><table border=1>");
//			while(rs.next())
//			{
			pw.println("<tr><td>PASSENGER NO</td><td>STATUS</td></tr>");

			pw.println("<tr><td> P001 </td><td>PENDING</td></tr>");
			pw.println("<tr><td> P002 </td><td>ALLOTED</td></tr>");
//			}
			pw.println("</table>");
			pw.println("<input type=BUTTON value='BACK' onclick='window.history.back()'>");
			pw.println("<input type=BUTTON value='HOME' onclick='location.href=\"http://server:8080/home.html\"'></form>");
			pw.println("</form></center>");			
		} //end of try block
		
		catch(Exception e)
		{
			System.out.println(e);
		}
} //end of method
	
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doPost(req,res);
	}
}
