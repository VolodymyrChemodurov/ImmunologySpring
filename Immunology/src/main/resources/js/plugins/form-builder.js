var container;
var formData = "";
var dropDownIdArr = [];

function renderForm(form) {
	container = form;
	$.ajax({
		type : "get",
		url : "/Immunology/cabinet/patient/form/first",
		dataType : "json",
		success : function(response) {
			console.log(response);
			formData += '<form class="form-horizontal">';
			renderMedcardFields(response);
			$(response.panels).each(function() {
				
				renderPanel(this);
			});
			formData += "</form>";
			$(form).html(formData);
			renderDropDownStyle();
		},
		error: function (request, status, error) {
	        alert(request.responseText);
	    }

	});
};

function renderMedcardFields(form){
	
	formData += '<fieldset class= "panel-fieldset">';
	formData += '<div class = "col-sm-3 groupe-padding" style="text-align: right;">';
	formData +=	'<div class = "com-sm-7 med_panel_div_left disable" >' + "Дата Створення" + '</div>';
	formData +='</div><div class = "col-sm-9" style="height: 35px; margin-top: 2px;">';
	
	formData += '<div class="col-sm-5">';
	formData += '<input type="text" value="'
		+ form.creationDate + '" class="form-control" style="margin-top: 2px;"></div>';
	formData += '<div class="col-sm-7"></div></div>';
	
	formData += '<div class = "col-sm-3 groupe-padding"  style="text-align: right;">';
	formData +=	'<div class = "com-sm-7 med_panel_div_left disable" >' + "Додаткова інформація" + '</div>';
	formData +='</div><div class = "col-sm-9">';
	
	formData += '<div class="col-sm-5">';
	formData += '<input type="text" value="'
		+ form.additionInfo + '" class="form-control"></div>';
	formData += '</div>';
	
	formData +=	'</fieldset>';
}

function renderPanel(panel) {
	formData += '<fieldset class= "panel-fieldset" style= "background-color: #E8ECF0;">';
	//formData += '<legend>' + panel.title + '</legend>';
	formData += '<div class = "col-sm-3 groupe-padding" >';
	formData +=	'<div class = "com-sm-7 med_panel_div_left disable" ><h4 class="med_panel_div_h">' + panel.name + '</h4></div>';
	formData +='</div><div class = "col-sm-9 group-panel">';
	$(panel.elements).each(function() {
		renderElement(this);
	});
	formData += '</div></fieldset>';
};

function renderElement(element) {
	
	
	renderCheckBox(element);
	
	switch (element.objectType) {
	case 'TextBox':
		renderTextBox(element);
		
		break;
	case 'Panel':
		renderSubPanel(element);
		break;
	case 'DropDown':
		renderDropDown(element);
		break;
	}
};
function renderSubElement(element) {
	
	renderSubPanelCheckBox(element);
	formData += '</div>';
	formData +='<div class="col-sm-7"></div>'; 
	switch (element.objectType) {
	case 'TextBox':
		renderTextBoxForPanel(element);
		break;
	case 'Panel':
		renderSubPanel(element);
		break;
	case 'DropDown':
		renderDropDown(element);
		break;
	}
};
function renderTextBoxForPanel(element) {
	formData += '<div class="col-sm-7"><input type="text" value="'
			+ element.text + '" class=\"form-control\"></div>';
};

function renderTextBox(element) {
	formData += '</div>';
	formData += '<div class="col-sm-7"><input type="text" value="'
			+ element.text + '" class=\"form-control\"></div>';
};

function renderCheckBox(element) {
	formData += '<div class="col-sm-5"><div class="checkbox"><label><input type="checkbox" >';
	//formData += element.checked ? 'checked="checked"' : '';
	formData += element.name;
	formData += '<i class="fa fa-square-o"></i></label></div>';
};
function renderCheckBoxForDropDown(element) {
	formData += '<div class="col-sm-5"><div class="checkbox"><label><input type="checkbox" >';
	//formData += element.checked ? 'checked="checked"' : '';
	formData += element.name;
	formData += '<i class="fa fa-square-o"></i></label>';
};
function renderSubPanelCheckBox(element) {
	formData += '<div class="col-sm-5" style="padding-left: 38px;"><div class="checkbox"><label><input type="checkbox" >';
	//formData += element.checked ? 'checked="checked"' : '';
	formData += element.name;
	formData += '<i class="fa fa-square-o"></i></label></div>';
};
function renderDropDown(element) {
	//renderCheckBoxForDropDown(element);
	formData = formData.substring(0, formData.length - 6);
	dropDownIdArr.push(element.name.split(' ').join('_'));
	formData += '<div class="col-sm-12"><select class="populate placeholder dropdown_select"  id="'
			+ element.name.split(' ').join('_') + '" >';
	$(Object.keys(element.values)).each(function(key, element) {
		formData += '<option value="' + element + '">' + element + '</option>';

	});
	formData += '</select></div></div></div>';
	
	
	formData += '<div class="col-sm-7" style="margin-bottom: 5px;"><input type="text" value="'
			+ element.text + '" class="form-control dropdown_text" ></div>';


	console.log(dropDownIdArr);
}
function renderSubPanel(subpanel){
	formData += '</div>';
	formData += '<div class="col-sm-9"></div>';
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