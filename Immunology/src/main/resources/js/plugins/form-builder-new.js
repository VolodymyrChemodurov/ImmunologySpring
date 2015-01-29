/**
 * NEW FORM this ANY TYPE;
 */
function Builder(object_Name) {
	//Constants
	this.MED_CARD_CONSTANTS = {
		date: "Дата створення",	
		addition: "Додаткова інформація"
	},
	this.TYPE = {
		MED_CARD : "MedicalCardForm",
		ANAMNESTIC_DATA : "AnamnesticDataForm",
		COMPLAINTS_DATA : "COMPLAINTS_FORM",
		CLINICAL_MANIFESTATIONS_DATA : "CLINICAL_MANIFESTATIONS_FORM",
		LABORATORY_DATA	: "LABORATORY_DATA_FORM",
		MORPHOLOGICAL_DATA : "MORPHOLOGICAL_DATA",
		INSTRUMENTAL_DATA : "INSTRUMENTAL_DATA",
		DIAGNOSIS_VERIFICATION_DATA: "DIAGNOSIS_VERIFICATION_DATA",
		MAIN_TREATMENT_DATA : "MAIN_TREATMENT_DATA",
		REHABILITATION_DATA : "REHABILITATION_DATA",
		PREVENTIVE_MEASURES_DATA : "PREVENTIVE_MEASURES_DATA"
	},
	this.URL = {
		MED_CARD_URL : "/patients/${id}/medical_card/",
		SYNDROME_DATA_URL : "/syndromes/patient/${id}/${name}",
		SYNDRONE_TEMPLATR_URL :  "/syndromes/template/${name}"
	},
	this.SAVE_BUTTON_URL = {
		MED_CARD_URL : "/patients/medical_card/update",
		ANAMNESTIC_DATA_URL : "/syndromes/patient/${id}"
	};
	
	//Values used for saving elements and other functions
	this.objectName = object_Name;
	this.container = [];
	this.syndromObject = {};
	this.surveyObject = {};
	this.formObject = {};
	this.patientId;
	this.formName;
	
	this.setSurvey = function(survey){
		this.surveyObject = survey;
	};
	
	this.setSyndrom = function(syndrom){
		this.syndromObject = syndrom;
	};
	this.getSyndrom = function(){
		return this.syndromObject;
	};
	
	this.setForm = function(form){
		this.formObject = form;
	};
	
	this.setContainer = function(object){
		this.container = object;
	};
	
	this.constructorInit = function(blockID,formObject){
		this.setContainer($(blockID));
		this.container.html("");
		if(formObject.objectType == this.TYPE.MED_CARD){
			this.setForm(formObject);
			this.renderMedCardFields();
			this.renderFormBody(false);
		} else {
			/*this.formName = formName;
			this.patientId = patientId;*/
			this.setContainer($(blockID));
			this.container.html("");
			this.container.attr("object",this.objectName);
			this.setForm(formObject);
			this.renderFormBody(false);
			this.event.init();
			this.prepareForm();
		}
		
		
	};
	
	this.init = function(blockID,type ,patientId, formName) {
		
		this.formName = formName;
		this.patientId = patientId;
		this.setContainer($(blockID));
		this.container.html("");
		this.container.attr("object",this.objectName);
		
		if(type == this.TYPE.MED_CARD){
			this.gettingFormObject("get",this.URL.MED_CARD_URL, patientId, formName);
			console.log(this.formObject);
			this.renderMedCard();
		} else if(type == this.TYPE.ANAMNESTIC_DATA){
			this.gettingFormObject("get",this.URL.SYNDROME_DATA_URL, patientId, formName);
			console.log(this.formObject);
			this.renderFormBody(true);
		} else {
			this.gettingFormObject("get",this.URL.SYNDROME_DATA_URL, patientId, formName);
			console.log(this.formObject);
			this.renderFormBody(true);
		}
		this.event.init();
		this.prepareForm();
	};
	
	this.initNewSurveyForm = function(blockID, type , patientId, formName, survey) {
		this.formName = formName;
		this.patientId = patientId;
		this.setContainer($(blockID));
		this.container.html("");
		this.container.attr("object",this.objectName);
		this.setSurvey(survey);
		this.setForm(findSyrveyFormByType(survey, type));
		this.renderFormBody(false);
		this.event.init();
		this.prepareForm();
	};
	
	this.initNewSurveyFormWithNewUrl = function(blockID, type, survey) {
		this.setContainer($(blockID));
		this.container.html("");
		this.container.attr("object", this.objectName);
		this.setForm(findSyrveyFormByType(survey, type));
		this.setSurvey(survey);
		this.renderFormBody(false);
		this.event.init();
		this.prepareForm();
	};
	
	function findSyrveyFormByType(survey, type) {
		for(var i = 0; i < survey.forms.length; i++) {
			if(survey.forms[i].formType === type) {
				return survey.forms[i]; 
			}
		}
		return null;
	}
	
	this.renderMedCard = function() {
		this.renderMedCardFields();
		this.renderFormBody(true);
	};
	
	this.renderMedCardFields = function(){
		panel = $('<fieldset class= "panel-fieldset"></fieldset>');
		panelDateRow = $('<div class="com-sm-7"></div>');
		panelAdditionRow = $('<div class="com-sm-7"></div>');
		
		panelDateRowTitle = this.utils.generatePanelTitle(this.MED_CARD_CONSTANTS.date);
		panelDateRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><input type="text" disabled value="'
							+ this.formObject.creationDate + '" class="form-control med_panel_left_input"/>');
		
		panelAdditionRowTitle = this.utils.generatePanelTitle(this.MED_CARD_CONSTANTS.addition);
		panelAdditionRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><textarea type="text" class="form-control med_panel_left_input">'
				+ this.formObject.additionalInfo + '</textArea>');
		panelDateRow.append(panelDateRowTitle).append(panelDateRowField);
		panelAdditionRow.append(panelAdditionRowTitle).append(panelAdditionRowField);
		panel.append(panelDateRow).append(panelAdditionRow);
		
		this.container.append(panel);
	};
	this.renderFormBody = function(renderSaveButton){
		if(this.formObject != null){
			this.formObject.panels.sort(comparator);
			for ( var i = 0; i < this.formObject.panels.length; i++ ) {
				this.formObject.panels[i].elements.sort(comparator);
				this.container.append(this.utils.generatePanel(this.formObject.panels[i],i));
			}
		}
		if(renderSaveButton){
			this.container.append(this.utils.generateSaveButton());
		}
		
	};

	function comparator(a,b) {
		  if (a.place < b.place)
		     return -1;
		  if (a.place > b.place)
		    return 1;
		  return 0;
	};
	
	this.gettingFormObject = function(type, url, patientID, formName){
		var form;
		var syndrom;
		console.log(url.replace("${id}", patientID).replace("${name}", formName));
		$.ajax({
			type : type,
			url :  url.replace("${id}", patientID).replace("${name}", formName),
			dataType : "json",
			async:   false,
			success : function(response) {
				if(response.objectType == "MedicalCardForm"){
					form = response;
				}else{
					syndrom = response;
					this.surveyObject = response;
					form = response.anamnesticData;
				}
				
			},
			error: function (request, status, error) {
				alert(error);
		    }
		});
		this.setForm(form);
		this.setSyndrom(syndrom);
	},	
	
// -------------	this UTILES-------------
	this.utils = {
		generatePanelTitle : function(title, panelIndex){
			var name = panelIndex;
			return $('<div class = "col-sm-3 panel-title-block" name= "' + name + '" ><div class = "com-sm-7 med_panel_title_div disable" >' + title + '</div></div>');
		},
		generatePanel : function(panelObj, panelIndex){
			
			panel = $('<fieldset class= "panel-fieldset"/>').attr("index", panelIndex);
			panelTitle = this.generatePanelTitle(panelObj.name, panelIndex);
			panelRowSet = $('<div class = "col-sm-9"/>');
			
			for ( var i = 0; i < panelObj.elements.length; i++ ) {
				panelRowSet.append(this.generateElement(panelObj.elements[i],i));
			}
			panel.append(panelTitle).append(panelRowSet);
			console.log(panel);
			return panel;
		},
		generateElement: function(elementObj, elementIndex){
			switch (elementObj.objectType) {
			case 'TextBox':
				return this.generateTextBox(elementObj, elementIndex);
				break;
			case 'DropDown' :
				return this.generateDropDown(elementObj, elementIndex);
				break;
			case 'Panel' :
				elementObj.elements.sort(comparator);
				return this.generateSubPanel(elementObj, elementIndex);
				break;
			case 'ButtonGroup' :
				return this.generateButtonGroup(elementObj, elementIndex);
				break;
		}
		},
		generateTextBox: function(textBoxObj, elementIndex){
			row = $('<div class = "col-sm-12 element_row" style="margin-top: 2px;"/>').attr("index", elementIndex);
			rowTitle = $('<div class="col-sm-5"/>');
			rowTitle.append(this.generateCheckBox(textBoxObj.name, textBoxObj.checked, elementIndex));
			rowRightSide = $('<div class="col-sm-7" />');
			input = this.generateTextField(textBoxObj.text, textBoxObj.checked, elementIndex);
			rowRightSide.append(input);
			row.append(rowTitle);
			row.append(rowRightSide);
			return row;
		},
		generateCheckBox: function(title, checked, elementIndex){
			var div = $('<div class="checkbox" style="margin: 2px 0px 2px 0px;"/>');
			var label = $('<label/>');
			var input = $('<input type="checkbox"/>');
			var i = $('<i class="fa fa-square-o"/>');
			if(checked){
				input.attr("checked", "checked");
			}
			
			label.append(input);
			label.append(title);
			label.append(i);
			div.append(label);
			return div;
		},
		generateDropDown: function(dropDown, elementIndex){
			row = $('<div class = "col-sm-12 element_row" style="margin-top: 2px;"/>').attr("index", elementIndex);
			
			rowTitle = $('<div class="col-sm-12 "/>');
			rowTitle.append(this.generateCheckBox(dropDown.name, dropDown.checked, elementIndex));
			
			selectRow = $('<div class = "col-sm-12" style = "padding: 0px"/>');
			selectDiv = $('<div class = "col-sm-5"/>');
			select = $('<select class = "form-control dropdown">');
			$(Object.keys(dropDown.values)).each(function(key, optionElement) {
				if(key == dropDown.selected){
					option = $('<option value="' + key + '" selected = "selected">' + optionElement + '</option>');
				}else {
					option = $('<option value="' + key + '">' + optionElement + '</option>');
				}
				select.append(option);
				
			});
			
			if(!dropDown.checked){
				$(select).attr("disabled","true");
			}
			
			rowRightSide = $('<div class="col-sm-7"></div>');
			rowRightSide.append(this.generateTextField(dropDown.text, dropDown.checked, elementIndex));
			selectRow.append(selectDiv.append(select));
			selectRow.append(rowRightSide);
			
			row.append(rowTitle);
			row.append(selectRow);
			return row;
		},
		generateSubPanel: function(subPanel, subElementIndex){
			subPanelBlock = $('<div class = "col-sm-12 sub-panel" style="padding-right: 0px; "/>');
			subPanelBlock.attr("index",subElementIndex);
			subPanelBody = $('<div class = "col-sm-12" style="padding-right: 0px; padding-left: 0px;"/>');
			div = $('<div class="col-sm-12" style="padding-right: 0px;" />');
			
			for ( var i = 0; i < subPanel.elements.length; i++ ) {
				subPanelBody.append(this.generateElement(subPanel.elements[i],i));
			}
			subPanelBlock.append(div.append(this.generateCheckBox(subPanel.name, subPanel.checked, subElementIndex)));
			subPanelBlock.append(subPanelBody);
			
			return subPanelBlock;
		},
		generateButtonGroup: function(buttonGroup, elementIndex){
			row = $('<div class = "col-sm-12 element_row" style="margin-top: 2px;"/>').attr("index", elementIndex);
			rowTitle = $('<div class="col-sm-5"/>');
			rowTitle.append(this.generateCheckBox(buttonGroup.name, buttonGroup.checked, elementIndex));
			rowRightSide = $('<div class="col-sm-7" />');
			buttonsDiv = $('<div class="btn-group col-sm-12" data-toggle="buttons" style="padding: 0px"/>');
			for (var int = 0; int < 4; int++) {
				if(buttonGroup.value == int){
					buttonsDiv.append('<label class="btn btn-primary active group-button-item" style=" width: 25%; margin-bottom: 0px;"><input type="radio" name="options">'+ int +' </label>');
				}else{
					buttonsDiv.append('<label class="btn btn-primary group-button-item" style=" width: 25%; margin-bottom: 0px;"><input type="radio" name="options">'+ int +' </label>');
				}
				
				
			}
			rowRightSide.append(buttonsDiv);
			row.append(rowTitle);
			row.append(rowRightSide);
			return row;
		},
		
		generateTextField: function(value, checked, elementIndex ){
			input = $('<input type="text" class="form-control textbox"/>');
			input.val(value);
			if(!checked){
				input.attr("disabled","disabled");
			}
			return input;
		},
		
		generateSaveButton: function(){
			var fieldset = $('<fieldset class= "panel-fieldset" style="text-align: center; "/>');
			var button = $('<button type="button" class="btn btn-primary">Save</button>');
			$(button).click(function(){
				var container = $(this).parents(".form-container");
				var obj =window[container.attr("object")];
				obj.sendForm();
				
			});
			fieldset.append(button);
			return fieldset;
		}
		
	},
	
// ---------	EVENTS ----------
	this.event = {
		init : function(){
			$("input[type=checkbox]").click(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				var panelTitleBlock = $(fieldset).find(".med_panel_title_div");
				var container = $(fieldset).parents(".form-container");
				var input = $(row).find("input[type=text]");
				var select = $(row).find("select");
				var checkBoxes = $(fieldset).find("input[type=checkbox]");
				var indicator = false;
				$(checkBoxes).each(function(index,element){
					if(element.checked){
						$(panelTitleBlock).css("background-color","rgb(255, 135, 50)");	
						indicator = true;
					}
				});
				if(indicator){
					$(panelTitleBlock).css("background-color","rgb(255, 135, 50)");	
				}else{
					$(panelTitleBlock).css("background-color","rgb(33, 145, 192)");	
				}
				
				if(this.checked){
					$(input).removeAttr("disabled");
					$(select).removeAttr("disabled");
				}else{
					$(input).attr("disabled","disabled");
					$(select).attr("disabled","true");
				}
				// Setting values
				var panel_index = $(fieldset).attr("index");
				var element_index = $(row).attr("index");
				var sub_panel_index = $(subPanelBlock).attr("index");
				console.log("Set new value to:" + container.attr("object"));
				var obj =window[container.attr("object")];
				obj.setCheckBoxValue(panel_index, element_index, sub_panel_index, this.checked);
			});
			$("select.dropdown").change(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				var container = $(this).parents(".form-container");
				var obj =window[container.attr("object")];
				obj.setDropDownValue($(fieldset).attr("index"), $(row).attr("index"),subPanelBlock.attr("index"), $(this).find("option:selected").text());
				
				
			});
			$("input.textbox").change(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				var container = $(this).parents(".form-container");
				var obj =window[container.attr("object")];
				obj.setTextBoxValue($(fieldset).attr("index"), $(row).attr("index"),subPanelBlock.attr("index"), $(this).val());
			});
			
			$(".group-button-item").click(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				var container = $(this).parents(".form-container");
				var obj =window[container.attr("object")];
				console.log($(this));
				obj.setGroupButtonValue($(fieldset).attr("index"), $(row).attr("index"),subPanelBlock.attr("index"), $(this).text());
			});
			
		},
		},
	this.prepareForm = function(){
		$("input[type=checkbox]").each(function(){
			var fieldset = $(this).parents(".panel-fieldset");
			var row = $(this).parents(".element_row");
			var panelTitleBlock = $(fieldset).find(".med_panel_title_div");
			var input = $(row).find("input[type=text]");
			var checkBoxes = $(fieldset).find("input[type=checkbox]");
			var indicator = false;
			$(checkBoxes).each(function(index,element){
				if(element.checked){
					$(panelTitleBlock).css("background-color","rgb(255, 135, 50)");	
					indicator = true;
				}
			});
			if(indicator){
				$(panelTitleBlock).css("background-color","rgb(255, 135, 50)");	
			}else{
				$(panelTitleBlock).css("background-color","rgb(33, 145, 192)");	
			}
			
			if(this.checked){
				$(input).removeAttr("disabled");
			//	$(select).removeAttr("disabled");
			}else{
				$(input).attr("disabled","disabled");
			//	$(select).attr("disabled","true");
			}	
			
		});
		
		
	},
	
	this.setCheckBoxValue = function(panel_index, element_index, sub_panel_index, checked){
		if(sub_panel_index == undefined){
			this.formObject.panels[panel_index].elements[element_index].checked = checked;
		}else{
			this.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].checked = checked;
		}
		
	},
	this.setDropDownValue = function(panel_index, element_index,sub_panel_index, value){
		if(sub_panel_index == undefined){
			this.formObject.panels[panel_index].elements[element_index].selected = value;
		}else{
			this.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].selected = value;
		}
		
		
	},
	this.setTextBoxValue =  function(panel_index, element_index,sub_panel_index, text){
		if(sub_panel_index == undefined){
			this.formObject.panels[panel_index].elements[element_index].text = text;
		}else{
			this.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].text = text;
		}
		
	};
	this.setGroupButtonValue =  function(panel_index, element_index,sub_panel_index, value){
		if(sub_panel_index == undefined){
			this.formObject.panels[panel_index].elements[element_index].value = parseFloat(value);
		}else{
			this.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].value =  parseFloat(value);
		}
		
	};
	
	this.sendForm =  function(){
		var saveURL;
		var saveObject;
		if(this.formObject.objectType == this.TYPE.MED_CARD){
			saveURL = this.SAVE_BUTTON_URL.MED_CARD_URL;
			saveObject = this.formObject;
		}
		if(this.formObject.objectType == this.TYPE.ANAMNESTIC_DATA){
			saveURL = this.SAVE_BUTTON_URL.ANAMNESTIC_DATA_URL;
			saveObject = this.syndromObject;
			saveObject.anamnesticData = this.formObject;
			
		}
		
		console.log("Try to save this object:");
		console.log(saveObject);
		$.ajax({
		  type:"POST", 
	      url:saveURL.replace("${id}", this.patientId),
	      data: JSON.stringify(saveObject),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(resposeJsonObject){
	    	  console.log("Successfully saved.");
	    	  console.log(resposeJsonObject);
	      },
		
	      error: function (request, status, error) {
			alert(error);
	      }
	    });
	};
};
