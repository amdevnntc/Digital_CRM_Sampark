
<section class="content" ng-init="enquiryInit()">
<!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader" style="z-index: 4"></i> -->
<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
		<div class="row">
        <div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
             <li class="active"><a data-target="#tab_2" data-toggle="tab" ng-click="enquiryInit()"><i class="fa fa-eye text-red"></i> &nbsp;View Enquiry</a></li>
              <li ><a data-target="#tab_1" data-toggle="tab"><i class="fa fa-user text-yellow"></i> &nbsp;Add Enquiry</a></li>
               
            </ul>
            <div class="tab-content">
              <div class="tab-pane" id="tab_1">
              <form role="form" name="myForm">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Name" ng-model="enquiry.name" required="required" >
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Contact</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Contact" ng-model="enquiry.contact" required="required"  maxlength="10">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Alternate Contact</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Alternate Contact" ng-model="enquiry.alternateContact" maxlength="10">
							</div>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Email</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control input-sm" placeholder="Email Address"  ng-model="enquiry.email" >
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Location</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Location"  ng-model="enquiry.location" required="required">
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Enquiry Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-handshake-o"></i></span>
								<select  class="form-control input-sm"  ng-model="enquiry.wantTo" required="required">
							<option value="Sell">Sell</option>
							<option value="Rent">Rent</option>
							</select>
							</div>
						</div>
					</div>
					
					
					<div class="col-md-3">
						<div class="form-group">

							<label>Price</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
							 <input type="text"  placeholder="Price min"  ng-model="enquiry.priceMin" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 35%;">
                                <input type="text" placeholder="Price max" ng-model="enquiry.priceMax" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								</span>
								<span class="input-group-addon" style="width: 27%;">
								<select ng-model="enquiry.pricein" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								<option value="Lacs">Lacs</option>
								<option value="Crore"> Crore</option>
								</select></span>
								
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="row">
				
				
				<div class="col-md-4">
						<div class="form-group">

							<label>Area</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
							 <input type="text"  placeholder="Area min"    ng-model="enquiry.areaMin" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 30%;">
                                <input type="text" placeholder="Area max" ng-model="enquiry.areaMax" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								</span>
								<span class="input-group-addon" style="width: 33%;">
								<select ng-model="enquiry.areain" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								  <option value="Sq. Ft.">Sqft</option>
									<option value="Sq. Yrds."> Square Yard</option>
								</select></span>
								
							</div>
						</div>
					</div>
					
				
					
					
						<div class="col-md-4">
						<div class="form-group">
							<label>Enquiry For</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<select class="form-control input-sm" ng-model="enquiry.enquiryFor" ng-change="projecttype()" required="required">
								<option value="Residential">Residential</option>
								<option value="Commercial">Commercial</option>
								</select>
							</div>
						</div>
					</div>
					
					
					<div class="col-md-4">
						<div class="form-group">
							<label>{{property}}</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-home"></i></span>
								<select class="form-control input-sm"  ng-model="enquiry.propertytype" required="required">
								<option value="{{property}}" ng-repeat="property in Propertytype">{{property}}</option>
								
								</select>
							</div>
						</div>
					</div>
					
					
					<!-- <div class="col-md-4" >
						<div class="form-group">
							<label>Property Type</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-home"></i></span>
								<select ng-model="enquiry.projectType" class="form-control input-sm">
								<option value="Residential">Residential</option>
								<option value="Commercial">Commercial</option>
								<option value="Furnished">Furnished</option>
								<option value="Unfurnished">Unfurnished</option>
								<option value="Studio Apartment">Studio Apartment</option>
								<option value="Builder Floor">Builder Floor</option>
								<option value="Hotel/Resorts">Hotel/Resorts</option>
								</select>
							</div>
						</div>
					</div>
					 -->
				
					
					
				
					
				</div>
				<div class="box-footer with-border">
			<div class="col-md-3 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()"><i class="fa fa-refresh"></i> &nbsp; Reset</button>
						<button class="btn btn-primary btn-sm" ng-click="save()" ng-disabled="myForm.$invalid" ><i class="fa fa-save"></i>  &nbsp; Save</button>
					</div>
				
		</div>
				
			</form>
              
              
              
              
              
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane active" id="tab_2" style="min-height:400px;">
                 <div class="table-responsive mailbox-messages">
                 <table id="example1" class="table table-bordered table-striped">
                <thead style="width: 100%">
                <tr>
                 <th style="width: 2%">S.No</th>
                  <th style="width: 15%">Name</th>
                  <th style="width: 10%">Contact</th>
                  <th>Enquiry For</th>
                  <th>PropertyType</th>
                  <th>price(Min-max)</th>
                   <th>Area(Min-max)</th>
                   <th>Location</th>
                  <th>Enquiry Date</th>
                  <th style="width: 2%">View</th>
                  <th style="width: 2%">Transfer</th>
                  <th>Meeting</th>
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-if="enquirylist.length=='0'">
                <td colspan="11" style="text-align: center;">No Data Available</td>
                </tr>
                <tr ng-repeat="enquiry in enquirylist">
                 <td>{{$index+1}}</td>
                  <td>{{enquiry.name}}</td>
                  <td>{{enquiry.contact}}</td>
                   <td>{{enquiry.enquiryFor}}</td>
                   <td>{{enquiry.propertytype}}</td>
                   <td>{{enquiry.priceMin}}-{{enquiry.priceMax}} &nbsp;{{enquiry.pricein}}</td>
                    <td>{{enquiry.areaMin}}-{{enquiry.areaMax}} &nbsp;{{enquiry.areain}}</td>
                   <td>{{enquiry.location}}</td>
                  <td>{{enquiry.createdOn | date: 'yyyy-MM-dd'}}</td>
                   <td><button class="btn btn-primary btn-xs"  data-toggle="modal" data-target="#modal-default"    ng-model="enquiry.checked"  ng-click="viewDetails(enquiry)" ><i class="fa fa-eye" ></i></button></td>
                     <td><button class="btn btn-info btn-xs"    data-toggle="modal" data-target="#myModaltransfer"   ng-model="enquiry.checked"  ng-click="transfer(enquiry)" ng-disabled="enquiry.meetingStatus=='1'" ><i class="fa fa-exchange" ></i></button></td>
                 <td><button class="btn btn-success btn-xs" ng-model="enquiry.checked" ng-click="scheduleMeeting(enquiry)" ng-disabled="enquiry.meetingStatus=='1'"><i class="fa fa-handshake-o "></i></button></td>
                </tr>
               
                </tbody>
               
              </table>
              </div>

              </div>
              </div>
          </div>
       </div>
   
      </div>
		
		</section>



<div class="modal fade" id="modal-default">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="row">
				<div class="col-md-4">
				<h4 class="modal-title">Property List</h4>
				</div>
				<div class="col-md-4 modal-title">
						<div class="callout callout-success callout-custom"
							style="padding: 5px; text-align: center;" ng-show="success">{{message}}</div>
						<div class="callout callout-danger callout-custom"
							style="padding: 5px; text-align: center;" ng-show="error">{{message}}</div>
					</div>
				</div>
				
			</div>
		
			<div class="modal-body" style="min-height: 200px;">
			<i class="fa fa-spinner fa-spin fa-4x"  style="z-index:4;position: fixed;margin-left: 45%;margin-top: 6%;color:#3F51B5" ng-show="modalLoader"></i>
			<div class="row" id="listpro">
			<div class="col-md-10" style="margin-top: 15px;">
							
								<ul class="list-inline">
									<li><i class="fa fa-user text-aqua" aria-hidden="true"
										></i>&nbsp; Name :{{viewData.name}}</li>
									<li><i class="fa fa-home text-yellow" aria-hidden="true"
										></i>&nbsp;Contact : {{viewData.contact}}</li>
										
										
										<li><i class="fa fa-mobile-phone text-red" aria-hidden="true"></i>&nbsp;Alternate Contact : {{viewData.alternateContact}}</li>
										
										
									<li><i class="fa fa-inr" aria-hidden="true"
										style="color: #F55549;"></i>&nbsp; price : {{viewData.priceMin}} - {{viewData.priceMax}} &nbsp; {{viewData.pricein}} </li>
										
									<li><i class="fa fa-map-marker text-green" aria-hidden="true"
										></i>&nbsp; Location : {{viewData.location}}</li>
										
										
								</ul>
								
								<ul class="list-inline">
								
									
										
									<li><i class="fa fa-area-chart text-yellow" aria-hidden="true"
										></i>&nbsp;Area : {{viewData.areaMin}} - {{viewData.areaMax}} &nbsp; {{viewData.areain}}</li>
																		
										<li><i class="fa fa-building text-blue" aria-hidden="true"></i>&nbsp;Enquiry For:&nbsp;&nbsp;{{viewData.enquiryFor}}</li>
										

								</ul>

							


							

						</div>
					 <div class="col-md-2" ng-if="enquirycount>'0'" >
  <label>Notify By</label>
    <ul class="list-inline">

    <li><i class="fa fa-google fa-2x btn btn-default btn-xs text-red" ng-click="share(viewData,'Email')" ></i></li>
    <li><i class="fa fa-envelope fa-2x btn btn-default btn-xs" style="color:green;" ng-model="property.checked"  ng-click="share(viewData,'Sms')"></i></li>
  </ul>
  </div>
			
			</div>
			
			
		
  
  <div class="row"  id="listpro" ng-repeat=" project in projectlist"  ng-show="projectview">
    
    <div class="form-group">
    <div class="col-md-2">
   <img alt="" src="{{project.imagename}}" width="150" height="80" style="margin-left: -15px;">
  
  
  </div>
  <div class="col-md-8" style="margin-top:15px;padding-left: 70px;">
   <div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<ul class="list-inline">
									<li><i class="fa fa-area-chart" aria-hidden="true"
										style="color: green;"></i>&nbsp;{{project.area}}, Onwards</li>
									<li><i class="fa fa-home" aria-hidden="true"
										style="color: #4558BE;"></i>&nbsp;{{project.bhk}}BHK</li>
										
										
										<li><i class="fa fa-home" aria-hidden="true"
										style="color: #26A69A;"></i> Status :&nbsp;{{project.projecstatus}}</li>
									<li><i class="fa fa-inr" aria-hidden="true"
										style="color: #F55549;"></i> Price :&nbsp;{{project.price}}</li>
								</ul>
								
								<ul class="list-inline">
									<li><i class="fa fa-map-marker" aria-hidden="true"
										style="color: green;"></i>Location :&nbsp;{{project.location}}</li>
										
										<li><i class="fa fa-calendar" aria-hidden="true"
										style="color: green;"></i>&nbsp;Possession:&nbsp;{{project.possessionDate}}</li>
										
										
										<li><i class="fa fa-building" aria-hidden="true"
										style="color: green;"></i>&nbsp;Project Type: &nbsp;{{project.projecttype}}</li>
										

								</ul>

							


							</div>

						</div>

					</div>
  
  </div>
  
<!--   <div class="col-md-2" style="margin-top: 15px;">
  <label>Notify By</label>
    <ul class="list-inline">

    <li><i class="fa fa-whatsapp fa-2x" style="color:green;"></i></li>
    <li><i class="fa fa-envelope fa-2x btn" style="color:green;"></i></li>
  </ul>
  
  </div> -->
    
    </div>
  
  
  </div>
  
  <div class="row"  id="listpro" ng-repeat="property in propertylist"  ng-show="propertyview">
  
 
    <div class="form-group">
    <div class="col-md-2">
   <img alt="" src="{{property.image}}" width="150" height="80" style="margin-left: -15px;">
  </div>
  <div class="col-md-9" style="margin-top:15px;padding-left: 50px;">
   <div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<ul class="list-inline">
									<li><i class="fa fa-area-chart text-green" aria-hidden="true"
										></i>&nbsp;{{property.area}} {{property.areatype}}</li>
									<li><i class="fa fa-car text-red" aria-hidden="true"
										></i> &nbsp; {{property.parking}}</li>
										
										
										<li><i class="fa fa-inr text-aqua" aria-hidden="true"></i>&nbsp; price Type :&nbsp;{{property.priceType}}</li>
									<li><i class="fa fa-inr" aria-hidden="true"
										style="color: #F55549;"></i>&nbsp;Price :&nbsp;{{property.price}} {{property.pricein}}</li>
								</ul>
								
								<ul class="list-inline">
									<li><i class="fa fa-map-marker text-red" aria-hidden="true"
										></i>&nbsp; Location: &nbsp;{{property.locality}}</li>
										
										
										
										<li><i class="fa fa-building text-blue" aria-hidden="true"
										></i>&nbsp;Type: &nbsp;{{property.propertytype}}</li>
										
										
										<li><i class="fa fa-building text-yellow" aria-hidden="true"
										style="color: green;"></i>&nbsp;For: &nbsp;{{property.wantto}}</li>
										

								</ul>
								
								
									<ul class="list-inline">
									<li><i class="fa fa-cogs text-yellow" aria-hidden="true"
										></i>&nbsp; Maintenance : &nbsp; Rs {{property.maintenance}}, {{property.maintenancetype}}</li>
										
										
										
									 	<li><i class="fa fa-user text-aqua" aria-hidden="true"></i>&nbsp; Owner: &nbsp;{{property.ownerName}} <strong>({{property.ownertype}})</strong></li>
										
										
										<li><i class="fa fa-mobile text-red" aria-hidden="true"></i>&nbsp; Mobile: &nbsp;<strong>{{property.ownerMobile}}</strong></li>
										 

								</ul>

							<b>Description :</b><br>
									<p>{{property.description}}</p>	
									


							</div>

						</div>

					</div>
  
  </div>
  
  <div class="col-md-1" style="margin-top: 15px;">
 
    <ul class="list-inline">

    <li><input type="checkbox"  ng-model="property.checked" ng-click="enquiryProductIdlist(property.id)"> </li>
 <!--    <li><i class="fa fa-envelope fa-2x btn btn-default btn-xs" style="color:green;" ng-model="property.checked"  ng-click="sendSms(property,viewData.contact)"></i></li>
 -->  </ul>
  
  </div>
    
    </div>
 
  </div>
  
   <div class="row"  id="listpro" ng-repeat="property in propertylist"  ng-show="residentialpropertyview">
    <div class="form-group">
    <div class="col-md-2">
   <img alt="" src="{{property.image}}" width="150" height="130" style="margin-left: -15px;">
  </div>
  <div class="col-md-9" style="margin-top:15px;padding-left: 50px;">
   <div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<ul class="list-inline">
									<li><i class="fa fa-area-chart text-aqua" aria-hidden="true"
										></i>&nbsp;{{property.area}} &nbsp; {{property.areatype}}</li>
										
											
										
										<li><i class="fa fa-home text-yellow" aria-hidden="true"
										></i>&nbsp;{{property.propertytype}}</li>
									<li><i class="fa fa-inr text-red" aria-hidden="true"
										></i>&nbsp;{{property.price}} &nbsp; {{property.pricein}}</li>
										
										<li><i class="fa fa-bed text-blue" aria-hidden="true"
										></i> &nbsp;{{property.bedroom}}</li>
										
										
										
										<li><i class="fa fa-bath text-red" aria-hidden="true"
										></i>&nbsp;{{property.bathroom}}</li>
								</ul>
								
								<ul class="list-inline">
									<li><i class="fa fa-map-marker text-aqua" aria-hidden="true"
										></i> Location: &nbsp;{{property.locality}}</li>
										
										
										
										<li><i class="fa fa-building text-yellow" aria-hidden="true"
										></i>City : &nbsp;{{property.city}}</li>
										
										
										<li><i class="fa fa-building text-red" aria-hidden="true"
										></i> &nbsp;{{property.furnishedType}}</li>
										
											<li><i class="fa fa-car text-blue" aria-hidden="true"
										></i>&nbsp;Parking : &nbsp;{{property.parking}}</li>
										

								</ul>
								
								
								
								
							
									<b>Description :</b><br>
									<p>{{property.description}}</p>	
										
									

								

							


							</div>

						</div>

					</div>
  
  </div>
  
  <div class="col-md-1" style="margin-top: 15px;">
 
    <ul class="list-inline">

    <li><input type="checkbox"  ng-model="property.checked" ng-click="enquiryProductIdlist(property.id)"> </li>
    <!-- <li><i class="fa fa-envelope fa-2x btn btn-default btn-xs" style="color:green;" ng-model="property.checked"  ng-click="sendSms(property,viewData.contact)"></i></li>
   --></ul>
  
  </div>
    
    </div>
  
  
  
  
  </div>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
			
			
			
			
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger btn-sm"
					data-dismiss="modal" >Close</button>
				
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>









<!-- Modal -->
<div id="myModaltransfer" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Transfer Your digitalCrm</h4>
      </div>
      <div class="modal-body">
        <div class="row">
        <div class="col-md-12">
        <div class="form-group">
        <label>Select Employee to Transfer digitalCrm</label>
        <select class="form-control input-sm" ng-model="employeeid">
        <option ng-repeat="employee in  employeelist" value="{{employee.id}}">{{employee.name}}-{{employee.mobile}}</option>
        </select>
        
        </div>
        
        </div>
       
        
        </div>
      </div>
      <div class="modal-footer">
       <div class="col-md-2 pull-left">
        <div class="form-group">
        <input type="submit" class="btn btn-primary btn-sm" value="Transfer" ng-click="savetransfer()">
          
        </div>
        
        </div>
        
           <div class="col-md-6 pull-right">
             <div class="form-group">
              <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Close</button>
             </div>
           </div>
     
      </div>
    </div>

  </div>
</div>