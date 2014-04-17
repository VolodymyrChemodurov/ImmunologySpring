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

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="<c:url value='j_spring_security_check' />" method="POST">
							<fieldset>
								<c:if test="${param.fail == true}">
									<div id="error_block" class="form-group has-error">
										<label class="control-label" for="inputError">Wrong login or password</label>
									</div>
								</c:if>
								<div class="form-group">
									<input class="form-control" placeholder="login" autofocus id="inputLogin" name='j_username'>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" type="password" id="inputPassword" name='j_password'>
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">Remember Me
									</label>
								</div>
								<button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
    <jsp:include page="/WEB-INF/pages/base-scripts.jsp">
    	<jsp:param value="${baseURL}" name="baseURL"/>
    </jsp:include>
</body>
</html>