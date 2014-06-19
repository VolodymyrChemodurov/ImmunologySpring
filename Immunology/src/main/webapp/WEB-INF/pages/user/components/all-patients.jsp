<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Main</a></li>
			<li><a href="#">All patients</a></li>
		</ol>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<i class="fa fa-users"></i> <span>All patients list</span>
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
							<th>Add to my patients</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allPatients}" var="patient">
							<tr>
								<td>${patient.key.firstName}</td>
								<td>${patient.key.lastName}</td>
								<td>${patient.key.dateOfBirth}</td>
								<td>${patient.key.country}</td>
								<td>${patient.key.city}</td>
								<td><c:out value="${patient.key.street}, ${patient.key.house}"></c:out></td>
								<td width="150px" align="center">
									<c:if test="${!patient.value}">
										<button id="button" class="btn btn-primary"
										onclick="doAjaxPost('patient/id=${patient.key.id}')">Add</button>
									</c:if>
									

								</td>
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
							<th>Add to my patients</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	// Run Datables plugin and create 3 variants of settings
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