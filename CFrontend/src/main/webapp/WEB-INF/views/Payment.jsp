<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Payment</title>
		<style>
			#fr{
			  box-shadow: 4px 4px 8px 4px rgba(0,0,0,1);
			  transition: 0.4s;
			  width: 350px;
			  height: 250px;
			  border-radius: 10px;
			}
			
			body { margin-top:20px; }
			.panel-title {display: inline;font-weight: bold;}
			.checkbox.pull-right { margin: 0; }
			.pl-ziro { padding-left: 0px; }
			
		</style>
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<script>
			function showDiv() {
			   document.getElementById('cardDetails').style.display = "block";
			}
		</script>
	</head>
	<body background="<c:url value="/resources/images/bg.png"/>" >
	<div class="container">
		<!-- <h1 align="center"><b>Payment</b></h1> -->
		<br>
		<div class="col-sm-6">
			<table class="card" id="fr">
				<tr>
					<td><img src="<c:url value="/resources/images/payment.jpg"/>" alt="Avatar" style="width:100%"></td>
				<tr>
					<td align="center"><h4><b>Total Amount : &#8377; 10,000/-</b></h4></td>
				</tr>
				<tr>
					<td align="center">
						<h4><b>Payment Type :</b></h4> 
						<input type="radio" name="paymentMode" value="COD" onclick="showDiv()"/><b>Debit Card</b>
						<input type="radio" name="paymentMode" value="CC" onclick="showDiv()"/><b>Credit Card</b>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
        <div class="col-sm-4" id="cardDetails" style="display:none;">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form role="form">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CV" required />
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><span class="badge pull-right"> &#8377;10,000/-</span> Final Payment</a>
                </li>
            </ul>
            <br/>
            <a href="<c:url value="/Pay"/>" class="btn btn-success btn-lg btn-block" role="button">Pay</a>
        </div>
    </div>
	</body>
</html>