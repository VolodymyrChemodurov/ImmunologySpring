var typeOfChart;

var drugName = null;

var drugType;

var patientId = 0;

function drawChartDateOfRegistration() {
	var jsonData = $.ajax({
		url : "/statistic/medical_cards/by_years",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();

	data.addColumn({
		"type" : "number",
		"label" : "Роки"
	});
	data.addColumn({
		"type" : "number",
		"label" : "Кількість пацієнтів"
	});

	jsonData = sort(jsonData);

	data.addRows(jsonData);
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_dateofregistration', dataView, options);
}

function drawSyndromePatient() {
	var jsonData = $.ajax({
		url : "/statistic/syndrome/by_patient",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();
	data.addColumn({
		"type" : "string",
		"label" : "Синдром"
	});
	data.addColumn({
		"type" : "number",
		"label" : "Кількість пацієнтів"
	});

	data.addRows($.parseJSON(jsonData));
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_syndrome_patient', dataView, options);
}

function drawPatientSex() {
	var jsonData = $.ajax({
		url : "/statistic/patient/by_sex",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();
	data.addColumn({
		"type" : "string",
		"label" : "Стать"
	});
	data.addColumn({
		"type" : "number",
		"label" : "Кількість пацієнтів"
	});

	data.addRows($.parseJSON(jsonData));
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_patient_sex', dataView, options);
}

function drawInsufficiency() {
	var jsonData = $.ajax({
		url : "/statistic/user/insufficiency",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();

	data.addColumn({
		"type" : "number",
		"label" : "Ступінь важкості,%"
	});

	data.addColumn({
		"type" : "string",
		"label" : "Роки"
	});

	data.addRows($.parseJSON(jsonData));
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 1);
		},
		type : 'string'
	}, 0 ]);
	selectTypeOfChart('chart_insufficiency', dataView, options);
}

function drawSeverity() {
	var jsonData = $.ajax({
		url : "/statistic/user/severity",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();

	data.addColumn({
		"type" : "number",
		"label" : "Ступінь недостатності,%"
	});

	data.addColumn({
		"type" : "string",
		"label" : "Роки"
	});

	data.addRows($.parseJSON(jsonData));
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 1);
		},
		type : 'string'
	}, 0 ]);
	selectTypeOfChart('chart_severity', dataView, options);
}

function drawTolerance() {
	var jsonData = $.ajax({
		url : "statistic/drug/by_tolerance",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();

	data.addColumn({
		"type" : "string",
		"label" : "Переносимість препарату"
	});

	data.addColumn({
		"type" : "number",
		"label" : "Кількість значень"
	});

	data.addRows(replaceTolerance(jsonData));
	
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_tolerance', dataView, options);
}

function drawEvaluation() {
	var jsonData = $.ajax({
		url : "statistic/drug/by_evaluation",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();

	data.addColumn({
		"type" : "string",
		"label" : "Оцінка ефективності препарату"
	});

	data.addColumn({
		"type" : "number",
		"label" : "Кількість значень"
	});

	data.addRows(replaceEvaluation(jsonData));
	
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_evaluation', dataView, options);
}

function drawSideEffect() {
	var jsonData = $.ajax({
		url : "statistic/drug/by_sideEffect",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();

	data.addColumn({
		"type" : "string",
		"label" : "Ступінь вираженості ПЕ"
	});

	data.addColumn({
		"type" : "number",
		"label" : "Кількість значень"
	});

	data.addRows(replaceSideEffect(jsonData));
	
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_sideEffect', dataView, options);
}

function drawCancel() {
	var jsonData = $.ajax({
		url : "statistic/drug/cancel",
		dataType : "json",
		async : false
	}).responseText;

	var data = new google.visualization.DataTable();
	jsonData = replaceCancel(jsonData);
	data.addColumn({
		"type" : "string",
		"label" : "Вимагає скасування"
	});

	data.addColumn({
		"type" : "number",
		"label" : "Кількість значень"
	});

	data.addRows(jsonData);
	
	var options = {
		width : 1492,
		height : 350,
	};
	var dataView = new google.visualization.DataView(data);
	dataView.setColumns([ {
		calc : function(data, row) {
			return data.getFormattedValue(row, 0);
		},
		type : 'string'
	}, 1 ]);
	selectTypeOfChart('chart_cancel', dataView, options);
}

function selectTypeOfChart(nameOfDiv, dataView, options) {
	var pieChart = new google.visualization.PieChart(document
			.getElementById(nameOfDiv));

	var columnChart = new google.visualization.ColumnChart(document
			.getElementById(nameOfDiv));

	var lineChart = new google.visualization.LineChart(document
			.getElementById(nameOfDiv));

	if (typeOfChart.trim() == 'Кругова діаграма') {
		pieChart.draw(dataView, options);
	} else if (typeOfChart.trim() == 'Стовпчикова діаграма') {
		columnChart.draw(dataView, options);
	} else if (typeOfChart.trim() == 'Гістограма') {
		histogram.draw(dataView, options);
	} else if (typeOfChart.trim() == 'Графік') {
		lineChart.draw(dataView, options);
	}
}

function sort(jsonData) {
	jsonData = $.parseJSON(jsonData);
	jsonData.sort(function(a, b) {
		var a1 = a[1], b1 = b[1];
		if (a1 == b1)
			return 0;
		return a1 > b1 ? 1 : -1;
	});
	return jsonData;
}

function drawAllGeneral() {
	drawChartDateOfRegistration();
	drawSyndromePatient();
	drawPatientSex();
}

function drawUserChart() {
	drawInsufficiency();
	drawSeverity();
}

function drawAllDrugs() {
	drawTolerance();
	drawEvaluation();
	drawSideEffect();
	drawCancel();
}
function drawAll() {
	drawAllGeneral();
	if (patientId == 0) {
		$(".messageUser").css("display", "inline");
	} else {
		$(".messageUser").css("display", "none");
		drawUserChart();
	}
	if (drugName != null) {
		drawAllDrugs();
	}
}
$("#select_chart_button").click(function() {
	typeOfChart = $('#typeofchart').val();
	$(".message").css("display", "none");
	$(".type").css("display", "inline");
	$(".users").css("display", "inline");
	google.load("visualization", "1", {
		packages : [ "corechart" ],
		callback : drawAll
	});
});


function userChart(userId) {
	$(".messageUser").css("display", "none");
	patientId = userId;
	$.ajax({
		type : "post",
		url : "/statistic/userId",
		data : {
			'patientId' : userId,
		},
		success : function(response) {
			google.load("visualization", "1", {
				packages : [ "corechart" ],
				callback : drawUserChart
			});
		},
	});
}

$(document).ready(function() {
	$("#tabs").tabs();

});