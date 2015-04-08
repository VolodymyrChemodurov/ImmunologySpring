
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Modal  Panel-->
<div class="modal fade" id="edit-drug-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Редагувати препарат</h4>
			</div>
			<div class="modal-body form-horizontal">
				<fieldset>
				<div class="form-group">
					<label class="col-sm-3 control-label">Тип</label>
					<div class="col-sm-7">
						<select id="typeOfDrugs" class="form-control"></select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Вид</label>
					<div class="col-sm-7">
						<select id="speciesOfDrugs" class="form-control"></select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Назва</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name=drug_name id="drug_name" />
					</div>
				</div>
				<input type="hidden" class="form-control" name="drug_id" id="drug_id" />
				</fieldset>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
				<button type="button" class="btn btn-primary" id="save-drug"
					data-dismiss="modal">Зберегти зміни</button>
			</div>
		</div>
	</div>
</div>