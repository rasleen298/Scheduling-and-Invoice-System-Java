import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DriverLogin extends HttpServlet
{	 int j;
ResultSet rs;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=#ffffcc text=darkgreen> ");
		pw.println("<h4><b>");
	
		String drname=req.getParameter("drname");
		String drpass=req.getParameter("drpass");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		   // pw.println("connected"); 
			Statement s=c.createStatement();	
			rs = s.executeQuery("select * from Driver where drivername='"+drname+"' and driverpass='"+drpass+"'");
			if (rs.next())
			{
				pw.println("<form><h3> LOGIN FINE </h3>");

				pw.println("<input type=Button value='SCHEDULED INFO' onClick='location.href=\"http://server:8080/servlet/ScheduleInformation?drno="+rs.getString(1)+"\"'>");
				pw.println("<input type=Button value='REPORTING' onClick='location.href=\"http://server:8080/report.html\"'></form>");
			}
		} //end of try block
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		pw.flush();
		 

} //end of method
	
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doPost(req,res);
	}
}
