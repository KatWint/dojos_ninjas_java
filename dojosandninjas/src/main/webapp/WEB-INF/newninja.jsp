<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Add a new Ninja</h1>
		<a href="/">Dashboard</a>
	</div>
	<div class="container">
	<form:form action="/createninja" method="post" modelAttribute="ninja">
	<p>
    <form:select path="dojo">
    	<c:forEach items="${allDojos}" var="dojo">
    	<option value="${dojo.id}"> ${dojo.name} </option>
    	</c:forEach>
    </form:select>
     
	<p>
 		<form:errors class="text-danger" path="firstName"/>
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors class="text-danger"  path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>     
        <form:input type="age" path="age"/>
    </p>    
<button class="btn btn-primary">Create</button>
</form:form>
	</div>
</body>
</html>
