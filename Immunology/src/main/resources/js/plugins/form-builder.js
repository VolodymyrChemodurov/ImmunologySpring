var container;
var formStructure = "";
var dropDownIdArr = [];

function renderForm(form) {
	container = form;
	$.ajax({
		type : "get",
		url : "/Immunology/cabinet/patient/form/first",
		dataType : "json",
		success : function(response) {
			console.log(response);
			renderMedicalForm(response);
			$(form).html(formStructure);
			renderDropDownStyle();
		},
		error: function (request, status, error) {
	        alert(request.responseText);
	    }

	});
};

	// Create structure of medical form
function renderMedicalForm(form){
	formStructure += '<form class="form-horizontal">';
		renderMedcardFields(form);
		$(form.panels).each(function() {
		renderPanel(this);
		});
	formStructure += '</form>';
}

	// Render Medical form fields( Date & Addition. Inf.)
function renderMedcardFields(form){
	
	formStructure += '<fieldset class= "panel-fieldset">';
	formStructure += 	'<div class = "col-sm-3 panel-title-block" >';
	formStructure +=			'<div class = "com-sm-7 med_panel_title_div disable" >' + "Дата Створення" + '</div>';
	formStructure +=		'</div>';
	formStructure +=		'<div class = "col-sm-9">';
	formStructure += 		'<div class="col-sm-5">';
	formStructure += 			'<input type="text" value="'
								+ form.creationDate + '" class="form-control med_panel_left_input">';
	formStructure +=		'</div>';
	formStructure += 		'<div class="col-sm-7"></div></div>';
	
	formStructure += 	'<div class = "col-sm-3 panel-title-block">';
	formStructure +=			'<div class = "com-sm-7 med_panel_title_div disable" >' + "Додаткова інформація" + '</div>';
	formStructure +=		'</div>';
	formStructure +=		'<div class = "col-sm-9">';
	formStructure += 			'<div class="col-sm-5">';
	formStructure += 				'<textArea class="form-control med_panel_left_input">'
									+ form.additionInfo + '</textArea>';
	formStructure += 			'</div>';
	formStructure += 	'</div>';
	formStructure += '</fieldset>';
}
	//render panel(title & made place for fields)
function renderPanel(panel) {
	formStructure += '<fieldset class= "panel-fieldset">';
	formStructure += 	'<div class = "col-sm-3 groupe-padding" >';
	formStructure +=		'<div class = "com-sm-7 med_panel_title_div disable" ><h4>' + panel.name + '</h4></div>';
	formStructure +=	'</div>';
	formStructure +=	'<div class = "col-sm-9 group-panel">';
			$(panel.elements).each(function() {
				renderElement(this);
			});
	formStructure += 	'</div>';
	formStructure += '</fieldset>';
};

function renderElement(element) {
	renderCheckBox(element);
	
	switch (element.objectType) {
	case 'TextBox':
		formStructure += '</div>';
		renderTextBox(element);
		break;
	case 'Panel':
		renderSubPanel(element);
		break;
	case 'DropDown':
		renderDropDown(element,false);
		break;
	}
};

	//finished field and made marging for subelements;
function renderSubElement(element) {
	
	renderSubPanelCheckBox(element);
	formStructure += '</div>';
	formStructure +='<div class="col-sm-7"></div>'; 
		switch (element.objectType) {
		case 'TextBox':
			renderTextBox(element);
			break;
		case 'DropDown':
			renderDropDown(element, true);
			break;
		}
};
function renderTextBox(element) {
	formStructure += '<div class="col-sm-7">';
	formStructure +=	'<input type="text" class="form-control" value="'
						+ element.text + '" >';
	formStructure +='</div>';
};

function renderCheckBox(element) {
	formStructure += '<div class="col-sm-5">';
	formStructure +=	'<div class="checkbox"><label><input type="checkbox" ';
	formStructure += 			element.checked ? 'checked' : '';
	formStructure +=		' >';
	formStructure +=		 element.name;
	formStructure += 		'<i class="fa fa-square-o"></i></label>';
	formStructure += 	'</div>';
};
function renderSubPanelCheckBox(element) {
	formStructure += '<div class="col-sm-5" style="padding-left: 38px;">';
	formStructure +=	'<div class="checkbox"><label><input type="checkbox" ';
	formStructure += 	element.checked ? 'checked' : '';
	console.log(element.checked);
	formStructure +=	' >';
	formStructure += 	element.name;
	formStructure += 	'<i class="fa fa-square-o"></i></label>';
	formStructure += '</div>';
};


//SubElement is boolean variable whitch inform is the dropdown under the sumpanel;
function renderDropDown(element,subElement) {
		//Cut "</div>";
	if(subElement){
		formStructure = formStructure.substring(0, formStructure.length - 34);
		console.log("if true");
	}else {
		console.log("if false");
		formStructure = formStructure.substring(0, formStructure.length - 6);
	}
	
		//Collect all id's for render DropDown styles;
	dropDownIdArr.push(element.name.split(' ').join('_'));
	formStructure += '<div class="col-sm-12">';
	formStructure +=	'<select class="populate placeholder dropdown_select"  id="'
						+ element.name.split(' ').join('_') + '" >';
					$(Object.keys(element.values)).each(function(key, element) {
	formStructure += 		'<option value="' + element + '">' + element + '</option>';
						});
	formStructure += 	'</select>';
	formStructure +='</div>';
	formStructure +='</div></div>';
	
	if(subElement){
		console.log("2 if true");
		formStructure = formStructure.substring(0, formStructure.length - 6);
	}
		//render dropdown right textbox field;
	formStructure += '<div class="col-sm-7" style="margin-bottom: 5px;">';
	formStructure +=	'<input type="text" value="'
						+ element.text + '" class="form-control dropdown_text" >';
	formStructure +='</div>';
}
function renderSubPanel(subpanel){
	formStructure += '</div>';
	formStructure += '<div class="col-sm-9"></div>';
		$(subpanel.elements).each(function() {
			renderSubElement(this);
		});

}
function renderDropDownStyle(element) {

	var i;
	for (i = 0; i < dropDownIdArr.length; ++i) {
		console.log(dropDownIdArr[i]);
		$("#"+dropDownIdArr[i]).select2();
	}

}