<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<div class="box-name">
					 <span>Виберіть діаграму:</span>
				</div>
				<div class="no-move"></div>
			</div>
				<div class="box-content" style="display: list-item;">
						<div class="col-sm-9">
							<select id="typeofchart" class="form-control">
    								<option>Кругова діаграма</option>
    								<option>Стовпчикова діаграма</option>
    								<option>Гістограма</option>
    								<option>Графік</option>
							</select>
						</div>
						<div class="col-sm-3">
							<button type="button" id="select_chart_button" class="btn btn-default"><i class="fa fa-arrow-circle-down"></i> Вибрати</button>
						
						</div>
				</div>
			</div>
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
							<div class="col-xs-12 col-sm-12">
								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Статистика реєстрації осіб</span>
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
										<div id="chart_dateofregistration"></div>
									</div>
								</div>


								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Статистика віку</span>
										</div>
										<div class="box-icons">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="expand-link"> <i class="fa fa-expand"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i>
											</a>
										</div>
										<div class="no-move"></div>
									</div>
									<div class="box-content"></div>

								</div>

								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Статистика хвороб</span>
										</div>
										<div class="box-icons">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="expand-link"> <i class="fa fa-expand"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i>
											</a>
										</div>
										<div class="no-move"></div>
									</div>
									<div class="box-content"></div>
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
					<div id="tabs-3">
						<div class="row">
							<div class="col-xs-12 col-sm-12">
								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Переносимість препарату</span>
										</div>
										<div class="box-icons">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="expand-link"> <i class="fa fa-expand"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i>
											</a>
										</div>
										<div class="no-move"></div>
									</div>
									<div class="box-content"></div>
								</div>
								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Оцінка ефективність препарату</span>
										</div>
										<div class="box-icons">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="expand-link"> <i class="fa fa-expand"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i>
											</a>
										</div>
										<div class="no-move"></div>
									</div>
									<div class="box-content"></div>
								</div>
								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Ступінь вираженості ПЕ</span>
										</div>
										<div class="box-icons">
											<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
											</a> <a class="expand-link"> <i class="fa fa-expand"></i>
											</a> <a class="close-link"> <i class="fa fa-times"></i>
											</a>
										</div>
										<div class="no-move"></div>
									</div>
									<div class="box-content"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
var typeOfChart;
	function drawChartDateOfRegistration() {
		var jsonData = $.ajax({
			url : "/statistic/medical_cards/by_years",
			dataType : "json",
			async : false
		}).responseText;

		var data = new google.visualization.DataTable();
		data.addColumn({
			"type" : "number",
			"label" : "Years"
		});
		data.addColumn({
			"type" : "number",
			"label" : "Amount"
		});
		data.addRows(JSON.parse(jsonData));

		var options = {
			width : '50%',
			height : 400,
		};
		var dataView = new google.visualization.DataView(data);
		dataView.setColumns([ {
			calc : function(data, row) {
				return data.getFormattedValue(row, 0);
			},
			type : 'string'
		}, 1 ]);

		var pieChart = new google.visualization.PieChart(document
				.getElementById('chart_dateofregistration'));
		
		var histogram = new google.visualization.Histogram(document
				.getElementById('chart_dateofregistration'));
		
		var columnChart = new google.visualization.ColumnChart(document
				.getElementById('chart_dateofregistration'));
		
		var lineChart = new google.visualization.LineChart(document
				.getElementById('chart_dateofregistration'));
		
		if(typeOfChart.trim()=='Кругова діаграма'){
			pieChart.draw(dataView, options);
			}else if (typeOfChart.trim()=='Стовпчикова діаграма'){
				columnChart.draw(dataView, options);
			}else if (typeOfChart.trim()=='Гістограма'){
				histogram.draw(dataView, options);
			}else if (typeOfChart.trim()=='Графік'){
				lineChart.draw(dataView, options);
			}
	}
	
	$("#select_chart_button").click(function(){
		typeOfChart=$('#typeofchart').val();
		google.load("visualization", "1", {
			packages : [ "corechart" ],
			callback : drawChartDateOfRegistration
		});
	});
	
	

	$(document).ready(function() {
		$("#tabs").tabs();

	});
</script>