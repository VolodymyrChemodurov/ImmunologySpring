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
			<li>Формули</li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-8 col-xs-offset-2">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-users"></i>
					<span>Налаштування формул</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<label class="col-sm-12 control-label">Виберіть синдром:</label> 
				<select class="form-control" id="syndrrom-names" name="syndrrom-names" style="margin-bottom: 10px;">
				<c:forEach items="${syndromes}" var="syndrome">
					<option>${syndrome}</option>
				</c:forEach>
				</select> 
				<label class="col-sm-12 control-label" style="margin-left: 10px;">Формула 1:</label>
				<div class="control-group">
					<label class="control-label" style="font-size: large;">Σ</label>
					<input type="text" class="form-control" id="severity-formula" style="width: 96%; float: right;">
				</div> 
				<label class="col-sm-12 control-label" style="margin-left: 10px; margin-top: 10px;">Формула 2:</label>
				<div class="control-group">
					<label class="control-label" style="font-size: large;">Σ</label>
					<input type="text" class="form-control" id="insufficiency-formula" style="width: 96%; float: right;">
				</div>
				<div class="control-group">
					<label style="margin-left: 10px; margin-top: 10px; font-weight: inherit;">*Можна використовувати наступні символи: ' * ' , ' ^ ' , ' / ' , ' X ' ; де Х - значення коефіцієнта</label>
					<div class="modal-footer" style="height: 40px; text-align: center;">
						<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="sendFormulaValues();">Зберегти</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>