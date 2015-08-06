package regserv;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.io.PrintWriter;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.List;


//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

import dao.Bean;

//import dao.Bean;
//import dao.Selectdb;
//import dao.Updateselectdao;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(false); 
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		 
        try {
        	int id = Integer.parseInt(request.getParameter("id"));
        	con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","admin");
		    Class.forName("com.mysql.jdbc.Driver");
		  String s ="select name , age ,address, mailid from registration where id=?";
		  ps = (PreparedStatement) con.prepareStatement(s); 
		  ps.setInt(1,id);
		  rs=(ResultSet) ps.executeQuery();
		 
		 if(rs.next())
		 { 
			 Bean area = new Bean();
             area.setName(rs.getString("name"));
             //area.setId(rs.getInt("id"));
             area.setAge(rs.getInt("age"));
             area.setAddress(rs.getString("address"));
             area.setMailid(rs.getString("mailid"));
             request.setAttribute("mb", area);
 		 	if(session!=null)
 		 	session.setAttribute("uid", id);
 	    	RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");    
 	       rd.forward(request,response); 
          
 			}
		 
		 }
        catch(Exception e)
        {
			 System.out.println(e);
		 }
		 	 
		 	
		 
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
