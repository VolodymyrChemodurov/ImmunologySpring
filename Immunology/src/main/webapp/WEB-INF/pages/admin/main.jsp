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
							<li><a class="ajax-link" href="#"  onclick="doAjaxGet('/users');">All users</a></li>
						</ul>
					</li>
					<li>
						<a href="#" onclick="doAjaxGet('/medcard');" class="ajax-link">
							<i class="fa fa-dashboard"></i>
							<span class="hidden-xs">Medical Card</span>
						</a>
					</li>
					<li>
						<a href="#" data-toggle="modal" data-target="#select-syndrom-modal" class="ajax-link">
							<i class="fa fa-dashboard"></i>
							<span class="hidden-xs">Anamnestic data</span>
						</a>
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
			<jsp:include page="/WEB-INF/pages/admin/components/new-panel-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/new-sub-panel-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/new-textbox-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/new-dropdown-modal.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/pages/admin/components/remove-element-modal.jsp"></jsp:include>
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
							<select name="syndrrom-names">
							<c:forEach items="${syndromes}" var="syndrome">
    							<option>${syndrome}</option>
							</c:forEach>
							</select>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" onclick="doAjaxGet('anamnestic'); initAnamnestic($('select[name=syndrrom-names]')[0].value)" data-dismiss="modal">Choose</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	
	<jsp:include page="/WEB-INF/pages/base-scripts.jsp">
		<jsp:param value="${baseURL}" name="baseURL"/>
	</jsp:include>
	
	<script type="text/javascript">
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
	$(document).ready(function(){
		doAjaxGet('/users');
		});
	</script>
	
</body>

</html>
