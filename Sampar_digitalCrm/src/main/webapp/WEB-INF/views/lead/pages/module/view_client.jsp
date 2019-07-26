<head>

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
<section class="content" ng-init="clientListInit()">

<div style="max-height: 200px;">

 <!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader"></i> -->
 <img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
</div>
  
   <div class="row">
        <div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a data-target="#tab_1" data-toggle="tab" ng-click="clientListInit()"><i class="fa fa-users" style="color: blue;"></i> &nbsp;Individual Clients</a></li>
                <li><a data-target="#tab_3" data-toggle="tab" ng-click="clientListInit()"><i class="fa fa-users" style="color: red;"></i> &nbsp;Broker Clients</a></li>
              <li><a data-target="#tab_2" data-toggle="tab" ng-click="randomClient()"><i class="fa fa-users" style="color: green;"></i> &nbsp;Random Clients</a></li>
               
            </ul>
            <div class="tab-content">
             <div class="box-header">
             <div class="row">
             <div class="col-md-12">
             <div class="">
             <input type="text" class="form-control input-sm" placeholder="Type to search" ng-model="search">
             </div>
              </div>
             </div>
            </div>
              <div class="tab-pane active" id="tab_1" style="min-height:400px;">
            
            <div class="table-responsive mailbox-messages">
              <table id="example1" class="table table-bordered table-striped" >
                <thead>
                <tr>
                
                  <th>Name</th>
                  <th>Contact</th>
                  <th>Email</th>
              
                  <th>Sub Type</th>
                   <th>Create Meeting</th>
                  <th>Edit</th>
                 
                </tr>
                
                </thead>
                
                <tbody>
               
               <tr ng-if="clientList.length=='0'">
                <td colspan="8" style="text-align: center;">No Data Available</td>
                </tr>
                <tr ng-if="client.clientType=='Individual'"  ng-repeat="client in clientList | filter : search">
               
                  <td>{{client.name}}</td>
                  <td>{{client.mobile}}</td>
                  <td>{{client.email}}</td>
               
                  <td>{{client.subClientType}}</td>
                  <td><center><i class="fa fa-handshake-o btn btn-success btn-xs"  ng-model="client.checked" aria-hidden="true" ng-click="createMeeting(client.id)"></i><!--  | <i class="fa fa-sticky-note-o btn btn-xs btn-default" aria-hidden="true" ng-click="notes()"></i> --></center></td>
                  <td><i class="fa fa-pencil btn-info btn btn-xs"   ng-model="client.checked" ng-click="edit(client)"></i> <!-- | <i class="fa fa-trash btn-danger btn btn-xs"></i></td> -->
                 
                </tr>
               
                </tbody>
               
              </table>
              </div>
           
              
              
              
              
              
              
              
              </div>
              
               <div class="tab-pane" id="tab_3" style="min-height:400px;">
                <div class="table-responsive mailbox-messages">
              <table id="example1" class="table table-bordered table-striped" >
                <thead>
                <tr>
              
                  <th>Name</th>
                  <th>Contact</th>
                  <th>Email</th>
                
                  <th>Sub Type</th>
                   <th>Create Meeting</th>
                  <th>Edit</th>
                 
                </tr>
                
                </thead>
                
                <tbody>
               
               <tr ng-if="clientList.length=='0'">
                <td colspan="8" style="text-align: center;">No Data Available</td>
                </tr>
                <tr   ng-if="client.clientType=='Broker'"  ng-repeat="client in clientList | filter : search">
                 
                  <td>{{client.name}}</td>
                  <td>{{client.mobile}}</td>
                  <td>{{client.email}}</td>
               
                  <td>{{client.subClientType}}</td>
                  <td><center><i class="fa fa-handshake-o btn btn-success btn-xs"  ng-model="client.checked" aria-hidden="true" ng-click="createMeeting(client.id)"></i><!--  | <i class="fa fa-sticky-note-o btn btn-xs btn-default" aria-hidden="true" ng-click="notes()"></i> --></center></td>
                  <td><i class="fa fa-pencil btn-info btn btn-xs"   ng-model="client.checked" ng-click="edit(client)"></i> <!-- | <i class="fa fa-trash btn-danger btn btn-xs"></i></td> -->
                 
                </tr>
               
                </tbody>
               
              </table>
              </div>
               
               </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="tab_2" style="min-height:400px;">
                 <div class="table-responsive mailbox-messages">
                 <table id="example1" class="table table-bordered table-striped">
                <thead style="width: 100%">
                <tr>
                 <th style="width: 2%">S.No</th>
                  <th style="width: 15%">Name</th>
                  <th style="width: 10%">Contact</th>
                   <th style="width: 10%">Alt Contact</th>
                  <th>Email Address</th>
                   <th>Location</th>
                   <th>Meeting Status</th>
               
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-if="enquirylist.length=='0'">
                <td colspan="10" style="text-align: center;">No Data Available</td>
                </tr>
                <tr ng-repeat="enquiry in enquirylist">
                 <td>{{$index+1}}</td>
                  <td>{{enquiry.name}}</td>
                  <td>{{enquiry.contact}}</td>
                   <td>{{enquiry.alternateContact}}</td>
                   <td>{{enquiry.email}}</td>
                  <td>{{enquiry.location}}</td>
                  <td ng-if="enquiry.meetingStatus=='1'">Schedule &nbsp; <i class="fa fa-dot-circle-o text-green" aria-hidden="true"></i></td>
                  <td ng-if="enquiry.meetingStatus=='0'">Not Schedule &nbsp; <i class="fa fa-dot-circle-o text-red" aria-hidden="true"></i></td>
                </tr>
               
                </tbody>
               
              </table>
              </div>

              

              </div>
              </div>
          </div>
       </div>
   
      </div>
      
      
      
  
	
	
</section>

