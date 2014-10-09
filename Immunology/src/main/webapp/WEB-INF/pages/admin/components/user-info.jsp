<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.sub-panel .col-sm-7{
padding-left: 4px;
}
.DTTT{
display: none;
}

</style>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="index.html">Головна</a></li>
			<li><a href="#">Мої пацієнти</a></li>
			<li><a href="#">${user.firstName} ${user.lastName}</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-user"></i> <span>${user.firstName}
						${user.lastName}</span>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content">
			<fieldset>
				
				<div class="col-xs-6">
				<label class="control-label">Current user syndroms:</label>
					<select multiple="" class="form-control">
						<c:forEach items="${syndromes}" var="syndrom">
								<option>${syndrom}</option>
						</c:forEach>
					</select>
				
				<label class="control-label">Add new syndrom:</label>
				
				<select class="form-control">
					<c:forEach items="${allSyndroms}" var="syndrom">
								<option>${syndrom}</option>
						</c:forEach>
				</select>
				<button class="btn btn-primary" style="margin-top: 10px; width: 30%;">Add</button>
				</div>
				
			</fieldset>
			</div>
		</div>
	</div>

	<input type="hidden" id="user_id" value="${user.id}"/>




<script type="text/javascript">


</script>
