<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Main</a></li>
			<li><a href="#">Users</a></li>
			<li><a href="#">All users</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-users"></i>
					<span>All users list</span>
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
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-3">
					<thead>
						<tr>
							<th>First name</th>
							<th>Last name</th>
							<th>Middle name</th>
							<th>Login</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user"> 
							<tr  onclick="reloadPageUSingUrl('users/${user.id}')">
								<td>${user.firstName}</td>
								<td>${user.lastName}</td>
								<td>${user.middleName}</td>
								<td>${user.login}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function AllTables(){
	TestTable3();
	Select2Script(MakeSelect2);
}
function MakeSelect2(){
	$('select[name=datatable-3_length').select2();
	$('#dropdownValues').select2();
	$('.dataTables_filter').each(function(){
		$(this).find('label input[type=text]').attr('placeholder', 'Search');
	});
}
$(document).ready(function() {
	DataTablesScripts(AllTables);
});
</script>

</html>