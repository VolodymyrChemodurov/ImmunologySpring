<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Dashboard</a></li>
			<li><a href="#">Forms</a></li>
			<li><a href="#">Anamnestic Data</a></li>
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
				    <a href="#" data-toggle="modal" data-target="#create-textbox">
				      <span class="badge pull-right">0</span>
				      Create TextBox
				    </a>
				  </li>
				  <li class="active">
				    <a href="#" data-toggle="modal" style="background-color: #cc181e" data-target="#remove-element">
				      <span class="badge pull-right">0</span>
				     	Remove Element
				    </a>
				  </li>
				</ul>
				<div class="col-sm-5" style="margin-top: 5px;">
					<button type="button" name="save-button"  class="btn btn-default btn-lg" onclick="renderPreviewMedForm()"> Save & Show</button>
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
$(document).ready(function() {
	initAnamnestic();
	initEvents();
});
</script>
	