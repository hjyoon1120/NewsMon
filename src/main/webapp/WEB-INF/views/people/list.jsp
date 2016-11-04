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
					<h3 class="box-title">People News List</h3>
					<c:if test = "${not empty login }">
						<c:if test="${login.isreporter}">
							<button id='newBtn'>Write</button>
						</c:if>
					</c:if>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">PNO</th>
							<th>TITLE</th>
							<th>REPORTER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
							<th>IMAGE</th>
						</tr>

						<c:forEach items="${list}" var="peopleNewsVO">
							<script>
								$(document).ready(function(){
									var pno = ${peopleNewsVO.pno};
									
									$.getJSON("/people/getAttach/" + pno, function(list){
										$(list).each(function(){
											var fileInfo = getPeopleFileInfo(this);
											var html="<img class='attachment-img' src='" + fileInfo.imgsrc + "' alt='Attachment Image'>"
											$(".clearfix${peopleNewsVO.pno}").prepend(html);
										});
									});
								});
							</script>

							<tr>
								<td>${peopleNewsVO.pno}</td>
								<td><a
									href='/people/read${pageMaker_ten.makeSearch(pageMaker_ten.cri_ten.page) }&pno=${peopleNewsVO.pno}'>
										${peopleNewsVO.title} </a></td>
								<td>${peopleNewsVO.nickname}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${peopleNewsVO.regdate}" /></td>
								<td><span class="badge bg-red">${peopleNewsVO.viewcnt }</span></td>
								<td><div class="clearfix${peopleNewsVO.pno}"></div></td>
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
			self.location = "/people/register";
		});
	});
</script>

<%@include file="../include/footer.jsp"%>