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
		error : function() {
			console.log('ERROR');
		}

	});
};

function renderPanel(panel) {
	formData += '<fieldset>';
	formData += '<legend>' + panel.title + '</legend>';
	$(panel.elements).each(function() {
		renderElement(this);
	});
	formData += '</fieldset>';
};

function renderElement(element) {
	formData += '<div class="form-group"><label class="col-sm-3 control-label">'
			+ element.name + '</label>';
	switch (element.objectType) {
	case 'TextBox':
		renderTextBox(element);
		break;
	case 'CheckBox':
		renderCheckBox(element);
		break;
	case 'DropDown':
		renderDropDown(element);
		break;
	}
};

function renderTextBox(element) {
	formData += '<div class="col-sm-5"><input type="text" value="'
			+ element.text + '" class=\"form-control\"></div></div>';
};

function renderCheckBox(element) {
	formData += '<div class="col-sm-5"><div class="checkbox"><label><input type="checkbox" ';
	formData += element.checked ? 'checked="checked"' : '';
	formData += '><i class="fa fa-square-o"></i></label></div>';
	formData += '</div></div>';
};
function renderDropDown(element) {
	console.log('enter to render');
	dropDownIdArr.push(element.name.split(' ').join('_'));
	formData += '<div class="col-sm-5"><select class="populate placeholder" id="'
			+ element.name.split(' ').join('_') + '" >';
	$(Object.keys(element.values)).each(function(key, element) {
		// $(this).
		formData += '<option value="' + element + '">' + element + '</option>';

	});
	formData += '</select></div></div>';
	console.log(dropDownIdArr);
}
function renderDropDownStyle() {

	var i;
	for (i = 0; i < dropDownIdArr.length; ++i) {
		console.log(dropDownIdArr[i]);
		$("#"+dropDownIdArr[i]).select2();
	}

}