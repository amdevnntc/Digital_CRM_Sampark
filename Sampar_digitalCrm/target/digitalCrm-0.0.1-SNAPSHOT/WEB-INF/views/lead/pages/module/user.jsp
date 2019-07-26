
<%-- <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="<%=request.getContextPath()%>/resources/new/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href=""><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active">
        <a href="#/"><i class="fa fa-dashboard"></i><span>Dashboard</span><span class="pull-right-container"></span></a> 
        </li>
        <jsp:include page="inc-sidebar.jsp"></jsp:include>
       <li class="treeview">
  <a href="javascript:void(0);"><i class="fa fa-user-secret"></i> Supervisors
	<span class="pull-right-container">
	  <i class="fa fa-angle-left pull-right"></i>
	</span>
  </a>
  <ul class="treeview-menu">
	<li class="treeview">
	  <a href="javascript:void(0);"><i class="fa fa-user-secret"></i> supo
		<span class="pull-right-container">
		  <i class="fa fa-angle-left pull-right"></i>
		</span>
	  </a>
	  <ul class="treeview-menu">
		<li><a href="javascript:void(0);"><i class="fa fa-user"></i> Driver 1</a></li>
	  </ul>
	</li>
  </ul>
</li>
        </ul>
        </section>
        </aside> --%>
         <section class="content-header">
      <h1>
        User Registration
        
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
       
        <li class="active">Registration</li>
      </ol>
    </section>
    
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
           
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form">
              <div class="box-body ">
                 <div class="form-group col-md-6">
                 <label for="">Id</label>
                  <div class="input-group">
                 <input type="text" class="form-control" placeholder="Enter User id" ng-model="app.userId">
                 <span class="input-group-addon btn" data-toggle="modal" data-target="#myModal" ><i class="glyphicon glyphicon-search"></i></span>
                 </div>
              </div>
                <div class="form-group col-md-6">
                  <label for="">Name</label>
                  <input type="text" class="form-control"  placeholder="Name" ng-model="app.userName">
                </div>
               
              </div>
              <div class="box-body ">
                <div class="form-group col-md-6" >
                  <label for="">Phone no</label>
                  <input type="text" class="form-control" placeholder="Enter phone no" ng-model="app.phoneNo">
                </div>
                <div class="form-group col-md-6">
                  <label for="exampleInputPassword1">Password</label>
                  <input type="password" class="form-control"  placeholder="Password" ng-model="app.password">
                </div>
               
              </div>
               <div class="box-body ">
                <div class="form-group col-md-6" >
                  <label>Select</label>
                  <select class="form-control" ng-model="app.roleId">
                    <option ng-selected="true">Select Role</option>
                    <option>ADMIN</option>
                    <option>USER</option>
                   
                  </select> </div>
               
              </div>

              <div class="box-footer">
                <button type="submit" class="btn btn-primary" ng-click="saveuser()">Submit</button>
              </div>
            </form>
          </div>
          </div>
      <!-- /.row -->
    </section>
    
    <div id="myModal" class="modal fade" role="dialog">
   <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">User Details</h4>
      </div>
       <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <!--  <div class="input-group input-group-sm col-xs-3">
                  <input type="text" name="table_search" class="form-control" placeholder="Search by name" ng-model="userName">
                 <div class="input-group-btn">
                    <button type="submit" class="btn btn-default" ng-click="searchbyname(userName)"><i class="fa fa-search"></i></button>
                  </div>
                </div> -->
                <!-- /input-group -->
        <div class="col-lg-4">
              <div class="input-group custom-search-form">
              <input type="text" name="table_search" class="form-control" placeholder="Search by name" ng-model="userName"><span class="input-group-btn">
              <button class="btn btn-default" type="button" ng-click="searchbyname(userName)"><span class="glyphicon glyphicon-search"></span></button>
              </span>
              </div>
              </div>
        <div class="col-lg-4">
              <div class="input-group custom-search-form">
              <input type="text" name="table_search" class="form-control" placeholder="Search by phone no" ng-model="phoneNo"><span class="input-group-btn">
              <button class="btn btn-default" type="button" ng-click="searchbyphone(phoneNo)"><span class="glyphicon glyphicon-search"></span></button>
              </span>
              </div>
              </div>
        <div class="col-lg-4">
              <div class="input-group custom-search-form">
              <input type="text" name="table_search" class="form-control" placeholder="Search by Id" ng-model="userId"><span class="input-group-btn">
              <button class="btn btn-default" type="button" ng-click="searchbyId(userId)"><span class="glyphicon glyphicon-search"></span></button>
              </span>
              </div>
              </div>
                
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tr>
                  <th>User Id</th>
                  <th>Name</th>
                  <th>Phone No</th>
                  <th>Role</th>
                  <th>Action</th>
                </tr>
                <tr ng-repeat= "u in list">
                  <td>{{u.userId}}</td>
                  <td>{{u.userName}}</td>
                  <td>{{u.phoneNo}}</td>
                  <td>{{u.roleId}}</td>
                  <td><i class="fa fa-edit btn"></i></td>
                  
                </tr>
              
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
    
    
    