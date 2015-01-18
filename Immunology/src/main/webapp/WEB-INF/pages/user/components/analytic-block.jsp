<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#" onclick="doAjaxGet('patients/my');">Головна</a></li>
			<li>Аналітика</li>
			<li><a href="#">Аналітичний блок</a></li>
			
		</ol>
	</div>
</div>
  <table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>№</th>
							<th>Назва препарату</th>
							<th>Переносимість апарату</th>
							<th>Оцінка ефективності препарату</th>
							<th>Опис</th>
							<th>Ступінь вираженості ПЕ</th>
							<th>Вимагає скасування препарату?</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Алергени пилкові</td>
							<td>добра</td>
							<td>помірна (позит. динаміка 50-70)</td>
							<td>опис-опис-опис</td>
							<td>середній</td>
							<td>ні</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Алергени ще якісь</td>
							<td>задовільна</td>
							<td>відсутність ефекту</td>
							<td>опис-опис-опис</td>
							<td>тяжкий</td>
							<td>так</td>
						</tr>
						<tr>
							<td>3</td>
							<td>IІ ще якісь алергени</td>
							<td>незадовільна</td>
							<td>відсутність ефекту</td>
							<td>опис-опис-опис</td>
							<td>середній</td>
							<td>так</td>
						</tr>
					</tbody>
				</table> 

</body>
</html> 