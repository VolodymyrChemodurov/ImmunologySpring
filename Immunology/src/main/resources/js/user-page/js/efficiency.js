$("#save-sub-efficiency-button").click(
		function() {
			var efficiencyData = {};
			efficiencyData.drugTolerance = $("#drug_tolerance").val();
			efficiencyData.efficacyEvaluation = $("#efficacy_evaluation").val();
			efficiencyData.sideEffectDescription = $("#side_effect_description").val();
			efficiencyData.sideEffectsSeverityDegree = $("#side_effects_severity_degree").val();
			efficiencyData.cancel = $("#cancel").val();
			
			console.log(efficiencyData);

			$.ajax({
				type : "POST",
				url : "/drugs/efficiency/{surveyId}".replace("{surveyId}", surveyId),
				data : JSON.stringify(efficiencyData),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(response) {
					console.log("Success Save");
				},
				error : function(request, status, error) {
					alert(error);
				}
			});
});