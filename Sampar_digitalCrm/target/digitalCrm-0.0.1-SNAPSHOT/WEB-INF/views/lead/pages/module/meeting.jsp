
<section class="content">

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Creating Meeting</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
		   <form name="myForm">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Meeting Title <span class="required" ng-if="myForm.title.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-handshake-o"></i></span> <input type="text" name="title"
									class="form-control input-sm" placeholder="Meeting Title"
									ng-model="meeting.meetingtitle" required="required">
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label>Meeting Members <span class="required" ng-if="myForm.employeeids.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-handshake-o"></i></span> <select 
									class="form-control select2" multiple="multiple"
									data-placeholder="Select a Employee"  name="employeeids"
									id="employeeids" style="width: 100%;" required="required">
									<option value="{{employee.id}}" ng-repeat="employee in employeelist">{{employee.name}}</option>
								</select>
							</div>
						</div>
					</div>


					<div class="col-md-4">
						<div class="form-group">
							<label>Meeting Date <span class="required" ng-if="myForm.date.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<!-- <input type="date" class="form-control input-sm" placeholder="Username" ng-model="client.dob"> -->
								<input type="date" class="form-control input-sm" name="date"
									ng-model="meeting.meetingdate" id="meetingdate" required="required">
							</div>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Start Time <span class="required" ng-if="myForm.start.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="time" class="form-control input-sm" ng-model="time"  name="start" id="fromtime" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>End Time <span class="required" ng-if="myForm.end.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="time" class="form-control input-sm"  ng-model="time1"  name="end"    id="totime" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Reminder <span class="required" ng-if="myForm.reminder.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-bell"></i></span>
								<select class="form-control input-sm" name="reminder"
									ng-model="meeting.reminder" required="required">
									<option value="1">1 hour</option>
									<option value="2">2 hour</option>
									<option value="3">3 hour</option>
									
								</select>
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Meeting Location <span class="required" ng-if="myForm.location.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-map-marker"></i></span> <input type="text" name="location"
									class="form-control input-sm" ng-model="meeting.location" required="required">

							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Meeting Description <span class="required" ng-if="myForm.desc.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-building-o"></i></span>
								<textarea rows="" cols="" class="form-control input-sm" name="desc"
									placeholder="Meeting Description"
									ng-model="meeting.meetingdesc" required="required"></textarea>
							</div>
						</div>
					</div>



				</div>
				<div class="box-footer with-border">
					<div class="col-md-4">
						<button class="btn btn-danger btn-sm" ng-click="reset()">
							<i class="fa fa-refresh"></i> &nbsp; Reset
						</button>
						<button class="btn btn-primary btn-sm" ng-click="saveMeeting()"  ng-disabled="myForm.$invalid">
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

