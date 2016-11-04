<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-8">
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">REGISTER</h3>
				</div>
				<!-- /.box-header -->
				<form role="form" method="post">
					<input type='hidden' name='cno' value="${cultureNewsVO.cno}">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="box-body">
						<div class="form-group">
							<label>TITLE</label> <input type="text" name="title"
								class="form-control" value="${cultureNewsVO.title}" /> <label>SUBTITLE</label>
							<input type="text" name="subtitle" class="form-control"
								value="${cultureNewsVO.subtitle}" />
							<div class="row">
								<div class="col-xs-4">
									<label>PRESS</label> <input type="text" name="press"
										class="form-control" value="${cultureNewsVO.press}" />
								</div>
								<div class="col-xs-4">
									<label>REPOTER</label> <input type="hidden" name="reporter_id"
										class="form-control" value="${cultureNewsVO.reporter_id}" readonly/>
										<input type="text" name="nickname"
										class="form-control" value="${cultureNewsVO.nickname}" readonly/>
								</div>
							</div>
							<hr>
							<label>CONTENT</label>
							<textarea class="form-control" name="content" rows="10">${cultureNewsVO.content}</textarea>
							<!-- <textarea class="textarea" name="content" placeholder="Place some text here" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea> -->
							<hr>
							<label>QUERY</label> <input type="text" name="query"
								class="form-control" value="${cultureNewsVO.query}" />
						</div>
					</div>
					<!-- /.box-body -->
				</form>
				<!-- /.form -->

				<div class="box-footer">
					<button type="submit" class="btn btn-success pull-right">SUBMIT</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>
				<!-- /.box-footer -->

			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->

		<%@include file="../include/right_up.jsp"%>
		
		<%@include file="../include/right_down.jsp"%>
	</div>
	<!--./row-->
</section>
<!-- /.content -->

<script>
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function() {
			
			var msg = "Are you sure you want to discard your changes?";

			if (confirm(msg) != 0) {
				
				self.location = "/culture/?page=${cri.page}&perPageNum=${cri.perPageNum}&keyword=${cri.keyword}";
				
			} else {
					
			}
		});
		
		$(".btn-success").on("click", function() {
			
			formObj.submit();
			
		});
	});
</script>
<%@include file="../include/footer.jsp"%>