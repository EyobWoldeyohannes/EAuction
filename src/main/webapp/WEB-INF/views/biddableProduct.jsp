<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->	
 	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="<spring:url value="/resource/js/controllers.js"/>"></script>
<title>Biddable Product</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1>Biddable Product</h1>
			</div>
		</div>
	</section>
	<section >
	<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
	
		<div>
		<div>
			<img src="<c:url value="/resource/images/${biddableProduct.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
		</div>
		
			<div>
				<p>
					<strong>Product Code : </strong><span>${biddableProduct.productId}</span>
				</p>
				<h3>Product Name : ${biddableProduct.productName}</h3>
				<p>Product Description : ${biddableProduct.productDescription}</p>
				<p>Product Category : ${biddableProduct.productDescription}</p>
				<p>Product Unit Price : ${biddableProduct.productUnitPrice}USD</p>
				<p>Bid Start Date : ${biddableProduct.startDate}</p>
				<p>Bid End Date : ${biddableProduct.endDate}</p>
				<p>Bidding Price :${biddableProduct.bidPrice}USD</p>
				<p>Pay per Bid : ${biddableProduct.payPerBid}</p>
				<p>Profit per this : ${biddableProduct.profit}USD</p>
				<p>Status : ${biddableProduct.status}</p>
							
				
				<%-- <p ng-controller="cartCtrl">
					<a href="#" ng-click="addToCart('${product.productId}')"> Order Now </a>
				<a href="<spring:url value="/cart" />">
					<span></span> View Cart
				</a> --%>

 				<%-- <a href=" <spring:url value="/products/product/edit?id=${product.productId}" /> "> Edit
 				 --%>
 				 <p>
 				<a href="<spring:url value="/biddables" />"> Back</a>
 				</p>

				

			</div>
		</div>
<!--/div-->
	</section>
</body>
</html>
