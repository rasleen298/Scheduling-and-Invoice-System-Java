import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class TicketCancel extends HttpServlet
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
	
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		   // pw.println("connected"); 
			Statement s=c.createStatement();	
			rs = s.executeQuery("select passno from passengerinfo where status is null");
			pw.println("<form action='http://server:8080/servlet/Allot'>");
			pw.println("<h3> SELECT THE PASSENGER ID :<select name=passno>");
			while(rs.next())
			{
			pw.println("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");


			}
			//pw.println("<option value=P001>P001</option>");
			//pw.println("<option value=P002>P002</option>");
			//pw.println("<option value=P003>P003</option>");
			//pw.println("<option value=P004>P004</option>");
			pw.println("</select></H3><BR><BR><CENTER><input type=SUBMIT value='CANCEL'>");
			pw.println("<input type=BUTTON value='HOME' onclick='location.href=\"http://server:8080/home.html\"'></form>");
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
