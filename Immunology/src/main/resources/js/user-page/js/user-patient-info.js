function DemoSelect2() {
		//$('#s2_with_tag').select2({placeholder: "Select OS"});
	//	$('#country').select2();
	//	$('#sex').select2();
	$('select[name=datatable-3_length').select2();
}

$(document).ready(function() {
	// Create jQuery-UI tabs
	$("#tabs").tabs();
	$('#dateOfBirth').datepicker({
		dateFormat : "dd/mm/yy",
		changeMonth : true,
		changeYear : true,
		yearRange : "-110:+2"
	});
	$('#datepicker').click(function() {
		$('#dateOfBirth').datepicker("show");
	});
	TestTable3();
	initSyndromeEvent();

	// Add tooltip to form-controls
	$('.form-control').tooltip();
	Select2Script(DemoSelect2);
	BootstrapValidatorScript(PatientValidator);
	// New Form Builder //
	//1) ID Container div 2) Patient Id 3) Form Type;
	medCard.init('#container', "MedicalCardForm", $('#patient_id').val());

	WinMove();

});

function initSyndromeEvent() {
	$("#select_syndrome_button").click(
			function() {
				$("#newSurveyButton").css("display", "inline");
				anamnesticData.init('#AnamnesticDataContainer',
						"AnamnesticDataForm", $('#patient_id').val(), $(
								'#syndrom').val());
				refreshTable($('#syndrom').val());
			});
	$("#newSurveyButton").click(
			function() {
				if ($("#syndrom").val() != null) {
					var href = 'survey/patientId/'
							+ $("#patient_id").val() + '/syndrome/'
							+ $('#syndrom').val();
					doAjaxGet(href);
				}
			});
}
function initSurveyRowesEvent() {
	$(".surveyRow").click(
			function() {
				var href = 'survey/edit/patientId/'
						+ $("#patient_id").val() + '/surveyId/'
						+ $(this).attr("surveyId") + '/syndrome/'
						+ $('#syndrom').val();
				doAjaxGet(href);
			});
	$('.efficiency').click(function() {
		$('#efficiency-modal').modal('show');
		return false;
	});

}
