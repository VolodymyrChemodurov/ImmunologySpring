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
		MED_CARD : "medicalCard",
		ANAMNESTIC_DATA : "AnamnesticDataForm"
	},
	URL : {
		MED_CARD_URL : "/Immunology/patients/${id}/medical_card/"
	},
	//Values
	container : [],
	formObject : {},
		
		
	init: function(blockID,patientId,type) {
		Builder.container = $(blockID);
		if(type =db= Builder.TYPE.MED_CARD){
			Builder.gettingFormObject("get",Builder.URL.MED_CARD_URL, patientId);
			console.log(Builder.formObject);
			Builder.renderMedCard();
		}
	},
	
	renderMedCard : function() {
		Builder.renderMedCardFields();
		Builder.renderFormBody();
		
	}, 
	renderMedCardFields : function(){
		panel = $('<fieldset class= "panel-fieldset"></fieldset>');
		panelDateRow = $('<div class="com-sm-7"></div>');
		panelAdditionRow = $('<div class="com-sm-7"></div>');
		
		panelDateRowTitle = Builder.utils.generatePanelTitle(Builder.MED_CARD_CONSTANTS.date);
		panelDateRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><input type="text" disabled value="'
							+ Builder.formObject.creationDate + '" class="form-control med_panel_left_input"/>');
		
		panelAdditionRowTitle = Builder.utils.generatePanelTitle(Builder.MED_CARD_CONSTANTS.addition);
		panelAdditionRowField = $('<div class = "col-sm-9"><div class="col-sm-5"><textarea type="text" value="'
				+ Builder.formObject.addionalInfo + '" class="form-control med_panel_left_input"/>');
		
		panelDateRow.append(panelDateRowTitle).append(panelDateRowField);
		panelAdditionRow.append(panelAdditionRowTitle).append(panelAdditionRowField);
		panel.append(panelDateRow).append(panelAdditionRow);
		
		Builder.container.append(panel);
	},
	renderFormBody : function(){
		$(Builder.formObject.panels).each(function(panelIndex, panelObj) {
			Builder.container.append(Builder.utils.generatePanel(panelObj));
		});
	},

	
	
	
	gettingFormObject : function(type, url, patientID){
		$.ajax({
			type : type,
			url :  url.replace("${id}", patientID),
			dataType : "json",
			async:   false,
			success : function(response) {
				Builder.formObject = response;
			},
			error: function (request, status, error) {
				alert(error);
		    }
		});
	},	
	
	
	
	
	
	// BUILDER UTILES
	utils : {
		generatePanelTitle : function(title){
			return $('<div class = "col-sm-3 panel-title-block" ><div class = "com-sm-7 med_panel_title_div disable" >' + title + '</div></div>');
		},
		generatePanel : function(panelObj){
			
			panel = $('<fieldset class= "panel-fieldset"/>');
			panelTitle = Builder.utils.generatePanelTitle(panelObj.name);
			panelRowSet = $('<div class = "col-sm-9"/>');
				$(panelObj.elements).each(function(elementIndex, elementObj) {
					panelRowSet.append(Builder.utils.generateElement(elementObj));
				});
			
			panel.append(panelTitle).append(panelRowSet);
			console.log(panel);
			return panel;
		},
		generateElement: function(elementObj){
			switch (elementObj.objectType) {
			case 'TextBox':
				return Builder.utils.generateTextBox(elementObj);
				break;
			case 'DropDown' :
				return Builder.utils.generateDropDown(elementObj);
				break;
			case 'Panel' :
				return Builder.utils.generateSubPanel(elementObj);
				break;
		}
		},
		generateTextBox: function(textBoxObj){
			row = $('<div class = "col-sm-12"/>');
			rowTitle = $('<div class="col-sm-5"/>');
			rowTitle.append(Builder.utils.generateCheckBox(textBoxObj.name, textBoxObj.checked));
			rowRightSide = $('<div class="col-sm-7"><input type="text" style="margin: 2px 0px 2px 0px; " class="form-control"/></div>');
			
			row.append(rowTitle);
			row.append(rowRightSide);
			return row;
		},
		generateCheckBox: function(title,checked){
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
		generateDropDown: function(dropDown){
			row = $('<div class = "col-sm-12"/>');
			rowTitle = $('<div class="col-sm-12"/>');
			rowTitle.append(Builder.utils.generateCheckBox(dropDown.name, dropDown.checked));
			
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
			rowRightSide = $('<div class="col-sm-7"><input type="text" class="form-control"/></div>');
			selectRow.append(selectDiv.append(select));
			selectRow.append(rowRightSide);
			
			row.append(rowTitle);
			row.append(selectRow);
			return row;
		},
		generateSubPanel: function(subPanel){
			subPanelBlock = $('<div class = "col-sm-12" style="padding-right: 0px;"/>');
			subPanelBody = $('<div class = "col-sm-12" style="padding-right: 0px; padding-left: 0px;"/>');
			div = $('<div class="col-sm-12" style="padding-right: 0px;" />');
			
			$(subPanel.elements).each(function(elementIndex, elementObj) {
				subPanelBody.append(Builder.utils.generateElement(elementObj));
			});
			
			subPanelBlock.append(div.append(Builder.utils.generateCheckBox(subPanel.name, subPanel.checked)));
			subPanelBlock.append(subPanelBody);
			
			return subPanelBlock;
		},
		
		generateTextField: function(value, checked){
			
		}
		
	}
	

};




