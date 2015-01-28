var getMedCardUrl = "/admin/medical_card";
var getSyndromUrl = "/syndromes/template/{name}";
var syndrom = null;
var formObject = null;

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
	} else {
		console.log("Getting" + formType + "Data Form");
		getSyndrome(getSyndromUrl.replace('{name}',syndromName), formType);
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
			}
		},
		error: function (request, status, error) {
			alert("Error in anamnestic data");
			alert(error);
	    }

	});
}


function getSyndrome(url, formType){
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		async:   false,
		success : function(response) {
			syndrom = response;
			console.log(syndrom);
			var form = findSyrveyFormByType(syndrom, formType);
			if(form == null){
				formObject = {};
				formObject["panels"] = [];
				formObject["objectType"] = "SurveyForm";
				formObject["formType"] = formType;
			}else{
				formObject = form;
			}
			if(formObject != null){
				initPanelNames();
				renderPreviewMedForm();
			}
		},
		error: function (request, status, error) {
			alert("Error in anamnestic data");
			alert(error);
	    }

	});
}

function findSyrveyFormByType(syndrome, type) {
	if(syndrome.surveys[0] != null) {
		var survey = syndrome.surveys[0];
		for(var i = 0; i < survey.forms.length; i++) {
			if(survey.forms[i].formType === type) {
				return survey.forms[i]; 
			}
		}
	}
	return null;
}

function addSurveyForm(syndrome, form) {
	setUpPositions(form);
	if(syndrome.surveys[0] != null) {
		var survey = syndrome.surveys[0];
		for(var i = 0; i < survey.forms.length; i++) {
			if(survey.forms[i].formType === form.formType) {
				survey.forms[i] = form;
				return
			}
		}
		survey.forms.push(form);
	}
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

///START EVENTS

function spClick(){
	var parent = $("#remove-element");
	
	var panelSelect = $(parent).find("select[name=panel-names]");
	var subPanelSelect = $(parent).find("select[name=sub-panel-names]");
	
	var panelIndex = parseInt($(panelSelect).val());
	var subPanelIndex = parseInt($(subPanelSelect).val());
	
	var formElementSelect = $(parent).find("select[name=element-title]");

		$(formElementSelect).html("<option value='-1'>- ПУСТО -</option>");
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
		
		$(subPanelSelect).append("<option value='-1'>- ПУСТО -</option>");
		
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
		var elementSelect = $(parent).find("select[name=element-title]");
		
		var panelIndex = parseInt($(panelSelect).val());
		var subPanelIndex = parseInt($(subPanelSelect).val());
		var elementIndex = parseInt($(elementSelect).val());
		
		if(panelIndex != -1) {
			if(subPanelIndex != -1 && elementIndex != -1) {
				formObject.panels[panelIndex].elements[subPanelIndex].elements.splice(elementIndex,1);
			} else if(subPanelIndex != -1 && elementIndex == -1) {
				formObject.panels[panelIndex].elements.splice(subPanelIndex, 1);
			} else {
				formObject.panels[panelIndex].elements.splice(elementIndex, 1);
			}
		} else {
			formObject.panels.splice(panelIndex,1);
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
		if(formObject.objectType == "SurveyForm"){
			addSurveyForm(syndrom, formObject);
			saveSyndromData(syndrom);
		}
		
	});
	
}

function setUpPositions(form) {
	for(var i = 0; i < form.panels.length; i++) {
		var panel = form.panels[i]; 
		panel.place = i;
		setUpPanelContentPositions(panel);
	}
}

function setUpPanelContentPositions(panel) {
	for(var j = 0; j < panel.elements.length; j++) {
		var element = panel.elements[j]; 
		element.place = j;
		if(element.hasOwnProperty('elements')) {
			setUpPanelContentPositions(element);
		}
	}
}

function saveMedicalCard() {
	setUpPositions(formObject);
	console.log("INFO: Saving medical card ");
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
	setUpPositions(formObject);
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

//////////ELEMENTS//////

function createPanel(title){
 	panel = {};
 	
 	panel["name"] = title;
 	panel["checked"] = false;
 	panel["objectType"] = "Panel";
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

// HELPER METHODS //
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
