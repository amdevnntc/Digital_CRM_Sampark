<section class="content" ng-init="sms()">
<!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader" style="z-index: 4"></i> -->
<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
		<div class="row">
        <div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a data-target="#tab_1" data-toggle="tab"><i class="fa fa-user"></i> &nbsp;Add Employee</a></li>
              <li><a data-target="#tab_2" data-toggle="tab" ng-click="viewEmployee()"><i class="fa fa-eye"></i> &nbsp;View Employee</a></li>
               
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="tab_1">
                <form role="form" name="myForm">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Name" ng-model="employee.name"  required="required" >
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Contact</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Mobile" ng-model="employee.mobile" maxlength="10"  required="required">
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Email</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control input-sm" placeholder="Email Address" ng-model="employee.email" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Date of Birth</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="date" class="form-control input-sm" placeholder="Username" ng-model="employee.dob"  >
							</div>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Working Area</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="employee.area"  required="required">
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Aadhar Number</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-id-card-o"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="employee.aadhar" >
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>Address</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-home"></i></span>
								<textarea class="form-control input-sm" placeholder="Home address" ng-model="employee.address">
								</textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="box-footer with-border">
			<div class="col-md-2 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()"><i class="fa fa-refresh"></i> &nbsp; Reset</button>
						<button class="btn btn-primary btn-sm" ng-click="save()"  ng-disabled="myForm.$invalid"><i class="fa fa-save"></i>  &nbsp; Save</button>
					</div>
				
		</div>
				
			</form>
              
              
              
              
              
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="tab_2" style="min-height:400px;">
                 <table id="example1" class="table table-bordered table-striped">
                <thead style="width: 100%">
                <tr>
                 <th>S.No</th>
                  <th >Name</th>
                  <th>Contact</th>
                    <th>Email Address</th>
                    <th>Area</th>
                  <th>Joined On</th>
                
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-if="employeelist.length=='0'">
                <td colspan="6" style="text-align: center;">No Employee Available</td>
                </tr>
                <tr ng-repeat="employee in employeelist">
                 <td>{{$index+1}}</td>
                  <td>{{employee.name}}</td>
                  <td>{{employee.mobile}}</td>
                  <td>{{employee.email}}</td>
                  <td>{{employee.area}}</td>
                  <td>{{employee.createdOn | date: 'yyyy-MM-dd'}}</td>
                 
                </tr>
               
                </tbody>
               
              </table>
              

              </div>
              </div>
          </div>
       </div>
   
      </div>
		
		</section>

