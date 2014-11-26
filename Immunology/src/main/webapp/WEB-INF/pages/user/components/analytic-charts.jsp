<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="${param.baseURL}/resources/js/statistic.js"></script>
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
						<option>Графік</option>
					</select>
				</div>
				<div class="col-sm-3">
					<button type="button" id="select_chart_button"
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
											<span>Статистика статі</span>
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
										<div id="chart_patient_sex"></div>
									</div>

								</div>

								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Статистика синдромів</span>
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
										<div id="chart_syndrome_patient"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="tabs-2">
						<div class="box-name messageUser"
							style="display: none; color: red">
							<span>Виберіть користувача</span>
						</div>
						<div class="box-content no-padding users" style="display: none;">
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
										<tr onclick="userChart(${patient.id})">
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
						<div class="row">
							<div class="col-xs-12 col-sm-12">
								<div class="box-name message"
									style="display: inline; color: red">
									<span>Виберіть тип діаграми</span>
								</div>
								<div class="box">
									<div class="box-header">
										<div class="box-name">
											<span>Ступінь важкості</span>
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
										<div id="chart_insufficiency"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="box-header">
								<div class="box-name">
									<span>Ступінь недостатності</span>
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
								<div id="chart_severity"></div>
							</div>
						</div>
					</div>
					<div id="tabs-3">
						<div class="row">
							<div class="col-xs-12 col-sm-12">
								<div class="box-name message"
									style="display: inline; color: red">
									<span>Виберіть діаграму</span>
								</div>
								<div class="box type" style="display: none;">
									<div class="box-header">
										<div class="box-name">
											<span>Виберіть тип препарату:</span>
										</div>
									</div>
									<div class="box-content" style="display: list-item;">
										<div class="col-sm-9">
											<select id="typeOfDrugs" class="form-control">
												<c:forEach items="${drugsType}" var="drug">
													<option>${drug}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-sm-3">
											<button type="button" id="select_drug_type_button"
												class="btn btn-default">
												<i class="fa fa-arrow-circle-down"></i> Вибрати
											</button>
										</div>
									</div>
								</div>
								<div class="box species" style="display: none;">
									<div class="box-header">
										<div class="box-name">
											<span>Виберіть вид препарату:</span>
										</div>
									</div>
									<div class="box-content" style="display: list-item;">
										<div class="col-sm-9">
											<select id="speciesOfDrugs" class="form-control">
											</select>
										</div>
										<div class="col-sm-3">
											<button type="button" id="select_drug_species_button"
												class="btn btn-default">
												<i class="fa fa-arrow-circle-down"></i> Вибрати
											</button>
										</div>
									</div>
								</div>
								<div class="box name" style="display: none;">
									<div class="box">
										<div class="box-header">
											<div class="box-name">
												<span>Виберіть назву препарату:</span>
											</div>
										</div>
										<div class="box-content" style="display: list-item;">
											<div class="col-sm-9">
												<select id="nameOfDrugs" class="form-control">
												</select>
											</div>
											<div class="col-sm-3">
												<button type="button" id="select_drug_name_button"
													class="btn btn-default">
													<i class="fa fa-arrow-circle-down"></i> Вибрати
												</button>
											</div>
										</div>
									</div>
								</div>
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
									<div class="box-content">
									<div id="chart_tolerance"></div>
									</div>
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

