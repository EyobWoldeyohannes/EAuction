<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->
 <title>Biddable Products</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1>Biddable Products</h1>
				<p>Add biddable products</p>
			</div>
 			<div>
				<a href="?language=en" >English</a>|<a href="?language=nl" >Dutch</a>					
			</div>
			
		</div>
	</section>
	<section>
		<form:form  modelAttribute="newBiddableProduct" class="form-horizontal" >
			<fieldset>
				<legend>Add new biddable product</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<%-- <form:input path="id" type="hidden" value="${product.id}"/>
				 --%>
				<form:input path="productId" type="hidden" value="${product.productId}"/>
				<form:input path="productName" type="hidden" value="${product.productName}"/>
				<form:input path="productUnitPrice" type="hidden" value="${product.productUnitPrice}"/>
				<form:input path="productDescription" type="hidden" value="${product.productDescription}" />
				<form:input path="productImage" type="file"  value="${product.productImage}"/>
								
				<div>
					<label for="startDate"><spring:message code="addProduct.form.name.label"/></label>
					<div>
						<form:input id="startDate" path="startDate" type="text" class="form:input-large"/>
						<form:errors path="startDate" cssClass="text-danger"/>
					</div>
				</div>

				<div>
					<label for="endDate"><spring:message code="addProduct.form.name.label"/></label>
					<div>
						<form:input id="endDate" path="endDate" type="text" class="form:input-large"/>
						<form:errors path="endDate" cssClass="text-danger"/>
					</div>
				</div>
				<div>
					<label for="bidPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>
					<div>
						<div class="form:input-prepend">
							<form:input id="bidPrice" path="bidPrice" type="text" class="form:input-large"/>
							<form:errors path="bidPrice" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div>
					<label for="payPerBid"><spring:message code="addProduct.form.unitPrice.label"/></label>
					<div>
						<div class="form:input-prepend">
							<form:input id="payPerBid" path="payPerBid" type="text" class="form:input-large"/>
							<form:errors path="payPerBid" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				
				<div>
					<div>
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
