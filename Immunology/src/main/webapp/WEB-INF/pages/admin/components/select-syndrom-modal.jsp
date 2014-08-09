	<!-- Modal  Panel-->
<div class="modal fade" id="select-syndrom-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
      	<label class="col-sm-12 control-label">Set Panel Name:</label>
       	<select name="syndrrom-names">
       		<option>Test Syndrom 1</option>
       		<option>Test Syndrom 2</option>
		</select>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="doAjaxGet('anamnestic');" data-dismiss="modal">Save changes</button>
      </div>
    </div>
  </div>
</div>