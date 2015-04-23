<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Modal  Panel-->
<div class="modal fade" id="add-drug-to-syndrome-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Виберіть препарат</h4>
			</div>
			<div class="modal-body form-horizontal">
				<fieldset>
				<div class="form-group">
					<label class="col-sm-3 control-label">Тип</label>
					<div class="col-sm-7">
						<select id="syndromeSelectTypeOfDrugs" class="form-control"></select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Вид</label>
					<div class="col-sm-7">
						<select id="syndromeSelectSpeciesOfDrugs" class="form-control"></select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Назва</label>
					<div class="col-sm-7">
						<select id="syndromeSelectDrugName" class="form-control"></select>
					</div>
				</div>
				</fieldset>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
				<button type="button" class="btn btn-primary" id="addDrugToSyndrome"
					data-dismiss="modal">Додати</button>
			</div>
		</div>
	</div>
</div>