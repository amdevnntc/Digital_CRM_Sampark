<section class="content" ng-init="campaignInit()">
<!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader" style="z-index: 4"></i> -->

<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
		<div class="row">
        <div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a data-target="#tab_1" data-toggle="tab"> &nbsp;Add Campaign</a></li>
              <li><a data-target="#tab_2" data-toggle="tab" ng-click="viewEmployee()"> &nbsp;View Campaign</a></li>
               
            </ul>
            <div class="tab-content" style="min-height:380px;">
              <div class="tab-pane active" id="tab_1">
              <form role="form"  name="myForm">
				

				<div class="row">
					<!-- <div class="col-md-6">
						<div class="form-group">

							<label>Campaign Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building"></i></span>
								<input type="text" class="form-control input-sm"
									ng-model="camp.name" placeholder="Campaign Name" required>

							</div>
						</div>
					</div> -->

					<!-- <div class="col-md-4">
						<div class="form-group">
							<label>Campaign Document Url</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-picture-o"></i></span>
									 <input type="text"  ng-model="camp.filename" class="form-control input-sm" ng-pattern="/^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/" required>

							</div>
						</div>
					</div> -->
				
				<div class="col-md-2">
						<div class="form-group">
							<label>Notifiy By</label>
							<select class="form-control input-sm" ng-model="camp.notifiyBy" ng-change="notifiyBy()" required>
							<option value="Sms">Sms</option>
							<option value="Email">Email</option>
							</select>
						</div>
					</div>
					

                <div class="col-md-4">
						<div class="form-group">
							<label>Select Template</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-picture-o"></i></span>
								<select class="form-control input-sm" ng-model="camp.templateid" ng-disabled="!templateview" ng-change="templateViews()"> 
									<option value="{{template}}" ng-repeat="template in templatelist">{{template.name}}</option>
								</select>
								
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Start Date</label>
							<input type="date" class="form-control input-sm" ng-model="startdate" id="startdate" required="required" min="{{ today |date :'yyyy-MM-dd'}}">
						</div>
					</div>
					
					
					
					
						<div class="col-md-3">
						<div class="form-group">
							<label>End Date</label>
							<input type="date" class="form-control input-sm" ng-model="enddate" id="enddate" required="required" min="{{ today |date :'yyyy-MM-dd'}}">
						</div>
					</div>
					
				</div>
             	<div class="row">
             	<div class="col-md-6"  >
						<div class="form-group">
							<label>Select Client</label>
							
							
							<div class="input-group"  ng-show="noti" >
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<select class="form-control select2" multiple="multiple" data-placeholder="Select  Members"  id="memberemail" style="width:100%" > 
									<option value="{{client.email}}" ng-repeat="client in clientList">{{client.name}}</option>
								</select>
								
							</div>
							
							
							<div class="input-group" ng-show="!noti">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<select class="form-control select2" multiple="multiple" data-placeholder="Select  Members" id="membermobile" style="width:100%"> 
									<option value="{{client.mobile}}" ng-repeat="client in clientList">{{client.name}}</option>
								</select>
							
							</div>
							
							
						</div>
					</div>
					
					<!-- <div class="col-md-4"  >
						<div class="form-group">
							<label>Select Client Mobile</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<select class="form-control select2" multiple="multiple" data-placeholder="Select  Members" id="membermobile" style="width:100%"> 
									<option value="{{client.mobile}}" ng-repeat="client in clientList">{{client.name}}</option>
								</select>
								<span class="input-group-addon"><input type="checkbox" id="checkbox22" >Select All</span>
							</div>
							
							
							
							
							
							
						</div>
					</div> -->
					
					
					
					
					<div class="col-md-6">
						<div class="form-group">

							<label>Campaign Description</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-list"></i></span>
								<textarea  class="form-control input-sm" ng-model="camp.description"
									placeholder="Campaign Description" required>
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
					
					
					  <div class="row" ng-show="templateSection">
					<div class="col-md-12 well" style="margin-top: 15px;">
					<div class="form-group">
					<p id="tttttt"></p>
					</div>
					
					</div>
					
					</div>
		
				</div>

			</form>
              
              
              
              
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="tab_2">
              
             
                <p class="well" ng-if="campaignList.length=='0'" style="text-align: center; font-weight: bold;"> No campaign Available</p>
               
              
              <div class="panel panel-default" ng-repeat="campaign in campaignList">
               <div  class="panel-heading" data-toggle="collapse" data-target="#demo{{$index+1}}"><p>Title</p><b>{{campaign.name}}</b><span class="pull-right">{{campaign.createdOn | date: 'yyyy-MM-dd'}}</span></div>
  <div id="demo{{$index+1}}" class="collapse">
  <p><b>Description</b></p>
   {{campaign.description}}
   
   <p><a href="{{campaign.filename}}" target="_blank">Document Url</a></p>
  </div>
              </div>
              </div>
              </div>
          </div>
       </div>
   
      </div>
		</section>
