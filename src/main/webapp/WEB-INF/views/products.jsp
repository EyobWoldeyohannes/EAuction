<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->
 <title>Products</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1>Products</h1>
				<p>All the available products</p>
			</div>
		</div>
	</section>

	<section>
		<div>
			<c:forEach items="${products}" var="product">
				<div>
					<div>
					<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${product.productName}</h3>
							<p>${product.productDescription}</p>
							<p>${product.productUnitPrice}USD</p>
							<p>
								<a href=" <spring:url value="/products/product?id=${product.productId}" /> "> Details
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
