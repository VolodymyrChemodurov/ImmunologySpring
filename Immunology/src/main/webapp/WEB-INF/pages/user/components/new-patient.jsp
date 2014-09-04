<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		<div class="box">
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
		BootstrapValidatorScript(DemoFormValidator);
		// Add drag-n-drop feature to boxes
		WinMove();
	});
</script>
