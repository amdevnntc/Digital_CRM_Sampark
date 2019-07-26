
<section class="content" ng-init="clientlist()">

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Add Property</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
			<form role="form">
				<div class="row">
				
				<div class="col-md-4">
						<div class="form-group">
						
							<label>Property Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text"  class="form-control input-sm" ng-model="pro.propertyname" placeholder="Property Name">
								  
							</div>
						</div>
					</div>
					
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Project Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<select class="form-control input-sm" ng-model="pro.projectype" ng-change="projecttype()">
								<option value="Residential">Residential</option>
								<option value="Commercial">Commercial</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Property Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<select class="form-control input-sm" ng-model="pro.propertytype" ng-change="propertytype()">
								<option value="{{property}}" ng-repeat="property in Propertytype">{{property}}</option>
								
								</select>
							</div>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-md-4">
					
					<div class="row">
					<div class="col-md-8">
					<div class="form-group" ng-show="area">
							<label>Area</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-area-chart"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="pro.area" placeholder="Area">
								
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
					<div class="form-group" ng-show="area">
							<label>Select Unit</label>
							<select class="form-control input-sm" ng-model="pro.areaunit">
							<option value="yard">Yard</option>
							<option value="guage">Guage</option>
							</select>
								
								
								
							
						</div>
					</div>
					</div>
						
					</div>
					
					<div class="col-md-4" ng-show="bhk">
						<div class="form-group">
							<label>No Of Bhk</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<select class="form-control input-sm" ng-model="pro.bhk">
								<option value="1">1 BHK</option>
								<option value="2">2 BHK</option>
								<option value="3">3 BHK</option>
								<option value="4">4 BHK</option>
								<option value="5">5 BHK</option>
								<option value="Other">Other</option>
											
								</select>
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
					<div class="row">
					<div class="col-md-8">
					<div class="form-group">
							<label>Price</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-inr"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="pro.price" placeholder="Price">
							</div>
						</div>
					</div>
					<div class="col-md-4">
					<div class="form-group">
							<label>Price</label>
							<select class="form-control input-sm" ng-model="pro.priceunit">
							<option value="lakh">Lakh</option>
							<option value="crore">Crore</option>
							</select>	
								
							
						</div>
					</div>
					</div>
					
					
					
						
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Construction Status</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-cog"></i></span>
								<select class="form-control input-sm" ng-model="pro.constructionstatus">
								<option value="construction">Under Construction</option>
								<option value="move">Ready To Move</option>
								<option value="newlaunch">New Launch</option>
								<option value="Other">Other</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Booking Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-image"></i></span>
								<select class="form-control input-sm"  ng-model="pro.bookingtype">
								<option value="New Booking">New Booking</option>
								<option value="ReSale">ReSale</option>
								</select>
							</div>
						</div>
					</div> 
					
					<div class="col-md-4">
						<div class="form-group">
							<label>location</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="pro.location" placeholder="Location">
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Owner Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select class="form-control input-sm" ng-model="pro.clientid">
								<option value="{{member.id}}" ng-repeat="member in memberslist">{{member.name}}</option>
								</select>
							</div>
						</div>
					</div>
					
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Property Description</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<textarea rows="2" cols="2" class="form-control input-sm" ng-model="pro.description"></textarea>
							</div>
						</div>
					</div>
					
					
				</div>
				
				
			
				<div class="box-footer with-border">
			<div class="col-md-2 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()"><i class="fa fa-refresh"></i> &nbsp; Reset</button>
						<button class="btn btn-primary btn-sm" ng-click="save()"><i class="fa fa-save"></i>  &nbsp; Save</button>
					</div>
					<div class="col-md-5">
					<div class="callout callout-success callout-custom" style="padding: 5px; text-align:center;" ng-show="success">{{message}}</div>
					<div class="callout callout-danger callout-custom" style="padding: 5px; text-align:center;" ng-show="error">{{message}}</div>
					</div>
		</div>
				
			</form>
		</div>
	</div>
	<!-- /.row -->
</section>

