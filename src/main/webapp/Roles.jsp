<%@page import="com.Roles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roles Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/Roles.js"></script>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">

	<h1>Roles Management </h1>

	<form id="formRoles" name="formRoles">
 		Item ID:
 		<input id="roleID" name="RoleID" type="text" class="form-control form-control-sm">
 		<br> 
 		Item Name:
		<input id="roleName" name="roleName" type="text" class="form-control form-control-sm">
 		<br> 
 		Item Description:
		<input id="roleDescription" name="roleDescription" type="text" class="form-control form-control-sm">
 		<br>
 		
 		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 		<input type="hidden" id="hidroleIDSave" name="hidroleIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>

	<br>
	<div id="divRolesGrid">
 		<%
 			Roles roleObj = new Roles();
 			out.print(roleObj.readRoles());
 		%>
	</div>
</div> </div> </div>
</body>
</html>