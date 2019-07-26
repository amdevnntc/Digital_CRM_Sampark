<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
#f1_container {
	position: relative;
	margin: 10px auto;
	height: 281px;
	z-index: 1;
}

#f1_container {
	perspective: 1000;
}

#f1_card {
	width: 100%;
	height: 100%;
	transform-style: preserve-3d;
	transition: all 1.0s linear;
	border: 2px solid;
}

#f1_container:hover #f1_card {
	transform: rotateY(180deg);
	box-shadow: -5px 5px 5px #aaa;
}

.face {
	position: absolute;
	width: 100%;
	height: 100%;
	backface-visibility: hidden;
}

.face.back {
	display: block;
	transform: rotateY(180deg);
	box-sizing: border-box;
	padding: 10px;
	color: white;
	text-align: center;
	background-color: #aaa;
}

div.panel-body {
    word-wrap: break-word;
    
}
#box{
box-shadow: 10px 10px 15px rgba(73, 78, 92, 0.1);
    background: #fff;
    transition: 0.4s;
}

#box:hover{
box-shadow: 10px 10px 15px rgba(73, 78, 92, 0.1);
    background: #fff;
    transition: 0.4s;
   -webkit-transform: translateY(-10px);
}

</style>
<section class="content" ng-init="propertylist1()">
 <!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader"></i> -->
 <img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<div class="row">
				<div class="col-md-2">
					<label>Search By</label>
					<div class="form-group">
						<select class="form-control input-sm" ng-model="by" ng-change="searchby()">
						<option value="residential">Residential</option>
						<option value="commercial">Commercial</option>
						<option value="bhk">BHK</option>
						</select>
					</div>

				</div>
				
				<div class="col-md-2">
					<label>Search For</label>
					<div class="form-group">
						<select class="form-control input-sm" ng-model="fors">
						<option value="{{property}}" ng-repeat="property in Propertytype">{{property}}</option>
						</select>
					</div>

				</div>
				
				<div class="col-md-2">
					<label class="hidden-xs">&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<div class="form-group">
						<i class="btn btn-primary btn-sm fa fa-search" value="search" ng-click="search()"></i>
					</div>
				</div>
			</div>
			<div class="row">
			<div class="col-md-12">
			<div class="form-group">
			<label>Type To Filter</label>
					<div class="form-group">
						<input type="search" class="form-control input-sm" ng-model="test" placeholder="Type something to filter......">
					</div>
			</div>
					

				</div>
			</div>
			
		</div>
		<div class="box-body" style="height:390px;overflow: auto;">
		
		   <div ng-if="propertylist.length=='0'">
		   <img  id="nodata"  alt="" src="/digitalCrm/resources/image/notdatafound.png" height="200" width="200" ng-show="nodata">
		   
		   </div>
		
		
			<div class="col-md-3" ng-repeat="property in propertylist | filter:test"">
				
				<div class="panel panel-default box box-primary" id="box">
					 
					<center style="margin-top: 10px;"><img   alt="" src="/digitalCrm/resources/image/villa.png" height="50" width="50"></center>
					<div class="panel-body scroll-notes"><b>{{property.propertyname}}</b></div>
					
					
					
					
					
					
					 <div class="row" style="text-align: center;">
					<div class="col-md-12">
					<div class="form-group">
					<ul class="list-inline">
    <li><i class="fa fa-area-chart" aria-hidden="true" style="color: green;"></i>&nbsp;<b>Area:</b>&nbsp;{{property.area}}</li>
    <li ng-if="property.bhk!=null"><i class="fa fa-home" aria-hidden="true" style="color: #4558BE;" ></i>&nbsp;{{property.bhk}} BHK</li>
  </ul>
  <ul class="list-inline">
    <li><i class="fa fa-home" aria-hidden="true" style="color: #26A69A;"></i>&nbsp;<b>Type:</b>&nbsp;{{property.projectype}}</li>
    <li><i class="fa fa-inr" aria-hidden="true" style="color: #F55549;"></i>&nbsp;{{property.price}}</li>
  </ul>
  <ul class="list-inline">
    <li><i class="fa fa-building" aria-hidden="true" style="color: green;"></i>&nbsp;<b>Property:</b>&nbsp;{{property.propertytype}}</li>
   
  </ul>
   <ul class="list-inline">
    <li><i class="fa fa-map-marker" aria-hidden="true" style="color: #F44336;"></i>&nbsp;<b>Location:</b>&nbsp;{{property.location}}</li>
   
  </ul>
   <ul class="list-inline">
    <li><i class="fa fa-user" aria-hidden="true" style="color: green;"></i>&nbsp;<b>Owner:</b>&nbsp;{{property.client.name}}</li>
   
  </ul>

   <ul class="list-inline">
    <li ng-if="property.client.employeeid==property.employeeid"><i class="fa fa-mobile" aria-hidden="true" style="color: #4558BE;"></i>&nbsp;<b>Contact:</b>&nbsp;{{property.client.mobile}}</li>
  </ul>
  
  <ul class="list-inline">
    <li><i class="fa fa-mobile" aria-hidden="true" style="color: #4558BE;"></i>&nbsp;<b>Posted By:</b>&nbsp;{{property.postedby}}</li>
  </ul>
					</div>
					
					</div>
					
					</div> 
					
					
				</div>

			</div>

		</div>
	</div>

</section>

