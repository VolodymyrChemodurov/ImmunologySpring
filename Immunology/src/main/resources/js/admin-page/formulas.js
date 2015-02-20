var formulaRegExp = new RegExp('^([0-9+-/*^xX()])+$');

function getFormulaForSyndrom(formulaType) {
	var syndromName = $("#syndrrom-names").val();
	var url = "/syndromes/template/{name}/{formulaType}".replace("{formulaType}", formulaType).replace("{name}", syndromName);
	$.ajax({
		type : "GET",
		url : url,
		async : false,
		success : function(response) {
			console.log(response);
			if (formulaType == "severityLevel") {
				$("#severity-formula").val(response);
			}
			if (formulaType == "insufficiencyLevel") {
				$("#insufficiency-formula").val(response);
			}

		},

		error : function(request, status, error) {
			console.log(formulaType + "= null;");
		}
	});
}
function saveFormulaForSyndrom(formulaType, formula) {
	var syndromName = $("#syndrrom-names").val();
	var url = "/syndromes/template/{name}/{formulaType}".replace("{formulaType}", formulaType).replace("{name}", syndromName);
	$.ajax({
		type : "POST",
		url : url,
		data : {
			"formula" : formula
		},
		dataType : "json",
		async : false,
		success : function(response) {
			console.log(response);
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}
function sendFormulaValues() {
	saveFormulaIfValid($("#severity-formula"), "severityLevel");
	saveFormulaIfValid($("#insufficiency-formula"), "insufficiencyLevel");
}

function saveFormulaIfValid(input, type) {
	var value = input.val();
	result = formulaRegExp.test(value);
	if(!result) {
		input.parent().removeClass("has-success");
		input.parent().addClass("has-error");
	} else {
		input.parent().removeClass("has-error");
		input.parent().addClass("has-success");
		saveFormulaForSyndrom(type, value);
	}
}

function refreshFormulaValues() {
	getFormulaForSyndrom("severityLevel");
	getFormulaForSyndrom("insufficiencyLevel");
}

$(document).ready(function() {
	$("#syndrrom-names").change(function() {
		refreshFormulaValues();
	});
	refreshFormulaValues();
});