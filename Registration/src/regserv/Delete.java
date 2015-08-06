package regserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 protected void doGet(
	   HttpServletRequest request,
	   HttpServletResponse response
	   ) throws ServletException, IOException {
	 
	  doPost(request, response);
	 
	 }
	 
	 protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 try
			{
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");  
		       
		        Connection conn=null;
		        String url = "jdbc:mysql://localhost:3306/";  
		        String dbName="sample";
		        String driver="com.mysql.jdbc.Driver";
		       
		      Class.forName(driver).newInstance();  
		      conn = DriverManager.getConnection(url+dbName,"root", "admin");
		      
		      	int id = Integer.parseInt(request.getParameter("id"));
		      	String query = "delete  from registration where id=?"; 
				PreparedStatement preparedStatement = conn.prepareStatement(query); 
				preparedStatement.setInt(1,id );
				preparedStatement.executeUpdate();
				//out.println("deleted");
				request.getRequestDispatcher("Select").forward(request, response);
				preparedStatement.close();
				
		    }  
		    catch (Exception e){  
		      System.out.println(e.getMessage());  
		    }  
	 }
}