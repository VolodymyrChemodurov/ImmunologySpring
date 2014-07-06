	<!-- Modal  Panel-->
<div class="modal fade" id="create-textbox" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
       	
			<select name="panelNames" id="panelNameForTextBox"  class="form-control">
				<option>Android</option>
				<option>Sailfish OS</option>
				<option>CyanogenMod</option>
				<option>FirefoxOS</option>
				<option>MeeGo</option>
			</select>
				<label class="col-sm-12 control-label">Set TextBox Name:</label>
			<input type="text" class="form-control"  id="textBoxName" />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick='createTextBox($("#panelNameForTextBox").val(),$("#textBoxName").val())'>Save changes</button>
      </div>
    </div>
  </div>
</div>