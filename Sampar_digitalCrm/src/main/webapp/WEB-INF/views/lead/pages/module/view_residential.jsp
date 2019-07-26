<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.check {
	opacity: 0.5;
	color: #996;
}

.img-check {
	height: 100px;
}
</style>
<section class="content" ng-init="viewresidential()">

	<div style="max-height: 200px;">

		<img alt="" src="/digitalCrm/resources/image/loading.gif"
			style="z-index: 4" ng-show="pageloader" id="pageloader" height="100"
			width="100">
	</div>

	<div class="row">
		<div class="col-md-12">
			<!-- Custom Tabs -->
			<div class="nav-tabs-custom">
				<ul class="nav nav-tabs">
					<li class="active"><a data-target="#tab_1" data-toggle="tab"
						ng-click="viewresidential()"><i class="fa fa-users"
							style="color: blue;"></i> &nbsp;Residential</a></li>
					<li><a data-target="#tab_2" data-toggle="tab"><i
							class="fa fa-users" style="color: green;"></i> &nbsp;Fliter</a></li>

				</ul>
				<div class="tab-content">
					<div class="box-header"></div>
					<div class="tab-pane active" id="tab_1">
						<div class="row">
							<div class="col-md-7 form-group">

								<input type="text" class="form-control input-sm"
									placeholder="Type to search" ng-model="search">

							</div>
							<div class="col-md-5">
								<ul class="list-inline">
									<li ng-if="residentcount>'0'"><button
											class="btn  btn-default  btn-xs" title="Click to Notifiy"
											data-toggle="modal" data-target="#myModal">
											<img src="/digitalCrm/resources/image/bell.png">
										</button></li>
									<li><button class="btn  btn-default btn-xs">
											<img src="/digitalCrm/resources/image/countdown.png">&nbsp;&nbsp;Selected
											Product : {{residentcount}}
										</button></li>
									<li><button class="btn  btn-default btn-xs">
											<img src="/digitalCrm/resources/image/countdown.png">&nbsp;&nbsp;Total
											Product : {{residentialList.length}}
										</button></li>

								</ul>
							</div>
						</div>
						<div class="row" id="property"
							ng-repeat="property in residentialList | filter : search">
							<div class="form-group">
								<div class="col-md-2" style="padding-top: 10px;">
									<img alt="" src="{{property.imageUrl}}" width="150"
										height="130" style="margin-left: 10px;">
								</div>
								<div class="col-md-8"
									style="margin-top: 15px; padding-left: 50px;">
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<ul class="list-inline" ng-if="property.propertyname !='' ">
													<li style="font-weight: bold; font-size: 18px;"
														class="text-blue"><i class="fa fa-building"
														aria-hidden="true"></i>&nbsp;{{property.propertyname}}</li>

												</ul>
												<ul class="list-inline">
													<li><i class="fa fa-area-chart text-aqua"
														aria-hidden="true"></i>&nbsp;{{property.area}} &nbsp;
														{{property.areatype}}</li>



													<li><i class="fa fa-home text-yellow"
														aria-hidden="true"></i>&nbsp;{{property.propertytype}}</li>
													<li><i class="fa fa-inr text-red" aria-hidden="true"></i>&nbsp;{{property.price}}
														&nbsp; {{property.pricein}}</li>

													<li><i class="fa fa-bed text-blue" aria-hidden="true"></i>
														&nbsp;{{property.bedroom}}</li>



													<li><i class="fa fa-bath text-red" aria-hidden="true"></i>&nbsp;{{property.bathroom}}</li>
												</ul>

												<ul class="list-inline">
													<li><i class="fa fa-map-marker text-aqua"
														aria-hidden="true"></i> Location:
														&nbsp;{{property.locality}}</li>



													<li><i class="fa fa-building text-yellow"
														aria-hidden="true"></i>City : &nbsp;{{property.city}}</li>


													<li><i class="fa fa-building text-red"
														aria-hidden="true"></i> &nbsp;{{property.furnishedType}}</li>

													<li><i class="fa fa-car text-blue" aria-hidden="true"></i>&nbsp;Parking
														: &nbsp;{{property.parking}}</li>

													<li><i class="fa fa-home text-blue" aria-hidden="true"></i>&nbsp;society
														: &nbsp; {{property.societyEntity.societyName}}</li>

													<li><i class="fa fa-home text-blue" aria-hidden="true"></i>&nbsp;sector
														: &nbsp; {{property.sectorId}}</li>
												</ul>
												<b>Description :</b><br>
												<p>{{property.description}}</p>
											</div>

										</div>

									</div>

								</div>
								<div class="col-md-2"
									style="margin-top: 15px; text-align: center;">
									<ul class="list-inline">
										<li><button ng-model="property.checked"
												ng-click="updateInfo(property)" class="btn btn-info btn-xs">
												<i class="fa fa-pencil"></i>
											</button></li>
										<li><button class="btn btn-danger btn-xs"
												ng-model="property.checked"
												ng-click="deleteresidential(property)">
												<i class="fa fa-trash"></i>
											</button></li>
										<li><button class="btn btn-success btn-xs"
												ng-model="property.checked"
												ng-click="soldresidential(property)">sold</button></li>
										<li><input type="checkbox" class="flat-red"
											ng-model="property.checked" data-toggle="tooltip"
											title="Check to Send Message"
											ng-click="residentialproductId(property.id)"></li>

									</ul>
								</div>


							</div>




						</div>










					</div>
					<!-- /.tab-pane -->
					<div class="tab-pane" id="tab_2" style="min-height: 400px;">
						<form method="get">
							<div class="row">

								<div class="col-md-12">
									<label>Property Types</label>

									<div class="form-group">
										<div class="col-md-2  col-xs-6 col-sm-4">
											<label class="btn"> <img
												src="/digitalCrm/resources/image/apartment.png" alt="..."
												class="img-thumbnail img-check"> <input
												type="checkbox" name="chk1" id="item4" value="Apartment"
												class="hidden" ng-click="addProrperty('Apartment')"
												autocomplete="off"><br> Apartment
											</label>

										</div>
										<div class="col-md-2 col-xs-6 col-sm-4">
											<label class="btn"> <img
												src="/digitalCrm/resources/image/stairs.png" alt="..."
												class="img-thumbnail img-check"> <input
												type="checkbox" name="chk1" id="item4" value="Builder_Floor"
												class="hidden" autocomplete="off"
												ng-click="addProrperty('Builder_Floor')"><br>
												Builder Floor
											</label>

										</div>
										<div class="col-md-2 col-xs-6 col-sm-4">
											<label class="btn"> <img
												src="/digitalCrm/resources/image/park.png" alt="..."
												class="img-thumbnail img-check"> <input
												type="checkbox" name="chk1" id="item4" value="Plot/Land"
												class="hidden" autocomplete="off"
												ng-click="addProrperty('Plot_Land')"><br>
												Plot/Land
											</label>

										</div>
										<div class="col-md-2 col-xs-6 col-sm-4">
											<label class="btn"> <img
												src="/digitalCrm/resources/image/house (2).png" alt="..."
												class="img-thumbnail img-check"> <input
												type="checkbox" name="chk1" id="item4" value="House/Villa"
												class="hidden" autocomplete="off"
												ng-click="addProrperty('House_Villa')"><br>
												House/Villa
											</label>

										</div>
										<div class="col-md-2 col-xs-6 col-sm-4">
											<label class="btn"> <img
												src="/digitalCrm/resources/image/studio.png" alt="..."
												class="img-thumbnail img-check"> <input
												type="checkbox" name="chk1" id="item4"
												value="Studio_Apartment" class="hidden" autocomplete="off"
												ng-click="addProrperty('Studio_Apartment')"><br>
												Studio Apartment
											</label>

										</div>
										<div class="col-md-2 col-xs-6 col-sm-4">
											<label class="btn"> <img
												src="/digitalCrm/resources/image/house.png" alt="..."
												class="img-thumbnail img-check"> <input
												type="checkbox" name="chk1" id="item4" value="Farm_House"
												class="hidden" autocomplete="off"
												ng-click="addProrperty('Farm_House')"><br> Farm
												House
											</label>

										</div>
									</div>

								</div>
							</div>



							<div class="row" style="margin-top: 15px;">
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
											class="flat-red saletype" required="required"> Rent
											Out Property
										</label>
									</div>

								</div>


								<div class="col-md-2">
									<div class="form-group">
										<label>Locality</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-map-marker"></i></span> <input type="text"
												value="delhi" placeholder="Locality" ng-model="locality"
												class="form-control input-sm" />
										</div>
									</div>

								</div>


								<div class="col-md-4">
									<div class="form-group">

										<label>Price</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-inr"></i></span>
											<input type="number" placeholder="Price min"
												ng-model="pricemin" class="form-control input-sm"
												required="required"> <span class="input-group-addon"
												style="width: 35%;"> <input type="number"
												placeholder="Price max" ng-model="pricemax"
												class="form-control input-sm" required="required"
												style="height: -webkit-fill-available; min-height: 16px; padding: 0; border: 0;">
											</span> <span class="input-group-addon" style="width: 27%;">
												<select ng-model="pricein" class="form-control input-sm"
												required="required"
												style="height: -webkit-fill-available; min-height: 16px; padding: 0; border: 0;">
													<option value="Lacs">Lacs</option>
													<option value="Crore">Crore</option>
											</select>
											</span>

										</div>
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">

										<label>Bedroom(s)</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-bed"></i></span>
											<input type="text" autocomplete="off"
												class="form-control input-sm" value="1" ng-model="bedroom"
												placeholder="Bedroom(s)" required="required">

										</div>
									</div>
								</div>

								<div class="col-md-2">
									<div class="form-group">
										<button class="btn btn-primary" ng-click="searchresidential()"
											ng-disabled="albumNameArray.length=='0'">
											<i class="fa fa-filter">&nbsp;Filter</i>
										</button>


									</div>
								</div>


							</div>

						</form>

						<div class="box-footer">
							<div class="" id="property-listings">

								<div class="row">

									<div class="row" style="text-align: center;"
										ng-show="residentcountboard">

										<ul class="list-inline">
											<li ng-if="residentcount>'0'"><button
													class="btn  btn-default  btn-xs" title="Click to Notifiy"
													data-toggle="modal" data-target="#myModal">
													<img src="/digitalCrm/resources/image/bell.png">
												</button></li>
											<li><button class="btn  btn-default btn-xs">
													<img src="/digitalCrm/resources/image/countdown.png">&nbsp;&nbsp;Selected
													Product : {{residentcount}}
												</button></li>
											<li><button class="btn  btn-default btn-xs">
													<img src="/digitalCrm/resources/image/countdown.png">&nbsp;&nbsp;Total
													Product : {{totalresidential}}
												</button></li>

										</ul>

									</div>

									<div class="row" style="text-align: center;"
										ng-if="tishu.length=='0'">

										<img src="/digitalCrm/resources/image/notdatafound.png"
											height="200" width="200">

									</div>
									<div class="col-sm-6" ng-repeat="res in tishu">

										<!-- Begin Listing: 609 W GRAVERS LN-->
										<div
											class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing"
											style="height: 194px;">
											<div class="media">
												<a class="pull-left" href="" target="_parent"> <img
													alt="image" class="img-responsive hidden-xs"
													src="{{res.imageUrl}}" style="height: 150px;"></a>

												<div class="clearfix visible-sm"></div>

												<div class="media-body fnt-smaller">
													<a href="#" target="_parent"></a>

													<h4 class="media-heading text-green"
														style="font-weight: bold;">

														<i class="fa fa-inr"></i>&nbsp;{{res.price}}
														&nbsp;{{res.pricein}} <small class="pull-right text-green"
															style="font-weight: bold;"><i class="fa fa-user"></i>&nbsp;&nbsp;{{res.ownerName}}&nbsp;&nbsp;<i
															class="fa fa-mobile"></i>&nbsp;{{res.ownerMobile}}</small>
													</h4>


													<ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
														<li><i class="fa fa-area-chart text-red"></i>&nbsp;{{res.area}}
															&nbsp;{{res.areatype}}</li>

														<li style="list-style: none">|</li>

														<li><i class="fa fa-bed text-yellow"></i>&nbsp;&nbsp;{{res.bedroom}}
															Beds</li>

														<li style="list-style: none">|</li>

														<li><i class="fa fa-bath text-aqua"></i>&nbsp;&nbsp;{{res.bathroom}}
															Baths</li>
													</ul>

													<ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
														<li><i class="fa fa-user text-red"></i>&nbsp;&nbsp;{{res.ownerType}}</li>



														<li style="list-style: none">|</li>

														<li><i class="fa fa-map-marker text-aqua"></i>&nbsp;&nbsp;{{res.locality}}
														</li>
													</ul>

													<ul class="list-inline mrg-0 btm-mrg-10 clr-535353">
														<li><i class="fa fa-building text-red"></i>&nbsp;&nbsp;{{res.city}}</li>

														<li style="list-style: none">|</li>

														<li><i class="fa fa-building text-yellow"></i>&nbsp;&nbsp;{{res.propertytype}}</li>

														<li style="list-style: none">|</li>

														<li><i class="fa fa-building text-aqua"></i>&nbsp;&nbsp;
															Flat No &nbsp;{{res.flatNo}}</li>
													</ul>

													<!-- <p class="hidden-xs" style="word-break: break-all;height:40px;overflow: auto;">{{res.description}}
                                </p>
                                 -->

													<span class="fnt-smaller fnt-lighter fnt-arial">&nbsp;{{res.propertyname}}</span>

												</div>
												<div class="panel-footer"
													style="padding-top: 5px; background-color: #9999990a;">
													<div style="text-align: center;">
														<ul class="list-inline">
															<li><input type="checkbox" class="flat-red"
																ng-model="res.checked" data-toggle="tooltip"
																title="Check to Send Message"
																ng-click="residentialproductId(res.id)"></li>
															<!--  <li><i class="fa  fa-envelope  text-yellow btn btn-xs" style="font-size: 20px;"  data-toggle="tooltip" title="Send Message"></i></li>
    <li><i class="fa fa-send-o  text-red btn btn-xs" style="font-size: 20px;"  data-toggle="tooltip" title="Send Email"></i></li>
    -->
															<li><i
																class="fa fa-plus-square  text-green btn btn-xs"
																ng-model="res.checked" ng-click="updateInfo(res)"
																style="font-size: 20px;"></i></li>
														</ul>
													</div>
												</div>
											</div>


										</div>
										<!-- End Listing-->


									</div>
									<!-- End Col -->
								</div>
								<!-- End row -->
							</div>
							<!-- End container -->

						</div>
					</div>
				</div>
			</div>
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
									<select class="form-control select2" multiple="multiple"
										data-placeholder="Select  Members" id="membermobile"
										required="required" style="width: 100% !important;">
										<option value="{{client.id}}" ng-repeat="client in clientList">{{client.name}}</option>
									</select> <span class="input-group-addon"><input type="checkbox"
										id="checkbox22"> All</span>
									<!-- 	<span class="input-group-addon"><i class="fa fa-plus btn btn-primary btn-xs"></i></span>
							 -->
								</div>
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

					<button type="button" class="btn btn-primary pull-right"
						ng-click="share()">Share With Client</button>
					<button type="button" class="btn btn-danger pull-left"
						data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


</section>

