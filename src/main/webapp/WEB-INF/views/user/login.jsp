<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jsp"%>

<style type="text/css">

</style>

<!-- Main content -->
<section class="content">
	<div class="row">
		
		<form action="/user/loginPost" method="post">
			<div class="form-group has-feedback">
				<input type="text" name="email" class="form-control" placeholder="USER EMAIL"/>
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" name="pw" class="form-control" placeholder="PASSWORD"/>
				<span class="glyphicon glyphicon-lock form-control-feedback"/></span> 
			</div>
			
			<button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
		</form>
		
<%-- 		<%@include file="../include/right_up.jsp"%>
		
		<%@include file="../include/right_down.jsp"%> --%>
	</div>
	<!--./row-->
</section>
<!-- /.content -->

<%@ include file="../include/footer.jsp"%>