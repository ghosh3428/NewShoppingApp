<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->

	<%@ include file="./shared/nav.jsp"%>
<br/>

	<!-- Page Content -->
	<div class="container">
	<c:if test="${userclickhome == true}">
		<%@ include file="home.jsp"%>
	</c:if>
	<c:if test="${userclickallproduct == true}">
		<%@ include file="productlist.jsp"%>
	</c:if>
	</div>
	<!-- /.container -->

	<div class="container">
		<hr>
		<%@ include file="./shared/footer.jsp"%>
		<!-- Footer -->
	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

</body>

</html>
