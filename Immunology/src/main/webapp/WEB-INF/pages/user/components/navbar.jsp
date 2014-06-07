
<header class="navbar">
		</div>
	<div class="container-fluid expanded-panel">
		
		<div class="row">
			<div id="logo" class="col-xs-12 col-sm-2">
				<a href="/Immunology/cabinet">Immunology</a>
			</div>
			<div id="top-panel" class="col-xs-12 col-sm-10">
				<div class="row">
					<div class="col-xs-8 col-sm-4 marg-top-10px">
						<a href="#" class="show-sidebar marg-top-8px">
						  <i class="fa fa-bars"></i>
						</a>
						<div id="search">
							<input type="text" placeholder="search"/>
							<i class="fa fa-search"></i>
						</div>
					</div>
					<div class="col-xs-4 col-sm-8 top-panel-right">
						<ul class="nav navbar-nav pull-right panel-menu">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
									<i class="fa fa-angle-down pull-right"></i>
									<div class="user-mini pull-right">
										<span class="welcome">Welcome,</span>
										<span>${user.firstName}  ${user.lastName}</span>
									</div>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="#" onclick="doAjaxGet('profile')">
											<i class="fa fa-user"></i>
											<span class="hidden-sm text">Profile</span>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="fa fa-cog"></i>
											<span class="hidden-sm text">Settings</span>
										</a>
									</li>
									<li>
										<a href="/Immunology">
											<i class="fa fa-power-off"></i>
											<span class="hidden-sm text">Logout</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>