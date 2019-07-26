
<section class="content" ng-init="getDataOnLoad()">

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Add Projects</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
			<form role="form">
				<div class="row">



					<div class="col-md-3">
						<div class="form-group">

							<label>Project Image</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-image"></i></span>
								<input type="file" file-model1="file1"
									class="form-control input-sm">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>Project Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="project.projectname" placeholder="Property Name">

							</div>
						</div>
					</div>
					
					
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Contact Person Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="project.personName" placeholder="Contact Person Name">

							</div>
						</div>
					</div>
					
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Contact Person Mobile</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-mobile"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="project.personMobile" placeholder="Contact Person Mobile">

							</div>
						</div>
					</div>




					<div class="col-md-3">
						<div class="form-group">
							<label>Possession Date</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="date" class="form-control input-sm" ng-model="possesaion"
									id="possessionDate">

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Area </label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-area-chart"></i></span>
								<input type="text" placeholder="Area" ng-model="project.area"
									class="form-control input-sm" required="required"> <span
									class="input-group-addon" style="width: 40%;"> <select
									ng-model="project.areatype" class="form-control input-sm"
									required="required"
									style="height: -webkit-fill-available; min-height: 16px; padding: 0; border: 0;">
									  <option value="Sq. Ft.">Sqft</option>
									<option value="Sq. Yrds."> Square Yard</option>

								</select></span>
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Price </label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-inr"></i></span>
								<input type="text" placeholder="Price" ng-model="project.price"
									class="form-control input-sm" required="required"> <span
									class="input-group-addon" style="width: 40%;"> <select
									ng-model="project.pricein" class="form-control input-sm"
									required="required"
									style="height: -webkit-fill-available; min-height: 16px; padding: 0; border: 0;">
										<option value="lakh">Lakh</option>
										<option value="crore">Crore</option>
									
								</select></span>
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Locality</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm" ng-model="project.locality" placeholder="Locality"
									id="possessionDate">

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>City</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm"   ng-model="project.city"  placeholder="City"
									id="possessionDate">

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Sector</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<select class="form-control input-sm"
									ng-model="society.sectorId" placeholder="Sector"
									required="required" ng-change="getSociety()">
									<option value="{{sector.sectorid}}" ng-repeat="sector in sectorList">{{sector.sectorname}}</option>
									</select>
									

							</div>
						</div>
					</div>
					
					
					
							<div class="col-md-3">
						<div class="form-group">

							<label>Society Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select ng-model="project.societyId" class="form-control input-sm" required="required" >
									
										<option value="{{society.societyid}}" ng-repeat="society in societyList">{{society.societyName}}</option>
							
									</select>

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Project Status</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-cog"></i></span>
								<select class="form-control input-sm" ng-model="project.projecstatus">
									<option value="Under Construction">Under Construction</option>
									<option value="Ready To Move">Ready To Move</option>
									<option value="New Launch">New Launch</option>
									<option value="Other">Other</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Sale Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building-o"></i></span>
								<select class="form-control input-sm" ng-model="project.bookingtype">
									<option value="Sell">Sell</option>
									<option value="Rent">Rent</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Project Type </label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-map-marker"></i></span> <select
									class="form-control input-sm" ng-model="project.projecttype">
									<option value="residential">Residential</option>
									<option value="commercial">Commercial</option>
									<option value="furnished">Furnished</option>
									<option value="unfurnished">Unfurnished</option>
								</select>
							</div>
						</div>
					</div>
						<div class="col-md-6">
						<div class="form-group">
							<label>Project Description</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-building-o"></i></span>
								<textarea rows="2" cols="2" class="form-control input-sm"
									ng-model="project.description"></textarea>
							</div>
						</div>
					</div>
				</div>


			



				<div class="box-footer with-border">
					<div class="col-md-3 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()">
							<i class="fa fa-refresh"></i> &nbsp; Reset
						</button>
						<button class="btn btn-primary btn-sm" ng-click="save()">
							<i class="fa fa-save"></i> &nbsp; Save
						</button>
					</div>
					<div class="col-md-5">
						<div class="callout callout-success callout-custom"
							style="padding: 5px; text-align: center;" ng-show="success">{{message}}</div>
						<div class="callout callout-danger callout-custom"
							style="padding: 5px; text-align: center;" ng-show="error">{{message}}</div>
					</div>
				</div>

			</form>
		</div>
	</div>
	<!-- /.row -->
</section>

