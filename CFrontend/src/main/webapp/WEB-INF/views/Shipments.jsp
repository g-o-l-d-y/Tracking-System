<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Shipments</title>
		<style>
			#nid{
			  	box-shadow: 4px 4px 8px 4px rgba(0,0,0,0.5);
			  	transition: 0.4s;
			  	width: 180px;
			  	height: 250px;
			  	border-radius: 10px;
			  	display: block
			}
			
			#received{
			  	box-shadow: 6px 6px 8px 6px rgba(0,300,0,0.5);
			  	transition: 0.4s;
			  	width: 180px;
			  	height: 250px;
			  	border-radius: 10px;
			  	display: block
			}
			
			#nid:hover{
			  	box-shadow: 0 8px 16px 0 rgba(0,0,0,1);
			}
			
			#received:hover{
				box-shadow: 0px 8px 16px 0px rgba(0,300,0,1);
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1 align="center"><b>Tracking</b></h1>
			<c:forEach items="${transactionIds}" var="tId">
			<br>
			<br>
			<div class="row">
				<div class="col-sm-2">
					<table class="card" id="nid" class="rounded-circle">
						<tr>
							<td><img src="<c:url value="/resources/images/transaction.png"/>" alt="Avatar" style="width:100%"></td>
						</tr>
						<tr>
							<td align="center"><h3><b>${tId.getKey()}</b></h3></td>
						</tr>
					</table>
				</div>
				<c:forEach items="${transactionList}" var="user">
					<c:if test="${tId.getKey()==user.transactionId}">
						<div class="col-sm-2">
							<c:choose>  
							    <c:when test="${user.status==1 && user.role=='SELLER'}">  
							      	<table class="card" id="nid">
							      		<tr>
							      			<td><img src="<c:url value="/resources/images/start.png"/>" alt="Avatar" style="width:100%"></td>
							      		</tr>
							      		<tr><td align="center"><b>${user.participantId}</b></td></tr>
							      		<c:if test="${user.role!=sessionScope.role}">
											<tr><td align="center"><b>${user.role}</b></td></tr>
										</c:if>
										<c:if test="${user.role==sessionScope.role}">
											<tr><td align="center"><b>${user.role} - You</b></td></tr>
										</c:if>
										<c:if test="${user.date!=null}">
											<tr><td align="center"><b>${user.date}</b></td></tr>
										</c:if>
										<c:if test="${user.date==null}">
											<tr><td></td></tr>
										</c:if>
										<c:if test="${tId.getValue()==user.role && tId.getValue()==sessionScope.role}">
											<tr><td align="center"><a href="<c:url value="/Received/${tId.getKey()}"/>" class="btn btn-success"> Received </a></td></tr>
										</c:if>
							      	</table>
							    </c:when>  
							    <c:when test="${user.status==1 && user.role!='SELLER'}">  
							        <table class="card" id="received">
							        	<tr>
							      			<td><img src="<c:url value="/resources/images/received.png"/>" alt="Avatar" style="width:100%"></td>
							      		</tr>
							        	<tr><td align="center"><b>${user.participantId}</b></td></tr>
										<c:if test="${user.role!=sessionScope.role}">
											<tr><td align="center"><b>${user.role}</b></td></tr>
										</c:if>
										<c:if test="${user.role==sessionScope.role}">
											<tr><td align="center"><b>${user.role} - You</b></td></tr>
										</c:if>
										<c:if test="${user.date!=null}">
											<tr><td align="center"><b>${user.date}</b></td></tr>
										</c:if>
										<c:if test="${user.date==null}">
											<tr><td></td></tr>
										</c:if>
										<c:if test="${tId.getValue()==user.role && tId.getValue()==sessionScope.role}">
											<tr><td align="center"><a href="<c:url value="/Received/${tId.getKey()}"/>" class="btn btn-success"> Received </a></td></tr>
										</c:if>
							      	</table>
							    </c:when>  
							    <c:when test="${user.status==2}">  
							        <table class="card" id="nid">
							        	<tr>
							      			<td><img src="<c:url value="/resources/images/passed.png"/>" alt="Avatar" style="width:100%"></td>
							      		</tr>
								      	<tr><td align="center"><b>${user.participantId}</b></td></tr>
										<c:if test="${user.role!=sessionScope.role}">
											<tr><td align="center"><b>${user.role}</b></td></tr>
										</c:if>
										<c:if test="${user.role==sessionScope.role}">
											<tr><td align="center"><b>${user.role} - You</b></td></tr>
										</c:if>
										<c:if test="${user.date!=null}">
											<tr><td align="center"><b>${user.date}</b></td></tr>
										</c:if>
										<c:if test="${user.date==null}">
											<tr><td></td></tr>
										</c:if>
										<c:if test="${tId.getValue()==user.role && tId.getValue()==sessionScope.role}">
											<tr><td align="center"><a href="<c:url value="/Received/${tId.getKey()}"/>" class="btn btn-success"> Received </a></td></tr>
										</c:if>
							      	</table>
							    </c:when>
							    <c:otherwise>  
							       <table class="card" id="nid">
							       		<tr>
							      			<td><img src="<c:url value="/resources/images/waiting.png"/>" alt="Avatar" style="width:100%"></td>
							      		</tr>
								      	<tr><td align="center"><b>${user.participantId}</b></td></tr>
										<c:if test="${user.role!=sessionScope.role}">
											<tr><td align="center"><b>${user.role}</b></td></tr>
										</c:if>
										<c:if test="${user.role==sessionScope.role}">
											<tr><td align="center"><b>${user.role} - You</b></td></tr>
										</c:if>
										<c:if test="${user.date!=null}">
											<tr><td align="center"><b>${user.date}</b></td></tr>
										</c:if>
										<c:if test="${user.date==null}">
											<tr><td></td></tr>
										</c:if>
										<c:if test="${tId.getValue()==user.role && tId.getValue()==sessionScope.role}">
											<tr><td align="center"><a href="<c:url value="/Received/${tId.getKey()}"/>" class="btn btn-success"> Received </a></td></tr>
										</c:if>
							      	</table>  
							    </c:otherwise>  
							</c:choose>  
						</div>
					</c:if>
				</c:forEach>
			</div>
			</c:forEach>
		</div>
	</body>
</html>