<!DOCTYPE html>
<%-- <%@page import="com.sampark.digitalCrm.constants.AppConstants"%> --%>
<html ng-app="app">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>digital CRM</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->

<link rel="stylesheet"
	href="/digitalCrm/resources/dist/css/skins/_all-skins.min.css">
<script src="/digitalCrm/resources/dist/js/angular.min.js"></script>
<script src="/digitalCrm/resources/dist/js/angular-ui-router.min.js"></script>
<link rel="stylesheet" href="/digitalCrm/resources/css/style.css">
<link rel="stylesheet"
	href="/digitalCrm/resources/css/residentStyle.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap slider -->
<link rel="stylesheet"
	href="/digitalCrm/resources/plugins/bootstrap-slider/slider.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- Select2 -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/select2/dist/css/select2.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="/digitalCrm/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet"
	href="/digitalCrm/resources/plugins/iCheck/all.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
<!-- fullCalendar -->
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/fullcalendar/dist/fullcalendar.min.css">
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/fullcalendar/dist/fullcalendar.print.min.css"
	media="print">
<!-- bootstrap time picker -->
<link rel="stylesheet"
	href="/digitalCrm/resources/plugins/timepicker/bootstrap-timepicker.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="/digitalCrm/resources/plugins/iCheck/flat/blue.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"
	type="text/css">
<link rel="stylesheet"
	href="/digitalCrm/resources/css/buttons.dataTables.min.css"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<script src="/digitalCrm/resources/js/app.js"></script>

<script
	src="http://jvandemo.github.io/angularjs-google-maps/dist/angularjs-google-maps.js"></script>

<!--  
   -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD2ZQ7NphzYhrT04-Mq2CfF9JccgQz8Bio&libraries=places&extension=.js"></script>

<!-- <script src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script> -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="http://ui-grid.info/release/ui-grid-unstable.js"></script>
<link rel="stylesheet"
	href="http://ui-grid.info/release/ui-grid-unstable.css" type="text/css">
<link rel="stylesheet"
	href="/digitalCrm/resources/dist/css/AdminLTE.min.css">

<style>
.all-labels-dashboard h3 {
	font-size: 30px;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini fixed"
	ng-controller="bodyController">
	<div class="wrapper" id="main_body">
		<%-- <%String username=(String)session.getAttribute(AppConstants.USER); %> --%>
		<header class="main-header">
			<!-- Logo -->
			<a href="" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>d</b>C</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b> digital </b>CRM</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top navbar-custom">
				<!-- Sidebar toggle button-->
				<a href="" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown messages-menu"><a href=""
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-user">&nbsp;&nbsp;devesh Kumar</i>
						</a></li>
						<li class="dropdown"><a href="/digitalCrm/logoutdigitalCrm">
								<i class="fa fa-power-off">&nbsp;&nbsp;Logout</i>
						</a></li>
						<!--    <li class="dropdown user user-menu">
            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/digitalCrm/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs" ng-cloak>{{profiledetails.name}}</span>
            </a>
            <ul class="dropdown-menu">
              User image
              <li class="user-header">
                <img src="/digitalCrm/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
              </li>
              Menu Footer
              <li class="user-footer">
               
                <div class="pull-right">
                  <a href="/digitalCrm/logoutdigitalCrm" class="btn btn-danger btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li> -->

					</ul>
				</div>
			</nav>
		</header>
		<aside class="main-sidebar">
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="/digitalCrm/resources/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>1</p>
						<a href=""><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<%@ include file="/WEB-INF/views/lead/pages/menu/inc-sidebar.jsp"%>
			</section>

		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<ui-view>
		</div>

		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>V</b> 2
			</div>
			<strong>Copyright &copy; 2018 <a href="#">Sampark
					Software</a>.
			</strong> All rights reserved.
		</footer>

		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script
		src="/digitalCrm/resources/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="/digitalCrm/resources/bower_components/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="/digitalCrm/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Select2 -->
	<script
		src="/digitalCrm/resources/bower_components/select2/dist/js/select2.full.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="/digitalCrm/resources/bower_components/raphael/raphael.min.js"></script>
	<!-- InputMask -->
	<script
		src="/digitalCrm/resources/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="/digitalCrm/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="/digitalCrm/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<!-- date-range-picker -->
	<script
		src="/digitalCrm/resources/bower_components/moment/min/moment.min.js"></script>
	<script
		src="/digitalCrm/resources/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap datepicker -->
	<script
		src="/digitalCrm/resources/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

	<!-- jvectormap -->
	<script
		src="/digitalCrm/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="/digitalCrm/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="/digitalCrm/resources/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="/digitalCrm/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script
		src="/digitalCrm/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="/digitalCrm/resources/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- iCheck 1.0.1 -->
	<script src="/digitalCrm/resources/plugins/iCheck/icheck.min.js"></script>
	<!-- Select2 -->
	<script
		src="/digitalCrm/resources/bower_components/select2/dist/js/select2.full.min.js"></script>


	<!-- AdminLTE App -->
	<script src="/digitalCrm/resources/dist/js/adminlte.min.js"></script>

	<!-- FastClick -->
	<script
		src="/digitalCrm/resources/bower_components/fastclick/lib/fastclick.js"></script>

	<!-- Bootstrap slider -->
	<script
		src="/digitalCrm/resources/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/digitalCrm/resources/dist/js/demo.js"></script>
	<!-- DataTables -->
	<script
		src="/digitalCrm/resources/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="/digitalCrm/resources/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<!-- fullCalendar -->
	<script src="/digitalCrm/resources/bower_components/moment/moment.js"></script>
	<script
		src="/digitalCrm/resources/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>

	<script
		src="/digitalCrm/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.flash.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!-- iCheck -->
	<script src="/digitalCrm/resources/plugins/iCheck/icheck.min.js"></script>

	<!-- ChartJS -->
	<script src="/digitalCrm/resources/bower_components/chart.js/Chart.js"></script>

	<script
		src="/digitalCrm/resources/bower_components/morris.js/morris.min.js"></script>
	<!-- sweet Alert -->

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!-- <script type="text/javascript" src="/digitalCrm/resources/bower_components/jquery-slimscroll/jquery.slimscroll.js"></script> -->

</body>
</html>
