<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Cabinet</a></li>
			<li><a href="#">Patients</a></li>
			<li><a href="#">${patient.firstName} ${patient.lastName}</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-9">
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
						<li><a href="#tabs-1">Profile</a></li>
						<li><a href="#tabs-2">Medical Card </a></li>
						<li><a href="#tabs-3">Other</a></li>
					</ul>
					<div id="tabs-1">
						<jsp:include
							page="/WEB-INF/pages/user/components/patient-profile.jsp" />

					</div>
					<div id="tabs-2">
						<div id="container"></div>
					</div>
					<div id="tabs-3">
						<p>Other page</p>
						<p>I don't know what page now(</p>
					</div>
				</div>
			</div>
		</div>
	</div>



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
		renderForm($('#container'));
		
	});


</script>