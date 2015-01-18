// Run Datables plugin and create 3 variants of settings
function AllTables() {
	TestTable3();
	Select2Script(MakeSelect2);
}
function MakeSelect2() {
	$('select[name=datatable-3_length').select2();
	$('#dropdownValues').select2();
	$('.dataTables_filter').each(
			function() {
				$(this).find('label input[type=text]').attr('placeholder',
						'Пошук');
			});
}
$(document).ready(function() {
	// Load Datatables and run plugin on tables 
	DataTablesScripts(AllTables);
	// Add Drag-n-Drop feature
	WinMove();
});

function addPatient(id){
	var patient = "patients/"+id;
	$.ajax({
		type : "post",
		url : patient,
		success : function(response) {
			/* alert(patient); */
			location.href = "/cabinet";
		}, 
		error: function (request, status, error) {
			alert(error);
	    }
	});
}