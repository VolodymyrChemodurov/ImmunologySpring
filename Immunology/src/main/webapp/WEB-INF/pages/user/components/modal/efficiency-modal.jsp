<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				<div class="col-sm-12" style="padding: 0px">
					<div class="col-sm-4" style="float: left; padding: 0px;">
						<div class="effinciency_div_first" style="margin-left: 0px; margin-right: 0px;">Переносимість
							препарату</div>
						<div class="effinciency_div_first" style="margin-left: 0px; margin-right: 0px;">Оцінка
							ефект. препарату</div>
						<div class="effinciency_div_first" style="margin-left: 0px; margin-right: 0px;">Опис
							ПЕ</div>
						<div class="effinciency_div_first" style="margin-left: 0px; margin-right: 0px;">Ступінь
							вираженості ПЕ</div>
						<div class="effinciency_div_first" style="margin-left: 0px; margin-right: 0px;">Вимагає
							скасування?</div>
					</div>
					<div class="col-sm-4">
						<select id="drug_tolerance" name="drug_tolerance" class="form-control dropdown effinciency_select">
							<option value="GOOD">Добра</option>
							<option value="SATISFYING">Задовільна</option>
							<option value="BAD">Незадовільна</option>
						</select> 
						<select id="efficacy_evaluation" name="efficacy_evaluation" class="form-control dropdown effinciency_select">
							<option value="NO_EFFECT">Відсутність ефекту</option>
							<option value="HIGH">Висока (позит. динаміка > 70)</option>
							<option value="MODERATE">Помірна (позит. динаміка 50-70)</option>
						</select> 
						<input id="side_effect_description" name="side_effect_description" type="text" class="form-control" style="margin-left:9px"/> 
						<select id="side_effects_severity_degree" name="side_effects_severity_degree" class="form-control dropdown effinciency_select">
							<option value="LIGHT">Легкий</option>
							<option value="MIDDLE">Середній</option>
							<option value="HARD">Тяжкий</option>
						</select> 
						<select id="cancel" name="cancel" class="form-control dropdown effinciency_select">
							<option value="true">Так</option>
							<option value="false">Ні</option>
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
			<div class="modal-footer" style="margin-top: 180px;">
				<button type="button" class="btn btn-primary"
					id="save-sub-efficiency-button" data-dismiss="modal">Зберегти</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Закрити</button>
			</div>
		</div>
	</div>
</div>