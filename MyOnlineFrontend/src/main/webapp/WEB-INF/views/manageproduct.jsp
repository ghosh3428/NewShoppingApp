
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container">
	<c:if test="${not empty message}">
		<div class="col-xs-12 offset-md-1 col-md-10">
			<div class="alert alert-success alert-dismissible" role="alert">
				${message}
				<button type="button" class="close text-end" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<div class="card">
		<div class="card-header bg-primary text-center text-white">
			<h1 class="display-5">MANAGE PRODUCT FORM</h1>
		</div>
		<div class="card-body">
			<sf:form action="${contextRoot}/manage/product" method="post"
				modelAttribute="product">
				<div class="form-group row mt-1">
					<label for="name" class="col-md-4 fs-4 fw-bold">Product
						Name</label>
					<div class="col-md-8">
						<sf:input type="text" path="name" id="name" class="form-control" />
						<sf:errors path="name" cssClass="help-block" element="em" />
					</div>

				</div>
				<div class="form-group row  mt-1"">
					<label for="brand" class="col-md-4 fs-4 fw-bold">Brand Name</label>
					<div class="col-md-8">
						<sf:input type="text" path="brand" id="brand" class="form-control" />
						<sf:errors path="brand" cssClass="help-block" element="em" />
					</div>

				</div>
				<div class="form-group row  mt-1"">
					<label for="unitPrice" class="col-md-4 fs-4 fw-bold">Price</label>
					<div class="col-md-8">
						<sf:input type="number" path="unitPrice" id="unitPrice"
							class="form-control" />
						<sf:errors path="unitPrice" cssClass="help-block" element="em" />
					</div>

				</div>
				<div class="form-group row  mt-1"">
					<label for="quantity" class="col-md-4 fs-4 fw-bold">Quantity</label>
					<div class="col-md-8">
						<sf:input type="number" path="quantity" id="quantity"
							class="form-control" />
						<sf:errors path="quantity" cssClass="help-block" element="em" />
					</div>

				</div>
				<div class="form-group row  mt-1"">
					<label for="description" class="col-md-4 fs-4 fw-bold">Description</label>
					<div class="col-md-8">
						<sf:textarea path="description" id="description"
							class="form-control" rows="5" />
						<sf:errors path="description" cssClass="help-block" element="em" />
					</div>

				</div>
				<div class="form-group row  mt-1"">
					<label for="supplierId" class="col-md-4 fs-4 fw-bold">Supplier
						ID</label>
					<div class="col-md-8">
						<sf:select id="supplierId" path="supplierId"
							items="${supplierList}" itemLabel="firstName" itemValue="id"
							class="form-control">
						</sf:select>
					</div>

				</div>
				<div class="form-group row  mt-1">
					<label for="categoryId" class="col-md-4 fs-4 fw-bold">Category
						ID</label>
					<div class="col-md-8">
						<sf:select id="categoryId" path="categoryId"
							items="${categoryList}" itemLabel="categoryName" itemValue="id"
							class="form-control">
						</sf:select>
					</div>
					<div class="text-end mt-1">
						<a class="btn btn-warning btn-sm" data-toggle="modal"
							data-target="#myCategoryModal">Manage Category</a>
					</div>
				</div>
				<div class="mt-1 text-center">
				<sf:hidden path="id" />
				<sf:hidden path="code" />
				<sf:hidden path="active" />
							
					<input type="submit" class="btn btn-success btn-lg"
						value="Manage Product" />
				</div>
			</sf:form>
		</div>
	</div>



	<hr />
	<br />


	<div class="card">
		<div class="card-header bg-info text-center text-white">
			<h1 class="display-6">AVAILABLE PRODUCTS</h1>
		</div>
		<div class="card-body">
		<table id="adminProductsTable"
				class="table table-condensed table-bordered">

				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>ACTIVATE</th>
						<th>EDIT</th>
					</tr>
				</thead>



				<tfoot>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>ACTIVATE</th>
						<th>EDIT</th>
					</tr>
				</tfoot>


			</table>
		</div>
	</div>

	


	<div class="modal" id="myCategoryModal" tabindex="-1" role="dialog">

		<div class="modal-dialog" role="document">

			<div class="modal-content">

				<div class="modal-header text-center bg-warning text-white">

					<h1 class="fs-3">ADD CATEGORY FORM</h1>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">

					<sf:form id="categoryForm" class="form-horizontal"
						modelAttribute="category"
						action="${contextRoot}/manage/add/category" method="POST">

						<div class="form-group row mt-1">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="categoryName" class="form-control"
									placeholder="Category Name" />
							</div>
						</div>

						<div class="form-group row mt-1">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8 validate">
								<sf:textarea path="description" rows="3" class="form-control"
									placeholder="Enter category description here!" />
							</div>
						</div>


						<div class="form-group row mt-1">
							<div class="offset-md-4 col-md-4">
								<input type="submit" name="submit" value="Save"
									class="btn btn-primary " />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>