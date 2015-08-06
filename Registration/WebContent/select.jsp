<%@ page import="java.sql.*" %>
<% Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); %>

<HTML>
    <HEAD>
        <TITLE>Fetching Data From a Database</TITLE>
    </HEAD>

    <BODY>
        <H1>Database Lookup</H1>
        <FORM ACTION="select.jsp" METHOD="POST">
            Enter id:
            <BR>
            <INPUT TYPE="TEXT" NAME="id">
            <BR>
            <INPUT TYPE="SUBMIT" value="Submit">
        </FORM>


       

        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sample", "root", "admin");

            Statement statement = connection.createStatement();

            String id = request.getParameter("id");  

            ResultSet resultset = 
                statement.executeQuery("select * from registration where id = '" + id + "'") ; 

             
            	
            	
               
             if(resultset.next()) {
        %>
 			<TABLE BORDER="1">
                <TR>
                   <TH>Name</TH>
                   <TH>Id</TH>
                   <TH>Age</TH>
                   <TH>Address</TH>
                   <TH>Mailid</TH>
               </TR>
               <TR>
                   <TD> <%= resultset.getString(1) %> </TD>
                   <TD> <%= resultset.getString(2) %> </TD>
                   <TD> <%= resultset.getString(3) %> </TD>
                   <TD> <%= resultset.getString(4) %> </TD>
                   <TD> <%= resultset.getString(5) %> </TD>
               </TR>
           </TABLE>
           <BR>
        
       <% 
           } 
        	          	  
       %>
    </BODY>
</HTML>

      
       