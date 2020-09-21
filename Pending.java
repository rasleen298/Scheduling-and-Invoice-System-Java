import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
public class Pending extends HttpServlet
{	 int j;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{	 
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>SCHEDULEING AND DISPATCHING  </title> </head>");
		pw.println("<body bgcolor=#ffffcc text=darkgreen> ");
		pw.println("<h4><b>");
	
		String passno=req.getParameter("passno");

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:schedule","","");
		   // pw.println("connected"); 
			Statement s=c.createStatement();	
			PreparedStatement ps=c.prepareStatement("update table passengerinfo set status='PENDING' WHERE PASSNO=?");
			ps.setString(1,passno);
			j = ps.executeUpdate();

			if (j==1)
			{
				pw.println("<h3> SCHEDULER IS ALLOTED SUCCESSFULLY </h3>");
	    		pw.println("<input type=Button value='HOME' onClick='http://server:8080/home.html'></form>");
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
