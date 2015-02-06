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
<jsp:include page="/WEB-INF/pages/loading-screen.jsp" />
<jsp:include page="/WEB-INF/pages/user/components/modal/efficiency-modal.jsp"></jsp:include>
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
						<li><a id = "addNewPatient" class="ajax-link" href="#" onclick="doAjaxGet('patients/new');">Додати нового пацієнта</a></li>
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
			<div class="preloader">
				<img src="${param.baseURL}/resources/img/devoops_getdata.gif" class="devoops-getdata" alt="preloader"/>
			</div>
			<div id="ajax-content"></div>
		</div>
		<!--End Content-->
	</div>	
</div>

<jsp:include page="/WEB-INF/pages/base-scripts.jsp">
	<jsp:param value="${baseURL}" name="baseURL"/>
</jsp:include>
<script src="${param.baseURL}/resources/js/user-page/js/user-main.js"></script>
<script src="${param.baseURL}/resources/js/user-page/js/efficiency.js"></script>
</body>
</html>
