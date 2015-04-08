//Admin drugs management
var globalDrugTypes;
var globalDrugSpecies;

function getDrug(url) {
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
			getDrugSpecies(response.typeName, response.speciesName);
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
			//var drugTypes = $("#typeOfDrugs");
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

function getDrugSpecies(type, species) {
	$.ajax({
		type : "POST",
		url : "drugs/getDrugSpecies",
		data : {
			'typeOfDrugs' : type
		},
		async: false,
		success : function(response) {
			console.log(response);
			var speciesOfDrugs = $("#speciesOfDrugs");
			speciesOfDrugs[0].options.length = 0;
			$.each(response, function() {
				speciesOfDrugs.append('<option>' + this + '</option>');
			});
			if(species !== null) {
				speciesOfDrugs.val(species);
			} else {
				$('#speciesOfDrugs :nth-child(0)').prop('selected', true); 
			}
		},
		error : function(request, status, error) {
			alert(error);
		}
	});
}

//$("#create-drug").click(
function createDrug() {
			getDrugTypes(null, "#typeOfDrugs");
			getDrugSpecies(globalDrugTypes[0], null);
			$('#edit-drug-modal').modal('show'); 
};//);

//$("#create-drug-type").click(
function createDrugType() {
			$('#create-drug-type-modal').modal('show'); 
}//);

//$("#create-drug-species").click(
function createDrugSpecies() {
			getDrugTypes(null, '#selectedTypeOfDrugs');
			$('#create-drug-species-modal').modal('show'); 
};//);

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

$('#typeOfDrugs').on('change', function (e) {
	var type = this.value;
    getDrugSpecies(type, null);
});