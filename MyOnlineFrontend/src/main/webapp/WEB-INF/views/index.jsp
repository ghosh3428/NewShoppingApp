<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />
<spring:url var="images" value="/rs/images" />

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

<!-- Datatable CSS -->
<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<script>
	window.contextRoot = '${contextRoot}';
</script>

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
	<c:if test="${userclickallproducts == true || userclickcategoryproducts == true }">
		<%@ include file="productlist.jsp"%>
	</c:if>
	
	<c:if test="${userclicksingleproduct == true}">
		<%@ include file="singleproduct.jsp"%>
	</c:if>
	<c:if test="${userclickmanageproduct == true}">
		<%@ include file="manageproduct.jsp"%>
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
	
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/bootbox.min.js"></script>
	
<script src="${js}/customscript.js"></script>
</body>

</html>
