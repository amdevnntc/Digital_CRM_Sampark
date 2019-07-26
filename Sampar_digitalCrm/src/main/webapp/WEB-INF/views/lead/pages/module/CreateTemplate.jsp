
<section class="content">

<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="loader" id="pageloader" height="100" width="100">
	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Create Template</h5>
		</div>
		<div class="box-body">
			<!-- /.box-header -->
			<!-- form start -->
		   <form name="myForm">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label>Upload image <span class="required" ng-if="myForm.file.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-file-image-o"></i></span> 
							 <input type="file" file-model1="file1"   class="form-control input-sm" required>
							</div>
						</div>
					</div>

					<div class="col-md-8">
						<div class="form-group">
							<label>Campaign name<span class="required" ng-if="myForm.name.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-info-circle"></i></span> <input type="text" name="name"
									class="form-control input-sm" 
									ng-model="name" required="required">
							</div>
						</div>
					</div>


			

				</div>


				<div class="row">
				
						<div class="col-md-4">
						<div class="form-group">
							<label>Start Date <span class="required" ng-if="myForm.startdate.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="date" class="form-control input-sm" name="startdate"
									ng-model="meeting.meetingdate" id="startdate" required="required">
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label>End Date <span class="required" ng-if="myForm.enddate.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="date" class="form-control input-sm" ng-model="enddate"  name="enddate" id="enddate" required="required">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>Signature <span class="required" ng-if="myForm.signature.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="signature"  name="signature"    id="totime" required="required">
							</div>
						</div>
					</div>
				
				</div>


				<div class="row">
				
					<div class="col-md-12">
						<div class="form-group">
							<label>Campaign Description <span class="required" ng-if="myForm.desc.$invalid">*</span></label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-sticky-note-o "></i></span>
								<textarea rows="" cols="" class="form-control input-sm" name="desc"
									placeholder="Meeting Description"
									ng-model="description" required="required"></textarea>
							</div>
						</div>
					</div>



				</div>
				<div class="box-footer with-border">
					<div class="col-md-4">
						<button class="btn btn-danger btn-sm" ng-click="reset()">
							<i class="fa fa-refresh"></i> &nbsp; Reset
						</button>
						<button class="btn btn-primary btn-sm" ng-click="savetemplate()"  ng-disabled="myForm.$invalid">
							<i class="fa fa-save"></i> &nbsp; Save
						</button>
					</div>
					<div class="col-md-5">
						<div class="callout callout-success callout-custom"
							style="padding: 5px; text-align: center;" ng-show="success">{{message}}</div>
						<div class="callout callout-danger callout-custom"
							style="padding: 5px; text-align: center;" ng-show="error">{{message}}</div>
					</div>
					
					
					<div class="row" ng-show="templatview" >
					
					<div class="col-md-12 well" style="margin-top: 15px;">
					<div class="form-group">
					<p id="tttttt"></p>
					</div>
					
					</div>
					
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /.row -->
</section>

