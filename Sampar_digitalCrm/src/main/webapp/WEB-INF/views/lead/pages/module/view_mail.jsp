 <section class="content" ng-init="mailinit()">
<!-- <i class="fa fa-spinner fa-spin fa-4x" id="pageloader" ng-show="pageloader" style="z-index: 4"></i> -->
<img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
		<div class="row">
        <div class="col-md-12">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a data-target="#tab_1" data-toggle="tab"><i class="fa fa-envelope"></i> &nbsp;Inbox</a></li>
            </ul>
            <div class="tab-content" style="min-height: 400px;">
              <div class="tab-pane active" id="tab_1">
              <div class="table-responsive mailbox-messages">
                <table class="table table-hover table-striped">
                  <tbody>
                  <tr ng-repeat="mail in maillist">
                    <td><input type="checkbox"></td>
                    <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                    <td class="mailbox-name"><a href="read-mail.html">{{mail.from.personal}}</a></td>
                    <td class="mailbox-subject"><b>{{mail.subject}}
                    </td>
                    <td class="mailbox-attachment"><i class="fa fa-paperclip" aria-hidden="true"></i></td>
                    <td class="mailbox-date">{{mail.sentDate|date: 'yyyy-MM-dd'}}</td>
                  </tr>
                  
                  </tbody>
                </table>
                <!-- /.table -->
              </div>
              </div>
              <!-- /.tab-pane -->
            
              </div>
          </div>
       </div>
   
      </div>
		
		</section>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 