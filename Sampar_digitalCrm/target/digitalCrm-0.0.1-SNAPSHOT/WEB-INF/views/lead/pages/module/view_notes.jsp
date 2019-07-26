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
</style>
<section class="content" ng-init="init()">
<!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader" style="z-index:4"></i> -->
<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
<img alt="" src="/digitalCrm/resources/image/notdatafound.png" width="200" height="200" id="nodata" ng-show="nodata">
	<!-- general form elements -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<div class="row">
				<div class="col-md-2">
					<label>Select Client Name:</label>
					<div class="form-group">
						<select class="form-control input-sm" ng-model="clientid"
							ng-change="getnotes(clientid)">
							<option ng-repeat="client in clientList"
								value="{{client.id}},{{client.dealerid}},{{client.employeeid}}">{{client.name}}</option>
						</select>
					</div>

				</div>
			</div>
		</div>
		<div class="box-body" style="min-height: 380px;">
			<div class="col-md-3" ng-repeat="notes in notesList">
				<div class="panel panel-default box box-primary">
					<div class="panel-heading"><b>Notes Date:</b>&nbsp;{{notes.createdOn | date:"yyyy-MM-dd HH:mm"}}</div>
					<div class="panel-body scroll-notes">{{notes.notesDesc}}</div>
				</div>

			</div>

		</div>
	</div>

</section>

