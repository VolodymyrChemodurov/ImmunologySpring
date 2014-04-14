<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
		<a class="navbar-brand" href="index.html">Immunology</a>
	</div>

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li>
					<a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
				</li>
				<li class="divider"></li>
				<li>
					<a href="Immunology/<c:url value="j_spring_security_logout" />"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
				</li>
			</ul>
		</li>
	</ul>

	<div class="navbar-default navbar-static-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="side-menu">
				<li>
					<a href="index.html"><i class="fa fa-user fa-fw"></i>Users</a>
				</li>
			</ul>
		</div>
	</div>
	
</nav>