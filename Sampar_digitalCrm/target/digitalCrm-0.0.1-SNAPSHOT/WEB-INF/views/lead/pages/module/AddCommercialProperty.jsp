
<section class="content"  ng-init="getDataOnLoad()">

<!-- ng-init="clientlist()" -->

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5><i class="fa fa-building-o text-red"></i>&nbsp;&nbsp;<b>Add Commercial Property</b></h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
				<form name="myForm">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group">
							<div>
								<label>Want to</label>
							</div>
							<label> <input type="radio" name="wantto"
								value="Sell_Property" id="wantto" class="flat-red" checked>
								Sell
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="wantto" value="Lease_Out_ProPerty" id="wantto"
								class="flat-red"> Lease
							</label>
						</div>
					</div>


					<div class="col-md-10">
						<div class="form-group">
							<div>
								<label>Property Type</label>
							</div>
							<label> <input type="radio" name="r3"
								value="Office" id="propertytype" class="flat-red" checked>
								Office
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Shop" id="propertytype" class="flat-red"> Shop
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Industrial_Lands_Plots" id="propertytype" class="flat-red">
								Land/Inst.land
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Showroom" id="propertytype" class="flat-red">
								Showroom
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Agri_Farm_Land" id="propertytype" class="flat-red">
								Agri/Farm Land
							
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Factory" id="propertytype" class="flat-red">
								Factory
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Ware_House" id="propertytype" class="flat-red">
								Ware House
							</label>
						</div>
					</div>



                  <div class="col-md-3">
						<div class="form-group">
							<div>
								<label>Owner Type</label>
							</div>
							<label> <input type="radio" name="owner"
								value="Broker" id="owner" class="flat-red" checked>
							Broker
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="owner" value="Individual" id="owner"
								class="flat-red"> Individual
							</label>
						</div>
					</div>
					
					
					  <div class="col-md-3">
					<div class="form-group">
							<div>
								<label>Price Type</label>
							</div>
							<label> <input type="radio" name="Price"
								value="All_Inclusive" id="pricetype" class="flat-red" checked
								required="required"> All Inclusive
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="Price" value="Negotiable" id="pricetype" class="flat-red"
								required="required"> Negotiable
							</label>



						</div>
					</div>
					
					<!-- <div class="col-md-3">
						<div class="form-group">
							<div>
								<label>Lifts </label>
							</div>
							<label> <input type="radio" name="lift"
								value="Yes" id="lift" class="flat-red" checked>
							Yes
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="lift" value="No" id="lift"
								class="flat-red"> No
							</label>
						</div>
					</div> -->
					
				</div>
                <div class="row">
                	<div class="col-md-3">
						<div class="form-group">

							<label>Society/Project Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="commercial.projectname" placeholder="Society/Project Name" required="required">

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Owner Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="commercial.ownerName" placeholder="Owner Name"
									required="required">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>Owner Mobile</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-phone"></i></span> <input type="text" placeholder="Owner mobile" maxlength="10"
									ng-model="commercial.ownerMobile" class="form-control input-sm" required="required">

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">

							<label>Email Address</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text" autocomplete="off"
									class="form-control input-sm" ng-model="commercial.ownerEmail"
									placeholder="Email Address" required="required">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>Asking Price</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
							 <input type="text" placeholder="Asking Price" ng-model="commercial.price" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 40%;">
                                <select ng-model="commercial.pricein" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;" required="required">
								<option value="Lacs">Lacs</option>
								<option value="Crore"> Crore</option>
								<option value="thousand">Thousand</option>
								</select></span>
								
							</div>
						</div>
					</div>
					
					
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Area </label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
								 <input type="text"  placeholder="Area"  ng-model="commercial.area" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 40%;">
                                <select ng-model="commercial.areatype" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;" required="required">
								  <option value="Sq. Ft.">Sqft</option>
									<option value="Sq. Yrds."> Square Yard</option>
								</select></span>
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Maintainence charges </label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
								 <input type="text"  placeholder="Maintainence"  ng-model="commercial.maintenance" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 40%;">
                                <select ng-model="commercial.maintenancetype" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;" required="required">
								<option value="Monthly">Monthly</option>
									<option value="Annually">Annually</option>
									<option value="One Time">One Time</option>
									<option value="Per Unit/Monthly">Per Unit/Monthly</option>
								</select></span>
							</div>
						</div>
					</div>
					 <div class="col-md-3">
						<div class="form-group">

							<label>Locality</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-map-marker"></i></span> <input type="text"
									class="form-control input-sm" ng-model="commercial.locality"
									placeholder="Locality" required="required">

							</div>
						</div>
					</div>
					
	         
					<div class="col-md-3">
						<div class="form-group">

							<label>City</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text" autocomplete="off"
									class="form-control input-sm" ng-model="commercial.city"
									placeholder="City" required="required">

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
								<select ng-model="commercial.societyId" class="form-control input-sm" required="required" >
									
										<option value="{{society.societyid}}" ng-repeat="society in societyList">{{society.societyName}}</option>
							
									</select>

							</div>
						</div>
					</div>
					
					
					  
					
					 <div class="col-md-3">
						<div class="form-group">

							<label>No of Floors</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text" autocomplete="off"
									class="form-control input-sm" ng-model="commercial.floors"
									placeholder="Floors">

							</div>
						</div>
					</div>
					
					 <div class="col-md-2">
						<div class="form-group">

							<label style="margin-top: 30px;" ng-show="plus" ng-click="showmore()"><i class="fa fa-plus btn btn-primary btn-xs">&nbsp;Add More</i>  </label>
							<label style="margin-top: 30px;" ng-show="minus" ng-click="hidemore()"><i class="fa fa-minus btn btn-danger btn-xs">&nbsp;view Less</i>  </label>
							
						</div>
					</div>
				</div>

				<div class="row" ng-show="more">
				

					<div class="col-md-3">
						<div class="form-group">

							<label>Society/Project Image</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-picture-o"></i></span> <input type="file"
									file-model1="file1" class="form-control input-sm">

							</div>
						</div>
					</div>
				<div class="col-md-3">
						<div class="form-group">

							<label>Washroom(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-bath"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="commercial.washroom" placeholder="Washroom(s)">

							</div>
						</div>
					</div>
				<div class="col-md-3">
						<div class="form-group">

							<label>Date of Availability</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-calendar"></i></span> <input type="date"
									class="form-control input-sm" id="doa" ng-model="doa" 
									 min="{{ doa |date :'yyyy-MM-dd'}}" >

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">

							<label>OwnerShip</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-building"></i></span>
							<select class="form-control input-sm" ng-model="commercial.ownership" >
							<option>FreeHold</option>
							<option>LeaseHold</option>
							<option>Co-operative Society</option>
							<option>Power of Attorney</option>
									</select>

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Parking(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-car"></i></span> <input type="text"
									class="form-control input-sm" ng-model="commercial.parking"
									placeholder="Parking(s)">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>Lift(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-car"></i></span> <input type="text"
									class="form-control input-sm" ng-model="commercial.lift"
									placeholder="Lifts(s)">

							</div>
						</div>
					</div>
                  <div class="col-md-3">
						<div class="form-group">

							<label>Description</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-file-text-o"></i></span> <textarea
									
									class="form-control input-sm" ng-model="commercial.description"
									placeholder="Description" >
                                      </textarea>

							</div>
						</div>
					</div>

				</div>
             		<div class="box-footer with-border">
					<div class="col-md-3 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()">
							<i class="fa fa-refresh"></i> &nbsp; Reset
						</button>
						<button class="btn btn-primary btn-sm" ng-click="save()" ng-disabled="myForm.$invalid">
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

