import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class UpdateRoute extends HttpServlet
{	 int j;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		out.println("<body bgcolor=#ffffcc text=darkgreen> ");
		out.println("<h4><b>");
	
		String vno=req.getParameter("vno");
		String vtype=req.getParameter("vtype");
		String vcapacity=req.getParameter("vcapacity");
		String rcno=req.getParameter("rcno");
		try

		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		    out.println("connected"); 
			Statement s=c.createStatement();	
			
			PreparedStatement ps=c.prepareStatement("update vehicle set vehicletype=? , vehiclecapacity=?, rcno=? where vehicleno=?");

			ps.setString(1,vtype);
			ps.setString(2,vcapacity);
			ps.setString(3,rcno);
			ps.setString(4,vno);
			int j=ps.executeUpdate();
		    out.println("RECORD UPDATED"); 

			if (j==1)
			{
				out.println("<form><h3> Record is Updated successfully </h3>");
				out.println("<input type=Button value=Back onClick=\"window.history.back()\"></form>");
			}
		} //end of try block
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		out.flush();
		 

} //end of method
	
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doPost(req,res);
	}
}
