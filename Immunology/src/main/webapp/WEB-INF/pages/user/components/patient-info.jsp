<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Головна</a></li>
			<li><a href="#">Мої пацієнти</a></li>
			<li><a href="#">${patient.firstName} ${patient.lastName}</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-user"></i> <span>${patient.firstName}
						${patient.lastName}</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<div id="tabs">
					<ul>
						<li><a href="#tabs-1">Профіль</a></li>
						<li><a href="#tabs-2">Медична картка</a></li>
						<li><a href="#tabs-3">Інше</a></li>
					</ul>
					<div id="tabs-1">
						<jsp:include
							page="/WEB-INF/pages/user/components/patient-profile.jsp" />

					</div>
					<div id="tabs-2">
						<div id="container"></div>
					</div>
					<div id="tabs-3">
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input type="hidden" id="patient_id" value="${patient.id}"/>

</div>


<script>
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
		// Load TimePicker plugin and callback all time and date pickers
		//LoadTimePickerScript(AllTimePickers);
		// Create jQuery-UI tabs
		$("#tabs").tabs();
		$('#input_date').datepicker({
			setDate : new Date()
		});
		// Load Timepicker plugin
		// Add tooltip to form-controls
		$('.form-control').tooltip();
		Select2Script(DemoSelect2);
		// Load example of form validation
		BootstrapValidatorScript(DemoFormValidator);
		formData ="";
		renderForm($('#patient_id').val(), $('#container'));

		/////////////////////////////////
		console.log("document ready");
		$("#Мати_checkBox").click(function() {
		    alert("click checkbox");
		});
		
	});


</script>