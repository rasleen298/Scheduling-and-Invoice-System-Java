import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DeleteVehicle extends HttpServlet
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
			rs = s.executeQuery("select VEHICLENO from vehicle");
			pw.println("<form action='http://server:8080/servlet/DeleteVehicle1'>");
			pw.println("<h3> SELECT THE VEHICLE NO TO DELETE :<select name=vno>");
			/*while(rs.next())
			{
			pw.println("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");


			}*/
			pw.println("<option value=V001>V001</option>");
			pw.println("<option value=V002>V002</option>");
			pw.println("<option value=V003>V003</option>");
			pw.println("<option value=V004>V004</option>");
			pw.println("</select></H3><BR><BR><CENTER><input type=SUBMIT value='DELETE'>");
			pw.println("<input type=RESET value='RESET'></form>");
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
