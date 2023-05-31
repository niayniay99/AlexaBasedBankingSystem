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
<title>AI based Banking | Add Branch</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/jquery.toast.min.css">
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
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Add Branch</h4>
									<f:form class="cmxform" id="commentForm" method="post"
										action="saveBranch" modelAttribute="BranchVO"
										onsubmit="return addBranch()">
										<fieldset>

											<div class="form-group">
												<label for="cname">Area Name</label>
												<f:select path="areaVO.areaid" class="form-control"
													id="selectArea">
													<option selected="selected" value="none"
														disabled="disabled">Select Area</option>
													<c:forEach items="${areaList}" var="i">
														<option value="${i.areaid}">${i.areaName}</option>
													</c:forEach>

												</f:select>
											</div>

											<div class="form-group">
												<label for="cname">Branch Name</label>
												<f:input id="branchName" class="form-control"
													name="branchName" type="text" path="branchName"
													onkeypress='return event.charCode>=65 && event.charCode<=90 || event.charCode>=97 && event.charCode<=122 || event.charCode==32' />
											</div>

											<div class="form-group">
												<label for="ccomment">Branch Address</label>
												<f:textarea id="branchAddress" class="form-control"
													name="branchAddress" path="branchAddress"></f:textarea>
											</div>
											<f:hidden path="branchid" />
											<input class="btn btn-primary" type="submit" value="Submit">
										</fieldset>
									</f:form>
								</div>
							</div>
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
	<script src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.toast.min.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/toaster.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/custom/customValidation.js"></script>

	<!-- End custom js for this page-->
</body>

</html>
