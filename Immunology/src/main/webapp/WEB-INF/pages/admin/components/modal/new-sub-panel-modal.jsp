<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Modal  Panel-->
<div class="modal fade" id="create-sub-panel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span></button>
        <h4 class="modal-title" id="myModalLabel">Створити нову Sub Panel</h4>
      </div>
      <div class="modal-body">
      	<label class="col-sm-12 control-label">Виберіть Panel:</label>
       	<select class="form-control" name="panel-names">
		</select>
		<label class="col-sm-12 control-label">Введіть назву Sub-panel:</label>
		<input type="text" class="form-control"  id="sub-panel-name" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
        <button type="button" class="btn btn-primary" id="save-sub-panel-button" data-dismiss="modal">Зберегти зміни</button>
      </div>
    </div>
  </div>
</div>