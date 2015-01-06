<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="/resources/css/login-page.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<img src="/resources/img/immunology_logo.png" style="width: 20%"/>
		<span class="logo-text">IMMUNOLOGY</span>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Вхід в систему</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="<c:url value='j_spring_security_check' />" method="POST">
							<fieldset>
								<c:if test="${param.fail == true}">
									<div id="error_block" class="form-group has-error">
										<label class="control-label" for="inputError">Неправильній логін або пароль</label>
									</div>
								</c:if>
								<div class="form-group">
									<input class="form-control" placeholder="Логін" autofocus id="inputLogin" name='j_username'>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Пароль" type="password" id="inputPassword" name='j_password'>
								</div>
								<button type="submit" class="btn btn-lg btn-primary btn-block">Увійти</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>