<head>
<style type="text/css">
.blinking{
	animation:blinkingText 1s infinite;
}
@keyframes blinkingText{
	0%{		color: green;	}
	49%{	color: transparent;	}
	50%{	color: transparent;	}
	99%{	color:transparent;	}
	100%{	color: green;	}
}
</style>
</head>

<!--  <section class="content-header">
      <h1>
        Master Supervisior
        
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
       
        <li class="active">Supervisior</li>
      </ol>
    </section>
     -->
<section class="content" ng-init="enqMeetingInit()">

<div style="max-height: 200px;">

 <!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader"></i> -->
 <img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
</div>
  
   
  
	<!-- general form elements -->
	<div class="box box-primary" ng-init="init()">
            <div class="box-header">
             
            </div>
          
            <!-- /.box-header -->
            <div class="box-body" style="min-height: 460px!important;">
            <div class="table-responsive mailbox-messages">
              <table id="meeting" class="table table-bordered table-striped">
                <thead>
                <tr>
                 <th>S.No</th>
                  <th>Name</th>
                  <th>Contact</th>
                   <th>Meeting Location</th>
                  <th>Meeting Date</th>
                  <th>From Time</th>
                  <th>To Time</th>
                 
                </tr>
                </thead>
                <tbody>
               <tr ng-if="meetingList.length=='0'">
                <td colspan="8" style="text-align: center;">No Meeting Available</td>
                </tr>
                <tr ng-repeat="meeting in enquiryMeetingList">
                 <td> <i class="fa fa-bell blinking" ng-if="meeting.reminderStatus=='1'" style="color:green;" ></i> <i class="fa fa-bell" ng-if="meeting.reminderStatus=='0'" style="color:red;"></i> &nbsp;{{$index+1}}</td>
                  <td>{{meeting.enquiryEntity.name}}</td>
                  <td>{{meeting.enquiryEntity.contact}}</td>
                  <td>{{meeting.location}}</td>
                  <td>{{meeting.meetingDate}}</td>
                  <td>{{meeting.fromTime | date :  "hh:mm" }}</td>
                  <td>{{meeting.toTime }}</td>
                 
                </tr>
               
                </tbody>
               
              </table>
              </div>
            </div>
            <!-- /.box-body -->
          </div>
	<!-- /.row -->
</section>

