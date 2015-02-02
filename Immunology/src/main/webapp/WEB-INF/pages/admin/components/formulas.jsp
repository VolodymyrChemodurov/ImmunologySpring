<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#" onclick="doAjaxGet('/users');">Головна</a></li>
			<li>Формули</li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-users"></i>
					<span>Налаштування формул</span>
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
				<label class="col-sm-12 control-label">Вибрати синдром:</label> 
				<select class="form-control" id="syndrrom-names" name="syndrrom-names" style="margin-bottom: 20px;">
				<c:forEach items="${syndromes}" var="syndrome">
					<option>${syndrome}</option>
				</c:forEach>
				</select> 
				<label class="col-sm-12 control-label" style="margin-left: 10px;">Формула обрахунку степені важкості:</label>
				<h3 style="width: 3%; float: left;">Σ</h3>
				<input type="text" class="form-control" id="severity-formula" style="width: 96%; float: right;"> 
				<small style="float: right;">Можна використовувати наступні символи: ' * ' , ' ^ ' , ' / ' , ' X ' ; де Х - значення коефіцієнта</small>
				<label class="col-sm-12 control-label" style="margin-left: 10px;">Формула обрахунку степені недостатності:</label>
				<h3 style="width: 3%; float: left;">Σ</h3>
				<input type="text" class="form-control" id="insufficiency-formula" style="width: 96%; float: right;"> 
				<small style="float: right;">Можна використовувати наступні символи: ' * ' , ' ^ ' , ' / ' , ' X ' ; де Х - значення коефіцієнта</small>
				<div class="modal-footer" style="margin-top: 160px; height: 40px;">
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="sendFormulaValues();">Зберегти</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
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