<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Immunology</title>
		
		<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL,
		pageContext.request.requestURI, pageContext.request.contextPath)}" />
		
		 <jsp:include page="/WEB-INF/pages/head.jsp">
    		<jsp:param value="${baseURL}" name="baseURL"/>
    	</jsp:include>
	</head>
<body>
	<jsp:include page="/WEB-INF/pages/admin/components/navbar.jsp"></jsp:include>
	
	<div id="main" class="container-fluid">
		<div class="row">
			<div id="sidebar-left" class="col-xs-2 col-sm-2">
				<ul class="nav main-menu">
					<li class="dropdown">
						<a href="#" class="active dropdown-toggle">
							<i class="fa fa-user"></i>
						 	<span class="hidden-xs">Users</span>
						</a>
						<ul class="dropdown-menu">
							<li><a class="ajax-link" href="#" onclick="doAjaxGet('/user/create');">Add new user</a></li>						
							<li><a class="ajax-link" href="#"  onclick="doAjaxGet('/users');">All users</a></li>
						</ul>
					</li>
					<li>
						<a href="#"  data-toggle="modal" data-target="#formula-modal" class="ajax-link">
							<i class="fa fa-flask"></i> 
							<span class="hidden-xs">Analitic Block</span>
						</a>
					</li>
					<li>
						<a href="#" onclick="doAjaxGet('/medcard');" class="ajax-link">
							<i class="fa fa-file-o"></i>
							<span class="hidden-xs">Medical Card</span>
						</a>
					</li>
				
					
					
					<li id="survey-parent" class="dropdown">
						<a  href="#"  class="dropdown-toggle">
							<i class="fa fa-pencil-square-o"></i>
						 	<span class="hidden-xs">Survey Forms</span>
						</a>
						<ul class="dropdown-menu">
						<li class="dropdown">
							<li>
								<a href="#"  data-toggle="modal" data-target="#new-syndrom-modal" class="ajax-link">
									<span class="hidden-xs">New Syndrom</span>
								</a>
							</li>
							
							
						
							<li class="dropdown">
								<a href="#" class="dropdown-toggle active-parent active">
									<i class="fa fa-plus-square"></i>
									<span class="hidden-xs">Survey Forms</span>
								</a>
								<ul class="dropdown-menu" style="display: block;">
									<li><a class="ajax-link" href="#"  data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'comlaints'">Complaints Form</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'clinicalManifestation'" >Clinical Manifestation Form</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'laboratoryData'" >Laboratory Data Form</a></li>
									
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'morphologicalData'" >Morphological Data</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'instrumentalData'" >Instrumental Data</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'diagnosisVerificationData'" >DiagnosisVerificationData Form</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'mainTreatmentData'" >Main Treatment Data Form</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'rehabilitationData'" >Rehabilitation Data Form</a></li>
									<li><a class="ajax-link" href="#" data-toggle="modal" data-target="#select-syndrom-modal" onclick="formType = 'preventiveMeasuresData'" >Preventive Measures Data Form</a></li>
								</ul>
							</li>
						</li>
						</ul>
					</li>
				</ul>
			</div>
			
			<div id="content" class="col-xs-12 col-sm-10">
				<div class="preloader">
					<img src="${param.baseURL}/resources/img/devoops_getdata.gif" class="devoops-getdata" alt="preloader"/>
				</div>
				<div id="ajax-content"></div>
			</div>
			
		</div>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/new-panel-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/new-sub-panel-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/new-textbox-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/new-dropdown-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/new-group-button.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/remove-element-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/modal/coeficient-modal.jsp"></jsp:include>
			<!-- Anamnestic DATA -->
			<div class="modal fade" id="select-syndrom-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
							<select class="form-control" name="syndrrom-names">
							<c:forEach items="${syndromes}" var="syndrome">
    							<option>${syndrome}</option>
							</c:forEach>
							</select>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" onclick="doAjaxGet('anamnestic'); initSurveyForm($('select[name=syndrrom-names]')[0].value)" data-dismiss="modal">Choose</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- NEW SYNDROM DATA -->
			<div class="modal fade" id="new-syndrom-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Syndroms</h4>
						</div>
						<div class="modal-body">
						
							<label class="col-sm-12 control-label">Set syndrom name:</label>
							<input type="text" class="form-control" id="new-syndrom-name">
							
							<label class="col-sm-12 control-label">Select syndrom as a parent syndrom</label> 
							<select name="parent-syndrom-name" class="form-control">
							<option>None</option>
							<c:forEach items="${syndromes}" var="syndrome">
    							<option>${syndrome}</option>
							</c:forEach>
							</select>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" id="save-syndrom-button" class="btn btn-primary" data-dismiss="modal">Save</button>
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- 			Analitic Block <Formula> -->
	<div class="modal fade" id="formula-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
							<select class="form-control" id="syndrrom-names" name="syndrrom-names" style="margin-bottom: 20px;">
							<c:forEach items="${syndromes}" var="syndrome">
    							<option>${syndrome}</option>
							</c:forEach>
							</select>
							<label class="col-sm-12 control-label" style="margin-left: 10px;">Severity Level formula:</label> 
							<h3 style="width: 3%; float: left;">Σ</h3><input type="text" class="form-control" id="severity-formula" style="width: 96%; float: right;">
							<small style="float: right;">You can use such symbols: ' * ' , ' ^ ' , ' / ' , ' X ' ; Х - is the coeficient value </small>
							<label class="col-sm-12 control-label"  style="margin-left: 10px;">Insufficiency Level formula</label>
							<h3 style="width: 3%; float: left;">Σ</h3><input type="text" class="form-control" id="insufficiency-formula" style="width: 96%; float: right;">
							<small style="float: right;">You can use such symbols: ' * ' , ' ^ ' , ' / ' , ' X ' ; Х - is the coeficient value </small>
							<div class="modal-footer" style="margin-top: 160px; height: 40px;">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="sendFormulaValues();">Save</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
	
	<jsp:include page="/WEB-INF/pages/base-scripts.jsp">
		<jsp:param value="${baseURL}" name="baseURL"/>
	</jsp:include>
	
	<script type="text/javascript">
	//neads for recognize what form you try to show;
	var formType = "None"; 
	
	
	function doAjaxGet(pageName) {
    	$.ajax({
        	type: "GET",
        	async:   false,
        	url: "/admin/"+pageName,
        	success: function(response) {
            	$("#content").html(response);
        	}
    	});
	}
	function reloadPageUSingUrl(url){
		$.ajax({
        	type: "GET",
        	async:   false,
        	url: url,
        	success: function(response) {
            	$("#content").html(response);
        	}
    	});
	}
	$(document).ready(function(){
		doAjaxGet('/users');
		$("#save-syndrom-button").click(function(){
			createNewSyndrom();	
			location.reload();
			
		});
		
	});
	
	function createNewSyndrom(){
		var syndromName = $("#new-syndrom-modal").find("input").val();
		var parentSyndromName = $("#new-syndrom-modal").find("select").val(); 
		var newSyndromObject = {};
		
		if(parentSyndromName == "None"){
			newSyndromObject = {};
			newSyndromObject["name"] = syndromName;
			newSyndromObject["surveys"] = [];
			
			
			
			newSyndromObject["anamnesticData"] = {};
			
			var anamnesticData = {};
			anamnesticData["name"] = "";
			anamnesticData["objectType"] = "AnamnesticDataForm";
			anamnesticData["panels"] = [];
			newSyndromObject.anamnesticData = anamnesticData;
			
			
			var survey = {};
			survey["complaintsForm"]= {};
			 var  complaintsForm = {};
			 complaintsForm["name"] = "";
			 complaintsForm["panels"] = [];
			 complaintsForm["objectType"] = "ComplaintsForm";
			 survey.complaintsForm = complaintsForm;
			 
			survey["clinicalManifestationsForm"] ={};
			 var clinicalManifestationsForm = {};
			 clinicalManifestationsForm["name"] = ""; 
			 clinicalManifestationsForm["panels"] = [];
			 clinicalManifestationsForm["objectType"] = "ClinicalManifestationsForm"
			 survey.clinicalManifestationsForm = clinicalManifestationsForm;
				 
			survey["laboratoryDataForm"]= {};
			 var laboratoryDataForm = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "LaboratoryDataForm";
			 survey.laboratoryDataForm = laboratoryDataForm;
			 
			 survey["morphologicalData"]= {};
			 var morphologicalData = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "MorphologicalData";
			 survey.laboratoryDataForm = morphologicalData;
			 
			 survey["instrumentalData"]= {};
			 var instrumentalData = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "InstrumentalData";
			 survey.instrumentalData = instrumentalData;
			 
			 survey["diagnosisVerificationData"]= {};
			 var diagnosisVerificationData = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "DiagnosisVerificationData";
			 survey.diagnosisVerificationData = diagnosisVerificationData;
			 
			 survey["mainTreatmentData"]= {};
			 var mainTreatmentData = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "MainTreatmentData";
			 survey.mainTreatmentData = mainTreatmentData;
			 
			 survey["rehabilitationData"]= {};
			 var rehabilitationData = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "RehabilitationData";
			 survey.rehabilitationData = rehabilitationData;
			 
			 survey["preventiveMeasuresData"]= {};
			 var preventiveMeasuresData = {};
			 laboratoryDataForm["name"] = "";
			 laboratoryDataForm["panels"] = [];
			 laboratoryDataForm["objectType"] = "PreventiveMeasuresData";
			 survey.preventiveMeasuresData = preventiveMeasuresData;
			
			 
			 newSyndromObject.surveys.push(survey);
			 //response.surveys.push(survey);
			
		}else{
		// Get Parent Template;
		$.ajax({
			type : "get",
			url : "/syndromes/template/{name}".replace("{name}", parentSyndromName),
			dataType : "json",
			async:   false,
			success : function(response) {
				newSyndromObject = response;
				newSyndromObject.name = syndromName
			},
			error: function (request, status, error) {
				alert(error);
		    }

		});
			
		}
		
		//Save new Syndrom;
		$.ajax({
			  type:"POST", 
		      url:"/syndromes/template",
		      data: JSON.stringify(newSyndromObject),
		      contentType: "application/json; charset=utf-8",
		      dataType: "json",
		      async:   false,
		      success: function(response){
		    	  console.log("Success Save");
		      },
			
			error: function (request, status, error) {
				alert(error);
		}});
		
	}
	function getFormulaForSyndrom(formulaType){
		 var syndromName = $("#syndrrom-names").val();
		 var url= "/syndromes/template/{name}/{formulaType}".replace("{formulaType}",formulaType).replace("{name}",syndromName)
		 $.ajax({
			  type:"GET", 
		      url: url,
		     // dataType: "json",
		      async:   false,
		      success: function(response){
		    	 console.log(response);
		    	 if(formulaType == "severityLevel"){
		    		 $("#severity-formula").val(response);
		    	 }
		    	 if(formulaType == "insufficiencyLevel"){
		    		 $("#insufficiency-formula").val(response);
		    	 }
		    	 
		      },
			
			error: function (request, status, error) {
				console.log(formulaType +"= null;");
		}});
	}
	function saveFormulaForSyndrom(formulaType, formula){
		 var syndromName = $("#syndrrom-names").val();
		 var url= "/syndromes/template/{name}/{formulaType}".replace("{formulaType}",formulaType).replace("{name}",syndromName)
		$.ajax({
			  type:"POST", 
		      url: url,
		      data:  {"formula": formula},
		      dataType: "json",
		      async:   false,
		      success: function(response){
		    	 console.log(response);
		      },
			
			error: function (request, status, error) {
				alert(error);
		}});
	}
	function sendFormulaValues(){
		var severity = $("#severity-formula").val();
		var insufficiency = $("#insufficiency-formula").val();
		
		saveFormulaForSyndrom("severityLevel", severity);
		saveFormulaForSyndrom("insufficiencyLevel", insufficiency);
		
	}
	function refreshFormulaValues(){
		getFormulaForSyndrom("severityLevel");
		getFormulaForSyndrom("insufficiencyLevel");
	}
	
	$( document ).ready(function() {
		refreshFormulaValues();
	});
	
	
	</script>
	
</body>

</html>