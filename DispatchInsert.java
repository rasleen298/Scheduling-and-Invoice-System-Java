import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class DispatchInsert extends HttpServlet
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
		String deptime=req.getParameter("deptime");
		String depfrom=req.getParameter("depfrom");
		String atime=req.getParameter("atime");
		String depto=req.getParameter("depto");
		String dno=req.getParameter("dno");
		String rtime=req.getParameter("rtime");

		try

		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
//		    pw.println("connected"); 
			Statement s=c.createStatement();	
			
			PreparedStatement ps=c.prepareStatement("insert into scheduleinfo values(?,?,?,?,?,?,?)");

			ps.setString(1,vno);
			ps.setString(2,deptime);
			ps.setString(3,depfrom);
			ps.setString(4,depto);
			ps.setString(5,atime);
			ps.setString(6,dno);
			ps.setString(7,rtime);
			
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
		pw.flush();
		 

} //end of method
	
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doPost(req,res);
	}
}
