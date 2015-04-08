<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="${param.baseURL}/resources/js/admin-page/formulas.js"></script>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#" onclick="doAjaxGet('/users');">Головна</a></li>
			<li>Препарати</li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-medkit"></i>
					<span>Список усіх препаратів</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-3">
					<thead>
						<tr>
							<th>ID</th>
							<th>Тип</th>
							<th>Вид</th>
							<th>Назва</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${drugs}" var="drug"> 
							<tr onclick="getDrug('drugs/${drug.id}')">
								<td>${drug.id}</td>
								<td>${drug.species.type.name}</td>
								<td>${drug.species.name}</td>
								<td>${drug.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-medkit"></i>
					<span>Дії</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding" style="text-align: center;">
				<div class="modal-body form-horizontal">
					<fieldset>
					<div class="form-group">
						<button type="button" class="btn btn-primary" id="create-drug"
							data-dismiss="modal">Створити новий препарат</button>
						<button type="button" class="btn btn-primary" id="create-drug-type"
							data-dismiss="modal">Створити новий тип</button>
						<button type="button" class="btn btn-primary" id="create-drug-species"
							data-dismiss="modal">Створити новий вид</button>
					</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
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
				getDrugTypes(response.typeName);
				getDrugSpecies(response.typeName, response.speciesName);
				$('#edit-drug-modal').modal('show'); 
			},
			error : function(request, status, error) {
				alert(error);
			}
		});
	}
	
	function getDrugTypes(type) {
		$.ajax({
			type : "GET",
			url : "drugs/getDrugTypes",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			async: false,
			success : function(response) {
				console.log(response);
				globalDrugTypes = response; 
				var drugTypes = $("#typeOfDrugs");
				drugTypes[0].options.length = 0;
				$.each(response, function() {
					drugTypes.append('<option>' + this + '</option>');
				});
				if(type !== null) {
					drugTypes.val(type);
				} else {
					$('#typeOfDrugs :nth-child(0)').prop('selected', true);
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
	
	$("#create-drug").click(
			function() {
				getDrugTypes(null);
				getDrugSpecies(globalDrugTypes[0], null);
				$('#edit-drug-modal').modal('show'); 
	});
	
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
</script>