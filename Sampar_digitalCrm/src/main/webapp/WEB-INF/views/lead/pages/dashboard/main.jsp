<%-- <%@ include file="/WEB-INF/pages/views/inc-sidebar.jsp" %> --%>


 <section class="content-header">
      <h1>
        Dashboard
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>
 <img alt="" src="/digitalCrm/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
 <section class="content all-labels-dashboard">
      <!-- Small boxes (Stat box) -->
      <div class="row">
      
        <!-- ./col -->
       
        <!-- ./col -->
         <div class="col-lg-6 col-xs-6">
         
         
         <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Residential Inventory</h3>

            
            </div>
             <div class="box-body chart-responsive">
              <div class="chart" id="residential" style="height:300px; position: relative;"></div>
            </div>
            <!-- /.box-body -->
          </div>
          
          
         
        </div>
        
          <div class="col-lg-6 col-xs-6">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">commercial inventory</h3>


            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="Commercial" style="height:300px; position: relative;"></div>
            </div>
            <!-- /.box-body -->
          </div>
        </div>
       
      </div>
    
     </section>