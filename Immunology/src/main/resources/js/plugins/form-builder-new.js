/**
 * NEW FORM BUILDER ANY TYPE;
 */

var Builder = {
	//Constants
	MED_CARD_CONSTANTS : {
		date: "Creation Date",	
		addition: "Addition info"
	},
	TYPE : {
		MED_CARD : "MedicalCardForm",
		ANAMNESTIC_DATA : "AnamnesticDataForm"
	},
	URL : {
		MED_CARD_URL : "/patients/${id}/medical_card/",
		ANAMNESTIC_DATA_URL : "/syndromes/patient/${id}/${name}"
	},
	//Values used for saving elements and other functions
	container : [],
	formObject : {},
		
		
	init: function(blockID,type ,patientId, formName) {
		this.container = $(blockID);
		this.container.html("");
		if(type == Builder.TYPE.MED_CARD){
			Builder.gettingFormObject("get",Builder.URL.MED_CARD_URL, patientId, formName);
			console.log(Builder.formObject);
			Builder.renderMedCard();
		}
		if(type == Builder.TYPE.ANAMNESTIC_DATA){
			Builder.gettingFormObject("get",Builder.URL.ANAMNESTIC_DATA_URL, patientId, formName);
			console.log(Builder.formObject);
			Builder.renderFormBody();
		}
		this.event.init();
		this.prepareForm();
	},
	
	renderMedCard : function() {
		Builder.renderMedCardFields();
		Builder.renderFormBody();
		
	}, 
	renderMedCardFields : function(){
		panel = $('<fieldset class= "panel-fieldset"></fieldset>');
		panelDateRow = $('<div class="com-sm-7"></div>');
		panelAdditionRow = $('<div class="com-sm-7"></div>');
		
		panelDateRowTitle = this.utils.generatePanelTitle(Builder.MED_CARD_CONSTANTS.date);
		panelDateRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><input type="text" disabled value="'
							+ this.formObject.creationDate + '" class="form-control med_panel_left_input"/>');
		
		panelAdditionRowTitle = this.utils.generatePanelTitle(Builder.MED_CARD_CONSTANTS.addition);
		panelAdditionRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><textarea type="text" class="form-control med_panel_left_input">'
				+ this.formObject.additionalInfo + '</textArea>');
		panelDateRow.append(panelDateRowTitle).append(panelDateRowField);
		panelAdditionRow.append(panelAdditionRowTitle).append(panelAdditionRowField);
		panel.append(panelDateRow).append(panelAdditionRow);
		
		this.container.append(panel);
	},
	renderFormBody : function(){
		$(Builder.formObject.panels).each(function(panelIndex, panelObj) {
			Builder.container.append(Builder.utils.generatePanel(panelObj,panelIndex));
		});
		Builder.container.append(Builder.utils.generateSaveButton());
	},

	
	
	
	gettingFormObject : function(type, url, patientID, formName){
		$.ajax({
			type : type,
			url :  url.replace("${id}", patientID).replace("${name}", formName),
			dataType : "json",
			async:   false,
			success : function(response) {
				if(response.objectType == Builder.TYPE.MED_CARD){
					Builder.formObject = response;
				}else{
					Builder.formObject = response.anamnesticData;
				}
				
			},
			error: function (request, status, error) {
				alert(error);
		    }
		});
	},	
	
	
	
	
	
// -------------	BUILDER UTILES-------------
	utils : {
		generatePanelTitle : function(title, panelIndex){
			var name = panelIndex;
			return $('<div class = "col-sm-3 panel-title-block" name= "' + name + '" ><div class = "com-sm-7 med_panel_title_div disable" >' + title + '</div></div>');
		},
		generatePanel : function(panelObj, panelIndex){
			
			panel = $('<fieldset class= "panel-fieldset"/>').attr("index", panelIndex);
			panelTitle = Builder.utils.generatePanelTitle(panelObj.name, panelIndex);
			panelRowSet = $('<div class = "col-sm-9"/>');
				$(panelObj.elements).each(function(elementIndex, elementObj) {
					panelRowSet.append(Builder.utils.generateElement(elementObj,elementIndex));
				});
			
			panel.append(panelTitle).append(panelRowSet);
			console.log(panel);
			return panel;
		},
		generateElement: function(elementObj, elementIndex){
			switch (elementObj.objectType) {
			case 'TextBox':
				return Builder.utils.generateTextBox(elementObj, elementIndex);
				break;
			case 'DropDown' :
				return Builder.utils.generateDropDown(elementObj, elementIndex);
				break;
			case 'Panel' :
				return Builder.utils.generateSubPanel(elementObj, elementIndex);
				break;
		}
		},
		generateTextBox: function(textBoxObj, elementIndex){
			row = $('<div class = "col-sm-12 element_row"/>').attr("index", elementIndex);
			rowTitle = $('<div class="col-sm-5"/>');
			rowTitle.append(Builder.utils.generateCheckBox(textBoxObj.name, textBoxObj.checked, elementIndex));
			rowRightSide = $('<div class="col-sm-7" />');
			input = Builder.utils.generateTextField(textBoxObj.text, textBoxObj.checked, elementIndex);
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
			row = $('<div class = "col-sm-12 element_row"/>').attr("index", elementIndex);
			
			rowTitle = $('<div class="col-sm-12 "/>');
			rowTitle.append(Builder.utils.generateCheckBox(dropDown.name, dropDown.checked, elementIndex));
			
			selectRow = $('<div class = "col-sm-12" style = "padding: 0px"/>');
			selectDiv = $('<div class = "col-sm-5"/>');
			select = $('<select class = "form-control dropdown">');
			$(Object.keys(dropDown.values)).each(function(key, optionElement) {
				if(key == dropDown.choosed){
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
			rowRightSide.append(Builder.utils.generateTextField(dropDown.text, dropDown.checked, elementIndex));
			selectRow.append(selectDiv.append(select));
			selectRow.append(rowRightSide);
			
			row.append(rowTitle);
			row.append(selectRow);
			return row;
		},
		generateSubPanel: function(subPanel, subElementIndex){
			subPanelBlock = $('<div class = "col-sm-12 sub-panel" style="padding-right: 0px;"/>');
			subPanelBlock.attr("index",subElementIndex);
			subPanelBody = $('<div class = "col-sm-12" style="padding-right: 0px; padding-left: 0px;"/>');
			div = $('<div class="col-sm-12" style="padding-right: 0px;" />');
			
			$(subPanel.elements).each(function(elementIndex, elementObj) {
				subPanelBody.append(Builder.utils.generateElement(elementObj,elementIndex));
			});
			
			subPanelBlock.append(div.append(Builder.utils.generateCheckBox(subPanel.name, subPanel.checked, subElementIndex)));
			subPanelBlock.append(subPanelBody);
			
			return subPanelBlock;
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
				Builder.handler.sendForm();
			});
			fieldset.append(button);
			return fieldset;
		}
		
	},
	
	
	
	
// ---------	EVENTS ----------
	event : {
		init : function(){
			$("input[type=checkbox]").click(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				var panelTitleBlock = $(fieldset).find(".med_panel_title_div");
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
				
				Builder.handler.setCheckBoxValue(panel_index, element_index, sub_panel_index, this.checked);
			});
			$("select.dropdown").change(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				Builder.handler.setDropDownValue($(fieldset).attr("index"), $(row).attr("index"),subPanelBlock.attr("index"), $(this).val());
				
				
			});
			$("input.textbox").change(function(){
				var fieldset = $(this).parents(".panel-fieldset");
				var row = $(this).parents(".element_row");
				var subPanelBlock = $(this).parents(".sub-panel");
				Builder.handler.setTextBoxValue($(fieldset).attr("index"), $(row).attr("index"),subPanelBlock.attr("index"), $(this).val());
			});
			
		},
		
	},
	prepareForm : function(){
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
				$(select).removeAttr("disabled");
			}else{
				$(input).attr("disabled","disabled");
				$(select).attr("disabled","true");
			}	
			
		});
		
		
	},
	handler: {
		setCheckBoxValue: function(panel_index, element_index, sub_panel_index, checked){
			if(sub_panel_index == undefined){
				Builder.formObject.panels[panel_index].elements[element_index].checked = checked;
			}else{
				Builder.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].checked = checked;
			}
			
		},
		setDropDownValue: function(panel_index, element_index,sub_panel_index, value){
			if(sub_panel_index == undefined){
				Builder.formObject.panels[panel_index].elements[element_index].choosed = value;
			}else{
				Builder.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].choosed = value;
			}
			
			
		},
		setTextBoxValue: function(panel_index, element_index,sub_panel_index, text){
			if(sub_panel_index == undefined){
				Builder.formObject.panels[panel_index].elements[element_index].text = text;
			}else{
				Builder.formObject.panels[panel_index].elements[sub_panel_index].elements[element_index].text = text;
			}
			
		},
	sendForm:  function(){
		console.log(formObj);
		$.ajax({
		  type:"POST", 
	      url:"/patients/medical_card/update",
	      data: JSON.stringify(Builder.formObject),
	      contentType: "application/json; charset=utf-8",
	      dataType: "json",
	      success: function(resposeJsonObject){
	    	  console.log(resposeJsonObject);
	      },
		
		error: function (request, status, error) {
			alert(error);
	    }});
	}
	
	}
		
	

};

