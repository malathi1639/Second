<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="Updatequety" method="post" >
<h4>  
        Hello,  
        <%=session.getAttribute("uid")%></h4>  
       
        <table>               
            <tr>
                <td></td>
                <td align="left">Enter Name</td>
                <td><input type="text" name="name" value="<c:out value="${mb.name}" />"/></td>
                <td></td>                               
            </tr>
            
            <tr>
                <td></td>
                <td align="left">Enter Age</td>
                <td><input type="text" name="age" value="<c:out value="${mb.age}" />"/></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td align="left">Enter Address</td>
                <td><input type="text" name="add" value="<c:out value="${mb.address}" />"/></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td align="left">Enter MailId</td>
                <td><input type="text" name="mid" value="<c:out value="${mb.mailid}" />"/></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td><input type="submit" value="submit"></td>
                <td></td>
            </tr>
            
            </table>
        </form>
</body>
</html>