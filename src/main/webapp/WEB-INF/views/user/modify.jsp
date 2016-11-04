<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<script
	src="//assets.codepen.io/assets/common/stopExecutionOnTimeout-53beeb1a007ec32040abaf4c9385ebfc.js"></script>
<!-- Main content -->
<section class="content">
	<div class="register-box">
		<div class="register-logo">
			<a href="/"><b>NEWS</b>MON</a>
		</div>

		<div class="register-box-body">
			<p class="login-box-msg">Modify your account information</p>

			<form role="form" action=modify method="post">
				<input type='hidden' name='uid' value="${userVO.uid}">
				<input type='hidden' name='page' value="${cri_ten.page}">
				<input type='hidden' name='perPageNum' value="${cri_ten.perPageNum}"> 

				<div class="form-group has-feedback">
					<input type="email" class="form-control" name="email"
						placeholder="Email" value="${userVO.email}" readonly> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" id="password" class="form-control" name="pw"
						placeholder="Password" value="${userVO.pw}"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" id="confirm_password" class="form-control"
						placeholder="Retype password" value="${userVO.pw}"> <span
						class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="nickname"
						placeholder="Nickname" value="${userVO.nickname}"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="row">
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-success btn-block btn-flat">SUBMIT</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->
</section>
<!-- /.content -->

<script>
	var password = document.getElementById("password"), confirm_password = document
			.getElementById("confirm_password");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
	
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function() {
			
			var msg = "Are you sure you want to discard your changes?";

			if (confirm(msg) != 0) {
				
				self.location = "/";
				
			} else {
					
			}
		});
		
		$(".btn-success").on("click", function() {
			
			formObj.submit();
			
		});
	});
</script>

<%@ include file="../include/footer.jsp"%>