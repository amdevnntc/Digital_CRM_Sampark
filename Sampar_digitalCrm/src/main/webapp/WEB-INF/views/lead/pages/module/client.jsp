
<section class="content">
 <img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5><i class="fa fa-user fa-2x text-yellow"></i>&nbsp;&nbsp;Add Client</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
		   <form name="myForm">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Name" ng-model="client.name" required="required" >
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Contact</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Mobile" ng-model="client.mobile" maxlength="10" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Date Of Birth</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="date" class="form-control input-sm" placeholder="Username" ng-model="client.dob" max="{{ today |date :'yyyy-MM-dd'}}" >
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Anniversary</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="date" class="form-control input-sm"  ng-model="client.anniversary"  max="{{ today |date :'yyyy-MM-dd'}}">
							</div>
						</div>
					</div>

				</div>


				<div class="row">
				
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Occupation</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select class="form-control input-sm"  ng-model="client.occupation" required="required">
								<option value="Salaried">Salried</option>
								<option value="Self Employeed">Self Employeed </option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Email Address</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control input-sm" placeholder="Email Address" ng-model="client.email" required="required">
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Client Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select ng-model="client.clientType" class="form-control input-sm" required="required" ng-change="chnageClient()">
								<option value="Individual">Individual</option>
								<option value="Broker">Broker</option>	
								</select>							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Client Sub Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select ng-model="client.subClientType" class="form-control input-sm" required="required">
								<option value="Seller">Seller</option>
								<option value="Buyer">Buyer</option>	
								</select>							</div>
						</div>
					</div>
					
				</div>
				
				
				<div class="row">
					
					<div class="col-md-4" ng-show="myVar">
						<div class="form-group">
							<label>Company Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" ng-model="client.companyName" class="form-control input-sm" placeholder="Company Name">
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Home Address</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-home"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Home address" ng-model="client.homeaddress"  >
							
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Office Address</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building-o"></i></span>
								<input type="text" class="form-control input-sm"  placeholder="office address" ng-model="client.officeaddress" ></textarea>
							</div>
						</div>
					</div>
					
					
					
				</div>
				<div class="box-footer with-border">
			<div class="col-md-2">
						<button class="btn btn-danger btn-sm" ng-click="reset()"><i class="fa fa-refresh"></i> &nbsp; Reset</button>
						<button class="btn btn-primary btn-sm" ng-click="save()" ng-disabled="myForm.$invalid"><i class="fa fa-save"></i>  &nbsp; Save</button>
					</div>
					
		</div>
				
			</form>
		</div>
	</div>
	<!-- /.row -->
</section>

