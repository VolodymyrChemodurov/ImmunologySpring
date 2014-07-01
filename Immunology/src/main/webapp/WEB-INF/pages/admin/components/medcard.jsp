<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Dashboard</a></li>
			<li><a href="#">Forms</a></li>
			<li><a href="#">Forms layouts</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-2">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<span>Instruments</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content" style="height: 300px;">
				<div class="col-sm-12">
					<label class="col-sm-12 control-label">Set Med.Card Name:</label>
					<input type="text" class="form-control" name="firstName" id="firstName" />
				</div>
				<div class="col-sm-12" style="margin-top: 5px;">
					<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#create-panel">Create Panel</button>
				</div>
				<div class="col-sm-12" style="margin-top: 5px;">
					<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#create-textbox" onclick="renderPanelNames();">Create TextBox</button>
				</div>
				<button type="button" class="btn btn-default btn-lg" onclick="renderPreviewMedForm();"> Save & Show</button>


			</div>
		</div>
	</div>
	

	<div class="col-xs-10">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<span>Instruments</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
			<div id="container"></div>
			</div>
		</div>
	</div>
	
	
	
	

	
	
	
</div>
	
<script type="text/javascript">
var jsonObj = [];
jsonObj["creationDate"] = "";
jsonObj["additionInfo"] = "";
jsonObj["panels"] = [];

$(document).ready(function() {
	
	
});
function renderPreviewMedForm(){
	
	renderMedicalForm(jsonObj);
	$('#container').html(formStructure);
	renderDropDownStyle();
	prepareForm();
	
}
function createPanel(title){
	panel = [];
	panel["name"] = title;
	panel["checked"] = false;
	panel["elements"] = [];
	jsonObj.panels.push(panel); 
	
}
function renderPanelNames(){
	panerNamesPreview ="";
	$(jsonObj.panels).each(function(index, panel) {
		panerNamesPreview += '<option>' + panel.name + '</option>';
	});
	$('#panelNames').html(panerNamesPreview);
}
function createTextBox(panelName, textBoxTitle){
	textBox = [];
	textBox["name"] = textBoxTitle;
	textBox["checked"] = false;
	textBox["objectType"] = "TextBox";
	$(jsonObj.panels).each(function(index, panel) {
		if(panel.name == panelName){
			jsonObj.panels[index].elements.push(textBox);
		}
	});
	
}




</script>
