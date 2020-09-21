import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DeleteRoute extends HttpServlet
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
			rs = s.executeQuery("select routeno from route");
			pw.println("<form action='http://server:8080/servlet/DeleteRoute1'>");
			pw.println("<h3> SELECT THE ROUTE NO TOM DELETE :<select name=rno>");
			while(rs.next())
			{
			pw.println("<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>");


			}
			//pw.println("<option value=R001>R001</option>");
			//pw.println("<option value=R002>R002</option>");
			//pw.println("<option value=R003>R003</option>");
			//pw.println("<option value=R004>R004</option>");
			pw.println("</select></H3><BR><BR><CENTER><input type=SUBMIT value='DELETE'>");
			pw.println("<input type=RESET value='RESET'></form>");
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
