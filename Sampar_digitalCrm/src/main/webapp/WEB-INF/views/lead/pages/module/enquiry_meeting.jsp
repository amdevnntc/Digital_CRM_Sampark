
<section class="content">

	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5><i class="fa fa-handshake-o text-green"></i>&nbsp;Creating Meeting</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
		   <form name="myForm">
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<label>Meeting Title <span class="required" ng-if="myForm.title.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-handshake-o"></i></span> <input type="text" name="title"
									class="form-control input-sm" placeholder="Meeting Title"
									ng-model="meetingenq.title" required="required">
							</div>
						</div>
					</div>

					
 <div class="col-md-3">
						<div class="form-group">
							<label>Meeting Date <span class="required" ng-if="myForm.date.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="date" class="form-control input-sm" ng-model="meetingDate" ng-model="today" min="{{ meetingDate |date :'yyyy-MM-dd'}}"  name="date" id="meetingDate" required="required">
							</div>
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<label>Meeting Reminder <span class="required" ng-if="myForm.reminder.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-bell"></i></span>
									 <select name="reminder"
									class="form-control input-sm" ng-model="meetingenq.reminder" required="required" ng-change="reminder(meetingenq.reminder)">
									<option value=1>1 hr</option>
									<option value=2>2 hr</option>
									<option value=3>3 hr</option>
</select>
							</div>
						</div>
					</div>
					
              <div class="col-md-2 col-xs-6">
						<div class="form-group">
							<label>Start Time <span class="required" ng-if="myForm.start.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="time" class="form-control input-sm" ng-model="fromTime"  name="start" id="fromTime"  value="{{ today |date :'HH:mm'}}"   required="required" min="{{ today |date :'HH:mm'}}" max="22:00">
							</div>
						</div>
					</div>
					
					
					
				</div>


			

				<div class="row">
				
					<div class="col-md-2 col-xs-6">
						<div class="form-group">
							<label>End Time <span class="required" ng-if="myForm.end.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
						<input type="time" class="form-control input-sm"  ng-model="toTime"  name="end"  value="{{ today |date :'HH:mm'}}"   id="toTime" required="required" min="{{ today |date :'HH:mm'}}" max="22:00">
						
							</div>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label>Meeting Location <span class="required" ng-if="myForm.location.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-map-marker"></i></span> <input type="text" name="location"
									class="form-control input-sm" ng-model="meetingenq.location" required="required">

							</div>
						</div>
					</div>
					<div class="col-md-5">
						<div class="form-group">
							<label>Meeting Description <span class="required" ng-if="myForm.desc.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-building-o"></i></span>
								<textarea rows="" cols="" class="form-control input-sm" name="desc"
									placeholder="Meeting Description"
									ng-model="meetingenq.description" required="required"></textarea>
							</div>
						</div>
					</div>



				</div>
				<div class="box-footer with-border">
					<div class="col-md-4">
						<button class="btn btn-danger btn-sm" ng-click="reset()">
							<i class="fa fa-refresh"></i> &nbsp; Reset
						</button>
						<button class="btn btn-primary btn-sm" ng-click="saveenqMeeting()"  ng-disabled="myForm.$invalid">
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

