	<!-- Modal  Panel-->
<div class="modal fade" id="remove-element" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Element</h4>
      </div>
      <div class="modal-body">
      	<label class="col-sm-12 control-label">Select Panel Name:</label>
		<select name="panel-names">
		</select>
		<label class="col-sm-12 control-label">Set sub-Panel Name:</label>
		<select id="sp-remove" name="sub-panel-names" onclick="spClick();">
			<option value="-1">-EMPTY-</option>
		</select>
		<label class="col-sm-12 control-label">Set element Name:</label>
		<select name="element-title">
			<option value="-1">-EMPTY-</option>
		</select>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="remove-element-button" style="background-color: #cc181e" data-dismiss="modal">Remove</button>
      </div>
    </div>
  </div>
</div>