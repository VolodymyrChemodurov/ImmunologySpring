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
					<span>Список препаратів</span>
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
							<tr>
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
						<button type="button" class="btn btn-primary" id="create-drug" onclick="addDrugToSyndrome()"
							data-dismiss="modal">Додати препарат</button>
					</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</div>