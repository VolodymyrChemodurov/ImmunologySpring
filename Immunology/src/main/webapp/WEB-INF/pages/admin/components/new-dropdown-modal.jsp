	<!-- Modal  Panel-->
<div class="modal fade" id="create-dropdown" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
			<select name="panelNames" id="panelNameForDropDown"  class="form-control" style="margin: 5px;">
				<option>Android</option>
				<option>Sailfish OS</option>
				<option>CyanogenMod</option>
				<option>FirefoxOS</option>
				<option>MeeGo</option>
			</select>
			<input type="text" class="form-control"  id="dropdownName"  placeholder="Dropdown title"  style="margin: 5px;"/>
			
				<select multiple="" class="form-control" id="dropdownValues"  style="margin: 5px;">
				</select>
			
			<input type="text" class="form-control"  id="dropdownElementValue" placeholder="Add new Value"  style="margin: 5px;"/>
			<div class="col-sm-12" style="margin-top: 5px;">
					<button class="btn btn-primary btn-lg" onclick="addToDropDownFromInput('dropdownValues','dropdownElementValue')">Add value</button>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick='createDropDown("panelNameForDropDown","dropdownName")'>Save changes</button>
      </div>
    </div>
  </div>
</div>