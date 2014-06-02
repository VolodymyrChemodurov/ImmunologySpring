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
			$(response.panels).each(function() {
				formData += '<form class="form-horizontal">';
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

function renderPanel(panel) {
	formData += '<fieldset class= "panel-fieldset" style= "background-color: #E8ECF0;">';
	//formData += '<legend>' + panel.title + '</legend>';
	formData += '<div class = "col-sm-3 groupe-padding" >';
	formData +=	'<div class = "com-sm-9" style= "padding: 5px; background-color: #5a8db6" ><h3 style=" text-align: right;">' + panel.title + '</h3></div>';
	formData +='</div><div class = "col-sm-9 group-panel">';
	$(panel.elements).each(function() {
		renderElement(this);
	});
	formData += '</div></fieldset>';
};

function renderElement(element) {
//	formData += '<div class="form-group"><label class="col-sm-3 control-label">'
//			+ element.name + '</label>';
	formData += '<div class="col-sm-5"><div class="checkbox"><label><input type="checkbox" >';
	//formData += element.checked ? 'checked="checked"' : '';
	formData += element.name;
	formData += '<i class="fa fa-square-o"></i></label></div>';
	
	
	switch (element.objectType) {
	case 'TextBox':
		renderTextBox(element);
		break;
	case 'CheckBox':
		//renderCheckBox(element);
		break;
	case 'DropDown':
		renderDropDown(element);
		break;
	}
};

function renderTextBox(element) {
	formData += '</div>';
	formData += '<div class="col-sm-7"><input type="text" value="'
			+ element.text + '" class=\"form-control\"></div>';
};

function renderCheckBox() {
	formData += '<div class="col-sm-5"><div class="checkbox"><label><input type="checkbox" ';
	//formData += element.checked ? 'checked="checked"' : '';
	formData += '><i class="fa fa-square-o"></i></label></div>';
	formData += '</div></div>';
};
function renderDropDown(element) {
	console.log('enter to render');
	dropDownIdArr.push(element.name.split(' ').join('_'));
	formData += '<div class="col-sm-12"><select class="populate placeholder" id="'
			+ element.name.split(' ').join('_') + '" >';
	$(Object.keys(element.values)).each(function(key, element) {
		// $(this).
		formData += '<option value="' + element + '">' + element + '</option>';

	});
	formData += '</select></div></div>';
	
	
	formData += '<div class="col-sm-7"><input type="text" style=" margin-top: 23px;" value="'
			+ element.text + '" class=\"form-control\"></div>';
	formData += '</div>';
	formData += '</div>';
	console.log(dropDownIdArr);
}
function renderDropDownStyle() {

	var i;
	for (i = 0; i < dropDownIdArr.length; ++i) {
		console.log(dropDownIdArr[i]);
		$("#"+dropDownIdArr[i]).select2();
	}

}