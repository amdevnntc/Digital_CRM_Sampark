
<section class="content">

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Reschedule Meeting</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
			   <form name="myForm">
				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
							<label>Meeting Title</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-handshake-o"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Meeting Title" ng-model="meeting.meetingtitle"  required="required">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Meeting Date</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<!-- <input type="date" class="form-control input-sm" placeholder="Username" ng-model="client.dob"> -->
						        <input type="date" class="form-control input-sm"  ng-model="meeting.meetingdate" required="required">
							</div>
						</div>
					</div>

				</div>


				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Start Time</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="time" class="form-control input-sm" id="fromtime" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>End Time</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="time" class="form-control input-sm" id="totime" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Reminder</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-bell"></i></span>
								<select class="form-control input-sm" ng-model="meeting.reminder" required="required">
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
							<label>Meeting Location</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm" ng-model="meeting.location" required="required" >
							
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Meeting Description</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-building-o"></i></span>
								<textarea rows="" cols="" class="form-control input-sm"  placeholder="Meeting Description" ng-model="meeting.meetingdesc" required="required"></textarea>
							</div>
						</div>
					</div>
					
					
					
				</div>
				<div class="box-footer with-border">
			       <div class="col-md-4">
						<button class="btn btn-danger btn-sm" ng-click="reset()"><i class="fa fa-refresh"></i> &nbsp; Reset</button>
						<button class="btn btn-primary btn-sm"   ng-disabled="myForm.$invalid" ng-click="editMeeting()"><i class="fa fa-save"></i>  &nbsp; Reschedule</button>
					</div>
					<div class="col-md-5">
					<div class="callout callout-success callout-custom" style="padding: 5px; text-align:center;" ng-show="success">{{message}}</div>
					<div class="callout callout-danger callout-custom" style="padding: 5px; text-align:center;" ng-show="error">{{message}}</div>
				</div>
		</div>
			</form>
		</div>
	</div>
	<!-- /.row -->
</section>

