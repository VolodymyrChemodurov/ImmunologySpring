<form id="defaultForm" method="POST" action="/Immunology/cabinet/patient/register"  class="form-horizontal">
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">First Name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="firstName" id="firstName" value="${patient.firstName}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Last Name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="lastName" id="lastName" value="${patient.lastName}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">Middle Name</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="middleName" id="middleName" value="${patient.middleName}"/>
							</div>
						</div>
						
					
					</fieldset>
					<fieldset>
					<legend></legend>
					<div class="form-group">
							<label class="col-sm-3 control-label">Select sex</label>
							<div class="col-sm-5">
								<select class="populate placeholder" name="sex" id="sex" >
									<option value="${patient.sex}">${patient.sex}</option>
									<option value="Male">Male</option>
									<option value="Female">Memale</option>
									
									
								</select>
							</div>
					</div>
					<div class="form-group has-feedback">
						<label class="col-sm-3 control-label">Date</label>
						<div class="col-sm-5">
							<input type="text"  name="dateOfBirth" id="dateOfBirth" class="form-control" placeholder="Date" value="${patient.dateOfBirth}">
							<span class="fa fa-calendar form-control-feedback"></span>
						</div>
						
						
					</div>
					</fieldset>	
					
					
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label class="col-sm-3 control-label">Country</label>
							<div class="col-sm-5">
								<select class="populate placeholder" name="country" id="country">
									<option value="${patient.country}">${patient.country}</option>
									<option value="Ukraine">Ukraine</option>
									<option value="France">France</option>
									<option value="Germany">Germany</option>
									<option value="Italy">Italy</option>
									<option value="Japan">Japan</option>
									<option value="Russia">Russia</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="United State">United State</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Region</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="region"  id="region" value="${patient.region}" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">City</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="city" id="city"  value="${patient.city}"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Street</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="street" id="street" value="${patient.street}"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">house</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="house" id="house" value="${patient.house}"/>
							</div>
						</div>
					</fieldset>
					
					
					<div class="form-group">
						<div class="col-sm-11 col-sm-offset-3">
							<button type="submit" class="btn btn-primary" >Submit</button>
						</div>
					</div>
				</form>
				