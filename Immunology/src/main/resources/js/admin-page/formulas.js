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
	var severity = $("#severity-formula").val();
	var insufficiency = $("#insufficiency-formula").val();

	saveFormulaForSyndrom("severityLevel", severity);
	saveFormulaForSyndrom("insufficiencyLevel", insufficiency);

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