<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>AI based Banking | View Branch</title>
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
					<div class="card">
						<div class="card-header">
						<a href="addBranch" style="float:right;" class="col-1">
							<input class="btn btn-primary" type="button" value="Add">
						</a><h4 class="">View Branch</h4>
					</div>
					

						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
													<th>Sr. no</th>
													<th>Area Name</th>
													<th>Branch Name</th>
													<th>Address</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

												<c:forEach items="${branchList}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${i.areaVO.areaName}</td>
														<td>${i.branchName}</td>
														<td>${i.branchAddress}</td>
														<td><a href="editBranch?branchid=${i.branchid}">
																<i class="mdi mdi-pencil-box" style="font-size: 20px;"></i>
														</a> <a href="deleteBranch?branchid=${i.branchid}"> <i
																class="mdi mdi-delete"
																style="font-size: 20px; margin-left: 15px; color: #ef5959;"></i>
														</a></td>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
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
	<script src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
