/**
 * NEW FORM BUILDER ANY TYPE;
 */

var Builder = {
	//Constants
	MED_CARD_CONSTANTS : {
		date: "Дата створення",	
		addition: "Додаткова інформація"
	},
	TYPE : {
		MED_CARD : "MedicalCardForm",
		ANAMNESTIC_DATA : "AnamnesticDataForm"
	},
	URL : {
		MED_CARD_URL : "/Immunology/patients/${id}/medical_card/",
		ANAMNESTIC_DATA_URL : "/Immunology/syndromes/patient/${id}/${name}"
	},
	//Values
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
							+ Builder.formObject.creationDate + '" class="form-control med_panel_left_input"/>');
		
		panelAdditionRowTitle = Builder.utils.generatePanelTitle(Builder.MED_CARD_CONSTANTS.addition);
		panelAdditionRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><textarea type="text" value="'
				+ this.formObject.addionalInfo + '" class="form-control med_panel_left_input"/>');
		
		panelDateRow.append(panelDateRowTitle).append(panelDateRowField);
		panelAdditionRow.append(panelAdditionRowTitle).append(panelAdditionRowField);
		panel.append(panelDateRow).append(panelAdditionRow);
		
		Builder.container.append(panel);
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
	
	
	
	
	
	// BUILDER UTILES
	utils : {
		generatePanelTitle : function(title, panelIndex){
			var name = panelIndex;
			return $('<div class = "col-sm-3 panel-title-block" name= "' + name + '" ><div class = "com-sm-7 med_panel_title_div disable" >' + title + '</div></div>');
		},
		generatePanel : function(panelObj, panelIndex){
			
			panel = $('<fieldset class= "panel-fieldset"/>');
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
				return Builder.utils.generateSubPanel(elementObj);
				break;
		}
		},
		generateTextBox: function(textBoxObj, elementIndex){
			row = $('<div class = "col-sm-12 element_row"/>');
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
			row = $('<div class = "col-sm-12 element_row"/>');
			rowTitle = $('<div class="col-sm-12 "/>');
			rowTitle.append(Builder.utils.generateCheckBox(dropDown.name, dropDown.checked, elementIndex));
			
			selectRow = $('<div class = "col-sm-12" style = "padding: 0px"/>');
			selectDiv = $('<div class = "col-sm-5"/>');
			select = $('<select class = "form-control">');
			$(Object.keys(dropDown.values)).each(function(key, optionElement) {
				if(key == dropDown.choosed){
					option = $('<option value="' + key + '" selected = "selected">' + optionElement + '</option>');
				}else {
					option = $('<option value="' + key + '">' + optionElement + '</option>');
				}
				select.append(option);
				
			});
			
			select.change(function(){
			});
			
			rowRightSide = $('<div class="col-sm-7"></div>');
			rowRightSide.append(Builder.utils.generateTextField(dropDown.text, dropDown.checked, elementIndex));
			selectRow.append(selectDiv.append(select));
			selectRow.append(rowRightSide);
			
			row.append(rowTitle);
			row.append(selectRow);
			return row;
		},
		generateSubPanel: function(subPanel, subElementEndex){
			subPanelBlock = $('<div class = "col-sm-12" style="padding-right: 0px;"/>');
			subPanelBody = $('<div class = "col-sm-12" style="padding-right: 0px; padding-left: 0px;"/>');
			div = $('<div class="col-sm-12" style="padding-right: 0px;" />');
			
			$(subPanel.elements).each(function(elementIndex, elementObj) {
				subPanelBody.append(Builder.utils.generateElement(elementObj,elementIndex));
			});
			
			subPanelBlock.append(div.append(Builder.utils.generateCheckBox(subPanel.name, subPanel.checked, subElementEndex)));
			subPanelBlock.append(subPanelBody);
			
			return subPanelBlock;
		},
		
		generateTextField: function(value, checked, elementIndex ){
			input = $('<input type="text" class="form-control"/>');
			input.attr("name","t"+elementIndex);
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
				alert("You are on the rigth way");
			});
			fieldset.append(button);
			return fieldset;
		}
		
	},
	event : {
		init : function(){
			$("input[type=checkbox]").click(function(){
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
				}else{
					$(input).attr("disabled","disabled");
				}
				
				
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
			}else{
				$(input).attr("disabled","disabled");
			}	
		});
		
		
	}
		
	

};

