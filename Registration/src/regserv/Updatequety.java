package regserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Updatequety
 */
@WebServlet("/Updatequety")
public class Updatequety extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Updatequety() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
				PrintWriter pw=response.getWriter();
				HttpSession session = request.getSession(false); 
		        String a=session.getAttribute("uid").toString();
		        int c=Integer.parseInt(a);
		        System.out.println(c);
		        String name = request.getParameter("name");  
		        int age = Integer.parseInt(request.getParameter("age"));  
		        String address = request.getParameter("add");  
		        String mailid = request.getParameter("mid"); 
	
				response.setContentType("text/html");  
				Connection conn=null;
		        
		        String url = "jdbc:mysql://localhost:3306/";  
		        String dbName="sample";
		        String driver="com.mysql.jdbc.Driver";
		      
		        Class.forName(driver).newInstance();  
		       	conn = DriverManager.getConnection(url+dbName,"root", "admin");
		      	String query = "UPDATE registration SET name=?,age=?,address=?,mailid=? WHERE id=?;"; 
		      	java.sql.PreparedStatement pst =  conn.prepareStatement(query); 
		      	
		      	
				pst.setString(1,name); 
				pst.setInt(2,age);        
			    pst.setString(3,address);
			    pst.setString(4,mailid);
			    pst.setInt(5,c);
			    int i = pst.executeUpdate();
			    
			      String msg=" ";
			      if(i!=0){  
			        //msg="User Updated";
			        //pw.print( msg );  
			        //pw.print(" '"+name+"'");
			    	  response.sendRedirect("Select");  
			      }  
			      else{  
			        msg="failed to update the data";
			        pw.print("<font size='6' color=blue>" + msg + "</font>");
			       }  
			     
			      pw.close();
			      pst.close();
			      conn.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
