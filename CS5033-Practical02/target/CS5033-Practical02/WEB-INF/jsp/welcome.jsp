<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="/assets/css/bootstrap-space.css" rel="stylesheet" />
    <link href="/bootstrap/css/bootstrap-theme.css" rel="stylesheet" />
    <style>
        body {
            height: 100%;
            margin: 0;
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
            <li class="active"><a href="/">Home</a></li>
            <li><a href="signup.html">Signup</a></li>
            <li><a href="login.html">Login</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">Shopping Cart</span></a></li>
        </ul>
    </div>
    <!-- /.nav-collapse -->
</div>
<div class="container">
    <div class="jumbotron">
        <div>
            <h1>Welcome to e-commerce</h1>
        </div>
    </div>

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Available Products</div>

        <!-- Table -->
        <table class="table">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th></th>
            </tr>
            <c:forEach items="${products}" var="Product">
                <tr>
                    <td>${Product.code}</td>
                    <td>${Product.name}</td>
                    <td>${Product.price}</td>
                    <td>
                        <form:form id="${Product.product_id}" method="get" action="#" >
                            <input type="hidden" name="productId" value="${Product.product_id}">
                            <input type="submit" name="submit" value="add to cart">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div></div>
</div>
<script src="/jquery-1.11.2.js">
</script>

<script src="/bootstrap/js/bootstrap.js">
</script>

</body>
</html>
