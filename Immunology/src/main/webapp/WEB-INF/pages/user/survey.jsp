
		<!--Start Content-->
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Головна</a></li>
			<li><a href="#" onclick="doAjaxGet('patients/my');">Мої пацієнти</a></li>
			<li><a href="#" onclick="doAjaxGet('patients/${patient.id}');">${patient.firstName} ${patient.lastName}</a></li>
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
				<div id="tabs" style="display: none">
					<ul>
						<li><a href="#tabs-1">Скарги</a></li>
						<li><a href="#tabs-2">Клінічні прояви</a></li>
						<li><a href="#tabs-3">Лабораторні дані</a></li>
						<li><a href="#tabs-4">Морфологічні дані</a></li>
						<li><a href="#tabs-5">Інструментальні дані</a></li>
						<li><a href="#tabs-6">Верифікація діагнозу</a></li>
						<li><a href="#tabs-7">ЛТ</a></li>			
						

					</ul>
					<div id="tabs-1">
						<div id="complaints" class="form-container" ></div>
					</div>
					<div id="tabs-2">
						<div id="clinicalManifestations" class="form-container" ></div>
					</div>
					<div id="tabs-3">
						<div id="laboratoryData" class="form-container"></div>
					</div>
					<div id="tabs-4">
						<div id="morphologicalData" class="form-container"></div>
					</div>
					<div id="tabs-5">
						<div id="instrumentalData" class="form-container"></div>
					</div>
					<div id="tabs-6">
						<div id="diagnosisVerificationData" class="form-container"></div>
					</div>
					<div id="tabs-7">
							<div id="sub-tabs" style="display: none">
								<ul>
									<li><a href="#sub-tabs-1">Основне лікування</a></li>
									<li><a href="#sub-tabs-2">Реабілітація</a></li>
									<li><a href="#sub-tabs-3">Профілактичні заходи</a></li>
									<li><a href="#sub-tabs-4"> Препарат </a></li>
								</ul>
								<div id="sub-tabs-1">
									<div id="mainTreatmentData" class="form-container" ></div>
								</div>
								<div id="sub-tabs-2">
									<div id="rehabilitationData" class="form-container" ></div>
								</div>
								<div id="sub-tabs-3">
									<div id="preventiveMeasuresData" class="form-container"></div>
								</div>
								<div id="sub-tabs-4">
									<div>
			
									</div>
								</div>
							</div>
					</div>
					
					</div>
				</div>
			</div>
		</div>
	</div>

	<input type="hidden" id="patient_id" value="${patient.id}"/>
		<!--End Content-->
	
	
	
	
<script type="text/javascript">
var surveyURL = "/survey/patient/${patient.id}/survey/${surveyId}";

var complaintsData  = new Builder("complaintsData");
var clinicalManifestationData  = new Builder("clinicalManifestationData");
var laboratoryData  = new Builder("laboratoryData");
var morphologicalData = new Builder("morphologicalData");
var instrumentalData = new Builder("instrumentalData");
var diagnosisVerificationData = new Builder("diagnosisVerificationData");
var mainTreatmentData = new Builder("mainTreatmentData");
var rehabilitationData = new Builder("rehabilitationData");
var preventiveMeasuresData = new Builder("preventiveMeasuresData");
var currentSurvey = {};
var currentSurveyId = "${surveyId}";
var surveyCreationDate = "${survey.creationDate}";

$(document).ready(function() {
	console.log("${syndrom.name}; ${syndrom.id}");
	$("#tabs").tabs();
	$("#sub-tabs").tabs();
	$("#sub-tabs").css("display", "block");
	$("#tabs").css("display", "inline");
	if("${surveyId}".length > 0){
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
		
		complaintsData.initNewSurveyForm("#complaints", "ComplaintsForm", $('#patient_id').val(), "${syndrom.name}");
		laboratoryData.initNewSurveyForm('#laboratoryData', "LaboratoryDataForm", $('#patient_id').val(),  "${syndrom.name}");
		clinicalManifestationData.initNewSurveyForm('#clinicalManifestations', "ClinicalManifestationsForm", $('#patient_id').val(), "${syndrom.name}");
		morphologicalData.initNewSurveyForm('#morphologicalData', "MorphologicalData", $('#patient_id').val(), "${syndrom.name}");
		instrumentalData.initNewSurveyForm('#instrumentalData', "InstrumentalData", $('#patient_id').val(), "${syndrom.name}");
		diagnosisVerificationData.initNewSurveyForm('#diagnosisVerificationData', "DiagnosisVerificationData", $('#patient_id').val(), "${syndrom.name}");
		mainTreatmentData.initNewSurveyForm('#mainTreatmentData', "MainTreatmentData", $('#patient_id').val(), "${syndrom.name}");
		rehabilitationData.initNewSurveyForm('#rehabilitationData', "RehabilitationData", $('#patient_id').val(), "${syndrom.name}");
		preventiveMeasuresData.initNewSurveyForm('#preventiveMeasuresData', "PreventiveMeasuresData", $('#patient_id').val(), "${syndrom.name}");
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

function doAjaxGet(pageName) {
    $.ajax({
        type: "GET",
        url: "/" + pageName,
        success: function(response) {
            $("#content").html(response);
        }
    });
}
function doAjaxPost(pageName) {
	console.info('doAjaxPost()');
    $.ajax({
        type: "POST",
        url: "/" + pageName,
        success: function(response) {
            $("#content").html(response);
        }
    });
}
function doAjaxPost(pageName) {
    console.info('doAjaxPost()');
    $.ajax({
       type: "POST",
       url: "/" + pageName,
       success: function(response) {
       $("#content").html(response);
    }
 });
}
function getSurveyTemplate(){
	$.ajax({
		type : "get",
		url :  "/syndromes/template/{name}".replace("{name}", "${syndrom.name}"),
		dataType : "json",
		success : function(response) {
			currentSurvey = response.surveys[0];
		},
		error: function (request, status, error) {
			alert(error);
	    }
	});
}
    
function saveSyrvey(){
	patientId = "${patient.id}";
	syndromName = "${syndrom.name}";
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
   
    
    

</script>
	
</body>

</html>
