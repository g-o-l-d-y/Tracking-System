<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Payment Success</title>
		<style>
			#fr{
			  box-shadow: 0 4px 8px 0 rgba(300,0,0,1);
			  transition: 0.4s;
			  width: 125px;
			  height: 45px;
			  border-radius: 10px;
			}
		</style>
	</head>
	<body background="<c:url value="/resources/images/bg.png"/>" >
		<div class="container">
			<div class="col-sm-5">
				<table class="table table-borderless">
					<tr class="card" id="fr">
						<td><img src="<c:url value="/resources/images/success.png"/>" alt="Avatar" style="width:90%" ></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>