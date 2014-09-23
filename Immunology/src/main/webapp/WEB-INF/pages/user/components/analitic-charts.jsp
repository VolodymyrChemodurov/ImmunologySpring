<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Головна</a></li>
			<li><a href="#">Аналітика</a></li>
			<li><a href="#">Діаграми</a></li>
			
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-search"></i>
					<span>Plot with points</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link">
						<i class="fa fa-chevron-up"></i>
					</a>
					<a class="expand-link">
						<i class="fa fa-expand"></i>
					</a>
					<a class="close-link">
						<i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<div id="xchart-1" style="height: 200px; width: 100%;"></div>
			</div>
		</div>
	</div>
	
</div>
<script type="text/javascript">
// Draw all test xCharts
var patients = [];
var getPatientUrl = "/patients/getAll";

function getResources(){
	$.ajax({
		type : "get",
		url : getPatientUrl,
		dataType : "json",
		success : function(response) {
			console.log(response);
		},
		error: function (request, status, error) {
			alert(error);
	    }
	});
}



$(document).ready(function() {
	getResources();
});
</script>
