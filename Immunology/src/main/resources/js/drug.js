function replaceTolerance(jsonData) {
	jsonData = $.parseJSON(jsonData);
	$.each(jsonData, function(index, value) {
		if (value[0] == "SATISFYING") {
			value[0] = "Задовільна";
		}
		if (value[0] == "GOOD") {
			value[0] = "Добра";
		}
		if (value[0] == "BAD") {
			value[0] = "Незадовільна";
		}
	});
	return jsonData;
}

function replaceCancel(jsonData) {
	jsonData = $.parseJSON(jsonData);
	$.each(jsonData, function(index, value) {
		if (value[0] == false) {
			value[0] = "Ні";
		}
		if (value[0] == true) {
			value[0] = "Так";
		}
	});
	return jsonData;
}

function replaceSideEffect(jsonData) {
	jsonData = $.parseJSON(jsonData);
	$.each(jsonData, function(index, value) {
		if (value[0] == "LIGHT") {
			value[0] = "Легкий";
		}
		if (value[0] == "MEDIUM") {
			value[0] = "Середній";
		}
		if (value[0] == "HARD") {
			value[0] = "Тяжкий";
		}
	});
	return jsonData;
}


function replaceEvaluation(jsonData) {
	jsonData = $.parseJSON(jsonData);
	$.each(jsonData, function(index, value) {
		if (value[0] == "HIGH") {
			value[0] = "Висока (позит. динаміка > 70)";
		}
		if (value[0] == "NO_EFFECT") {
			value[0] = "Відсутність ефекту";
		}
		if (value[0] == "MODERATE") {
			value[0] = "Помірна (позит. динаміка 50 - 70)";
		}
	});
	return jsonData;
}

$("#select_drug_type_button").click(
		function() {
			$(".name").css("display", "none");
			$(".species").css("display", "inline");
			drugType = $('#typeOfDrugs').val();
			$.ajax({
				type : "post",
				url : "/drugs/getDrugSpecies",
				data : {
					'typeOfDrugs' : drugType
				},
				success : function(response) {
					var species = (response);
					$("#speciesOfDrugs").html("");
					jQuery.each(species, function(index, value) {
						$("#speciesOfDrugs").append(
								$("<option></option>").text(value).attr(
										'value', index));
					});
				},
			});
		});

$("#select_drug_species_button").click(
		function() {
			$(".name").css("display", "inline");
			speciesOfDrugs = $('#speciesOfDrugs option:selected').text();
			$.ajax({
				type : "post",
				url : "/drugs/getDrugNames",
				data : {
					'speciesOfDrugs' : speciesOfDrugs
				},
				success : function(response) {
					var names = (response);
					$("#nameOfDrugs").html("");
					jQuery.each(names, function(index, value) {
						$("#nameOfDrugs").append(
								$("<option></option>").text(value).attr(
										'value', index));
					});
				},
			});
		});

$("#select_drug_name_button").click(function() {
	drugName = $('#nameOfDrugs option:selected').text();
	$.ajax({
		type : "post",
		url : "/statistic/getDrugName",
		data : {
			'nameOfDrugs' : drugName
		},
		success : function(response) {
			google.load("visualization", "1", {
				packages : [ "corechart" ],
				callback : drawAllDrugs
			});
		},
	});
});