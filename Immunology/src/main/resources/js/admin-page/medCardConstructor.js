var getMedCardUrl = "/admin/medical_card";
var getSyndromUrl = "/syndromes/template/{name}";
var syndrom = null;
var formObject = null;
var order = {
	panel: 0,
	element: 0
};

function init(){
	getResouces(getMedCardUrl);
	
	if(formObject == null){
		formObject = {};
		formObject["panels"] = [];
		formObject["objectType"] = "MedicalCardForm";
	}
	console.log("->MED.CARD AFTER getResources");
	console.log(formObject);
}
function initSurveyForm(syndromName){
	if(formType == "anamnestic"){
		console.log("Show Anamnestic Data Form");
		getAnamnesticResouces(getSyndromUrl.replace('{name}',syndromName));
		console.log(formObject);
	}
	if(formType == "comlaints"){
		console.log("Show Comlaints Data Form");
		getComlaintsResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "clinicalManifestation"){
		console.log("Show Clinical Manifestation Data Form");
		getClinicalManifestationsResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "laboratoryData"){
		console.log("Show Laboratory Data Form");
		getLaboratoryResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "morphologicalData"){
		console.log("Show Morphological Data Form");
		getMorphologicalDataResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "instrumentalData"){
		console.log("Show Morphological Data Form");
		getInstrumentalDataResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "diagnosisVerificationData"){
		console.log("Show Diagnosis Verification Data Form");
		getDiagnosisVerificationDataResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "mainTreatmentData"){
		console.log("Show Main Treatment Data Form");
		getMainTreatmentDataResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "rehabilitationData"){
		console.log("Show Main Rehabilitation Data Form");
		getRehabilitationDataResouces(getSyndromUrl.replace('{name}',syndromName));
	}
	if(formType == "preventiveMeasuresData"){
		console.log("Show PreventiveMeasures Data Data Form");
		getPreventiveMeasuresDataResouces(getSyndromUrl.replace('{name}',syndromName));
	}
}

function getAnamnesticResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			formObject = response.anamnesticData;
			console.log(formObject);
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in anamnestic data");
			alert(error);
	    }

	});
}
function getComlaintsResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			//if(response.surveys.length == 0){
		
			//}
			
			
			
			if(response.surveys[0].complaintsForm == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "ComplaintsForm";
			}else{
				formObject = response.surveys[0].complaintsForm;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in anamnestic data");
			alert(error);
	    }

	});
}
function getClinicalManifestationsResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].clinicalManifestationsForm == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "ClinicalManifestationsForm";
			}else{
				formObject = response.surveys[0].clinicalManifestationsForm;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in anamnestic data");
			alert(error);
	    }

	});
}
function getLaboratoryResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].laboratoryDataForm == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "LaboratoryDataForm";
			}else{
				formObject = response.surveys[0].laboratoryDataForm;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in anamnestic data");
			alert(error);
	    }

	});
}

function getMorphologicalDataResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].morphologicalData == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "MorphologicalData";
			}else{
				formObject = response.surveys[0].morphologicalData;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in MorphologicalData data");
			alert(error);
	    }

	});
}
function getInstrumentalDataResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].instrumentalData == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "InstrumentalData";
			}else{
				formObject = response.surveys[0].instrumentalData;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in Instrumental data");
			alert(error);
	    }

	});
}
function getDiagnosisVerificationDataResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].diagnosisVerificationData == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "DiagnosisVerificationData";
			}else{
				formObject = response.surveys[0].diagnosisVerificationData;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("Error in Diagnosis Verification data");
			alert(error);
	    }

	});
}

function getMainTreatmentDataResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].mainTreatmentData == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "MainTreatmentData";
			}else{
				formObject = response.surveys[0].mainTreatmentData;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("ERROR: Error in Main Treatmentdata");
			alert(error);
	    }

	});
}
function getRehabilitationDataResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].rehabilitationData == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "RehabilitationData";
			}else{
				formObject = response.surveys[0].rehabilitationData;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("ERROR: Error in Rehabilitation Data");
			alert(error);
	    }

	});
}
function getPreventiveMeasuresDataResouces(url){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			if(response.surveys[0].preventiveMeasuresData == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "PreventiveMeasuresData";
			}else{
				formObject = response.surveys[0].preventiveMeasuresData;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert("ERROR: Error in Preventive Measures Data");
			alert(error);
	    }

	});
}

function getResouces(){
	$.ajax({
		type : "get",
		url : getMedCardUrl,
		dataType : "json",
		success : function(response) {
			formObject = response;
			console.log("->GET RESOURCES");
			console.log(response);
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
				initOrderValues(formObject);
			}
		},
		error: function (request, status, error) {
			alert(error);
	    }

	});
}
function initPanelNames(){
	var optionElement;
	var panelNameSelects = $("select[name=panel-names]");
	$(panelNameSelects).html("");
	$(formObject.panels).each(function(index, panel){
		optionElement = $("<option>"+panel.name+"</option>");
		optionElement.val(index);
		$(panelNameSelects).append(optionElement); 
	});
//	panelIndex = panelNameSelects.val();
//	var subPanelSelect = $("select[name=sub-panel-names]");
//	$(formObject.panels[parseInt(panelIndex)].elements).each(function(index, element){
//		if(element.objectType == "Panel"){
//			optionElement = $("<option>"+element.name+"</option>");
//			optionElement.val(index);
//			$(subPanelSelect).append(optionElement); 
//		}else{
//			if(elementPanelSelect != null){
//				optionElement = $("<option>"+element.name+"</option>");
//				optionElement.val(index);
//				$(elementPanelSelect).append(optionElement); 
//			}
//		}
//		
//	});
	
//	$(subPanelSelect).append("<option value='-1'>- EMPTY -</option>");
	
};
function renderPreviewMedForm(){
	var constructor = new Builder("constructor");
	constructor.constructorInit('#container', formObject);
	cleanConstructorFields($("#panelName"), $("#sub-panel-name"), $("#text-box-name"), $("#group-button-name"), $("#dropdownName"));
	initCoefficientEvents();
 }


function saveMedicalCard() {
	console.log("INFO: Saving medical card")
	conole.log(formObject);
	$.ajax({
		  type:"POST", 
	      url:"/patients/medical_card",
	      data: JSON.stringify(formObject),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(response){
	    	  console.log("Success Save");
	      },
		
		error: function (request, status, error) {
			alert(error);
	    }});
	
}
function initOrderValues(form){
	$(formObject.panels).each(function(index, panel){
		if(panel.order > order.panel){
			order.panel = panel.order;
		}
	});
	
}

///START EVENTS

function spClick(){
	var parent = $("#remove-element");
	
	var panelSelect = $(parent).find("select[name=panel-names]");
	var subPanelSelect = $(parent).find("select[name=sub-panel-names]");
	
	var panelIndex = parseInt($(panelSelect).val());
	var subPanelIndex = parseInt($(subPanelSelect).val());
	
	var formElementSelect = $(parent).find("select[name=element-title]");

		$(formElementSelect).html("<option value='-1'>- EMPTY -</option>");
		if(subPanelIndex == -1){
			$(formObject.panels[panelIndex].elements).each(function(index, element){
				optionElement = $("<option>"+element.name+"</option>");
				optionElement.val(index);
				$(formElementSelect).append(optionElement); 
		});
		}else{
			$(formObject.panels[panelIndex].elements[subPanelIndex].elements).each(function(index, element){
				optionElement = $("<option>"+element.name+"</option>");
				optionElement.val(index);
				$(formElementSelect).append(optionElement); 
			});
		}
		
	
};

function initEvents(){
	$("select[name=panel-names]").unbind("click");
	$("select[name=panel-names]").click(function(){
		panelIndex = this.value;
		var parent = $(this).parent("div");
		var subPanelSelect = $(parent).find("select[name=sub-panel-names]");
		var elementPanelSelect = $(parent).find("select[name=element-title]");
		$(subPanelSelect).html("");
		if(elementPanelSelect != null){
			elementPanelSelect.html("");
		}
		$(formObject.panels[parseInt(panelIndex)].elements).each(function(index, element){
			if(element.objectType == "Panel"){
				optionElement = $("<option>"+element.name+"</option>");
				optionElement.val(index);
				$(subPanelSelect).append(optionElement); 
			}else{
				if(elementPanelSelect != null){
					optionElement = $("<option>"+element.name+"</option>");
					optionElement.val(index);
					$(elementPanelSelect).append(optionElement); 
				}
			}
			
		});
		
		$(subPanelSelect).append("<option value='-1'>- EMPTY -</option>");
		
	});
	$("#save-panel-button").unbind("click");
	$("#save-panel-button").click(function(){
		panelName =  $("#panelName").val();
		createPanel(panelName);
	});
	
	$("#save-sub-panel-button").unbind("click");
	$("#save-sub-panel-button").click(function(){
		var subPanelName = $("#sub-panel-name").val();
		var root = $("#create-sub-panel");
		var panelSelect = $(root).find("select");
		var panelIndex = panelSelect.val();
		createSubPanel(panelIndex,subPanelName);
	});
	
	$("#save-textBox-button").unbind("click");
	$("#save-textBox-button").click(function(){
		var textboxName = $("#text-box-name").val();
		var root = $("#create-textbox");
		var selects = $(root).find("select");
		var panelIndex = $(selects[0]).val();
		var subPanelIndex =$(selects[1]).val();
		createTextBox(panelIndex,subPanelIndex,textboxName);
	});
	
	$("#save-groupButton-button").unbind("click");
	$("#save-groupButton-button").click(function(){
		var textboxName = $("#group-button-name").val();
		var root = $("#create-groupButton");
		var selects = $(root).find("select");
		var panelIndex = $(selects[0]).val();
		var subPanelIndex =$(selects[1]).val();
		createButtonGroup(panelIndex,subPanelIndex,textboxName);
	});
	
	
	$("#add-value-button").unbind("click");
	$("#add-value-button").click(function(){
		var value = $("#dropdownElementValue").val();
		$("#dropdownElementValue").val("");
		var valueSelect = $("#dropdownValues");
		$(valueSelect).append("<option>"+value+"</option>");
	});
	
	$("#save-dropdown-button").unbind("click");
	$("#save-dropdown-button").click(function(){
		var divsWithValue =	$(".select2-search-choice").children("div");
		var dropDownName = $("#dropdownName").val();
		var root = $("#create-dropdown");
		var selects = $(root).find("select");
		var panelIndex = $(selects[0]).val();
		var subPanelIndex =$(selects[1]).val();
		var values = {};
		
		$(divsWithValue).each(function(index, element){
			values[$(element).text()] = index;
		});
		
		createDropDown(panelIndex,subPanelIndex,dropDownName,values);
	});
	$("#remove-element-button").unbind("click");
	$("#remove-element-button").click(function(){
		var parent = $("#remove-element");
		
		var panelSelect = $(parent).find("select[name=panel-names]");
		var subPanelSelect = $(parent).find("select[name=sub-panel-names]");
		var elementSelect = $(parent).find("select[name=sp-remove]");
		
		var panelIndex = parseInt($(panelSelect).val());
		var subPanelIndex = parseInt($(subPanelSelect).val());
		var elementIndex = parseInt($(elementSelect).val());
		
		if(subPanelIndex == -1){
			formObject.panels.splice(panelIndex,1);
		}else{
			if(elementIndex == -1){
				formObject.panels[panelIndex].elements.splice(subPanelIndex,1);
			}else{
				formObject.panels[panelIndex].elements[subPanelIndex].elements.splice(elementIndex,1);
			}
		}
		renderPreviewMedForm();
		initPanelNames();
		
	});
	
	$("button[name=save-button]").unbind("click");
	$("button[name=save-button]").click(function(){
		console.log(formObject);
		
		
		if(formObject.objectType ==  "MedicalCardForm"){
			saveMedicalCard();
		}
		if(formObject.objectType == "AnamnesticDataForm"){
			saveAnamnesticData();
		}
		if(formObject.objectType == "ComplaintsForm"){
			syndrom.surveys[0].complaintsForm = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "ClinicalManifestationsForm"){
			syndrom.surveys[0].clinicalManifestationsForm = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "LaboratoryDataForm"){
			syndrom.surveys[0].laboratoryDataForm = formObject;
			saveSyndromData(syndrom);
		}
//		MORPHOLOGICAL_DATA : "MorphologicalData",
//		INSTRUMENTAL_DATA : "InstrumentalData",
//		DIAGNOSIS_VERIFICATION_DATA: "DiagnosisVerificationData",
//		MAIN_TREATMENT_DATA : "MainTreatmentData",
//		REHABILITATION_DATA : "RehabilitationData",
//		PREVENTIVE_MEASURES_DATA : "PreventiveMeasuresData"
		if(formObject.objectType == "MorphologicalData"){
			syndrom.surveys[0].morphologicalData = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "InstrumentalData"){
			syndrom.surveys[0].instrumentalData = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "DiagnosisVerificationData"){
			syndrom.surveys[0].diagnosisVerificationData = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "MainTreatmentData"){
			syndrom.surveys[0].mainTreatmentData = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "RehabilitationData"){
			syndrom.surveys[0].rehabilitationData = formObject;
			saveSyndromData(syndrom);
		}
		if(formObject.objectType == "PreventiveMeasuresData"){
			syndrom.surveys[0].preventiveMeasuresData = formObject;
			saveSyndromData(syndrom);
		}
		
	});
	
}
function saveMedicalCard() {
	
	console.log("INFO: Saving medical card ")
	console.log(formObject);
	
	$.ajax({
		  type:"POST", 
	      url:"/patients/medical_card",
	      data: JSON.stringify(formObject),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(response){
	    	  console.log("Success Save");
	      },
		
		error: function (request, status, error) {
			alert(error);
	    }});
	
}
function saveAnamnesticData() {
	syndrom.anamnesticData = formObject; 
	$.ajax({
		  type:"POST", 
	      url:"/syndromes/template/{name}".replace("{name}", syndrom.name),
	      data: JSON.stringify(syndrom),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(response){
	    	  console.log("Success Save");
	      },
		
		error: function (request, status, error) {
			alert(error);
	    }});
	
}
function saveSyndromData(syndrom){
	$.ajax({
		  type:"POST", 
	      url:"/syndromes/template/{name}".replace("{name}", syndrom.name),
	      data: JSON.stringify(syndrom),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(response){
	    	  console.log("Success Save");
	      },
		
		error: function (request, status, error) {
			alert(error);
	    }});
}

///END EVENTS

//////////MED.CARD ELEMENTS//////

function createPanel(title){
 	panel = {};
 	
 	panel["name"] = title;
 	panel["checked"] = false;
 	panel["objectType"] = "Panel";
 	order.panel = order.panel + 1;
 	panel["order"] = order.panel;
 	panel["elements"] = [];
 	
 	if(formObject == null){
 		formObject = {};
 		formObject["panels"] = [];
 		formObject["name"] = "";
 		formObject["objectType"] = "AnamnesticDataForm";
 	}
 	formObject.panels.push(panel); 
 	initPanelNames();
 	renderPreviewMedForm();
}
function createSubPanel(index,title){
	subPanel = {};
	subPanel["name"] =title;
	subPanel["checked"] = false;
	subPanel["objectType"] = "Panel";
	subPanel["elements"] = [];
	formObject.panels[index].elements.push(subPanel); 
	renderPreviewMedForm();
}
function createTextBox(panelIndex,subPanelIndex,title){
 	textBox = {};
 	textBox["name"] = title;
 	textBox["checked"] = false;
 	textBox["objectType"] = "TextBox";
 	textBox["text"] = "";
 	textBox["multiplier"] = 0;
 	if(parseInt(subPanelIndex) == -1 || subPanelIndex == null){
 		formObject.panels[panelIndex].elements.push(textBox);
 	}else{
 		formObject.panels[panelIndex].elements[subPanelIndex].elements.push(textBox);
 		
 	}
 	renderPreviewMedForm();
}
function createDropDown(panelIndex,subPanelIndex,title,values){
	var dropDown = {};
 	dropDown["name"]=title;
 	dropDown["checked"] = false;
 	dropDown["objectType"] ="DropDown";
 	dropDown["values"] = values;
 	if(parseInt(subPanelIndex) == -1 || subPanelIndex == null){
 		formObject.panels[panelIndex].elements.push(dropDown);
 	}else{
 		formObject.panels[panelIndex].elements[subPanelIndex].elements.push(dropDown);
 	}
 	renderPreviewMedForm();
 	
}
function createButtonGroup(panelIndex,subPanelIndex,title,values){
	var groupButton = {};
	groupButton["name"] = title;
	groupButton["checked"] = false;
	groupButton["objectType"] ="ButtonGroup";
	groupButton["value"] = 0;
	groupButton["multiplier"] = 0;
 	if(parseInt(subPanelIndex) == -1 || subPanelIndex == null){
 		formObject.panels[panelIndex].elements.push(groupButton);
 	}else{
 		formObject.panels[panelIndex].elements[subPanelIndex].elements.push(groupButton);
 	}
 	renderPreviewMedForm();
 	
}

function cleanConstructorFields() {
	$(arguments).each(function() {
		this.val("");
	});
	cleanDropDowns();
}

function cleanDropDowns() {
	$(".select2-chosen").each(function() {
		$(this).prop("textContent", "");
	});
	$(".select2-search-choice").each(function() {
		$(this).remove();
	});
}
