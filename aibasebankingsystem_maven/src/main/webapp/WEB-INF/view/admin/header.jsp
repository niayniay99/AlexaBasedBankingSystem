<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
		<a class="navbar-brand brand-logo" href="index"><img
			src="<%=request.getContextPath()%>/adminResources/images/logo.png" alt="logo" style="height: 50px;width:200px;" /></a>
		<a class="navbar-brand brand-logo-mini" href="index.html"><img
			src="<%=request.getContextPath()%>/adminResources/images/logo-mini.svg" alt="logo" /></a>
	</div>
	<div
		class="navbar-menu-wrapper d-flex align-items-center justify-content-end justify-content-lg-start">
		<button class="navbar-toggler navbar-toggler align-self-center"
			type="button" data-toggle="minimize">
			<span class="mdi mdi-menu"></span>
		</button>
		<ul class="navbar-nav navbar-nav-right">
			
			<li class="nav-item nav-profile dropdown"><a
				class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
				id="profileDropdown"> <img src="<%=request.getContextPath()%>/adminResources/images/avatar.png"
					alt="profile" /> <span class="nav-profile-name"></span>
			</a>
				<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
					aria-labelledby="profileDropdown">
					
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/logout"> <i
						class="mdi mdi-logout text-primary"></i> Logout
					</a>
				</div></li>
			
		</ul>
		<button
			class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
			type="button" data-toggle="offcanvas">
			<span class="mdi mdi-menu"></span>
		</button>
	</div>
</nav>
