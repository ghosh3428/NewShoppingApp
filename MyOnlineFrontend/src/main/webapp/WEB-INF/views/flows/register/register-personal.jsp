<%@include file="../shared/header.jsp"%>


<div class="row">

	<div class="offset-md-1 col-md-10">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h4 class="display-5 text-center" >Sign Up - Personal</h4>
			</div>

			<div class="card-body">

				<sf:form method="POST" 
					modelAttribute="user" 
					id="registerForm">


					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold">First Name</label>
						<div class="col-md-8">
							<sf:input type="text" path="firstName" class="form-control"
								placeholder="First Name" />
							<sf:errors path="firstName" cssClass="help-block" element="em" />
						</div>
					</div>


					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold"">Last Name</label>
						<div class="col-md-8">
							<sf:input type="text" path="lastName" class="form-control"
								placeholder="Last Name" />
							<sf:errors path="lastName" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold"">Email</label>
						<div class="col-md-8">
							<sf:input type="text" path="email" class="form-control"
								placeholder="abc@zyx.com" />
							<sf:errors path="email" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold"">Contact Number</label>
						<div class="col-md-8">
							<sf:input type="text" path="contactNumber" class="form-control"
								placeholder="XXXXXXXXXX" maxlength="10" />
							<sf:errors path="contactNumber" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold"">Password</label>
						<div class="col-md-8">
							<sf:input type="password" path="password" class="form-control"
								placeholder="Password" />
							<sf:errors path="password" cssClass="help-block" element="em" />
						</div>
					</div>

					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold"">Confirm Password</label>
						<div class="col-md-8">
							<sf:input type="password" path="confirmPassword"
								class="form-control" placeholder="Re-type password" />
							<sf:errors path="confirmPassword" cssClass="help-block"
								element="em" />
						</div>
					</div>

					<div class="form-group row mt-1">
						<label class="col-md-4 fs-4 fw-bold"">Select Role</label>
						<div class="col-md-8">
							<label class="radio-inline"> <sf:radiobutton path="role"
									value="USER" checked="checked" /> User
							</label> <label class="radio-inline"> <sf:radiobutton path="role"
									value="SUPPLIER" /> Supplier
							</label>
						</div>
					</div>

					<br />
					<div class="form-group row">
						<div class="offset-md-4 col-md-8">
							<button type="submit" name="_eventId_billing"
								class="btn btn-primary">
								Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
							</button>
						</div>
					</div>


				</sf:form>


			</div>


		</div>


	</div>


</div>
<%@include file="../shared/footer.jsp"%>
