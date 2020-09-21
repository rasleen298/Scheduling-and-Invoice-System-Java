import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class VehicleInsert extends HttpServlet
{	 int j;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=#ffffcc text=darkgreen> ");
		pw.println("<h4><b>");
	
		String vno=req.getParameter("vno");
		String vtype=req.getParameter("vtype");
		String vcapacity=req.getParameter("vcapacity");
		String rcno=req.getParameter("rcno");
		try

		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		    pw.println("connected"); 
			Statement s=c.createStatement();	
			
			PreparedStatement ps=c.prepareStatement("insert into vehicle values(?,?,?,?)");

			ps.setString(1,vno);
			ps.setString(2,vtype);
			ps.setString(3,vcapacity);
			ps.setString(4,rcno);
			int j=ps.executeUpdate();
			if (j==1)
			{
				pw.println("<form><h3> Record is inserted </h3>");
				pw.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
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
