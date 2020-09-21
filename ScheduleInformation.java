import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class ScheduleInformation extends HttpServlet
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
		String drno = req.getParameter("drno");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		   // pw.println("connected"); 
			Statement s=c.createStatement();	
			rs = s.executeQuery("select *  from scheduleinfo where assignedto='"+drno+"'");
			pw.println("<center><table border=1>");
			while(rs.next())
			{
			pw.println("<tr><td> DRIVERNO</td><td>"+ drno+" </td></tr>");

			pw.println("<tr><td> VEHICLE NO </td><td>"+ rs.getString(1)+" </td></tr>");
			pw.println("<tr><td>DEPARTURE FROM </td><td>"+ rs.getString(3)+"</td></tr>");
			pw.println("<tr><td>DEPARTURE TO </td><td>"+ rs.getString(4)+" </td></tr>");
			pw.println("<tr><td>REPORTING TIME </td><td>"+ rs.getString(7)+" </td></tr>");
			pw.println("<input type=BUTTON value='BACK' onclick='window.history.back()'>");
			pw.println("<input type=BUTTON value='HOME' onclick='location.href=\"http://server:8080/home.html\"'></form>");
			}
		//	pw.println("THERE IS NO SCHEDULE FOR "+drno +"\n<input type=BUTTON value='BACK' onclick='window.history.back()'>");
		//	pw.println("<input type=BUTTON value='HOME' onclick='location.href=\"http://server:8080/home.html\"'></form>");
			
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
