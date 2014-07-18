	<!-- Modal  Panel-->
<div class="modal fade" id="create-sub-panel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
       	
			<label class="col-sm-12 control-label">Set Panel Name:</label>
			<input type="text" class="form-control"  id="panelName" />
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick='createPanel($("#panelName").val())'>Save changes</button>
      </div>
    </div>
  </div>
</div>