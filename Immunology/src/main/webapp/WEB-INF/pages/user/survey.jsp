<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>

		<meta charset="utf-8">
		<title>Immunology</title>
		<meta name="description" content="description">
		<meta name="author" content="DevOOPS">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL,
		pageContext.request.requestURI, pageContext.request.contextPath)}" />
		
		 <jsp:include page="/WEB-INF/pages/head.jsp">
    		<jsp:param value="${baseURL}" name="baseURL"/>
    	</jsp:include>


	</head>
	
	
	
<body>


<!--Start Header-->
	<jsp:include page="/WEB-INF/pages/user/components/navbar.jsp"></jsp:include>
<!--End Header-->
<!--Start Container-->
<div id="main" class="container-fluid">
	<div class="row">
		<div id="sidebar-left" class="col-xs-2 col-sm-2">
			<ul class="nav main-menu">
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-user"></i>
						 <span class="hidden-xs">Мої пацієнти</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="#" onclick="doAjaxGet('patients/new');">Додати нового пацієнта</a></li>
						<li><a class="ajax-link" href="#" onclick="doAjaxGet('patients/my');">Список моїх пацієнтів</a></li>
					</ul>
				</li>
				
				<li>
					<a href="#" class="" onclick="doAjaxGet('patients/all');">
						<i class="fa fa-users"></i>
						<span class="hidden-xs">Всі пацієнти</span>
					</a>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle">
						<i class="fa fa-align-left"></i>
						 <span class="hidden-xs">Аналітика</span>
					</a>
					<ul class="dropdown-menu">
						<li><a class="ajax-link" href="#" onclick="doAjaxGet('cabinet/analytic/block');">Аналітичний блок</a></li>
						<li><a class="ajax-link" href="#" onclick="doAjaxGet('cabinet/analytic/charts');">Діаграми</a></li>
					</ul>
				</li>

			
			</ul>
		</div>
		<!--Start Content-->
		<div id="content" class="col-xs-12 col-sm-10">
		<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Головна</a></li>
			<li><a href="#">Мої пацієнти</a></li>
			<li><a href="#">${patient.firstName} ${patient.lastName}</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-user"></i> <span>${patient.firstName}
						${patient.lastName}</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
				<div id="tabs" style="display: none">
					<ul>
						<li><a href="#tabs-1">Скарги</a></li>
						<li><a href="#tabs-2">Клінічні прояви</a></li>
						<li><a href="#tabs-3">Лабораторні дані</a></li>
					</ul>
					<div id="tabs-1">
						<div id="complaints" class="form-container" ></div>
					</div>
					<div id="tabs-2">
						<div id="clinicalManifestations" class="form-container" ></div>
					</div>
					<div id="tabs-3">
						<div id="laboratoryData" class="form-container">
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input type="hidden" id="patient_id" value="${patient.id}"/>
		</div>
		<!--End Content-->
	</div>
</div>
	<jsp:include page="/WEB-INF/pages/base-scripts.jsp">
		<jsp:param value="${baseURL}" name="baseURL"/>
	</jsp:include>
	
	
	
	
<script type="text/javascript">

var complaintsData  = new Builder("complaintsData");
var clinicalManifestationData  = new Builder("clinicalManifestationData");
var laboratoryData  = new Builder("laboratoryData");

$(document).ready(function() {
	$("#tabs").tabs();
	$("#tabs").css("display", "inline");
	complaintsData.initNewSurveyForm("#complaints", "ComplaintsForm", $('#patient_id').val(), "Test syndrome") ;
	laboratoryData.initNewSurveyForm('#laboratoryData', "LaboratoryDataForm", $('#patient_id').val(), "Test syndrome");
	clinicalManifestationData.initNewSurveyForm('#clinicalManifestations', "ClinicalManifestationsForm", $('#patient_id').val(), "Test syndrome");
});

function doAjaxGet(pageName) {
    $.ajax({
        type: "GET",
        url: "/" + pageName,
        success: function(response) {
            $("#content").html(response);
        }
    });
}
function doAjaxPost(pageName) {
	console.info('doAjaxPost()');
    $.ajax({
        type: "POST",
        url: "/" + pageName,
        success: function(response) {
            $("#content").html(response);
        }
    });
    
    
    
}

</script>
	
</body>

</html>