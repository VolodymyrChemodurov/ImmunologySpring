<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Main</a></li>
			<li><a href="#">Users</a></li>
			<li><a href="#">Add new user</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12" id="validation">
		<div class="box" id="new-user">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-search"></i> <span>New user</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="expand-link"> <i class="fa fa-expand"></i>
					</a> <a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<form id="defaultForm" method="POST" action="/admin"
					class="form-horizontal">
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Last name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="lastName"
									id="lastName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">First name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="firstName"
									id="firstName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Middle name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="middleName"
									id="middleName" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Login</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="login" id="login" />
							</div>
						</div>

						<div class="form-group" id="defaultForm-password">
							<label class="col-sm-3 control-label">Password</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="password"
									id="password" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">User's role</label>
							<div class="col-sm-5">
								<select class="form-control dropdown" name="user_role"
									id="user_role">
									<option value="">-- Choose the role --</option>
									<option value="ROLE_USER">User</option>
									<option value="ROLE_ADMIN">Admin</option>
									<option value="ROLE_DOCTOR">Doctor</option>
								</select>
							</div>
						</div>
					</fieldset>






					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary">Create</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</div>


<script type="text/javascript">
	// Run Select2 plugin on elements
	function DemoSelect2() {
		//$('#s2_with_tag').select2({placeholder: "Select OS"});
		$('#country').select2();
		$('#sex').select2();
	}

	$(document).ready(function() {
		// Add tooltip to form-controls
		$('.form-control').tooltip();
		Select2Script(DemoSelect2);
		// Load example of form validation
		BootstrapValidatorScript(PatientValidator);
		BootstrapValidatorScript(PasswordValidator);
		// Add drag-n-drop feature to boxes
		WinMove();
	});	
</script>
