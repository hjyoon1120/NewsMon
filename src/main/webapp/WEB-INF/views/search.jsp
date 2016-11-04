<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="include/header.jsp"%>

<div class="col-md-8">
	<div class="box box-success">

		<div class="box-header with-border">
			<h3 class="box-title">Society News List</h3>
		</div>
		<!--/.box-header-->
		<div class="box-body">
			<table class="table table-bordered">
				<tr>
					<th>TITLE</th>
					<th>SUBTITLE</th>
					<th>QUERY</th>
					<th>REGDATE</th>
				</tr>
				<c:forEach items="${societyList}" var="societyNewsVO">
					<tr class="societyRow"
						data-href='/society/read${pageMaker.makeSearch(pageMaker.cri_ten.page)}&sno=${societyNewsVO.sno}'>
						<td>${societyNewsVO.title}</td>
						<td>${societyNewsVO.subtitle}</td>
						<td>${societyNewsVO.query}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${societyNewsVO.regdate}"></fmt:formatDate></td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<!--/.box-body-->

		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev}">
						<li><a href="${pageMaker.makeSearch(pageMaker.startPage-1)}">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
						<li
							<c:out value="${pageMaker.cri_ten.page == idx ? 'class = active ' : ''}"/>>
							<a href="${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage >0}">
						<li><a
							href="${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>
				</ul>
				<!-- /.pagination -->
			</div>

		</div>
		<!-- /.box-footer -->
	</div>
	<!--/.box-->
</div>
<!--/.col-->

<script>
	$(document).ready(function() {
		$(".societyRow").click(function() {
			window.location = $(this).data("href");
		});
	});
</script>

<%@include file="include/footer.jsp"%>