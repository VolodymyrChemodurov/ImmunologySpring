var surveyId;

function DemoSelect2() {
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
		surveyId = $(this).parent().parent().attr("surveyId");
		$.ajax({
			type : "GET",
			url : "/drugs/efficiency/{surveyId}".replace("{surveyId}", surveyId),
			success : function(response) {
				console.log(response);
				if(response != '') {
					$("#side_effect_description").val(response.sideEffectDescription);
					$('#drug_tolerance option[value="' + response.drugTolerance + '"]').prop('selected', true);
					$('#efficacy_evaluation option[value="' + response.efficacyEvaluation + '"]').prop('selected', true);
					$('#cancel option[value="' + response.cancel + '"]').prop('selected', true);
					$('#side_effects_severity_degree option[value="' + response.sideEffectsSeverityDegree + '"]').prop('selected', true);
				} else {
					$("#side_effect_description").val('');
					$('#drug_tolerance').prop('selectedIndex', 0);
					$('#efficacy_evaluation').prop('selectedIndex', 0);
					$('#cancel').prop('selectedIndex', 0);
					$('#side_effects_severity_degree option[value=0]').prop('selectedIndex', 0);
				}
				if(response.updateDate != undefined) {
					$('#update-time-block').show();
					$('#update-time-label').text(response.updateDate);
				} else {
					$('#update-time-block').hide();
				}
				$('#efficiency-modal').modal('show');
			}
		});
		return false;
	});
}