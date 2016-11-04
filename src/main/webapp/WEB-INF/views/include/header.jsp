<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>NEWSmon | MONs group</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta
		content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
		name="viewport">
	<!-- Bootstrap 3.3.6 -->
	<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	
	<!-- Theme style -->
	<link rel="stylesheet" href="/resources/dist/css/AdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins
	         folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet"
		href="/resources/dist/css/skins/_all-skins.min.css">
	<!-- iCheck -->
    <link href="/resources/plugins/iCheck/flat/green.css" rel="stylesheet" type="text/css" />
	<!-- Date Picker -->
	<link rel="stylesheet"
		href="/resources/plugins/datepicker/datepicker3.css">
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>
	<script type="text/javascript" src="/resources/js/fileUpload.js"></script>
</head>

<body class="hold-transition skin-green sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<!-- Logo -->
			<a href="/" class="logo"> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>NEWS</b>MON</span>
			</a>

			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<div class="navbar-custom-menu text-center" style="float: left;">
					<ul class="nav navbar-nav" style="text-align: center;">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="/society/"><i
								class="fa fa-newspaper-o"></i><span class="hidden-xs"><b>&nbsp;SOCIETY</b></span></a>
						</li>
						<li class="dropdown messages-menu"><a href="/enm/"><i
								class="fa fa-star-half-o"></i><span class="hidden-xs"><b>&nbsp;ENTERTAINMENT</b></span></a>
						</li>
						<li class="dropdown messages-menu"><a href="/sports/"><i
								class="fa fa-soccer-ball-o"></i><span class="hidden-xs"><b>&nbsp;SPORTS</b></span></a>
						</li>
						<li class="dropdown messages-menu"><a href="/culture/"><i
								class="fa fa-camera-retro"></i><span class="hidden-xs"><b>&nbsp;CULTURE</b></span></a>
						</li>
						<li class="dropdown messages-menu"><a href="/people/"><i
								class="fa fa-group"></i><span class="hidden-xs"><b>&nbsp;PEOPLE</b></span></a>
						</li>
						<li class="dropdown messages-menu"><a href="/tech/"><i
								class="fa fa-flask"></i><span class="hidden-xs"><b>&nbsp;TECH</b></span></a>
						</li>
						<!-- <li class="dropdown messages-menu pull-right"><a href="/it/"><i
								class="fa fa-angle-double-down"></i>&nbsp;</span></a>
						</li> -->

					</ul>
				</div>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
					
						<%-- <div class="navbar-form navbar-left">
							<div class="form-group">
								<input type="text" class="form-control" id="navbar-search-input"
									name='keyword' value="${cri.keyword}">
								<button id="search-btn" class="btn btn-flat bg-green-active">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div> --%>
						
						<li class="dropdown messages-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-search"></i><span class="hidden-xs"><b>&nbsp;SEARCH</b></span></a>
							</a>
							<ul class="dropdown-menu">
									<li class="user-header" style="height:auto;">
										<div class="input-group input-group-sm">
											<input type="text" class="form-control" id="navbar-search-input"
												name='keyword' value="${cri.keyword}">
												<span class="input-group-btn">
													<button id="search-btn" class="btn btn-flat bg-green-active">
														<i class="fa fa-search"></i>
													</button>
												</span>
										</div>
									</li>
							</ul>
						</li>
						
						<!--User Account: style can be found in dropdown.less-->
						<c:if test="${empty login}">
							<li class="dropdown user user-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<i class="fa fa-sign-in"></i><span class="hidden-xs"><b>&nbsp;SIGN IN</b></span></a>
								</a>
								<form class="dropdown-menu" action="/user/loginPost" method="post">
										<li class="user-header" style="height:auto;">
											<p>Sign in to NEWSMON</p>
											<div class="form-group has-feedback">
												<input type="text" name="email" class="form-control" placeholder="EMAIL"/>
												<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
											</div>
											
											<div class="form-group has-feedback">
												<input type="password" name="pw" class="form-control" placeholder="PASSWORD"/>
												<span class="glyphicon glyphicon-lock form-control-feedback"></span>
											</div>
										</li>
										<li class="user-body no-padding">
											<div class="checkbox icheck" align="center">
												<label>
										   	    	<input type="checkbox" name="useCookie">&nbsp;Remember ID and Auto Login
										   	    </label>
										    </div>
										</li>
										
										
										<!--Menu Footer-->
										<li class="user-footer">
											
											<button type="submit" class="btn btn-default btn-flat">SIGN IN</button>
											
											<div class="pull-right">
												<a href="/user/register" class="btn btn-success btn-flat">SIGN UP</a>
											</div>
										</li>
								</form>
							</li>
						</c:if>
						
						<c:if test="${not empty login}">
						
							<li class="dropdown user user-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<img src="/resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
										<span class="hidden-xs">${login.nickname}</span>
								</a>
								<ul class="dropdown-menu">
									<li class="user-header">
										<img src="/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
										<p>${login.nickname}<small>Member since Nov. 2012</small></p>
										
									</li>
									<!-- Menu Body -->
									<li class="user-body">
										<div class="row">
											<div class="col-xs-4 text-center">
												<a href="#">Level</a><br>
												<span class="badge bg-green" align="center">31</span>
											</div>
											<div class="col-xs-4 text-center">
												<a href="#">Points</a>
												<span class="badge bg-yellow" align="center">1284</span>
											</div>
											<div class="col-xs-4 text-center">
												<a href="#">Interest</a>
												<span class="badge bg-blue" align="center">SPORTS</span>
											</div>
										</div> <!-- /.row -->
									</li>
									<li class="user-footer">
										<form role="modify" action="modify" method="post" class="pull-left">
											<input type='hidden' name='uid' value="${login.uid}">
										</form>
										<button id="modifyBtn" type="submit" class="btn btn-default btn-flat">Profile</button>
										<form action="/user/logout" method="post" class="pull-right">
											<button type="submit" class="btn btn-danger btn-flat">
												Sign out
											</button>
										</form>													
										<!-- <div class="pull-right" method="post">
											<a href="/user/logout" class="btn btn-default btn-flat">Sign out</a>
										</div> -->
									</li>
								</ul>
							</li>
							
						
						</c:if>
						
						<!-- <li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="/resources/dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">Alexander
									Pierce</span>
						</a>
							<ul class="dropdown-menu">
								User image
								<li class="user-header"><img
									src="/resources/dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">

									<p>
										Alexander Pierce - Web Developer <small>Member since
											Nov. 2012</small>
									</p></li>
								Menu Body
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> /.row
								</li>
								Menu Footer
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li> -->
					</ul>
				</div>
			</nav>
		</header>

		<script>
			$(document).ready(function() {
				
				var formObj = $("form[role='modify']");
				
				console.log(formObj);
				
				$("#modifyBtn").on("click", function(){
					formObj.attr("action", "/user/modify");
					formObj.attr("method", "get");
					formObj.submit();
				});
				
				$('#search-btn').on("click", function(event) {
					
					self.location = "/search/" + '${pageMaker.makeQuery(1)}'
									+ "&keyword=" + $('#navbar-search-input').val();
					
				});
				
			});
			
		</script>

		<div class="content-wrapper">