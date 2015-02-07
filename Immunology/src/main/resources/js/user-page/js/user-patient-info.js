var surveyId;

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

	//WinMove();

});

function initSyndromeEvent() {
	$("#select_syndrome_button").click(
			function() {
				$("#newSurveyButton").css("display", "inline");
				$(".box-content #tabs .hide").addClass('show');
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
		surveyId = $(this).parent().parent().attr("surveyId");
		
		$.ajax({
			type : "GET",
			url : "/drugs/efficiency/{surveyId}".replace("{surveyId}", surveyId),
			success : function(response) {
				console.log(response);
				$("#side_effect_description").val(response.sideEffectDescription);
				$('#drug_tolerance option[value="' + response.drugTolerance + '"]').prop('selected', true);
				$('#efficacy_evaluation option[value="' + response.efficacyEvaluation + '"]').prop('selected', true);
				$('#cancel option[value="' + response.cancel + '"]').prop('selected', true);
				$('#side_effects_severity_degree option[value="' + response.sideEffectsSeverityDegree + '"]').prop('selected', true);
			}
		});
		
		return false;
	});

}

$("#save-sub-efficiency-button").click(
		function() {
			var efficiencyData = {};
			efficiencyData.drugTolerance = $("#drug_tolerance").val();
			efficiencyData.efficacyEvaluation = $("#efficacy_evaluation").val();
			efficiencyData.sideEffectDescription = $("#side_effect_description").val();
			efficiencyData.sideEffectsSeverityDegree = $("#side_effects_severity_degree").val();
			efficiencyData.cancel = $("#cancel").val();
			
			console.log(efficiencyData);

			$.ajax({
				type : "POST",
				url : "/drugs/efficiency/{surveyId}".replace("{surveyId}", surveyId),
				data : JSON.stringify(efficiencyData),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(response) {
					console.log("Success Save");
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
});
