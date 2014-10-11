<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Головна</a></li>
			<li><a href="#">Мої пацієнти</a></li>
			<li><a href="#">Додати нового пацієнта</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box" id="new-patient">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-search"></i> <span>Новий пацієнт</span>
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
				<form id="defaultForm" method="POST"
					action="/patients"
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


					</fieldset>
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Стать</label>
							<div class="col-sm-5">
								<select class="populate placeholder" name="sex" id="sex">
									<option value="">-- Оберіть стать --</option>
									<option value="чоловік">Чоловіча</option>
									<option value="жінка">Жіноча</option>

								</select>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-3 control-label">Дата народження</label>
							<div class="col-sm-5">
								<input type="text" name="dateOfBirth" id="dateOfBirth"
									class="form-control" placeholder="дд/мм/рррр"> <span
									class="fa fa-calendar form-control-feedback"></span>
							</div>


						</div>
					</fieldset>


					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Країна</label>
							<div class="col-sm-5">
								<select class="populate placeholder" name="country" id="country">
									<option value="">-- Оберіть країну --</option>
									<option value="Україна">Україна</option>
									<option value="Франція">Франція</option>
									<option value="Німеччина">Німеччина</option>
									<option value="Італія">Італія</option>
									<option value="Россія">Россія</option>
									<option value="Японія">Японія</option>
									<option value="Великобританія">Великобританія</option>
									<option value="США">США</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Регіон</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="region"
									id="region" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Місто</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="city" id="city" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Вулиця</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="street"
									id="street" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Будинок</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="house" id="house" />
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
		BootstrapValidatorScript(PatientValidator);
		// Add drag-n-drop feature to boxes
		WinMove();
	});
	function PatientValidator(){
		$('#new-patient').bootstrapValidator({
			message: 'This value is not valid',
			fields: {
				
				firstName: {
					message: 'The first name is not valid',
					validators: {
						notEmpty: {
							message: 'The first rname is required and can\'t be empty'
						},
						stringLength: {
							min: 2,
							max: 30,
							message: 'The first name must be more than 2 and less than 30 characters long'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The first name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				lastName: {
					message: 'The last name is not valid',
					validators: {
						notEmpty: {
							message: 'The last name is required and can\'t be empty'
						},
						stringLength: {
							min: 2,
							max: 30,
							message: 'The last name must be more than 2 and less than 30 characters long'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The last name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				middleName: {
					message: 'The middle name is not valid',
					validators: {
						notEmpty: {
							message: 'The middle name is required and can\'t be empty'
						},
						stringLength: {
							min: 6,
							max: 30,
							message: 'The middle name must be more than 6 and less than 30 characters long'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The middle name must contains only letters,apostrophe or hyphen.'
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
							min: 6,
							max: 30,
							message: 'The region must be more than 6 and less than 30 characters long'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The region must contains only letters,apostrophe or hyphen.'
						}
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
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The city must contains only letters,apostrophe or hyphen.'
						}
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
						}
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
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The street name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				house: {
					message: 'The house is not valid',
					validators: {
						notEmpty: {
							message: 'The house is required and can\'t be empty'
						},
						stringLength: {
							min: 1,
							max: 3,
							message: 'The house must be more than 1 and less than 3 characters long'
						},
						regexp: {
							regexp: /^[a-zA-Z\u0400-\u052F0-9]+$/,
							message: 'The house must contains only letters or numbers.',
						}
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
						regexp: {
							regexp: /^[F0-9/]+$/,
							message: 'The input is not a valid date',
						}
					}
				},
				
				
				country: {
					validators: {
						notEmpty: {
							message: 'The country is required and can\'t be empty'
						},
						regexp: {
							regexp: /^([a-zA-Z\u0400-\u052F]+[-// /']?)*$/,
							message: 'The country name must contains only letters,apostrophe or hyphen.'
						}
					}
				},
				sex: {
					validators: {
						notEmpty: {
							message: 'The sex is required and can\'t be empty'
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
						regexp: {
							regexp: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]+$/,
							message: 'The input is not a valid email address',
						}
					}
				},
				password: {
					validators: {
						notEmpty: {
							message: 'The password is required and can\'t be empty'
						},
						identical: {
							field: 'confirmPassword',
							message: 'The password and its confirm are not the same'
						}
					}
				},
				confirmPassword: {
					validators: {
						notEmpty: {
							message: 'The confirm password is required and can\'t be empty'
						},
						identical: {
							field: 'password',
							message: 'The password and its confirm are not the same'
						}				
					}
				}
				
			}
		});
	}
</script>
