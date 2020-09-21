import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DriverInsert extends HttpServlet
{	 int j;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=#ffffcc text=darkgreen> ");
		pw.println("<h4><b>");
	
		String drno=req.getParameter("drno");
		String drname=req.getParameter("drname");
		String drpass=req.getParameter("drpass");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		    pw.println("connected"); 
			Statement s=c.createStatement();	
			
			PreparedStatement ps=c.prepareStatement("insert into Driver values(?,?,?)");

			ps.setString(1,drno);
			ps.setString(2,drname);
			ps.setString(3,drpass);
			int j=ps.executeUpdate();
			if (j==1)
			{
				pw.println("<form><h3> One Record is inserted </h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
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
