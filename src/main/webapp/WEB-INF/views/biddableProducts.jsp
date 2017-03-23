<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
		<script type="text/javascript" src="<spring:url value="/resource/js/bid.js"/>"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- <link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		 -->
 <title>Biddable Products</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1>Biddable Products</h1>
				<p>All the available products for bid</p>
			</div>
		</div>
	</section>

	<section>
		<div>
			<c:forEach items="${biddableProducts}" var="biddableProduct">
				<!-- <div>
					<div> -->
					<img src="<c:url value="/resource/images/${biddableProduct.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
						<!-- <div class="caption"> -->
							<p>
								<strong>Bidder ID and Name : </strong><span>${customer.id}</span> <span>${customer.firstName}</span> <br>
							
								<strong>Product ID : </strong><span>${biddableProduct.productId}</span>
							
							</p>
							<h3>Product Name : ${biddableProduct.productName}</h3>
							<p>Product Description : ${biddableProduct.productDescription}</p>
							<p>Product Unit Price : ${biddableProduct.productUnitPrice}USD</p>
							<p>Bid Start Date : ${biddableProduct.startDate}</p>
							<p>Bid End Date : ${biddableProduct.endDate}</p>
							<p>Bidding Price : ${biddableProduct.bidPrice}USD</p>
							<p>Pay per Bid : ${biddableProduct.payPerBid}</p>
							
							<div>
								<!-- <form id="bidForm" method="post">
								 -->
								 <form id="${biddableProduct.id}" method="post" >	
										<table>
										<%-- <tr>
											<td><input type="hidden" name="id" value="${customer.id}"></td>
										</tr>
										 --%>
										<tr>
											<td><input type="hidden" name="CUSTOMER_ID" value="${customer.id}"></td>
										</tr>
										<tr>
											<td><input type="hidden" name="BIDDABLE_PRODUCT_ID"  value="${biddableProduct.id}"></td>
										</tr>
										<tr>
											<td><input type="hidden" name="amount" value="${biddableProduct.payPerBid}"></td>
										</tr>
										<tr>
											<td><input type="hidden" name="status" value="WINNING"></td>
										</tr>
										<tr>
											<td><input type="hidden" name="soldPrice" value="${biddableProduct.soldPrice}"></td>
										</tr>
										
										<tr>
											<td>
													<div id="${biddableProduct.id}${biddableProduct.id}" >
													</div>
													
													<div id="${biddableProduct.id}${biddableProduct.id}${biddableProduct.id}" ></div>
													
													
											</td>
										</tr> 
										
										<tr>
											<td colspan="2" align="center">
											<input type="button" value="BID" onclick="makeAjaxBidCall(${biddableProduct.id});"></td>
										</tr>
									</table>
									</form>
									
											
							</div>
							
							<p>
								<a href=" <spring:url value="/products/biddables/biddableProduct?id=${biddableProduct.productId}" /> "> View Details</a>
								<a href=" <spring:url value="/products/biddables/edit?id=${biddableProduct.productId}" /> "> Edit</a>
								<a href=" <spring:url value="/products/biddables/delete?id=${biddableProduct.productId}" /> "> Delete</a>
								<a href=" <spring:url value="/products/biddables" /> "> Back</a>
							</p>
						<!-- </div> -->
					<!-- </div>
				</div> -->
			</c:forEach>
		</div>
	</section>
</body>
</html>
