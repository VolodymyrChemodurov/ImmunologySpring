$(document).ready(function() {
		console.log(syndrom_name, syndrom_id);
		$("#tabs").tabs();
		$("#sub-tabs").tabs();
		$("#sub-tabs").css("display", "block");
		$("#tabs").css("display", "inline");
		if(survey_id.length > 0){
			complaintsData.initNewSurveyFormWithNewUrl("#complaints", "ComplaintsForm",surveyURL );
			laboratoryData.initNewSurveyFormWithNewUrl('#laboratoryData', "LaboratoryDataForm", surveyURL);
			clinicalManifestationData.initNewSurveyFormWithNewUrl('#clinicalManifestations', "ClinicalManifestationsForm", surveyURL);
			morphologicalData.initNewSurveyFormWithNewUrl('#morphologicalData', "MorphologicalData", surveyURL);
			instrumentalData.initNewSurveyFormWithNewUrl('#instrumentalData', "InstrumentalData", surveyURL);
			diagnosisVerificationData.initNewSurveyFormWithNewUrl('#diagnosisVerificationData', "DiagnosisVerificationData", surveyURL);
			mainTreatmentData.initNewSurveyFormWithNewUrl('#mainTreatmentData', "MainTreatmentData", surveyURL);
			rehabilitationData.initNewSurveyFormWithNewUrl('#rehabilitationData', "RehabilitationData", surveyURL);
			preventiveMeasuresData.initNewSurveyFormWithNewUrl('#preventiveMeasuresData', "PreventiveMeasuresData", surveyURL);
		}else{
			complaintsData.initNewSurveyForm("#complaints", "ComplaintsForm", $('#patient_id').val(), syndrom_name);
			laboratoryData.initNewSurveyForm('#laboratoryData', "LaboratoryDataForm", $('#patient_id').val(),  syndrom_name);
			clinicalManifestationData.initNewSurveyForm('#clinicalManifestations', "ClinicalManifestationsForm", $('#patient_id').val(), syndrom_name);
			morphologicalData.initNewSurveyForm('#morphologicalData', "MorphologicalData", $('#patient_id').val(), syndrom_name);
			instrumentalData.initNewSurveyForm('#instrumentalData', "InstrumentalData", $('#patient_id').val(), syndrom_name);
			diagnosisVerificationData.initNewSurveyForm('#diagnosisVerificationData', "DiagnosisVerificationData", $('#patient_id').val(), syndrom_name);
			mainTreatmentData.initNewSurveyForm('#mainTreatmentData', "MainTreatmentData", $('#patient_id').val(), syndrom_name);
			rehabilitationData.initNewSurveyForm('#rehabilitationData', "RehabilitationData", $('#patient_id').val(), syndrom_name);
			preventiveMeasuresData.initNewSurveyForm('#preventiveMeasuresData', "PreventiveMeasuresData", $('#patient_id').val(), syndrom_name);
			getSurveyTemplate();
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
	currentSurvey.complaintsForm = complaintsData.formObject;
	currentSurvey.laboratoryDataForm = laboratoryData.formObject;
	currentSurvey.clinicalManifestationsForm = clinicalManifestationData.formObject;
	currentSurvey.morphologicalData = morphologicalData.formObject;
	currentSurvey.instrumentalData = instrumentalData.formObject;
	currentSurvey.diagnosisVerificationData = diagnosisVerificationData.formObject;
	currentSurvey.mainTreatmentData = mainTreatmentData.formObject;
 	currentSurvey.rehabilitationData = rehabilitationData.formObject;
	currentSurvey.preventiveMeasuresData = preventiveMeasuresData.formObject;
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
