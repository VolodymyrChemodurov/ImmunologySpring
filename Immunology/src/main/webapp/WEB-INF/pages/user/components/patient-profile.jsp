<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form id="defaultForm" method="POST" action="/patients/update"  class="form-horizontal">
					<fieldset>
						<legend></legend>
						<div class="form-group">
												<div class="form-group">
							<label class="col-sm-3 control-label">Прізвище</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="lastName" id="lastName" value="${patient.lastName}"/>
							</div>
						</div>
							<label class="col-sm-3 control-label">Ім'я</label>
							<div class="col-sm-5">
								<input type="hidden" name="id" id="id" value="${patient.id}">
								<input type="text" class="form-control" name="firstName" id="firstName" value="${patient.firstName}" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">По-батькові</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="middleName" id="middleName" value="${patient.middleName}"/>
							</div>
						</div>
						
					
					</fieldset>
					<fieldset>
					<legend></legend>
					<div class="form-group">
							<label class="col-sm-3 control-label">Стать</label>
							<div class="col-sm-5">
								<select class="form-control dropdown" name="sex" id="sex" >
									<option value="${patient.sex}">${patient.sex}</option>
									<option value="чоловік">Чоловіча</option>
									<option value="жінка">Жіноча</option>
									
									
								</select>
							</div>
					</div>
					<div class="form-group has-feedback">
						<label class="col-sm-3 control-label">Дата народження</label>
						<div class="col-sm-5">
							<input type="text"  name="dateOfBirth" id="dateOfBirth" class="form-control" placeholder="Date" value="${patient.dateOfBirth}">
							<span class="fa fa-calendar form-control-feedback" id="datepicker"></span>
						</div>
						
						
					</div>
					</fieldset>	
					
					
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Країна</label>
							<div class="col-sm-5">
								<select class="form-control dropdown" name="country" id="country">
									<option value="${patient.country}">${patient.country}</option>
									<option value="Україна">Україна</option>
									<option value="Франція">Франція</option>
									<option value="Німеччина">Німеччина</option>
									<option value="Італія">Італія</option>
									<option value="Россія">Россія</option>
									<option value="Японія">Японія</option>
									<option value="Великобританія">Великобританія</option>
									<option value="США">США</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Регіон</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="region"  id="region" value="${patient.region}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Місто</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="city" id="city"  value="${patient.city}"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Вулиця</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="street" id="street" value="${patient.street}"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Будинок</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="house" id="house" value="${patient.house}"/>
							</div>
						</div>
					</fieldset>
					
					
					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary" >ОК</button>
						</div>
					</div>
				</form>
