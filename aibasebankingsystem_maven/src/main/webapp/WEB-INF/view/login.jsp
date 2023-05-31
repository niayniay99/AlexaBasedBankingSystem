<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BoardsterUI Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>adminResources/images/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth">
				<div class="row w-100">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left p-5">
							<div class="brand-logo">
								<img src="<%=request.getContextPath()%>adminResources/images/logo.png" alt="logo"
									style="height: 50px; width: 200px;">
							</div>
							<br />
							<form class="pt-3" action="j_spring_security_check" method="post">
								<div class="form-group">
									<input name="username" type="text"
										class="form-control form-control-lg" id="exampleInputEmail1"
										placeholder="Username">
								</div>
								<div class="form-group">
									<input name="password" type="password"
										class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="Password">
								</div>
								<div class="mt-3">
									<input type="submit"
										class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn"
										value="SIGN IN">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>adminResources/js/vendor.bundle.base.js"></script>
	<script src="<%=request.getContextPath()%>adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>adminResources/js/todolist.js"></script>
	<!-- endinject -->
</body>

</html>
