<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->
 <title>Welcome</title>
</head>
<body>
	<section>
		<div>
			<div>
				<img src="<spring:url value='/resource/images/group.png' />" />
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
				<%-- <p>
					<security:authorize access="isAuthenticated()">
						Welcome <security:authentication property="principal.username"/>
					</security:authorize>
				</p> --%>
			</div>	 
 
				  <div>
				 <%--  <security:authorize access="isAnonymous()">
				  		<a href="<spring:url value='/login'/>" class="btn btn-default pull-right">  Login</a>
				  </security:authorize> --%>
		
					 <a href="<spring:url value='/products' />"> Go to Community
					</a>
					
					<a href="<spring:url value='/products/add' />"> Add Product
					</a>
					
				</div>	
				
				<div class="pull-left"> <h3>${SpecialMessage}</h3></div>
		</div>	
	</section>
	
</body>
</html>
