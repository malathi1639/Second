package regserv;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Bean;

import dao.Registerdao;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		try{
			 
			 Bean b=new Bean();
	            b.setName(request.getParameter("name"));
	            b.setId(Integer.parseInt(request.getParameter("id")));
	            b.setAge(Integer.parseInt(request.getParameter("age")));
	            b.setAddress(request.getParameter("add"));
	            b.setMailid(request.getParameter("mid"));
	            Registerdao.register(b);
	            response.sendRedirect("Select");
	          
				} catch (Exception ex) {
					System.out.println( ex);
				} 
	            
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
	}
	         
	}


