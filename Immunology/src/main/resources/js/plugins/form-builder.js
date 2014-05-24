var container;
var formData = "";

function renderForm(form) {
		container = form;
		$.ajax({
			type : "get",
			url : "/Immunology/cabinet/patient/form/first",
			dataType : "json",
			success : function(response) {
				console.log(response);
				$(response.panels).each(function(){
					formData += '<form class="form-horizontal">';
					renderPanel(this);
				});
				formData += "</form>";
				$(form).html(formData);
			},
			error : function() {
				console.log('ERROR');
			}

		});
};

function renderPanel(panel) {
	formData += '<fieldset>';
	formData += '<legend>' + panel.title + '</legend>';
	$(panel.elements).each(function(){
		renderElement(this);
	});
	formData += '</fieldset>';
};

function renderElement(element) {
	formData += '<div class="form-group"><label class="col-sm-3 control-label">'+ element.name +'</label>';
	switch(element.objectType) {
		case 'TextBox': renderTextBox(element); 
						break;
		case 'CheckBox': renderCheckBox(element); 
						break;
	}
};

function renderTextBox(element) {
	formData += '<div class="col-sm-5"><input type="text" value="' + element.text + '" class=\"form-control\"></div></div>';
};

function renderCheckBox(element) {
	formData += '<div class="col-sm-5"><input type="checkbox" class=\"form-control\"';
	formData += element.checked? 'checked="checked"' : '';
	formData +=	'></div></div>';
};