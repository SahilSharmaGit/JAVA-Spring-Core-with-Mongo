<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To Update Page</h1>
<form:form id="empForm" modelAttribute="emp" method="post">
            <fieldset>
              <legend>Email</legend>
               <form:input path="email" name="email" id="email" readonly="readonly" />
            </fieldset>
            <fieldset>
              <legend>Name</legend>
               <form:input path="name" name="name" id="name" />
            </fieldset>
            <fieldset>
 	           <legend>Department</legend>
        	    <form:password path="dept" name="dept" id="dept" />
    	    </fieldset>
            <form:button id="Update" name="update">Update</form:button>
   </form:form>
<br><br>
<h1>${msg}</h1>

</body>
</html>