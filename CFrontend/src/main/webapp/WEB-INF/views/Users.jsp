<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Users</title>
		<style>
		
			#netw {
			  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
			  transition: 0.4s;
			  width: 250px;
			  height: 300px;
			  border-radius: 20px;
			}
			
			#sr {
			  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
			  transition: 0.4s;
			  width: 200px;
			  height: 50px;
			  border-radius: 20px;
			}
			
			#sr:hover {
			  box-shadow: 0 8px 16px 0 rgba(0,0,0,1);
			}
			
			#fr{
			  /* box-shadow: 0 4px 8px 0 rgba(0,300,0,0.5); */
			  transition: 0.4s;
			  width: 200px;
			  height: 50px;
			  border-radius: 10px;
			}
			
		</style>
	</head>
	<body>
		<div class="container">
			<div class="col-sm-9">
				<table class="table table-borderless">
					<thead><h1><b>Users</b></h1></thead>
					<br>
					<tr class="card" id="fr">
						<td><h4><b>PARTICIPANT ID</b></h4></td>
						<td><h4><b>ADDRESS</b></h4></td>
						<td><h4><b>ROLE</b></h4></td>
						<td></td>
						<td></td>
					</tr>
					<c:forEach items="${userList}" var="user">
						<tr class="card" id="sr">
							<td><b>${user.participantId}</b></td>
							<td><b>${user.address}</b></td>
							<td><b>${user.role}</b></td>
							<td>
								<c:if test="${user.userName!=sessionScope.username}">
									<a href="<c:url value="/addUser/${user.participantId}"/>" class="btn btn-info">Add</a>
								</c:if>
								<c:if test="${user.userName==sessionScope.username}">
									<h5><b>You</b></h5>
								</c:if>
							</td>
							<td>
							<c:if test="${user.userName!=sessionScope.username}">
								<a href="<c:url value="/deleteUser/${user.participantId}"/>" class="btn btn-danger">Remove</a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-3">
			 	 <br>
				 <br>
				 <br>
				 <br>
				 <br>
				 <table class="card" id="netw">
					<tr align="center">
						<td><b>Add 5 Participants to create a Network</b></td> 
					</tr>
				 	<c:forEach items="${Network}" var="user">
				 		<tr>
					 		<c:if test="${user.getKey()!=sessionScope.participantId}">
								<td align="center"><b>${user.getKey()} - ${user.getValue()}</b></td>
							</c:if>
							
							<c:if test="${user.getKey()==sessionScope.participantId}">
								<td align="center"><b>${user.getKey()} - ${user.getValue()} (You)</b></td>
							</c:if>
				 		</tr>
				 	</c:forEach>
				 	<c:if test="${size==5}">
				 		<td align="center"><a href="<c:url value="/formNetwork"/>" class="btn btn-success">Create Network</a></td>
				 	</c:if>
				 </table>	 
			</div>
		</div>
	</body>
</html>