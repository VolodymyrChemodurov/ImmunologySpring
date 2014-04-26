<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="baseURL"
	value="${fn:replace(pageContext.request.requestURL,
		pageContext.request.requestURI, pageContext.request.contextPath)}" />
<jsp:include page="/WEB-INF/pages/head.jsp">
	<jsp:param value="${baseURL}" name="baseURL" />
</jsp:include>
</head>
<body>

	<div id="wrapper">

		<jsp:include page="admin-navbar.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">User management</h1>

					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">Users</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover"
											id="user-dataTable">
											<thead>
												<tr>
													<th>User id</th>
													<th>First name</th>
													<th>Middle name</th>
													<th>Last name</th>
													<th>Login</th>
													<th>Roles</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${users}" var="user">
													<tr class="odd gradeX">
														<th>${user.id}</th>
														<th>${user.firstName}</th>
														<th>${user.middleName}</th>
														<th>${user.lastName}</th>
														<th>${user.login}</th>
														<th>
															<c:forEach items="${user.roles}" var="role" varStatus="index">
																<c:choose>
																	<c:when test="${index.index eq 0}">
																		${role.roleName}
																	</c:when>
																	<c:otherwise>
																		, ${role.roleName}
																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</th>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<jsp:include page="/WEB-INF/pages/base-scripts.jsp">
		<jsp:param value="${baseURL}" name="baseURL" />
	</jsp:include>

</body>
</html>