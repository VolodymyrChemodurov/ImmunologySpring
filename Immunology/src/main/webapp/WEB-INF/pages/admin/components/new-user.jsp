<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Головна</a></li>
			<li><a href="#">Мої пацієнти</a></li>
			<li><a href="#">Додати нового пацієнта</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box" id="new-user">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-search"></i> <span>Новий користувач</span>
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
							<label class="col-sm-3 control-label">Прізвище</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="lastName"
									id="lastName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Ім'я</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="firstName"
									id="firstName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">По-батькові</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="middleName"
									id="middleName" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Логін</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="login"
									id="login" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Пароль</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="password"
									id="password" />
							</div>
						</div>
						
							<div class="form-group">
								<label class="col-sm-3 control-label">Роль користувача</label>
								<div class="col-sm-5">
									<select class="form-control dropdown" name="user_role" id="user_role">
										<option value="">-- Оберіть роль --</option>
										<option value="ROLE_USER">Звичайний користувач</option>
										<option value="ROLE_ADMIN">Адміністратор</option>
										<option value="ROLE_DOCTOR">Лікар</option>
									</select>
								</div>
							</div>
					</fieldset>
					





					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary">Створити</button>
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
	// Run timepicker
	function DemoTimePicker() {
		$('#input_time').timepicker({
			setDate : new Date()
		});
	}
	$(document).ready(function() {
		// Create Wysiwig editor for textare
		//TinyMCEStart('#wysiwig_simple', null);
		//TinyMCEStart('#wysiwig_full', 'extreme');
		// Add slider for change test input length
		//FormLayoutExampleInputLength($( ".slider-style" ));
		// Initialize datepicker
		$('#input_date').datepicker({
			setDate : new Date()
		});
		// Load Timepicker plugin
		//LoadTimePickerScript(DemoTimePicker);
		// Add tooltip to form-controls
		$('.form-control').tooltip();
		Select2Script(DemoSelect2);
		// Load example of form validation
		BootstrapValidatorScript(UserValidator);
		// Add drag-n-drop feature to boxes
		WinMove();
	});
	function UserValidator(){
		$('#new-user').bootstrapValidator({
			message: 'This value is not valid',
			fields: {
				
				firstName: {
					message: 'The username is not valid',
					validators: {
						notEmpty: {
							message: 'The username is required and can\'t be empty'
						},
						stringLength: {
							min: 6,
							max: 30,
							message: 'The username must be more than 6 and less than 30 characters long'
						},
						regexp: {
							regexp: /^[a-zA-Z0-9_\.]+$/,
							message: 'The username can only consist of alphabetical, number, dot and underscore'
						}
					}
				},
				lastName: {
					message: 'The username is not valid',
					validators: {
						notEmpty: {
							message: 'The username is required and can\'t be empty'
						},
						stringLength: {
							min: 6,
							max: 30,
							message: 'The username must be more than 6 and less than 30 characters long'
						},
						regexp: {
							regexp: /^[a-zA-Z0-9_\.]+$/,
							message: 'The username can only consist of alphabetical, number, dot and underscore'
						}
					}
				},
				middleName: {
					message: 'The username is not valid',
					validators: {
						notEmpty: {
							message: 'The username is required and can\'t be empty'
						},
						stringLength: {
							min: 6,
							max: 30,
							message: 'The username must be more than 6 and less than 30 characters long'
						},
						regexp: {
							regexp: /^[a-zA-Z0-9_\.]+$/,
							message: 'The username can only consist of alphabetical, number, dot and underscore'
						}
					}
				},
				
				region: {
					message: 'The region is not valid',
					validators: {
						notEmpty: {
							message: 'The region is required and can\'t be empty'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The region must be more than 3 and less than 30 characters long'
						},
					}
				},
				city: {
					message: 'The city is not valid',
					validators: {
						notEmpty: {
							message: 'The city is required and can\'t be empty'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The city must be more than 3 and less than 30 characters long'
						},
					}
				},
				login: {
					message: 'The login is not valid',
					validators: {
						notEmpty: {
							message: 'The login is required and can\'t be empty'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The login must be more than 3 and less than 30 characters long'
						},
					}
				},
				street: {
					message: 'The street is not valid',
					validators: {
						notEmpty: {
							message: 'The street is required and can\'t be empty'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The street must be more than 3 and less than 30 characters long'
						},
					}
				},
				house: {
					message: 'The house is not valid',
					validators: {
						notEmpty: {
							message: 'The house is required and can\'t be empty'
						},
						stringLength: {
							min: 3,
							max: 30,
							message: 'The house must be more than 3 and less than 30 characters long'
						},
					}
				},
				
				dateOfBirth: {
					message: 'The date is not valid',
					validators: {
						notEmpty: {
							message: 'The date is required and can\'t be empty'
						},
						stringLength: {
							min: 10,
							max: 10,
							message: 'The date must be format mm/dd/yyyy'
						},
					}
				},
				
				
				country: {
					validators: {
						notEmpty: {
							message: 'The country is required and can\'t be empty'
						}
					}
				},
				sex: {
					validators: {
						notEmpty: {
							message: 'The country is required and can\'t be empty'
						}
					}
				},
				acceptTerms: {
					validators: {
						notEmpty: {
							message: 'You have to accept the terms and policies'
						}
					}
				},
				email: {
					validators: {
						notEmpty: {
							message: 'The email address is required and can\'t be empty'
						},
						emailAddress: {
							message: 'The input is not a valid email address'
						}
					}
				},
				
				password: {
					validators: {
						notEmpty: {
							message: 'The password is required and can\'t be empty'
						}
						
					}
				},
				
			}
		});
	}
</script>
