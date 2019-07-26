<section class="content" ng-init="sms()">
<!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader" style="z-index: 4"></i> -->
<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
		<div class="row">
        <div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a data-target="#tab_1" data-toggle="tab"><i class="fa fa-envelope"></i> &nbsp;Send Sms</a></li>
              <li><a data-target="#tab_2" data-toggle="tab"><i class="fa fa-eye"></i> &nbsp;View Sms</a></li>
               
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="tab_1">
              <form name="myForm">
               <div class="row">
               <div class="col-md-8 col-md-offset-2">
               <div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Sms For</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select class="form-control input-sm" ng-model="members" ng-change="selectmember()" required="required">
								<option value="client">Client</option>
								<option value="employee">Employee</option>
								</select>
							</div>
						</div>
					</div>
					</div>
					<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Contact</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<select class="form-control select2" multiple="multiple" data-placeholder="Select  Members" id="membermobile" required="required"> 
									<option value="{{employee.mobile}}" ng-repeat="employee in memberslist">{{employee.name}} &nbsp;&nbsp; {{employee.clientType}}</option>
								</select>
								<span class="input-group-addon"><input type="checkbox" id="checkbox22" >Select All</span>
							</div>
						</div>
					</div>
					</div>
				 <div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Message Text <span style="color: red;font-weight: bold;" ng-if="!myForm.myInput.$valid">Maximun character Limit is 250.</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<textarea rows="2" cols="2"  ng-maxlength="300"  name="myInput" class="form-control input-sm" placeholder="Message" ng-model="smss.message" required="required"></textarea>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
				<div class="col-md-9">
						<div class="callout callout-success callout-custom"
							style="padding: 5px; text-align: center;" ng-show="success">{{message}}</div>
						<div class="callout callout-danger callout-custom"
							style="padding: 5px; text-align: center;" ng-show="error">{{message}}</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<input type="submit" value="Send Sms" class="btn btn-primary btn-block" ng-disabled="myForm.$invalid" ng-click="saveSms()">
						</div>
					</div>
				</div>
               </div>
               </div>
               </form>
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="tab_2" style="min-height:400px;">
               <div class="row">
               <div class="col-md-3 pull-right">
                <div class="form-group">
                  <label>Select Date</label>
               <input type="date" class="form-control input-sm" ng-model="date" ng-change="historysms()" id="date">
                </div>
             
               </div>
               </div>
               <table id="example1" class="table table-bordered table-striped">
                <thead style="width: 100%">
                <tr>
                 <th style="width: 2%">S.No</th>
                  <th style="width: 10%">Contact</th>
                  <th style="width: 70%">Message</th>
                  <th style="width: 10%">Created On</th>
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-if="smslist.length=='0'">
                <td colspan="4" style="text-align: center;">No Message Available</td>
                </tr>
                <tr ng-repeat="sms in smslist">
                 <td>{{$index+1}}</td>
                  <td>{{sms.contact}}</td>
                  <td style=" word-break: break-all;">{{sms.message}}</td>
                  <td>{{sms.createdOn | date: 'yyyy-MM-dd'}}</td>
                 
                </tr>
               
                </tbody>
               
              </table>
              

              </div>
              </div>
          </div>
       </div>
   
      </div>
		
		</section>