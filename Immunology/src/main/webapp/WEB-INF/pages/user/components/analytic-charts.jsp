<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Головна</a></li>
			<li><a href="#">Аналітика</a></li>
			<li><a href="#">Діаграми</a></li>

		</ol>
	</div>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<div id="tabs">
					<ul>
						<li><a href="#tabs-1">Загальна статистика</a></li>
						<li><a href="#tabs-2">Пацієнт</a></li>
						<li><a href="#tabs-3">Препарат</a></li>
					</ul>
					<div id="tabs-1">
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<i class="fa fa-search"></i> <span>Plot with points</span>
										</div>
										<div class="box-icons">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="expand-link"> <i class="fa fa-expand"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i>
											</a>
										</div>
										<div class="no-move"></div>
									</div>
									<div class="box-content">
										<div id="xchart-1" style="height: 200px; width: 100%;"></div>
									</div>
								</div>
							</div>

						</div>

					</div>
					<div id="tabs-2">
						<div class="box-content no-padding">
				<table
					class="table table-bordered table-striped table-hover table-heading table-datatable"
					id="datatable-3">
					<thead>
						<tr>
							<th>Прізвище</th>
							<th>Ім'я</th>
							<th>Дата народження</th>
							<th>Країна</th>
							<th>Місто</th>
							<th>Адреса проживання</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${myPatients}" var="patient">
							<tr onclick="doAjaxGet('patients/${patient.id}')">
								<td>${patient.lastName}</td>
								<td>${patient.firstName}</td>
								<td>${patient.dateOfBirth}</td>
								<td>${patient.country}</td>
								<td>${patient.city}</td>
								<td><c:out value="${patient.street}, ${patient.house}"></c:out></td>


							</tr>

						</c:forEach>


					</tbody>
					<tfoot>
						<tr>
							<th>Прізвище</th>
							<th>Ім'я</th>
							<th>Дата народження</th>
							<th>Країна</th>
							<th>Місто</th>
							<th>Адреса проживання</th>
						</tr>
					</tfoot>
				</table>
			</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	// Draw all test xCharts
	var patients = [];
	var getPatientUrl = "/patients/getAll";

	function getResources() {
		$.ajax({
			type : "get",
			url : getPatientUrl,
			dataType : "json",
			success : function(response) {
				console.log(response);
			},
			error : function(request, status, error) {
				alert(error);
			}
		});
	}

	$(document).ready(function() {
		$("#tabs").tabs();

		//	getResources();
	});
</script>
