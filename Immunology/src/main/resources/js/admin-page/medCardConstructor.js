var getMedCardUrl = "/Immunology/admin/medical_card";
var medCardObject = null;


function init(){
	getResouces();
	console.log("->MED.CARD AFTER getResources");
	console.log(medCardObject);
	
}
function initAnamnestic(){
	medCardObject = [];
	medCardObject["objectType"] = "AnamnesticDataForm";
	medCardObject["panels"] = [];
	console.log(medCardObject);
}

function getResouces(){
	$.ajax({
		type : "get",
		url : getMedCardUrl,
		dataType : "json",
		success : function(response) {
			medCardObject = response;
			console.log("->GET RESOURCES");
			console.log(response);
			if(medCardObject != null){
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
	$(medCardObject.panels).each(function(index, panel){
		optionElement = $("<option>"+panel.name+"</option>");
		optionElement.val(index);
		$(panelNameSelects).append(optionElement); 
	});
	
};
function renderPreviewMedForm(){
 	renderMedicalForm(medCardObject);
 	$('#container').html(formStructure);
 }

function saveMedicalCard() {
	$.ajax({
		  type:"POST", 
	      url:"/Immunology/patients/medical_card",
	      data: JSON.stringify(medCardObject),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(response){
	    	  console.log("Success Save");
	      },
		
		error: function (request, status, error) {
			alert(error);
	    }});
	
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
			$(medCardObject.panels[panelIndex].elements).each(function(index, element){
				optionElement = $("<option>"+element.name+"</option>");
				optionElement.val(index);
				$(formElementSelect).append(optionElement); 
		});
		}else{
			$(medCardObject.panels[panelIndex].elements[subPanelIndex].elements).each(function(index, element){
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
		$(subPanelSelect).html("");
		$(medCardObject.panels[parseInt(panelIndex)].elements).each(function(index, element){
			if(element.objectType == "Panel"){
				optionElement = $("<option>"+element.name+"</option>");
				optionElement.val(index);
				$(subPanelSelect).append(optionElement); 
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
			medCardObject.panels.splice(panelIndex,1);
		}else{
			if(elementIndex == -1){
				medCardObject.panels[panelIndex].elements.splice(subPanelIndex,1);
			}else{
				medCardObject.panels[panelIndex].elements[subPanelIndex].elements.splice(elementIndex,1);
			}
		}
		renderPreviewMedForm();
	});
	
	$("button[name=save-button]").unbind("click");
	$("button[name=save-button]").click(function(){
		console.log(medCardObject);
		saveMedicalCard();
	});
	
	
	
}
///END EVENTS

//////////MED.CARD ELEMENTS//////

function createPanel(title){
 	panel = {};
 	//panel["@id"] = 99;
 	//panel["place"] = 99;
 	//panel["panel"] = null;
 	//panel["order"] = 99;
 	
 	
 	panel["name"] = title;
 	panel["checked"] = false;
 	panel["objectType"] = "Panel";
 	panel["elements"] = [];
 	
 	medCardObject.panels.push(panel); 
 	initPanelNames();
 	renderPreviewMedForm();
}
function createSubPanel(index,title){
	subPanel = {};
	subPanel["name"] =title;
	subPanel["checked"] = false;
	subPanel["objectType"] = "Panel";
	subPanel["elements"] = [];
	medCardObject.panels[index].elements.push(subPanel); 
	renderPreviewMedForm();
}
function createTextBox(panelIndex,subPanelIndex,title){
 	textBox = {};
 	textBox["name"] = title;
 	textBox["checked"] = false;
 	textBox["objectType"] = "TextBox";
 	textBox["text"] = "";
 	if(parseInt(subPanelIndex) == -1){
 		medCardObject.panels[panelIndex].elements.push(textBox);
 	}else{
 		medCardObject.panels[panelIndex].elements[subPanelIndex].elements.push(textBox);
 	}
 	renderPreviewMedForm();
}
function createDropDown(panelIndex,subPanelIndex,title,values){
	var dropDown = {};
 	dropDown["name"]=title;
 	dropDown["checked"] = false;
 	dropDown["objectType"] ="DropDown";
 	dropDown["values"] = values;
 	if(parseInt(subPanelIndex) == -1){
 		medCardObject.panels[panelIndex].elements.push(dropDown);
 	}else{
 		medCardObject.panels[panelIndex].elements[subPanelIndex].elements.push(dropDown);
 	}
 	renderPreviewMedForm();
 	
}







