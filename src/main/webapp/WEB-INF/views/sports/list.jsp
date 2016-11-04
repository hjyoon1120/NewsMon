<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-8">
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">Sports News List</h3>
					<c:if test = "${not empty login }">
						<c:if test="${login.isreporter}">
							<button id='newBtn'>Write</button>
						</c:if>
					</c:if>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">ENO</th>
							<th>TITLE</th>
							<th>REPORTER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
							<th>IMAGE</th>
						</tr>

						<c:forEach items="${list}" var="sportsNewsVO">
							<script>
								$(document).ready(function(){
									var sno = ${sportsNewsVO.sno};
									
									$.getJSON("/sports/getAttach/" + sno, function(list){
										$(list).each(function(){
											var fileInfo = getSportsFileInfo(this);
											var html="<img class='attachment-img' src='" + fileInfo.imgsrc + "' alt='Attachment Image'>"
											$(".clearfix${sportsNewsVO.sno}").prepend(html);
										});
									});
								});
							</script>

							<tr>
								<td>${sportsNewsVO.sno}</td>
								<td><a
									href='/sports/read${pageMaker_ten.makeSearch(pageMaker_ten.cri_ten.page) }&sno=${sportsNewsVO.sno}'>
										${sportsNewsVO.title} </a></td>
								<td>${sportsNewsVO.nickname}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${sportsNewsVO.regdate}" /></td>
								<td><span class="badge bg-red">${sportsNewsVO.viewcnt }</span></td>
								<td><div class="clearfix${sportsNewsVO.sno}"></div></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker_ten.prev}">
								<li><a
									href="list${pageMaker_ten.makeSearch(pageMaker_ten.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker_ten.startPage }"
								end="${pageMaker_ten.endPage }" var="idx">
								<li
									<c:out value="${pageMaker_ten.cri_ten.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker_ten.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker_ten.next && pageMaker_ten.endPage > 0}">
								<li><a
									href="list${pageMaker_ten.makeSearch(pageMaker_ten.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->
		
		<%@include file="../include/right_up.jsp"%>
		
		<%@include file="../include/right_down.jsp"%>

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<script>
	var result = "${msg}";
	
	if(result == 'register'){
		alert('Register Success');
	} else if (result == 'remove') {
		alert("Remove Success");
	} else if(result == 'modify'){
		alert("Modify Success");
	}
	
	$(document).ready(function(){
		
		$("#newBtn").on("click", function(evt){
			self.location = "/sports/register";
		});
	});
</script>

<%@include file="../include/footer.jsp"%>