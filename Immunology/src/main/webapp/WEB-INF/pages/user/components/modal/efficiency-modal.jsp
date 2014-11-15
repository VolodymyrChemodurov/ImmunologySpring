<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- Modal  Panel-->
<div class="modal fade" id="efficiency-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:50%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="SetEfficiencyOfDrug">Встановити
					ефективність препарату</h4>
			</div>
			<div class="modal-body">
				<div class="col-sm-12">
					<div class="col-sm-4" style="float: left">
						<div class="effinciency_div_first">Переносимість
							препарату</div>
						<div class="effinciency_div_first">Оцінка
							ефективності препарату</div>
						<div class="effinciency_div_first">Опис
							ПЕ</div>
						<div class="effinciency_div_first">Ступінь
							вираженості ПЕ</div>
						<div class="effinciency_div_first">Вимагає
							скасування?</div>
					</div>
					<div class="col-sm-4">
						<select name="drug_tolerance" class="form-control dropdown effinciency_select">
							<option value="good">Добра</option>
							<option value="satisfactory">Задовільна</option>
							<option value="poor">Незадовільна</option>
						</select> <select name="efficacy_evaluation" class="form-control dropdown effinciency_select">
							<option value="without">Відсутність ефекту</option>
							<option value="high">Висока (позит. динаміка > 70)</option>
							<option value="moderate">Помірна (позит. динаміка 50-70)</option>
						</select> <input name="side_effect_description" type="text" class="form-control" style="margin-left:9px"/> <select
							name="side_effects_severity_degree" class="form-control dropdown effinciency_select">
							<option value="easy">Легкий</option>
							<option value="middle">Середній</option>
							<option value="hard">Тяжкий</option>
						</select> <select name="cancel" class="form-control dropdown effinciency_select">
							<option value="yes">Так</option>
							<option value="no">Ні</option>
						</select>
					</div>
					<div class="col-sm-4" style="float: right">
						<div class="effinciency_div_second"></div>
						<div class="effinciency_div_second"></div>
						<div class="effinciency_div_second"></div>
						<div class="effinciency_div_second"></div>
						<div class="effinciency_div_second"></div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					id="save-sub-efficiency-button" data-dismiss="modal">Зберегти</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
			</div>
		</div>
	</div>
</div>