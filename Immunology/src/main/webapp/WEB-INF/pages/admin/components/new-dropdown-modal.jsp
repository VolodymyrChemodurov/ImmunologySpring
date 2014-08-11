	<!-- Modal  Panel-->
<div class="modal fade" id="create-dropdown" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Create new DropDpown</h4>
      </div>
      <div class="modal-body">
      		<label class="col-sm-12 control-label">Set Panel Name:</label>
			<select name="panel-names" style="margin: 5px;">
			</select>
			<label class="col-sm-12 control-label">Set sub-panel Name:</label>
			<select name="sub-panel-names" style="margin: 5px;">
			</select>
			<label class="col-sm-12 control-label">Set DropDown Title:</label>
			<input type="text" class="form-control"  id="dropdownName"  placeholder="Dropdown title"  style="margin: 5px;"/>
			
			<label class="col-sm-12 control-label">DropDown Values:</label>
			<select multiple id="dropdownValues"  style="margin: 5px;">
			</select>
			
			<input type="text" class="form-control"  id="dropdownElementValue" placeholder="Add new Value"  style="margin: 5px;"/>
			<div class="col-sm-12" style="margin-top: 5px;">
					<button id="add-value-button" class="btn btn-primary btn-lg">Add value</button>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" id="save-dropdown-button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
      </div>
    </div>
  </div>
</div>