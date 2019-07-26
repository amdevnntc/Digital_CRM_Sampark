
<section class="content" ng-init="getDataOnLoad()">
	<img alt="" src="/digitalCrm/resources/image/loading.gif"
		style="z-index: 4" ng-show="pageloader" id="pageloader" height="100"
		width="100">
	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>
				<i class="fa fa-map-marker fa-2x text-green"></i>&nbsp;&nbsp;City Master
			</h5>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group">

					<form name="myForm">


						<div class="box-body">
							<!-- /.box-header -->
							<!-- form start -->

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label>City Name</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-map-marker"></i></span> <input type="text"
												class="form-control input-sm" placeholder="City Name"
												ng-model="city.cityname" required="required">
										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="box-footer with-border">
							<div class="col-md-12">
								<button class="btn btn-danger btn-sm" ng-click="reset()">
									<i class="fa fa-refresh"></i> &nbsp; Reset
								</button>
								<button class="btn btn-primary btn-sm" ng-click="save()"
									ng-disabled="myForm.$invalid">
									<i class="fa fa-save"></i> &nbsp; Save
								</button>
							</div>

						</div>

					</form>

				</div>

			</div>

			<div class="col-md-8">
				<div class="form-group">
					<form name="myForm1">
						<div class="box-body">

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>City</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-map-marker"></i></span> <select  class="form-control"
												ng-model="locality.cityid"
												data-placeholder="Select  City" id="city"
												required="required" ng-change="changeCity()">
												<option value="{{city.cityid}}"
													ng-repeat="city in cityList">{{city.cityname}}</option>
											</select>
										</div>
									</div>

								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Locality</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-map-marker"></i></span> <input type="text"
												class="form-control input-sm" placeholder="LOCALITY NAME"
												ng-model="locality.localityname" required="required">
										</div>
									</div>
								</div>

							</div>

						</div>
						<div class="box-footer with-border">
							<div class="col-md-12">
								<button class="btn btn-danger btn-sm" ng-click="resetLocality()">
									<i class="fa fa-refresh"></i> &nbsp; Reset
								</button>
								<button class="btn btn-primary btn-sm" ng-click="saveLocality()"
									ng-disabled="myForm1.$invalid">
									<i class="fa fa-save"></i> &nbsp; Save
								</button>
							</div>

						</div>

					</form>
				</div>
			</div>

		</div>



		<div class="row" style="padding: 15px;">
			<div class="col-sm-5">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>S.No</th>
							<th>City-Name</th>
							<th>Created On</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-if="cityList.length=='0'">
							<td colspan="4" style="text-align: center;">No Data
								Available</td>
						</tr>
						<tr ng-repeat="city in cityList">
							<td>{{$index+1}}</td>
							<td>{{city.cityname}}</td>
							<td>{{city.createdOn | date: 'yyyy-MM-dd'}}</td>
							<td><button class="btn btn-xs btn-info"
									ng-model="city.checked" ng-click="editCity(city)">
									<i class="fa fa-pencil"></i>
								</button>|
								<button class="btn btn-xs btn-danger"
									ng-click="deleteCity(city)">
									<i class="fa fa-trash " ng-model="city.checked"
										aria-hidden="true"></i>
								</button></td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="col-sm-7">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Locality Name</th>
							<th>Created On</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-if="localityList.length=='0'">
							<td colspan="4" style="text-align: center;">No Data
								Available</td>
						</tr>
						<tr ng-repeat="locality in localityList">
							<td>{{$index+1}}</td>
							<td>{{locality.localityname}}</td>
							<td>{{locality.createdOn | date: 'yyyy-MM-dd'}}</td>
							<td><button class="btn btn-xs btn-info"
									ng-model="locality.checked" ng-click="editLocality(locality)">
									<i class="fa fa-pencil"></i>
								</button>|
								<button class="btn btn-xs btn-danger" ng-model="locality.checked"
									ng-click="deleteLocality(locality)">
									<i class="fa fa-trash "></i>
								</button></td>
						</tr>

					</tbody>
				</table>
			</div>

		</div>
	</div>








	<!-- /.row -->
</section>

