import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class RouteInsert extends HttpServlet
{	 int j;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=#ffffcc text=darkgreen> ");
		pw.println("<h4><b>");
	
		String rno=req.getParameter("rno");
		String rtype=req.getParameter("routetype");
		String sloc=req.getParameter("startloc");
		String eloc=req.getParameter("endloc");
		String stime=req.getParameter("stime");
		String etime=req.getParameter("etime");
		String dno=req.getParameter("dno");
		String vno=req.getParameter("vno");
		try

		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		    pw.println("connected"); 
			Statement s=c.createStatement();	
			
			PreparedStatement ps=c.prepareStatement("insert into route values(?,?,?,?,?,?,?,?)");

			ps.setString(1,rno);
			ps.setString(2,rtype);
			ps.setString(3,sloc);
			ps.setString(4,eloc);
			ps.setString(5,stime);
			ps.setString(6,etime);
			ps.setString(7,dno);
			ps.setString(8,vno);
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
