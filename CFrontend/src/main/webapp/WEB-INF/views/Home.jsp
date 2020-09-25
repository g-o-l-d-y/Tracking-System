<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<style>
	
		#myCarousel{
			border-radius: 20px;
		}
		
		.carousel-indicators li{
			background-color: #2F4F4F;
		}
		
		.carousel-indicators .active {
		    background-color: #000000;
		}
		
		h1{
			font-family: "Comic Sans MS", "Comic Sans", cursive;
		}
	</style>
</head>
<body background="<c:url value="/resources/images/home.jpg"/>">
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		    <li data-target="#myCarousel" data-slide-to="1"></li>
		    <li data-target="#myCarousel" data-slide-to="2"></li>
		    <li data-target="#myCarousel" data-slide-to="3"></li>
		    <li data-target="#myCarousel" data-slide-to="4"></li>
		    <li data-target="#myCarousel" data-slide-to="5"></li>
		    <li data-target="#myCarousel" data-slide-to="6"></li>
		    <li data-target="#myCarousel" data-slide-to="7"></li>
		    <li data-target="#myCarousel" data-slide-to="8"></li>
		    <li data-target="#myCarousel" data-slide-to="9"></li>
		    <li data-target="#myCarousel" data-slide-to="10"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner">
		    <div class="item active">
		      <img src="<c:url value="/resources/images/welcome.png"/>" alt="Los Angeles">
		    </div>
			
			<div class="item">
		      <img src="<c:url value="/resources/images/0.png"/>" alt="Chicago">
		    </div>
			
			<div class="item">
		      <img src="<c:url value="/resources/images/1.png"/>" alt="Chicago">
		    </div>
			
		    <div class="item">
		      <img src="<c:url value="/resources/images/2.png"/>" alt="Chicago">
		    </div>
		
		    <div class="item">
		      <img src="<c:url value="/resources/images/3.png"/>" alt="New York">
		    </div>
		  
		  	<div class="item">
		      <img src="<c:url value="/resources/images/4.png"/>" alt="Los Angeles">
		    </div>
		    
		    <div class="item">
		      <img src="<c:url value="/resources/images/5.png"/>" alt="Los Angeles">
		    </div>
		    
		    <div class="item">
		      <img src="<c:url value="/resources/images/6.png"/>" alt="Los Angeles">
		    </div>
		    
		    <div class="item">
		      <img src="<c:url value="/resources/images/7.png"/>" alt="Los Angeles">
		    </div>
		    
		    <div class="item">
		      <img src="<c:url value="/resources/images/8.png"/>" alt="Los Angeles">
		    </div>
		    
		    <div class="item">
		      <img src="<c:url value="/resources/images/9.png"/>" alt="Los Angeles">
		    </div>
		  </div>
		  
		  <!-- Left and right controls -->
		  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#myCarousel" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	</div>
</body>
</html>