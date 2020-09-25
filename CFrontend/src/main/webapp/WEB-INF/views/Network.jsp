<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Network</title>
		<style>
			#sr {
			  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
			  transition: 0.4s;
			  width: 200px;
			  height: 50px;
			  border-radius: 20px;
			}
			
			#sr:hover,#nid:hover {
			  box-shadow: 0 8px 16px 0 rgba(0,0,0,1);
			}
			
			#fr{
			  /* box-shadow: 0 4px 8px 0 rgba(0,300,0,0.5); */
			  transition: 0.4s;
			  width: 200px;
			  height: 50px;
			  border-radius: 10px;
			}
			
			#nid{
			  box-shadow: 4px 4px 8px 4px rgba(0,300,0,0.5);
			  transition: 0.4s;
			  width: 250px;
			  height: 250px;
			  border-radius: 10px;
			}
		</style>
	</head>
	<body>
		<div class="container">
		<h1 align="center"><b>Networks</b></h1>
			<c:forEach items="${networkIds}" var="nId">
				<div class="col-sm-4">
					<br>
					<br>
					<table class="card" id="nid">
						<tr>
							<td><img src="<c:url value="/resources/images/network.png"/>" alt="Avatar" style="width:100%"></td>
						</tr>
						<tr>
							<td align="center"><h3><b>${nId.getKey()}</b></h3></td>
						</tr>
						<c:if test="${nId.getValue()==0}">
						<tr>
							<td align="center"><a href="<c:url value="/Payment/${nId.getKey()}"/>" class="btn btn-default"> Initiate Payment for this Network ID</a></td>
						</tr>
						</c:if>
					</table>
				</div>
				<div class="col-sm-6">
					<table class="table table-borderless">
						<tr class="card" id="fr">
							<td><h4><b>PARTICIPANT ID</b></h4></td>
							<td><h4><b>ROLE</b></h4></td>
						</tr>
						<c:forEach items="${networkList}" var="user">
						<c:if test="${nId.getKey()==user.networkId}">
							<tr class="card" id="sr">
								<td><b>${user.participantId}</b></td>
								<c:if test="${user.role!=sessionScope.role}">
									<td><b>${user.role}</b></td>
								</c:if>
								<c:if test="${user.role==sessionScope.role}">
									<td><b>${user.role} - You</b></td>
								</c:if>
							</tr>
						</c:if>
						</c:forEach>	
					</table>
				</div>
			</c:forEach>
		</div>
	</body>
</html>