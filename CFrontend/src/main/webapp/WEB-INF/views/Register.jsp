<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register</title>
		<script>
			function validateForm() {
			  var name = document.forms["myForm"]["customerName"].value;
			  var uname = document.forms["myForm"]["userName"].value;
			  var pw = document.forms["myForm"]["password"].value;
			  var address = document.forms["myForm"]["address"].value;
			  var role = document.forms["myForm"]["role"].value;
			  if (name == "*Name") {
			    alert("Name must be filled out");
			    return false;
			  }
			  if(uname=="*Username")
			  {
				  alert("Username must be filled out");
				  return false;
			  }
			  if(pw=="*Password")
			  {
				  alert("Password must be filled out");
				  return false;
			  }
			  if(address=="*Address")
			  {
				  alert("Address must be filled out");
				  return false;
			  }
			  if(role=="0")
			  {
				  alert("Select a Role");
				  return false;
			  }
			}
		</script>
	</head>
	<body background="<c:url value="/resources/images/bg.png"/>">
		<div class="container">
			<h1><b>Sign Up</b></h1>
			<br>
			<form:form action="registerUser" method="POST" modelAttribute="user" name="myForm" onsubmit="return validateForm()">
				<div class="form-group row">
	    			<!-- <label for="customerName" class="col-sm-3 col-form-label"><h4><b>Name</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="customerName" value="*Name">
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="userName" class="col-sm-3 col-form-label"><h4><b>Username</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<form:input path="userName" class="form-control" name="userName" value="*Username"/>
	    			</div>
	    			<div class="col-sm-2">
	    				<form:errors path="userName" cssClass="error"/>
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="password" class="col-sm-3 col-form-label"><h4><b>Password</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="password" value="*Password">
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="EmailId" class="col-sm-3 col-form-label"><h4><b>Email Id</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<!-- <input type="text" class="form-control" name="emailId"> -->
	    				<form:input path="emailId" class="form-control" name="emailId" value="Email Id"/>
	    			</div>
	    			<div class="col-sm-2">
	    				<form:errors path="emailId" cssClass="error"/>
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="MobileNo" class="col-sm-3 col-form-label"><h4><b>Mobile No.</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="mobileNo" value="Mobile No.">
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="Address" class="col-sm-3 col-form-label"><h4><b> Address</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="address" value="*Address">
	    			</div>
	    		</div>
	    		<div class="form-group row">
	    			<!-- <label for="role" class="col-sm-3 col-form-label"><h4><b> Role</b></h4></label> -->
	    			<div class="col-sm-3">
	    				<form:select class="form-control" path="role">
						<form:option value="0" label="*Select Role"/>
						<form:option value="SELLER" label="Seller"/>
						<form:option value="BUYER" label="Buyer"/>
						<form:option value="IMPORTER" label="Importer"/>
						<form:option value="EXPORTER" label="Exporter"/>
						<form:option value="CUSTOMS" label="Customs"/>
						</form:select>
					</div>
	    		</div>
	    		<br>
	    		<button type="submit" class="btn btn-primary">Sign Up</button>
			</form:form>
		</div>
	</body>
</html> 

 