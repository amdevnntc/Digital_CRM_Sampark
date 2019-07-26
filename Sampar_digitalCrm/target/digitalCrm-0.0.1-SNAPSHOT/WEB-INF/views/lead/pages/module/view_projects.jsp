<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="content" ng-init="projectInit(0)">

		<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
	<!-- general form elements -->
	<div class="box box-primary">

<!-- 
		<div class="box-header with-border">
	
			<div class="row">
				<div class="col-md-2">
					<div class="form-group">
						<label for="sel1">Sale Type</label>
						<select class="form-control input-sm" ng-model="saletype">
									<option value="Sell">Sell</option>
									<option value="Rent">Rent</option>
								</select>
					</div>

				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label for="sel1">Locality</label>
						 <input type="text"  class="form-control input-sm" ng-model="locality" >
					</div>

				</div>
				
				<div class="col-md-2">
					<div class="form-group">
						<label for="sel1">Project Type</label> <select  ng-model="projecttype"
							class="form-control input-sm" id="sel1" placeholder="Project Type">
							       <option value="residential">Residential</option>
									<option value="commercial">Commercial</option>
									<option value="furnished">Furnished</option>
									<option value="unfurnished">Unfurnished</option>
							</select>
					</div>

				</div>
				
				<div class="col-md-4">
						<div class="form-group">

							<label>Price</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-inr"></i></span>
							 <input type="text"  placeholder="Price min"    ng-model="pricemin" class="form-control input-sm" required="required">
								
                                <span class="input-group-addon" style="width: 35%;">
                                <input type="text" placeholder="Price max" ng-model="pricemax" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								</span>
								<span class="input-group-addon" style="width: 27%;">
								<select ng-model="pricein" class="form-control input-sm" required="required"  style="height: -webkit-fill-available; min-height: 16px;padding: 0;border: 0;">
								<option value="Lacs">Lacs</option>
								<option value="Crore"> Crore</option>
								</select></span>
								
							</div>
						</div>
					</div>
					
					<div class="col-md-2">
					<div class="form-group">
						<label for="sel1" class="hidden-xs" style="margin-top: 25px;">&nbsp;</label>
						<button class="btn btn-primary btn-sm" ng-click="searchProject()"><i class="fa fa-filter">&nbsp; Filter</i></button>
					</div>

				</div>
			</div>
		</div>
 -->
		<div class="box-body" style="min-height:400px;">
		<input type="text" class="form-control input-sm" placeholder="Type to search ............" ng-model="search"> 
		 <div class="container-fluid" style="padding-top: 15px;"  >
        <div class="" id="property-listings">
            
            <div class="row">
            
             <div class="row" style="text-align: center;" ng-show="projectcountboard">
				            
				  <ul class="list-inline">
				    <li ng-if="projectcount>'0'"><button  class="btn  btn-default  btn-xs" title="Click to Notifiy" data-toggle="modal" data-target="#myModal"><img src="/digitalCrm/resources/image/bell.png"></button></li>
				   <li><button  class="btn  btn-default btn-xs"><img src="/digitalCrm/resources/image/countdown.png">&nbsp;&nbsp;Selected Product : {{projectcount}}</button></li>
				    <li><button  class="btn  btn-default btn-xs"><img src="/digitalCrm/resources/image/countdown.png">&nbsp;&nbsp;Total Product : {{count}}</button></li>
				  
				  </ul>
            
            </div>
            
            <div class="row" style="text-align: center;" ng-if="projectlist.length=='0'" >
            
            <img src="/digitalCrm/resources/image/notdatafound.png" height="200" width="200">
            
            </div>
             <div class="col-sm-6"   ng-repeat="res in projectlist | filter:search"> 

                    <!-- Begin Listing: 609 W GRAVERS LN-->
                    <div class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing" style="height: 194px;">
                        <div class="media">
                            <a class="pull-left" href="" target="_parent">
                            <img alt="image" class="img-responsive hidden-xs" src="{{res.imageUrl}}" style="height: 150px;"></a>

                            <div class="clearfix visible-sm"></div>

                            <div class="media-body fnt-smaller">
                                <a href="#" target="_parent"></a>

                                <h4 class="media-heading">
                                  <a href="#" target="_parent"><i class="fa fa-inr"></i>&nbsp;{{res.price}} &nbsp;{{res.pricein}} <small class="pull-right">{{res.personName}}</small></a></h4>


                                <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                    <li><i class="fa fa-area-chart text-red"></i>&nbsp;&nbsp;{{res.area}} {{res.areatype}}</li>

                                    <li style="list-style: none">|</li>

                                    <li><i class="fa fa-wrench text-yellow"></i>&nbsp;&nbsp;{{res.projecstatus}}</li>

                                  
                                </ul>
                                
                                <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                  
                                    <li><i class="fa fa-phone text-yellow"></i>&nbsp;&nbsp;{{res.personMobile}}</li>

                                    <li style="list-style: none">|</li>

                                     <li><i class="fa fa-map-marker text-aqua"></i>&nbsp;&nbsp;Locality : &nbsp;&nbsp;{{res.locality}} </li>
                                 </ul>
                                 <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                        
                               <li><i class="fa fa-map-marker text-aqua"></i>&nbsp;&nbsp;society : &nbsp;&nbsp;  {{res.societyEntity.societyName}} </li>
                                 </ul>
                                

                                <ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
                                    <li><i class="fa fa-building text-red"></i>&nbsp;&nbsp;City : &nbsp;&nbsp; {{res.city}}</li>

                                    <li style="list-style: none">|</li>

                                    <li><i class="fa fa-building text-yellow"></i>&nbsp;&nbsp;{{res.bookingtype}}</li>

                                 
                                 </ul>

                                <!-- <p class="hidden-xs" style="word-break: break-all;height:40px;overflow: auto;">{{res.description}}
                                </p>
                                 -->
                                
                                <span class="fnt-smaller fnt-lighter fnt-arial">{{res.propertyname}}</span>
                                
                            </div>
                                         <div class="panel-footer" style="padding-top: 5px;background-color: #9999990a;">
                     <div style="text-align: center;">
                     <ul class="list-inline">
                        <li><input type="checkbox" class="flat-red" ng-model="res.checked"  data-toggle="tooltip" title="Check to Send Message" ng-click="projectproductId(res.id)"></li>
   <!--  <li><i class="fa  fa-envelope  text-yellow btn btn-xs" style="font-size: 20px;"  data-toggle="tooltip" title="Send Message"></i></li>
   <li><i class="fa fa-send-o  text-red btn btn-xs" style="font-size: 20px;"  data-toggle="tooltip" title="Send Email"></i></li>
    -->  <li><i class="fa fa-pencil-square  text-green btn btn-xs"  ng-model="res.checked"    ng-click="editProject(res)" style="font-size: 20px;"></i></li>
  </ul>
                     </div>
                    </div>
                        </div>
                        <p class="pull-right hidden-xs">Published On : {{res.createdOn | date}}</p>
       
                    
                    </div>
                    <!-- End Listing-->


                </div><!-- End Col -->
            </div><!-- End row -->
        </div><!-- End container -->
    </div>
		</div>
		
		
		
		
		<div class="box-footer" ng-show="footer">
		<ul class="pagination center">
              <li  ng-class="{'selected':$index == selectedRow}" ng-repeat="project in projectpagination"><a href="" ng-click="projectdata($index+1)">{{$index+1}}</a></li>
             
            </ul>
		
		</div>
		
	</div>
<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Send Notification</h4>
        </div>
        <div class="modal-body">
        <div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Select Clients</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users"></i></span>
								<select class="form-control select2" multiple="multiple" data-placeholder="Select  Members" id="membermobile" required="required" style="width: 100% !important;"> 
									<option value="{{client.id}}" ng-repeat="client in clientList">{{client.name}}</option>
								</select>
								<span class="input-group-addon"><input type="checkbox" id="checkbox22" > All</span>
							<!-- 	<span class="input-group-addon"><i class="fa fa-plus btn btn-primary btn-xs"></i></span>
							 --></div>
						</div>
					</div>
					
					<div class="col-md-4">
					<div class="form-group">
					<label>Notify By</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-bell"></i></span>
					<select class="form-control input-sm" ng-model="type">
					<option value="Sms">Sms</option>
					<option value="Email">Email</option>
					<option value="Both">Both</option>
					</select>
					</div>
					</div>
					</div>
					
					
					
					</div>


        </div>
        <div class="modal-footer">
        
          <button type="button" class="btn btn-primary pull-right" ng-click="share()">Share With Client</button>
          <button type="button" class="btn btn-danger pull-left" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</section>
 