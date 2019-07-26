<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="myApp">
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
	href="/digitalCrm/resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="/digitalCrm/resources/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="/digitalCrm/resources/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">


<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="/digitalCrm/resources/dist/js/angular.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<style type="text/css">
.btn-primary-login {
	border-color: #737070 !important;
	background-color: #737070 !important;
	font-size: 20px;
	color: white;
	font-weight: bold;
}

.btn-primary-login:hover {
	color: white;
}
</style>

</head>
<body class="hold-transition login-page" ng-controller="myCtrl" ngCloak>


	<div class="row" style="margin-top: 0%;">
		<p>
			<a href="/digitalCrm/help" class="pull-right"
				style="padding-right: 40px;">Help & Support</a>
		</p>
		<div class="col-md-4">
			<img alt="" src="/digitalCrm/resources/image/c2.png"
				class="img-responsive"
				style="padding-top: 100px; padding-left: 10px;">
		</div>
		<div class="col-md-4">
			<div class="login-box">

				<span></span>
				<c:url var="loginUrl" value="/login" />
				<!-- /.login-logo -->
				<div class="login-box-body">
					<form action="${loginUrl}" method="POST">
						<c:if test="${param.logoutnondigitalCrm != null}">
							<div class="alert alert-danger" id="div1">
								<p>You are not authorized to access this application. Please
									contact the system administrator.</p>
							</div>
						</c:if>
						<c:if test="${param.error != null}">
							<div class="alert alert-danger" id="div1">
								<p>Invalid username and password.</p>
							</div>
						</c:if>
						<c:if test="${param.logoutdigitalCrm != null}">
							<div class="alert alert-success" id="div2">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>

						<c:if test="${param.success != null}">
							<div class="alert alert-success" id="div2">
								<p>You have been Register successfully.Please Login to
									Continue</p>
							</div>
						</c:if>
						<div class="row">
							<div class="col-md-10 col-md-offset-1">
								<img alt=""
									src="/digitalCrm/resources/image/generating-clipart-transparent-1.png"
									class="img-responsive">
							</div>

						</div>

						<div class="form-group has-feedback" style="margin-top: 25px;">
							<input type="text" name="username" id="username" maxlength="10"
								class="form-control" required
								placeholder="<spring:message code='placeholder.username' />">
							<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="password" name="password" id="password"
								class="form-control" required
								placeholder="<spring:message code='placeholder.password'  />">
							<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>
						<div class="row">
							<!-- /.col -->

							<div class="col-xs-12">
								<button type="submit"
									class="btn  btn-primary-login  btn-block btn-flat">Login</button>
							</div>




						</div>
					</form>
				</div>
				<!-- /.login-box-body -->
			</div>
		</div>

		<div class="col-md-4">
			<img alt="" src="/digitalCrm/resources/image/c1.png"
				class="img-responsive" style="padding-top: 100px;">
		</div>
	</div>

	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script
		src="/digitalCrm/resources/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="/digitalCrm/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="/digitalCrm/resources/plugins/iCheck/icheck.min.js"></script>
	<script
		src="/digitalCrm/resources/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!-- InputMask -->
	<script
		src="/digitalCrm/resources/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="/digitalCrm/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="/digitalCrm/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>

	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' /* optional */
			});
		});
	</script>

	<script>
		$(function() {
			//Initialize Select2 Elements
			//Datemask dd/mm/yyyy
			$('.dd').inputmask('yyyy-mm-dd', {
				'placeholder' : 'yyyy-mm-dd'
			})

		})
	</script>
</body>
</html>
