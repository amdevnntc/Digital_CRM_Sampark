
<section class="content" ng-init="getDataOnLoad()">

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Add Residential Property</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
			<form name="myForm">
				<div class="row">

					<div class="col-md-4">
               <div class="form-group">
							<div>
								<label>Property For</label>
							</div>
							<label> <input type="radio" name="SellRent"
								value="Sell_Property" id="" class="flat-red saletype" checked
								required="required"> Sell Property
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="SellRent" value="Rent_Out_Property" id=""
								class="flat-red saletype" required="required"> Rent Out Property
							</label>
						</div>




					</div>

<!-- 
					<div class="col-md-4">

						<div class="form-group">
							<div>
								<label>Sale Type</label>
							</div>
							<label> <input type="radio" name="SaleType"
								value="New Booking" id="saletype" class="flat-red" checked
								required="required"> New Booking
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="SaleType" value="Resale" id="saletype" class="flat-red"
								required="required"> Resale
							</label>



						</div>

					</div>
 -->




					
						<div class="col-md-8">
						<div class="form-group">
							<div>
								<label>Property Type</label>
							</div>
							<label> <input type="radio" name="r3" value="Apartment"
								id="propertytype" class="flat-red" checked required="required">
								Apartment
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Builder_Floor" id="propertytype" class="flat-red"
								required="required"> Builder Floor
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Plot_Land" id="propertytype" class="flat-red"
								required="required"> Plot/Land
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="House_Villa" id="propertytype" class="flat-red"
								required="required"> House/Villa
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Studio_Apartment" id="propertytype" class="flat-red"
								required="required"> Studio Apartment
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" name="r3"
								value="Farm_House" id="propertytype" class="flat-red"
								required="required"> Farm House
							</label>
						</div>
					</div>


				</div>

				<div class="row">



									<div class="col-md-4">

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
					
				
				
				
					<div class="col-md-3">
						<div class="form-group">
							<div>
								<label>Owner Type</label>
							</div>
							<label> <input type="radio" name="Owner"
								value="Individual" id="ownertype_Individual" class="flat-red" checked
								required="required"> Individual
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="Owner" value="Broker" id="owneretype_Broker"
								class="flat-red" required="required"> Broker
							</label>



						</div>
					</div>
					
					<div class="col-md-5">
						<div class="form-group">
							<div>
								<label>Furnished Type</label>
							</div>
							<label> <input type="radio" name="furnished"
								value="Furnished" id="furnishedtype" class="flat-red" checked
								required="required"> Furnished
							</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="furnished" value="UnFurnished" id="furnishedtype"
								class="flat-red" required="required"> UnFurnished 
							</label>
							&nbsp;&nbsp;&nbsp; <label> <input type="radio"
								name="furnished" value="SemiFurnished" id="furnishedtype"
								class="flat-red" required="required"> SemiFurnished
							</label>



						</div>
					</div>
					
					

				</div>
				
				
				
				
				
								<div class="row">
								
								<div class="col-md-3">
						<div class="form-group">

							<label>Property/Society   Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="resident.propertyname" placeholder="Property/Society   Name" required="required"
									>

							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Owner  Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="resident.ownerName" placeholder="Owner Name"
									required="required">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>Owner mobile</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-phone"></i></span> <input type="text" placeholder="Owner mobile" maxlength="10"
									ng-model="resident.ownerMobile" class="form-control input-sm">

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">

							<label>Email Address</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text" autocomplete="off"
									class="form-control input-sm" ng-model="resident.ownerEmail"
									placeholder="Email Address" required="required">

							</div>
						</div>
					</div>
				</div>
	
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">

							<label>Bedroom(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-bed"></i></span>
								<input type="text" autocomplete="off"
									class="form-control input-sm" ng-model="resident.bedroom"
									placeholder="Bedroom(s)" required="required">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>Bathroom(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-bath"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="resident.bathroom" placeholder="Bathroom(s)"
									required="required">

							</div>
						</div>
					</div>

					<!-- <div class="col-md-3">
						<div class="form-group">

							<label>No Of Balcony</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-home"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="balcony" placeholder="No Of Balcony"
									required="required">

							</div>
						</div>
					</div> -->

					<div class="col-md-3">
						<div class="form-group">

							<label>Price</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
									
							 <input type="text" placeholder="price" ng-model="resident.price" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 50%;">
                                <select ng-model="resident.pricein" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								<option value="Lacs">Lacs</option>
								<option value="Crore"> Crore</option>
							
								</select></span>
							</div>
						</div>
					</div>

<div class="col-md-3">
						<div class="form-group">

							<label>Area</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-area-chart"></i></span>
									
							 <input type="text"  ng-model="resident.area" class="form-control input-sm" required="required" placeholder="Area">
								
                                <span class="input-group-addon" style="width: 50%;">
                                <select ng-model="resident.areatype" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								  <option value="Sq. Ft.">Sqft</option>
									<option value="Sq. Yrds."> Square Yard</option>
								</select></span>
							</div>
						</div>
					</div>
					
				</div>

				<div class="row">
	<div class="col-md-3">
						<div class="form-group">

							<label>Locality</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-map-marker"></i></span> <input type="text"
									autocomplete="off" class="form-control input-sm"
									ng-model="resident.locality" placeholder="Locality"
									required="required">

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">

							<label>City</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="resident.city" placeholder="City"
									required="required">

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
								<select ng-model="resident.societyId" class="form-control input-sm" required="required" >
									
										<option value="{{society.societyid}}" ng-repeat="society in societyList">{{society.societyName}}</option>
							
									</select>

							</div>
						</div>
					</div>
					
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Flat No</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="resident.flatNo" placeholder="Flat No"
									required="required">

							</div>
						</div>
					</div>



				</div>

<div class="row">
<div class="col-md-1">
<div class="form-group">
<b><i class="fa fa-plus btn btn-primary btn-xs" ng-show="plus" ng-click="showmore()"></i></b>
<b><i class="fa fa-minus btn btn-danger btn-xs" ng-show="minus" ng-click="hidemore()"></i></b>
</div>

</div>
</div>

			<div class="row" ng-show="more" >
					

					<div class="col-md-3">
						<div class="form-group">

							<label>Property Image</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-picture-o"></i></span> <input type="file"
									file-model1="file1" class="form-control input-sm" 
									>

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">

							<label>Balconie(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-info"></i></span>
								<input type="text" autocomplete="off"
									class="form-control input-sm" ng-model="resident.balcony"
									placeholder="Balconie(s)" >

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
							<select class="form-control input-sm" ng-model="resident.ownership" >
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

							<label>Floor(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-building"></i></span> <input type="text"
									class="form-control input-sm" ng-model="resident.floors"
									placeholder="Floor(s)" >

							</div>
						</div>
					</div>
					
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Parking(s)</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-car"></i></span> <input type="text"
									class="form-control input-sm" ng-model="resident.parking"
									placeholder="Parking(s)">

							</div>
						</div>
					</div>
					
										<div class="col-md-6">
						<div class="form-group">

							<label>Description</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-file-text-o"></i></span> <textarea
									
									class="form-control input-sm" ng-model="resident.description"
									placeholder="Description" >
                                      </textarea>

							</div>
						</div>
					</div>
					
				</div>








				<div class="box-footer with-border">
					<div class="col-md-2 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()">
							<i class="fa fa-refresh"></i> &nbsp; Reset
						</button>
						<button class="btn btn-primary btn-sm" ng-click="save()"
							ng-disabled="myForm.$invalid">
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

