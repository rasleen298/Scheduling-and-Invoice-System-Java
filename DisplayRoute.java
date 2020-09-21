import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DisplayRoute extends HttpServlet
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
		String rno = req.getParameter("rno");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		   // pw.println("connected"); 
			Statement s=c.createStatement();	
			rs = s.executeQuery("select *  from route where routeno='"+rno+"'");
			pw.println("<form action='http://server:8080/servlet/UpdateRoute'>");
			pw.println("<center><table border=1>");
			while(rs.next())
			{
			pw.println("<tr><td>ROUTENO</td><td><input name=vno value="+ rno+" disabled></td></tr>");

			pw.println("<tr><td> ROUTETYPE </td><td><input name=vtype value="+rs.getString(2)+"></td></tr>");
			pw.println("<tr><td>STARTLOC</td><td><input name=vcapacity value="+rs.getString(3)+"></td></tr>");
			pw.println("<tr><td>ENDLOC</td><td><input name=rcno value="+rs.getString(4)+"></td></tr>");
			pw.println("<tr><td> STARTTIME </td><td><input name=vtype value="+rs.getString(5)+"></td></tr>");
			pw.println("<tr><td>ENDTIME</td><td><input name=vcapacity value="+rs.getString(6)+"></td></tr>");
			pw.println("<tr><td>DRIVERNO</td><td><input name=rcno value="+rs.getString(7)+"></td></tr>");
			pw.println("<tr><td>VEHICLENO</td><td><input name=rcno value="+rs.getString(8)+"></td></tr>");

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
