//Admin drugs management
var globalDrugTypes;
var globalDrugSpecies;

function getDrug(url) {
	$("#delete-drug").show();
	$.ajax({
		type : "GET",
		url : url,
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(response) {
			console.log(response);
			$("#drug_name").val(response.name);
			$("#drug_id").val(response.id);
			getDrugTypes(response.typeName, "#typeOfDrugs");
			getDrugSpecies(response.typeName, response.speciesName, 'speciesOfDrugs');
			$('#edit-drug-modal').modal('show'); 
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function getDrugTypes(type, drugTypesSelectFieldSelector) {
	$.ajax({
		type : "GET",
		url : "drugs/getDrugTypes",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		async: false,
		success : function(response) {
			console.log(response);
			globalDrugTypes = response; 
			var drugTypes = $(drugTypesSelectFieldSelector);
			drugTypes[0].options.length = 0;
			$.each(response, function() {
				drugTypes.append('<option>' + this + '</option>');
			});
			if(type !== null) {
				drugTypes.val(type);
			} else {
				$(drugTypesSelectFieldSelector + ' :nth-child(0)').prop('selected', true);
			}
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function getDrugSpecies(type, species, speciesOfDrugsSelector) {
	$.ajax({
		type : "POST",
		url : "drugs/getDrugSpecies",
		data : {
			'typeOfDrugs' : type
		},
		async: false,
		success : function(response) {
			console.log(response);
			globalDrugSpecies = response;
			var speciesOfDrugs = $(speciesOfDrugsSelector);
			speciesOfDrugs[0].options.length = 0;
			$.each(response, function() {
				speciesOfDrugs.append('<option>' + this + '</option>');
			});
			if(species !== null) {
				speciesOfDrugs.val(species);
			} else {
				$(speciesOfDrugsSelector + ' :nth-child(0)').prop('selected', true); 
			}
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function getSpeciesDrugs(species, drugNamesSelector) {
	$.ajax({
		type : "POST",
		url : "drugs/getDrugNames",
		data : {
			'speciesOfDrugs' : species
		},
		async: false,
		success : function(response) {
			console.log(response);
			var drugNames = $(drugNamesSelector);
			drugNames[0].options.length = 0;
			$.each(response, function() {
				drugNames.append('<option>' + this + '</option>');
			});
			$(drugNamesSelector + ' :nth-child(0)').prop('selected', true); 
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

function createDrug() {
		$("#delete-drug").hide();
		getDrugTypes(null, "#typeOfDrugs");
		getDrugSpecies(globalDrugTypes[0], null, "#speciesOfDrugs");
		$('#edit-drug-modal').modal('show'); 
};

function createDrugType() {
			$('#create-drug-type-modal').modal('show'); 
}

function createDrugSpecies() {
			getDrugTypes(null, '#selectedTypeOfDrugs');
			$('#create-drug-species-modal').modal('show'); 
};

function addDrugToSyndrome() {
	getDrugTypes(null, "#syndromeSelectTypeOfDrugs");
	getDrugSpecies(globalDrugTypes[0], null, "#syndromeSelectSpeciesOfDrugs");
	getSpeciesDrugs(globalDrugSpecies[0],'#syndromeSelectDrugName');
	$('#add-drug-to-syndrome-modal').modal('show'); 
};

$("#save-drug").click(
		function() {
			var drug = {};
			drug.name = $("#drug_name").val();
			drug.speciesName = $("#speciesOfDrugs").val();
			drug.id = $("#drug_id").val();
			drug.typeName = $("#typeOfDrugs").val();
			
			console.log(drug);

			$.ajax({
				type : "POST",
				url : "/drugs/{drugId}".replace("{drugId}", drug.id),
				data : JSON.stringify(drug),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				async: false,
				success : function(response) {
					console.log("Success Save");
					doAjaxGet('drugs');
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
});

$("#save-new-drug-type").click(
		function() {
			var drugType = {};
			drugType.name = $("#newDrugType").val();
			console.log(drugType);

			$.ajax({
				type : "POST",
				url : "/drugs/type",
				data : JSON.stringify(drugType),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(response) {
					console.log("Success Save");
					doAjaxGet('drugs');
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
});

$("#save-new-drug-species").click(
		function() {
			var drugSpecies = {};
			drugSpecies.name = $("#newDrugSpecies").val();
			drugSpecies.type = {};
			drugSpecies.type.name = $("#selectedTypeOfDrugs").val(); 
			console.log(drugSpecies);

			$.ajax({
				type : "POST",
				url : "/drugs/species",
				data : JSON.stringify(drugSpecies),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(response) {
					console.log("Success Save");
					doAjaxGet('drugs');
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
});

$("#addDrugToSyndrome").click(function() {
	var drugType = $("#syndromeSelectTypeOfDrugs").val();
	var drugSpecies = $("#syndromeSelectSpeciesOfDrugs").val();
	var drugName = $("#syndromeSelectDrugName").val();
	var syndromeName = $('select[name=syndrrom-names]')[0].value;
	
	$.ajax({
		type : "POST",
		url : "/syndromes/template/{syndrome}/drug".replace("{syndrome}", syndromeName),
		data : {
			'type' : drugType,
			'species' : drugSpecies,
			'name' : drugName
		},
		success : function(response) {
			console.log("Success Save");
			doAjaxGet('drugs/syndrome/' + $('select[name=syndrrom-names]')[0].value);
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
});

$('#typeOfDrugs').on('change', function (e) {
	var type = this.value;
    getDrugSpecies(type, null, "#speciesOfDrugs");
});

$('#syndromeSelectTypeOfDrugs').on('change', function (e) {
	var type = this.value;
    getDrugSpecies(type, null, "#syndromeSelectSpeciesOfDrugs");
    getSpeciesDrugs(globalDrugSpecies[0],'#syndromeSelectDrugName');
});

$('#syndromeSelectSpeciesOfDrugs').on('change', function (e) {
	var species = this.value;
	getSpeciesDrugs(species,'#syndromeSelectDrugName');
});

$("#delete-drug").click(
		function() {
			drugId = $("#drug_id").val();

			$.ajax({
				type : "DELETE",
				url : "/drugs/{drugId}".replace("{drugId}", drugId),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				async: false,
				success : function(response) {
					console.log("Success delete");
					doAjaxGet('drugs');
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
});