<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Modal  Panel-->
<div class="modal fade" id="create-dropdown" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span></button>
        <h4 class="modal-title" id="myModalLabel">Створити новий DropDpown</h4>
      </div>
      <div class="modal-body">
      		<label class="col-sm-12 control-label">Виберіть Panel:</label>
			<select class="form-control" name="panel-names" style="margin: 5px;">
			</select>
			<label class="col-sm-12 control-label">Виберіть Sub-panel:</label>
			<select class="form-control" name="sub-panel-names" style="margin: 5px;">
			</select>
			<label class="col-sm-12 control-label">Введіть назву DropDown:</label>
			<input type="text" class="form-control"  id="dropdownName"  placeholder="Назва елементу"  style="margin: 5px;"/>
			
			<label class="col-sm-12 control-label">Значення DropDown:</label>
			<select multiple id="dropdownValues"  style="margin: 5px;">
			</select>
			
			<input type="text" class="form-control"  id="dropdownElementValue" placeholder="Додати нове значення"  style="margin: 5px;"/>
			<div class="col-sm-12" style="margin-top: 5px;">
					<button id="add-value-button" class="btn btn-primary btn-lg">Додати значення</button>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
        <button type="button" id="save-dropdown-button" class="btn btn-primary" data-dismiss="modal">Зберегти зміни</button>
      </div>
    </div>
  </div>
</div>

