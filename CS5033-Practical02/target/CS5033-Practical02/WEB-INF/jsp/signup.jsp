<%--
  Created by IntelliJ IDEA.
  User: jid
  Date: 21/04/15
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Signup</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/bootstrap-space.css" rel="stylesheet" />

<style>
.blue {
	font-weight: bold;
	color: blue;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/">Home</a></li>
				<li class="active"><a href="signup.html">Signup</a></li>
				<li><a href="login.html">Login</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">Shopping Cart</span></a></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<script type="text/javascript" src="jquery-1.11.2.js">
	</script>

	<script type="text/javascript" src="bootstrap/js/bootstrap.js">
	</script>

	<script type="text/javascript" src="datepicker/js/bootstrap-datepicker.js">
	</script>

	<div class="container">
		<div class="page-header">
			<div>
				<h1>Sign up <small>Its absolutely quick!</small></h1>
			</div>
		</div>

		<div></div>
	</div>

	<c:if test="${not empty message}">
		<div class="col-lg-6 col-lg-offset-3">
			<div class="message blue">${message}</div>
		</div>
	</c:if>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="myForm" method="post"
							class="bs-example form-horizontal" commandName="customer">
							<fieldset>
								<legend>Customer Signup Form</legend>

								<div class="form-group">
									<label for="emailInput" class="col-lg-3 control-label">Email Address</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="email"
											id="emailInput" placeholder="Email Address" />
										<form:errors path="email" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="passwordInput" class="col-lg-3 control-label">Password</label>
									<div class="col-lg-9">
										<form:input type="password" class="form-control"
											path="password" id="passwordInput" placeholder="Password" />
										<form:errors path="password" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="firstNameInput" class="col-lg-3 control-label">First Name</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="first_name"
											id="firstNameInput" placeholder="First Name" />
										<form:errors path="first_name" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="lastNameInput" class="col-lg-3 control-label">Last Name</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="last_name"
											id="lastNameInput" placeholder="Last Name" />
										<form:errors path="last_name" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-primary">Submit</button>
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");		
			
			yesButton.click(function() {		
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};
				
				setTimeout(countDown, 100);
			});
			
		});
	</script>


</body>
</html>