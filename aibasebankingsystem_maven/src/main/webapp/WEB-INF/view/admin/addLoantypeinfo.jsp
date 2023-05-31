
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
<title>AI based Banking | Add Loantype Info</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="/adminResources/css/vendor.bundle.addons.css">
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
					<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
					<div class="row grid-margin">
						<div class="col-12">
							<div class="card"></div>
						</div>
					</div>
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Loan Type Information</h4>
									<f:form class="cmxform" id="commentForm" method="post"
										onsubmit="return addLoantypeinfo()" action="saveLoantypeinfo"
										modelAttribute="LoantypeinfoVO">
										<fieldset>
											<div class="form-group">
												<label for="cname"> Loan Type</label>
												<f:select path="loantypeVO.loantypeid" class="form-control"
													id="selectLoantype">
													<option selected="selected" disabled="disabled"
														value="none">Select Loan Type</option>
													<c:forEach items="${loantypeList}" var="i">
														<option value="${i.loantypeid}">${i.loanType}</option>
													</c:forEach>

												</f:select>

											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<label for="cname"> Loan Rate (%)</label>
													<f:input id="loanRate" class="form-control" name="loanRate"
														type="text" path="loanRate"
														onkeypress='return event.charCode>=48 && event.charCode<=57 || event.charCode == 190' />
												</div>
												<div class="form-group col-md-6 ">
													<label for="cname"> Maximum Loan Amount </label>
													<f:input type="text" id="maximumloanAmount"
														class="form-control" name="maximumloanAmount"
														path="maximumloanAmount" />

												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<label>Time Duration</label>
													<f:input type="text" id="timeDuration" name="timeDuration"
														path="timeDuration" class="form-control" />
												</div>
												<div class="form-group col-md-6">
													<label for="cname"> Number Of EMI's </label>
													<f:input id="numberofEmi" class="form-control"
														name="numberofEmi" type="text" path="numberofEmi" />

												</div>
											</div>

											<f:hidden path="loantypeinfoid" />

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
