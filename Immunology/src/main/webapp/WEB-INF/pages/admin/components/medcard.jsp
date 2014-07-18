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
	<div class="col-xs-3">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<span>Instruments</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content" style="height: 300px;">
					<input type="text" style="margin-bottom: 5px;" class="form-control" name="firstName" id="firstName"  placeholder="Med.Card Title"/>
				
				<ul class="nav nav-pills nav-stacked">
				  <li class="active">
				    <a href="#" data-toggle="modal" data-target="#create-panel">
				      <span class="badge pull-right">0</span>
				      Create Panel
				    </a>
				  </li>
				  <li class="active">
				    <a href="#" data-toggle="modal" data-target="#create-sub-panel">
				      <span class="badge pull-right">0</span>
				      Create Sub-Panel
				    </a>
				  </li>
				  <li class="active">
				    <a href="#" data-toggle="modal" data-target="#create-dropdown">
				      <span class="badge pull-right">0</span>
				      Create DropDown
				    </a>
				  </li>
				   <li class="active">
				    <a href="#" data-toggle="modal" data-target="#create-textbox" onclick="renderPanelNames();">
				      <span class="badge pull-right">0</span>
				      Create TextBox
				    </a>
				  </li>
				</ul>
				<div class="col-sm-5" style="margin-top: 5px;">
					<button type="button"  class="btn btn-default btn-lg" onclick="renderPreviewMedForm();"> Save & Show</button>
				</div>

			</div>
		</div>
	</div>
	

	<div class="col-xs-9">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<span>Quick view</span>
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
jsonObj["panels"] = new Array();

var dropDownValues = new Array();


function renderPreviewMedForm(){
	
	renderMedicalForm(jsonObj);
	$('#container').html(formStructure);
	renderDropDownStyle();
	//prepareForm(jsonObj);
	
}
function createPanel(title){
	panel = [];
	panel["name"] = title;
	panel["checked"] = false;
	panel["elements"] = [];
	jsonObj.panels.push(panel); 
	renderPanelNames();
	
}
function renderPanelNames(){
	panerNamesPreview ="";
	$(jsonObj.panels).each(function(index, panel) {
		panerNamesPreview += '<option>' + panel.name + '</option>';
	});
	$("select[name = 'panelNames']").each(function() {
		 $( this).html(panerNamesPreview);
		 console.log($( this));
	});
	
	
	
}
function createTextBox(panelName, textBoxTitle){
	textBox = [];
	textBox["name"] = textBoxTitle;
	textBox["checked"] = false;
	textBox["objectType"] = "TextBox";
	$(jsonObj.panels).each(function(index, panel) {
		console.log(panel.name + " - " + panelName);
		if(panel.name == panelName){
			jsonObj.panels[index].elements.push(textBox);
		}
	});
	
}
function createDropDown(panelNameInputId,dropDownTitleInputId){
	var panelTitle = $("#"+panelNameInputId).val();
	var dropDownTitle = $("#"+ panelNameInputId).val();
	var dropDown = [];
	
	console.log(panelNameInputId+" - "+dropDownTitleInputId);
	
	dropDown["name"]=dropDownTitle;
	dropDown["checked"] = false;
	dropDown["objectType"] ="DropDown";
	dropDown["values"] = dropDownValues;
	dropDownValues = [];
	
	$(jsonObj.panels).each(function(index, panel) {
		if(panel.name == panelTitle){
			alert();
			jsonObj.panels[index].elements.push(dropDown);
		}
	});
	
}

function addToDropDownFromInput(dropDownId,inputId){
	var dropDown = $("#"+dropDownId);
	var input = $("#"+ inputId);
	
	dropDownValues.push(input.val());
	
	dropDown.html(dropDown.html() + '<option>' + input.val() + '</option>');
	input.val("");
}




</script>
