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
		<meta name="description" content="description">
		<meta name="author" content="DevOOPS">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL,
		pageContext.request.requestURI, pageContext.request.contextPath)}" />
		
		 <jsp:include page="/WEB-INF/pages/head-user.jsp">
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
				<li>
					<a href="#" class="active"  onclick="doAjaxGet('patients/my');" >
						<i class="fa fa-user"></i>
						<span class="hidden-xs">My Patients</span>
					</a>
				</li>
				<li>
					<a href="#" class="active " onclick="doAjaxGet('patients/all');">
						<i class="fa fa-users"></i>
						<span class="hidden-xs">All Patients</span>
					</a>
				</li>
				<li>
					<a href="#" class="active " onclick="doAjaxGet('analitic');">
						<i class="fa fa-align-left"></i>
						<span class="hidden-xs">Analitic</span>
					</a>
				</li>

			
			</ul>
		</div>
		<!--Start Content-->
		<div id="content" class="col-xs-12 col-sm-10">
			<jsp:include page="/WEB-INF/pages/user/components/new-patient.jsp"></jsp:include>
		
		</div>
		<!--End Content-->
	</div>
</div>
	<jsp:include page="/WEB-INF/pages/base-user-scripts.jsp">
		<jsp:param value="${baseURL}" name="baseURL"/>
	</jsp:include>
	
	
<script type="text/javascript">
function doAjaxGet(pageName) {
	//console.info('doAjaxPost()');
    $.ajax({
        type: "GET",
        url: "/Immunology/cabinet/"+pageName,
        success: function(response) {
           // console.log(response);
            $("#content").html(response);
        }
    });
  //  console.info('done doAjaxPost()');
}
function doAjaxPost(pageName) {
	console.info('doAjaxPost()');
    $.ajax({
        type: "POST",
        url: "/Immunology/cabinet/"+pageName,
        success: function(response) {
           // console.log(response);
            $("#content").html(response);
        }
    });
  //  console.info('done doAjaxPost()');
}


function AllTables(){
	//TestTable1();
	//TestTable2();
	TestTable3();
	LoadSelect2Script(MakeSelect2);
}
function MakeSelect2(){
	$('select').select2();
	$('.dataTables_filter').each(function(){
		$(this).find('label input[type=text]').attr('placeholder', 'Search');
	});
}
$(document).ready(function() {
	// Load Datatables and run plugin on tables 
	LoadDataTablesScripts(AllTables);
	// Add Drag-n-Drop feature
	WinMove();
});
function aaa(){
	alert('sdsd');
	// Load Datatables and run plugin on tables 
	LoadDataTablesScripts(AllTables);
	// Add Drag-n-Drop feature
	WinMove();
}
</script>
	
</body>

</html>
