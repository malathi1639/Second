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

<table>
    <c:forEach items="${areas}" var="area">
        <tr>
            <td>${area.name}</td>
            <td>${area.id}</td>
            <td>${area.age}</td>
            <td>${area.address}</td>
            <td>${area.mailid}</td>	
            <td><a href ="<c:url value="/Delete?id=${area.id}"/>">Delete</a>
					
					<td><a href ="<c:url value="/Update?id=${area.id}"/>">edit</a>
					</td>			
        </tr>
    </c:forEach>
   
</table>

</body>
</html>