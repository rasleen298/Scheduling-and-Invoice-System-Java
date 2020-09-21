import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class PassengerInsert extends HttpServlet
{	 int j;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=#ffffcc text=darkgreen> ");
		pw.println("<h4><b>");
	
		String pno=req.getParameter("pno");
		String pname=req.getParameter("pname");
		String page=req.getParameter("page");
		String bloc=req.getParameter("bloc");
		String vno=req.getParameter("vno");
		String dest=req.getParameter("dest");
		String paid=req.getParameter("paid");
		try

		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
//		    pw.println("connected"); 
			Statement s=c.createStatement();	
			
			PreparedStatement ps=c.prepareStatement("insert into passengerinfo(passno,passname,passage,boardingloc,vehicleno,destination,paid) values(?,?,?,?,?,?,?)");

			ps.setString(1,pno);
			ps.setString(2,pname);
			ps.setString(3,page);
			ps.setString(4,bloc);
			ps.setString(5,vno);
			ps.setString(6,dest);
			ps.setString(7,paid);
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
