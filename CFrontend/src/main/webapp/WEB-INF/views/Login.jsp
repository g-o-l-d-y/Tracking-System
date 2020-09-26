<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body background="<c:url value="/resources/images/bg.png"/>">
		<div class="container">
			<div class="row"> 
			<div class="col-sm-7">
			<c:if test="${f==0}">
				<div class="alert alert-success alert-dismissible">
	  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  				<strong>You have successfully signed up, login and have a great experience!</strong>
	  				<article class="hidden">${f=1}</article>
				</div>
			</c:if>
			</div>
			</div>
			<h1><b>Login</b></h1>
			<br>
			<form action="perform_login" method="POST">
				<div class="form-group row">
	    			<!-- <label for="userName" class="col-sm-2 col-form-label"><h4><b>Username</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="userName" placeholder="Username">
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="password" class="col-sm-2 col-form-label"><h4><b>Password</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="password" placeholder="Password">
	    			</div>
    			</div>
    			<br>
    			<button type="submit" class="btn btn-primary" style="">  Login  </button>
    		</form>
		</div>
	</body>
</html>
