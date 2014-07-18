var getMedCardUrl = "/Immunology/admin/medical_card";
var medCardObject = null;

$(document).ready(function() {
	init();
	
});


function init(){
	getResouces();
	console.log("->MED.CARD AFTER getResources");
	console.log(medCardObject);
	
}

function getResouces(){
	$.ajax({
		type : "get",
		url : getMedCardUrl,
		dataType : "json",
		success : function(response) {
			medCardObject = response;
			console.log("->GET RESOURCES");
			console.log(response);
			if(medCardObject != null){
				initPanelNames();
			}
		},
		error: function (request, status, error) {
			alert(error);
	    }

	});
}
function initPanelNames(){
	var optionElement;
	$(medCardObject.panels).each(function(index, panel){
		optionElement = $("<option>"+panel.name+"</option>");
		$("select[name=panel-names]").append(optionElement); 
	});
	
};




