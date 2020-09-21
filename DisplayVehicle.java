import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DisplayVehicle extends HttpServlet
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
			while(rs.next())
			{
			pw.println("<tr><td>VEHICLE NO</td><td><input name=vno value="+ vno+" disabled></td></tr>");

			pw.println("<tr><td> VEHICLE TYPE </td><td><input name=vtype value="+rs.getString(2)+"></td></tr>");
			pw.println("<tr><td>VEHICLE CAPACITY </td><td><input name=vcapacity value="+rs.getString(3)+"></td></tr>");
			pw.println("<tr><td>RC NO </td><td><input name=rcno value="+rs.getString(4)+"></td></tr>");

			}
			pw.println("</table></center>");
			pw.println("<input type=SUBMIT value='MODIFY'>");
			pw.println("</form>");
			pw.println("<input type=BUTTON value='BACK' onclick='window.history.back()'>");
			pw.println("<input type=BUTTON value='HOME' onclick='location.href=\"http://server:8080/home.html\"'></form>");
			
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
