<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Get Only One Record Page</h1>
 
<form action="/atmax/one" method="post">
	Email: <input type="text" name="email">
	<input type="submit" value="Search">

</form>
<br><br>
 <table>
 	<tr>
 		<th>Email</th>
 		<th>Name</th>
 		<th>Department</th>
 	</tr>
 	<c:forEach var="emp" items="${data}">
      <tr>
          <td>${emp.email}</td>
          <td>${emp.name}</td>
          <td>${emp.department}</td>
      </tr>
  </c:forEach>
 </table>
</body>
</html>