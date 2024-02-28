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


	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>

	<div class="container mt-5 mb-5">
		<c:if test="${not empty message}">
			<div class="row">
				<div class="offset-md-3 col-md-6">
					<div class="alert alert-danger fade-in">${message}</div>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty logout}">
			<div class="row">
				<div class="offset-md-3 col-md-6">
					<div class="alert alert-success fade-in">${logout}</div>
				</div>
			</div>
		</c:if>
		<div class="row">

			<div class="offset-md-3 col-md-6">

				<div class="card">

					<div class="card-heading bg-primary text-light text-center">
						<h4 class="display-6 fw-bold">Login</h4>
					</div>

					<div class="card-body">
						<form action="${contextRoot}/login" method="POST"
							class="form-horizontal" id="loginForm">

							<div class="form-group row">
								<label for="username" class="col-md-4 control-label">Email:
								</label>
								<div class="col-md-8">
									<input type="text" name="username" id="username"
										class="form-control" />
								</div>
							</div>
							<div class="form-group row mt-2">
								<label for="password" class="col-md-4 control-label">Password:
								</label>
								<div class="col-md-8">
									<input type="password" name="password" id="password"
										class="form-control" />
								</div>
							</div>
							<div class="form-group row mt-2">
								<div class="offset-md-4 col-md-8">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <input type="submit" value="Login"
										class="btn btn-primary" />
								</div>
							</div>
						</form>

					</div>
					<div class="card-footer">
						<div class="text-right">
							New User - <a href="${contextRoot}/register">Register Here</a>
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>


	<!-- Page Content -->

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
