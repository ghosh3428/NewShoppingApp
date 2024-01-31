<div class="col-md-3">
	<p class="lead">Shop Name</p>
	<div class="list-group">
		<c:forEach items="${categorylist}" var="category">
		<a href="${contextRoot}/product/show/all/active/category/${category.id}/products" >${category.categoryName}</a>
		</c:forEach>
	</div>
</div>