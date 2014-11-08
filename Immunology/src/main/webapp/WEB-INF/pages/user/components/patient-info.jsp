<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.sub-panel .col-sm-7 {
	padding-left: 4px;
}

.DTTT {
	display: none;
}
<
jsp










:include






	





page










="/
WEB-INF
/pages/user/components/modal/efficiency-modal










.jsp










"
>
</
jsp










:include
>
</style>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Головна</a></li>
			<li><a href="#">Мої пацієнти</a></li>
			<li><a href="#">${patient.firstName} ${patient.lastName}</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<span>Виберіть синдром:</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content" style="display: list-item;">
				<div class="col-sm-9">
					<select id="syndrom" class="form-control">
						<c:forEach items="${syndromes}" var="syndrome">
							<option>${syndrome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-sm-3">
					<button type="button" id="select_syndrome_button"
						class="btn btn-default">
						<i class="fa fa-arrow-circle-down"></i> Вибрати
					</button>

				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-user"></i> <span>${patient.firstName}
						${patient.lastName}</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<div id="tabs">
					<ul>
						<li><a href="#tabs-1">Профіль</a></li>
						<li><a href="#tabs-2">Медична картка</a></li>
						<li><a href="#tabs-3">Анамнестичні дані</a></li>
						<li><a href="#tabs-4">Обстеження</a></li>
					</ul>
					<div id="tabs-1">
						<jsp:include
							page="/WEB-INF/pages/user/components/patient-profile.jsp" />

					</div>
					<div id="tabs-2">
						<div id="container" class="form-container"></div>
					</div>
					<div id="tabs-3">
						<div id="AnamnesticDataContainer" class="form-container">
							<h3>Виберіть синдром</h3>
						</div>
					</div>
					<div id="tabs-4">
						<div id="SyrveyDataContainer">
							<div class="box-content no-padding"
								style="border: 2px solid; border-color: beige; border-radius: 5px; box-shadow: 10px 10px 30px #888;">
								<table
									class="table table-bordered table-striped table-hover table-heading table-datatable"
									id="datatable-3">
									<thead>
										<tr>
											<th>Дата створення</th>
											<th>Ступінь важкості %</th>
											<th>Ступінь недостатності %</th>
											<th>Лікар</th>
											<th>Ефективність</th>
										</tr>
									</thead>
									<tbody id="survey-table-body">
										<c:forEach items="${syndrom.surveys}" var="survey">
											<tr>
												<td>${survey.creationDate}</td>
												<td>${survey.severityLevel}</td>
												<%-- 										<td>${survey.user.firstName}</td> --%>
												<td class='custom-size'>
													<button type='button' class='btn btn-primary efficiency'>Ефективність</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th>Дата створення</th>
											<th>Ступінь важкості %</th>
											<th>Ступінь недостатності %</th>
											<th>Лікар</th>
											<th>Ефективність</th>
											<!-- 									<th>Лікар</th> -->
										</tr>
									</tfoot>
								</table>
							</div>
							<button id="newSurveyButton" type="button"
								style="width: 30%; height: 35px; margin-top: 10px; display: none;"
								class="btn btn-primary btn-sm btn-block">Додати нове
								обстеження</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<input type="hidden" id="patient_id" value="${patient.id}" />




<script>
	var medCard = new Builder("medCard");
	var anamnesticData = new Builder("anamnesticData");
	function DemoSelect2() {
		//$('#s2_with_tag').select2({placeholder: "Select OS"});
		//	$('#country').select2();
		//	$('#sex').select2();
	}

	$(document).ready(function() {
		// Create jQuery-UI tabs
		$("#tabs").tabs();
		$('#dateOfBirth').datepicker({
			dateFormat : "dd/mm/yy",
			changeMonth : true,
			changeYear : true,
			yearRange : "-110:+2"
		});
		$('#datepicker').click(function() {
			$('#dateOfBirth').datepicker("show");
		});
		TestTable3();
		initSyndromeEvent();

		// Add tooltip to form-controls
		$('.form-control').tooltip();
		Select2Script(DemoSelect2);
		BootstrapValidatorScript(PatientValidator);
		// New Form Builder //
		//1) ID Container div 2) Patient Id 3) Form Type;
		medCard.init('#container', "MedicalCardForm", $('#patient_id').val());

		WinMove();

	});

	function initSyndromeEvent() {
		$("#select_syndrome_button").click(
				function() {
					$("#newSurveyButton").css("display", "inline");
					anamnesticData.init('#AnamnesticDataContainer',
							"AnamnesticDataForm", $('#patient_id').val(), $(
									'#syndrom').val());
					refreshTable($('#syndrom').val());
				});
		$("#newSurveyButton").click(
				function() {
					if ($("#syndrom").val() != null) {
						window.location.href = '/survey/patientId/'
								+ $("#patient_id").val() + '/syndrome/'
								+ $('#syndrom').val();
					}
				});
	}
	function initSurveyRowesEvent() {
		$(".surveyRow").click(
				function() {
					window.location.href = '/survey/edit/patientId/'
							+ $("#patient_id").val() + '/surveyId/'
							+ $(this).attr("surveyId") + '/syndrome/'
							+ $('#syndrom').val();
				});
		$('.efficiency').click(function() {
			$('#efficiency-modal').modal('show');
			return false;
		})

	}
	function refreshTable(syndromName) {
		var patientId = "${patient.id}";
		var syndromName = $('#syndrom').val();
		var table = $("#survey-table-body");
		$
				.ajax({
					type : "get",
					url : "/syndromes/patient/{id}/{name}".replace("{id}",
							patientId).replace("{name}", syndromName),
					dataType : "json",
					async : false,
					success : function(response) {
						table.html("");
						for (var int = 0; int < response.surveys.length; int++) {
							if (response.surveys[int].id != 0) {
								var tr = $("<tr class='surveyRow' surveyId='"+response.surveys[int].id+"'/>");
								tr
										.append("<td>"
												+ response.surveys[int].creationDate
												+ "</td><td>"
												+ response.surveys[int].severityLevel
												+ "</td><td></td><td></td>"
												+ "<td class='custom-size'>"
												+ "<button "+
										"type='button'"+"class='btn btn-primary efficiency'>Ефективність</button></td>");
								//+"<td>"+response.surveys[int].user.firstName +"</td>");
								table.append(tr);
							}
						}
						//			response.surveys[int].user.firstName;
						initSurveyRowesEvent();
					},
					error : function(request, status, error) {
						alert(error);
					}
				})

	}
</script>
