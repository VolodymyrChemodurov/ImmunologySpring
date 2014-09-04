<!-- Modal  Panel-->
<meta charset="utf-8">
<div class="modal fade" id="select-syndrom-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Syndroms</h4>
			</div>
			<div class="modal-body">
				<label class="col-sm-12 control-label">Select Syndrom:</label> 
				<select name="syndrrom-names">
					<c:forEach items="${syndromes}" var="syndrome">
    					<option>${syndrome}</option>
					</c:forEach>
				</select>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="doAjaxGet('anamnestic');" data-dismiss="modal">Choose</button>
				</div>
			</div>
		</div>
	</div>
