<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL,
		pageContext.request.requestURI, pageContext.request.contextPath)}" />

    <jsp:include page="/WEB-INF/pages/head.jsp">
    	<jsp:param value="${baseURL}" name="baseURL"/>
    </jsp:include>
</head>
<body>
	<h2>Hello World!</h2>
	<a href="Immunology/<c:url value="j_spring_security_logout" />">Logout</a>
</body>
</html>
