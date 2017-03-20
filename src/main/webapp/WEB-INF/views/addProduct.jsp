<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->
 <title>Products</title>
</head>
<body>
	<section>
		<div>
			<div>
				<h1>Products</h1>
				<p>Add products</p>
			</div>
 			<div>
				<a href="?language=en" >English</a>|<a href="?language=nl" >Dutch</a>					
			</div>
			
		</div>
	</section>
	<section>
		<form:form  modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
			<fieldset>
				<legend>Add new product</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div>
					<label for="productId"><spring:message code="addProduct.form.productId.label"/></label>
					<div>
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						<form:errors path="productId" cssClass="text-danger"/>
					</div>
				</div>

				<div>
					<label for="productName"><spring:message code="addProduct.form.name.label"/></label>
					<div>
						<form:input id="productName" path="productName" type="text" class="form:input-large"/>
						<form:errors path="productName" cssClass="text-danger"/>
					</div>
				</div>

				<div>
					<label for="productUnitPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>
					<div>
						<div class="form:input-prepend">
							<form:input id="productUnitPrice" path="productUnitPrice" type="text" class="form:input-large"/>
							<form:errors path="productUnitPrice" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div>
					<label for="productDescription"><spring:message code="addProduct.form.description.label"/></label>
					<div>
						<form:textarea id="productDescription" path="productDescription" rows = "2"/>
					</div>
				</div>

				
				<div>
					<label for="productImage"><spring:message code="addProduct.form.productImage.label"/></label>
					<div>
						<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
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
