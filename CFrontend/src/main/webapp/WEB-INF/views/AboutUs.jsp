<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>About Us</title>
		<style>
			#idea {
			  box-shadow: 0 4px 8px 0 rgb(32, 178, 170);
			  transition: 0.4s;
			  width: 500px;
			  height: 100px;
			  border-radius: 50px;
			  font-family: Comic Sans MS;
			}
			
			#team {
			  box-shadow: 0 4px 8px 0 rgb(32, 178, 170);
			  transition: 0.4s;
			  width: 500px;
			  height: 50px;
			  border-radius: 300px;
			  font-family: Comic Sans MS;
			  font-size: 20px;
			}
			
			#idea:hover,#team:hover {
			  box-shadow: 4px 8px 16px 4px rgb(32, 178, 170);
			}
			
		</style>
	</head>
	<body background="<c:url value="/resources/images/bg.png"/>">
		<div class="container">
			<div class="row">
				<table class="card" id="idea" background="<c:url value="/resources/images/idea.jpg"/>">
					<tr><td align="center"><h1><b>Idea</b></h1></td></tr>
					<tr><td align="center"><h1><b>Blockchain as a technology can streamline the role of Customs in the trade of food products across the borders.</b></h1></td></tr>
				</table>
			</div>
			<br>
			<br>
			<br>
			<div class="row">
				<table class=card id="team" background="<c:url value="/resources/images/team.png"/>">
					<tr><td align="center"><h3><b>BL 04: Blue Chain Explorers</b></h3></td></tr>
					<tr><td align="center"><b>Aman Poddar (Team Captain)</b></td></tr>
					<tr><td align="center"><b>Harsh Neralla</b></td></tr>
					<tr><td align="center"><b>Shobhit Singh</b></td></tr>
					<tr><td align="center"><b>Goldy Jeyarani</b></td></tr>
					<tr><td></td></tr>
				</table>
			</div>
		</div>
	</body>
</html>