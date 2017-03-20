<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->	
 	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="<spring:url value="/resource/js/controllers.js"/>"></script>
<title>Products</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section >
	<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
	
		<div>
		<div>
			<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
		</div>
		
			<div>
				<h3>${product.productName}</h3>
				<p>${product.productDescription}</p>
				<p>
					<strong>Item Code : </strong><span>${product.productId}</span>
				</p>
				<%-- <p>
					<strong>category</strong> : ${product.category}
				</p> --%>
				<h4>${product.productUnitPrice} USD</h4>
				
				<%-- <p ng-controller="cartCtrl">
					<a href="#" ng-click="addToCart('${product.productId}')"> Order Now </a>
				<a href="<spring:url value="/cart" />">
					<span></span> View Cart
				</a> --%>

 				<a href="<spring:url value="/products" />"> Back
				</a>

				</p>

			</div>
		</div>
<!--/div-->
	</section>
</body>
</html>
