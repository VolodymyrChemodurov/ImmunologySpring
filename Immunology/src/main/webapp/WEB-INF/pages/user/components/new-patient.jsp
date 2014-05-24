<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Dashboard</a></li>
			<li><a href="#">Forms</a></li>
			<li><a href="#">Forms layouts</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-search"></i>
					<span>Adding new patient</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
					<a class="expand-link">
						<i class="fa fa-expand"></i>
					</a>
					<a class="close-link">
						<i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<form id="defaultForm" method="POST" action="/Immunology/cabinet/patient/register"  class="form-horizontal">
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">First Name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="firstName" id="firstName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Last Name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="lastName" id="lastName"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Middle Name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="middleName" id="middleName"/>
							</div>
						</div>
						
					
					</fieldset>
					<fieldset>
					<legend></legend>
					<div class="form-group">
							<label class="col-sm-3 control-label">Select sex</label>
							<div class="col-sm-5">
								<select class="populate placeholder" name="sex" id="sex">
									<option value="">-- Select a sex --</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
									
								</select>
							</div>
					</div>
					<div class="form-group has-feedback">
						<label class="col-sm-3 control-label">Date</label>
						<div class="col-sm-5">
							<input type="text"  name="dateOfBirth" id="dateOfBirth" class="form-control" placeholder="Date">
							<span class="fa fa-calendar form-control-feedback"></span>
						</div>
						
						
					</div>
					</fieldset>	
					
					
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Country</label>
							<div class="col-sm-5">
								<select class="populate placeholder" name="country" id="country">
									<option value="">-- Select a country --</option>
									<option value="Ukraine">Ukraine</option>
									<option value="France">France</option>
									<option value="Germany">Germany</option>
									<option value="Italy">Italy</option>
									<option value="Japan">Japan</option>
									<option value="Russia">Russia</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="United State">United State</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Region</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="region"  id="region"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">City</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="city" id="city" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Street</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="street" id="street" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">house</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="house" id="house"/>
							</div>
						</div>
					</fieldset>
					
					
					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary" >Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</div>
<script type="text/javascript">
// Run Select2 plugin on elements
function DemoSelect2(){
	//$('#s2_with_tag').select2({placeholder: "Select OS"});
	$('#country').select2();
	$('#sex').select2();
}
// Run timepicker
function DemoTimePicker(){
	$('#input_time').timepicker({setDate: new Date()});
}
$(document).ready(function() {
	// Create Wysiwig editor for textare
	//TinyMCEStart('#wysiwig_simple', null);
	//TinyMCEStart('#wysiwig_full', 'extreme');
	// Add slider for change test input length
	//FormLayoutExampleInputLength($( ".slider-style" ));
	// Initialize datepicker
	$('#input_date').datepicker({setDate: new Date()});
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
