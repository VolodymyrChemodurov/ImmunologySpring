<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="/Immunology/cabinet">Головна</a></li>
			<li><a href="#">Профіль</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12 col-sm-6">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-user-md"></i> <span>Ваш профіль</span>
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
					action="/Immunology/cabinet/profile/edit" class="form-horizontal">


					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Прізвище</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="lastName"
									id="lastName" value="${user.lastName}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Ім'я</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="firstName"
									value="${user.firstName}" id="firstName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">По-батькові</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="middleName"
									id="middleName" value="${user.middleName}" />
							</div>
						</div>


					</fieldset>



					<fieldset>
						<legend></legend>

						<div class="form-group">
							<label class="col-sm-3 control-label">Логін</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="login" id="login"
									value="${user.login}" />
							</div>
						</div>
					</fieldset>


					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary">Редагувати</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa  fa-unlock-alt"></i> <span>Змінити пароль</span>
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
					action="/Immunology/cabinet/profile/edit/password"
					class="form-horizontal">
					<fieldset>
						<legend></legend>

						<div class="form-group">
							<label class="col-sm-3 control-label">Поточний пароль</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" name="oldPassword"
									id="oldPassword" value="" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">Новий пароль</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Повторіть пароль</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" />
							</div>
						</div>
					</fieldset>


					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary">Зберегти</button>
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
		BootstrapValidatorScript(DemoFormValidator);
		// Add drag-n-drop feature to boxes
		WinMove();
	});
</script>
