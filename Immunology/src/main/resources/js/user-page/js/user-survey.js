$(document).ready(function() {
		console.log(syndrom_name, syndrom_id);
		$("#tabs").tabs();
		$("#sub-tabs").tabs();
		$("#sub-tabs").css("display", "block");
		$("#tabs").css("display", "inline");
		if(survey_id.length > 0){
			$.ajax({
				type : "get",
				url :  surveyURL,
				dataType : "json",
				async:   false,
				success : function(response) {
					var survey = response;
					complaintsData.initNewSurveyFormWithNewUrl("#complaints", "COMPLAINTS_FORM", survey);
					laboratoryData.initNewSurveyFormWithNewUrl('#laboratoryData', "LABORATORY_DATA_FORM", survey);
					clinicalManifestationData.initNewSurveyFormWithNewUrl('#clinicalManifestations', "CLINICAL_MANIFESTATIONS_FORM", survey);
					morphologicalData.initNewSurveyFormWithNewUrl('#morphologicalData', "MORPHOLOGICAL_DATA", survey);
					instrumentalData.initNewSurveyFormWithNewUrl('#instrumentalData', "INSTRUMENTAL_DATA", survey);
					diagnosisVerificationData.initNewSurveyFormWithNewUrl('#diagnosisVerificationData', "DIAGNOSIS_VERIFICATION_DATA", survey);
					mainTreatmentData.initNewSurveyFormWithNewUrl('#mainTreatmentData', "MAIN_TREATMENT_DATA", survey);
					rehabilitationData.initNewSurveyFormWithNewUrl('#rehabilitationData', "REHABILITATION_DATA", survey);
					preventiveMeasuresData.initNewSurveyFormWithNewUrl('#preventiveMeasuresData', "PREVENTIVE_MEASURES_DATA", survey);
				},
				error: function (request, status, error) {
					alert(error);
			    }
			});
		} else {
			getSurveyTemplate();
			complaintsData.initNewSurveyForm("#complaints", "COMPLAINTS_FORM", $('#patient_id').val(), syndrom_name, currentSurvey);
			laboratoryData.initNewSurveyForm('#laboratoryData', "LABORATORY_DATA_FORM", $('#patient_id').val(),  syndrom_name, currentSurvey);
			clinicalManifestationData.initNewSurveyForm('#clinicalManifestations', "CLINICAL_MANIFESTATIONS_FORM", $('#patient_id').val(), syndrom_name, currentSurvey);
			morphologicalData.initNewSurveyForm('#morphologicalData', "MORPHOLOGICAL_DATA", $('#patient_id').val(), syndrom_name, currentSurvey);
			instrumentalData.initNewSurveyForm('#instrumentalData', "INSTRUMENTAL_DATA", $('#patient_id').val(), syndrom_name, currentSurvey);
			diagnosisVerificationData.initNewSurveyForm('#diagnosisVerificationData', "DIAGNOSIS_VERIFICATION_DATA", $('#patient_id').val(), syndrom_name, currentSurvey);
			mainTreatmentData.initNewSurveyForm('#mainTreatmentData', "MAIN_TREATMENT_DATA", $('#patient_id').val(), syndrom_name, currentSurvey);
			rehabilitationData.initNewSurveyForm('#rehabilitationData', "REHABILITATION_DATA", $('#patient_id').val(), syndrom_name, currentSurvey);
			preventiveMeasuresData.initNewSurveyForm('#preventiveMeasuresData', "PREVENTIVE_MEASURES_DATA", $('#patient_id').val(), syndrom_name, currentSurvey);
		}
		$("#complaints").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#clinicalManifestations").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#laboratoryData").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#morphologicalData").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#instrumentalData").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#diagnosisVerificationData").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#mainTreatmentData").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
		$("#rehabilitationData").append('<button type="button" style="margin-left: 48%;" onClick="saveSyrvey();" class="btn btn-primary">Save</button>');
	});

function getSurveyTemplate(){
	$.ajax({
		type : "get",
		url :  "/syndromes/template/{name}".replace("{name}", syndrom_name),
		dataType : "json",
		async:   false,
		success : function(response) {
			currentSurvey = response.surveys[0];
		},
		error: function (request, status, error) {
			alert(error);
	    }
	});
}
    
function saveSyrvey(){
	patientId = patient_id;
	syndromName = syndrom_name;
	currentSurvey = complaintsData.surveyObject;
	currentSurvey.forms = [];
	for(var i = 0; i < forms.length; i++) {
		if(forms[i].formObject !== null) {
			currentSurvey.forms.push(forms[i].formObject);
		}
	}
	if(!isNaN(currentSurveyId)) {
		currentSurvey.id = currentSurveyId;
		if(surveyCreationDate) {
			currentSurvey.creationDate = surveyCreationDate;
		}
	}
	console.log(currentSurvey);
	 $.ajax({
			type : "post",
			url :   "/survey/patient/{patientId}/syndrome/{syndromeName}".replace("{patientId}", patientId).replace("{syndromeName}", syndromName),
			data: JSON.stringify(currentSurvey),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    async: false,
			success : function(response) {
				console.log(response);
				currentSurvey = response;
				currentSurveyId = response.id;
				surveyCreationDate = response.creationDate; 
				console.log("Survey Saved");
			},
			error: function (request, status, error) {
				alert(error);
		    }
		});
}
