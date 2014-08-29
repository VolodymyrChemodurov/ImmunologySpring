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
		MED_CARD : "medicalCard"
	},
	URL : {
		MED_CARD_URL : "/Immunology/cabinet/patient/form/medical_card/"
	},
	//Values
	container : [],
	formObject : {},
		
		
	init: function(blockID,patientId,type) {
		Builder.container = $(blockID);
		if(type == Builder.TYPE.MED_CARD){
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
			url :  url+ patientID,
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
			if(elementObj.objectType == 'TextBox'){
				return Builder.utils.generateTextBox(elementObj);
			}
		},
		generateTextBox: function(textBoxObj){
			row = $('<div class = "col-sm-12"/>');
			rowTitle = $('<div class="col-sm-5"/>');
			rowTitle.append(Builder.utils.generateCheckBox(textBoxObj.name));
			rowRightSide = $('<div class="col-sm-7"><input type="text" style="margin-top: 10px;" class="form-control"/></div>');
			
			row.append(rowTitle);
			row.append(rowRightSide);
			return row;
		},
		generateCheckBox: function(title){
			var div = $('<div class="checkbox"/>');
			var label = $('<label/>');
			var input = $('<input type="checkbox" checked/>');
			var i = $('<i class="fa fa-square-o"/>');
			label.append(input);
			label.append(title);
			label.append(i);
			div.append(label);
			return div;
		}
		
	}
	

};




