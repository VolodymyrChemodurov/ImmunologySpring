<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Main</a></li>
			<li><a href="#">My patients</a></li>
		</ol>
	</div>
</div>
<div>

<!--  	<button type="button"
			class="btn btn btn-primary" onclick="doAjaxGet('patient/new')">Add new Patient</button> -->
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-users"></i> <span>Your patients list</span>
				</div>
				<div class="box-icons">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="expand-link"> <i class="fa fa-expand"></i>
					</a> <a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
				<div class="no-move"></div>
			</div>
			<div class="box-content no-padding">
				<table
					class="table table-bordered table-striped table-hover table-heading table-datatable"
					id="datatable-3">
					<thead>
						<tr>
							<th>First name</th>
							<th>Last name</th>
							<th>date of birth</th>
							<th>Country</th>
							<th>City</th>
							<th>Street, house</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${myPatients}" var="patient">
							<tr onclick="doAjaxGet('patient/id=${patient.id}')">
								
								<td>${patient.firstName}</td>
								<td>${patient.lastName}</td>
								<td>${patient.dateOfBirth}</td>
								<td>${patient.country}</td>
								<td>${patient.city}</td>
								<td><c:out value="${patient.street}, ${patient.house}"></c:out></td>
								
								
							</tr>
							
						</c:forEach>


					</tbody>
					<tfoot>
						<tr>
							<th>First name</th>
							<th>Last name</th>
							<th>date of birth</th>
							<th>Country</th>
							<th>City</th>
							<th>Street, house</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	//Run Datables plugin and create 3 variants of settings
	function AllTables() {
		TestTable3();
		Select2Script(MakeSelect2);
	}
	function MakeSelect2() {
		$('select').select2();
		$('.dataTables_filter').each(
				function() {
					$(this).find('label input[type=text]').attr('placeholder',
							'Search');
				});
	}
	$(document).ready(function() {
		// Load Datatables and run plugin on tables 
		DataTablesScripts(AllTables);
		// Add Drag-n-Drop feature
		WinMove();
	});
</script>
</html>