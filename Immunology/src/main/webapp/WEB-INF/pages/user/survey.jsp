<!--Start Content-->
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
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
	var syndrom_name = "${syndrom.name}";
	var syndrom_id = "${syndrom.id}";
	var survey_id = "${surveyId}";
	var patient_id = "${patient.id}";
</script>
<script src="${param.baseURL}/resources/js/user-page/js/user-survey.js"></script>
</body>
</html>
