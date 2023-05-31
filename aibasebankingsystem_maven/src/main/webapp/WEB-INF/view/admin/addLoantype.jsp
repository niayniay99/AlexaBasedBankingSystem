<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>AI based Banking | Add Loan type</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/jquery.toast.min.css">

<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->


		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->


			<jsp:include page="menu.jsp"></jsp:include>



			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row grid-margin">
						<div class="col-12">
							<div class="card"></div>
						</div>
					</div>
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Loan Type</h4>
									<f:form class="cmxform" id="commentForm" method="post"
										onsubmit="return addLoantype()" action="saveLoantype"
										modelAttribute="LoantypeVO">
										<fieldset>
											<div class="form-group">
												<label for="cname"> Loan Type</label>
												<f:input id="loanType" class="form-control" name="loanType"
													minlength="2" type="text" path="loanType" onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122 || event.charCode==32' />
											</div>

											<div class="form-group">
												<label for="ccomment">Loan Description</label>
												<f:textarea id="loanDescription" class="form-control"
													name="loanDescription" path="loanDescription"></f:textarea>
											</div>
											<f:hidden path="loantypeid" />
											<input class="btn btn-primary" type="submit" value="Submit">
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="card"></div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->

				<jsp:include page="footer.jsp"></jsp:include>

				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/custom/customValidation.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	
	<!-- End custom js for this page-->
</body>

</html>
