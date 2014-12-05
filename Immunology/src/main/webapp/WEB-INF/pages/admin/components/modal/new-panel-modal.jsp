<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Modal  Panel-->
<div class="modal fade" id="create-panel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span></button>
        <h4 class="modal-title" id="myModalLabel">Створити нову Panel</h4>
      </div>
      <div class="modal-body">
       	
			<label class="col-sm-12 control-label">Введіть назву Panel:</label>
			<input type="text" class="form-control"  id="panelName" />
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
        <button type="button" id="save-panel-button" class="btn btn-primary" data-dismiss="modal">Зберегти зміни</button>
      </div>
    </div>
  </div>
</div>