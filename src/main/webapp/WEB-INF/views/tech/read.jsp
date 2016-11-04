<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<style type="text/css">
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}

.popup {
	position:  absolute;
}

.back {
	background-color: gray; 
	opacity: 0.5;
	width: 100%;
	heigth: 300%;
	overflow: hidden;
	z-index:1101;
}

.front {
	z-index:1110;
	opacity:1;
	oarder:1px;
	margin: auto;
}

.show{
	position:relative;
	max-width: 1200px;
	max-height: 800px;
	overflow: auto;
}
</style>

<!-- Main content -->
<section class="content">
	<div class="row">
		<form role="form" method="post">
			<input type='hidden' name='tno' value="${techNewsVO.tno}">
			<input type='hidden' name='page' value="${cri_ten.page}"> <input
				type='hidden' name='perPageNum' value="${cri_ten.perPageNum}"> <input
				type='hidden' name='keyword' value="${cri_ten.keyword}">
			<!-- <input type='hidden' name='voter' value="123"> -->
		</form>

		<div class="col-md-8">
			<div class="box box-success">
				<div class="box-header with-border">
					
					<small> <i class="fa fa-pencil"></i>&nbsp;${techNewsVO.press}
						&nbsp;|&nbsp; ${techNewsVO.nickname}
					</small> &nbsp;-&nbsp; <span class="description"> <i
						class="fa fa-clock-o"></i> <fmt:formatDate
							pattern="yyyy-MM-dd HH:mm" value="${techNewsVO.regdate}" />
						&nbsp;|&nbsp;<b>UPDATED</b> <fmt:formatDate
							pattern="yyyy-MM-dd HH:mm" value="${techNewsVO.uptdate}" />
					</span>
					<div class="box-tools pull-right">
						<button class='btn btn-box-tool' id='backBtn'><a href="/tech/list/">
							<i class='fa fa-chevron-left'></i></a>
						</button>
						<c:if test="${login.uid == techNewsVO.reporter_id }">
							<button class='btn btn-box-tool' type="submit" id='modifyBtn'>
								<i class='fa fa-wrench'></i>
							</button>
							<button class='btn btn-box-tool' type="submit" id='removeBtn'>
								<i class='fa fa-times'></i>
							</button>
						</c:if>
					</div>
					<br>
					<h1>${techNewsVO.title}</h1>
					<span class="description">${techNewsVO.subtitle}</span>
				</div>
				<div class="box-body uploadedList">
					
				</div>
				<!-- /.box-header -->
				
				<div class="box-body no-padding">
					<div class="mailbox-read-message">${techNewsVO.content}</div>
					<!-- /.mailbox-read-message -->
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<div class="text-center">
						<a class="btn btn-social-icon btn-facebook"><i
							class="fa fa-facebook"></i></a> <a
							class="btn btn-social-icon btn-google"><i
							class="fa fa-google-plus"></i></a> <a
							class="btn btn-social-icon btn-instagram"><i
							class="fa fa-instagram"></i></a> <a
							class="btn btn-social-icon btn-twitter"><i
							class="fa fa-twitter"></i></a>
					</div>
				</div>
				<!-- /.box-footer -->
				<div class="box-footer">
					<div>
						<h4 class="text" style="float: left;">
							<b>투표 상황</b> | ${techNewsVO.query}
						</h4>
						<span class="pull-right text-muted">
							
							
							&nbsp;<i class="fa fa-bar-chart"></i>
						</span><br>
						<span class="pull-right text-muted"><span id="replyCnt">${techNewsVO.replycnt}</span>&nbsp;<i class="fa fa-commenting"></i></span>
						
					</div>
				</div>
				<!-- /.box-footer -->
				<div class="box-footer">
					<div class="info-box">
						<div>
						<span class="text-muted">
							찬성:&nbsp;&nbsp;<span id = "positiveRate">${techNewsVO.vote_rate}</span>%&nbsp;&nbsp;|&nbsp;&nbsp;<span>${techNewsVO.votecnt_positive}명</span>
						</span>
						<span class="text-muted pull-right">
							반대:&nbsp;&nbsp;<span id = "negativeRate"></span>%&nbsp;&nbsp;|&nbsp;&nbsp;
							<span class="text-muted pull-right">${techNewsVO.votecnt_negative}명</span>
						</span>
						</div>
						<div class="info-box bg-light-blue-gradient"
							style="width: ${techNewsVO.vote_rate}%; float: left;">
							<span class="info-box-icon" id="positiveBtn" data-choice = "positive"> <i
								class="fa fa-thumbs-o-up"></i>
							</span>
							
						</div>
						<div class="info-box bg-red-gradient" id="negativeBtn">
							<span class="info-box-icon pull-right"
								transform: scaleX(-1);" id="negativeBtn" data-choice = "negative"> <i
								class="fa fa-thumbs-o-down"></i>
							</span>
						</div>
					</div>
				</div>
				<!-- /.box-footer -->
				<div class="box-footer">
					<div class="col-sm-6 no-padding">
						<div class="box box-solid">
							<div class="box-header with-border">
								<h3 class="box-title">뉴스몬이 뽑은 베스트 댓글</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="box-group">
									<!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
									<div class="panel box box-primary">
										<div class="box-header with-border">
											<div class="user-block">
												<img class="img-circle"
													src="/resources/dist/img/user1-128x128.jpg"
													alt="user image"> <span class="username">Lv.3
													아이디_1</span> <span class="description">09.06 18:20</span>
											</div>
										</div>
										<div class="panel-collapse collapse in">
											<div class="box-body">
												<p>직접적으로 기록된 문서라..하 정말 어이가 없어서 코웃음만 나오네 강도가 남의 집주인 죽이고
													부인을 능욕하고 집안 터는걸 강도가 기록으로 잘도 남겨....</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!--/.col-->
					<div class="col-sm-6 no-padding">
						<div class="box box-solid">
							<div class="box-header with-border">
								<h3 class="box-title">네티즌이 뽑은 베스트 댓글</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="box-group">
									<!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
									<div class="panel box box-danger">
										<div class="box-header with-border">
											<div class="user-block">
												<img class="img-circle"
													src="/resources/dist/img/user1-128x128.jpg"
													alt="user image"> <span class="username">Lv.3
													아이디_4</span> <span class="description">09.06 18:20</span>
											</div>
										</div>
										<div class="panel-collapse collapse in">
											<div class="box-body">
												<p>직접적으로 기록된 문서라..하 정말 어이가 없어서 코웃음만 나오네 강도가 남의 집주인 죽이고
													부인을 능욕하고 집안 터는걸 강도가 기록으로 잘도 남겨....</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!--/.col-->
				</div>
				<!-- /.box-footer -->
				
				<c:if test="${not empty login}">
				<div class="box-footer">
					<!-- <b>ITEM INVENTORY :</b>
			<div class="btn-group">
				<ul class="fc-color-picker" id="color-chooser">
					<li><a class="text-aqua" href="#"><i class="fa fa-cloud"></i></a></li>
					<li><a class="text-blue" href="#"><i class="fa fa-bolt"></i></a></li>
					<li><a class="text-light-blue" href="#"><i
							class="fa fa-eye-slash"></i></a></li>
					<li><a class="text-teal" href="#"><i class="fa fa-eye"></i></a></li>
					<li><a class="text-yellow" href="#"><i
							class="fa fa-frown-o"></i></a></li>
					<li><a class="text-orange" href="#"><i class="fa fa-magic"></i></a></li>
					<li><a class="text-green" href="#"><i class="fa fa-legal"></i></a></li>
					<li><a class="text-lime" href="#"><i class="fa fa-paw"></i></a></li>
					<li><a class="text-red" href="#"><i class="fa fa-square"></i></a></li>
					<li><a class="text-purple" href="#"><i
							class="fa fa-quote-left"></i></a></li>
					<li><a class="text-fuchsia" href="#"><i
							class="fa fa-trash-o"></i></a></li>
					<li><a class="text-muted" href="#"><i
							class="fa fa-wheelchair"></i></a></li>
					<li><a class="text-navy" href="#"><i
							class="fa fa-compress"></i></a></li>
				</ul>
			</div> -->
					<!-- <form action="#" method="post">
				<img class="img-responsive img-circle img-sm"
					src="dist/img/user4-128x128.jpg" alt="Alt Text">
				.img-push is used to add margin to elements next to floating images
				<div class="img-push">
					<input type="text" class="form-control input-sm"
						placeholder="Press enter to post comment">
				</div>
			</form> -->
					<img class="img-responsive img-circle img-sm"
						src="../resources/dist/img/user4-128x128.jpg" alt="Alt Text">
					<!-- .img-push is used to add margin to elements next to floating images -->
					<div class="img-push">
						<div class="input-group input-group-sm">
							<input type='hidden' id='inputReplyerId' value="${login.uid}">
							<input type='hidden' id='inputReplyer' name ="nickname" value="${login.nickname}">
							<input type="text" class="form-control" id="inputReplyText"	placeholder="Press enter to post comment...">
							<span class="input-group-btn">
								<button type="button" class="btn btn-success btn-flat"
									id="replyAddBtn">
									<i class="fa fa-send-o"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
				<!-- /.box-footer -->
				</c:if>
				
				<c:if test="${empty login}">
					<div class="box-footer">
						<div><a href="../user/login">Login Please</a></div>
					</div>
				</c:if>
				<div class="box-footer box-comments" id="replylist">
					
					<div class="text-center">
						<ul id="pagination" class="pagination pagination-sm no-margin"></ul>
						<!-- <span><b>View more comments</b></span> -->
					</div>
				</div>
				<!-- /.box-footer -->
			</div>
			<!-- /. box -->
		</div>
		<!--/.col-->

		<!-- Modal -->
		<div id="modifyModal" class="modal modal-primary fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body" data-rno>
						<p>
							<input type="text" id="replytext" class="form-control">
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
						<button type="button" class="btn btn-danger" id="replyDelBtn">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.Modal -->
		
		<!-- img popup -->
		<div class='popup back' style="display:none;"></div>
		<div id='popup_front' class="popup front" style="display:none;">
			<img id="popup_img">
		</div>	
		<!-- /.popup -->
		<%@include file="../include/right_up.jsp"%>
		
		<%@include file="../include/right_down.jsp"%>
	</div>
	<!--./row-->
</section>
<!-- /.content -->

<script id="template" type="text/x-handlebars-template">
{{#each .}}

<div class="box-comment" data-rno={{rno}}>

	<!-- User image -->
	<img class="img-circle img-sm" src="../resources/dist/img/user3-128x128.jpg" alt="User Image">
	
	<div class="comment-text">
		<span class="username"> {{nickname}} 
			<span class="text-muted pull-right">
				<i class="fa fa-clock-o">&nbsp;{{prettifyDate regdate}}</i>
			</span>
		</span><!-- /.username -->
	</div>

	<div class="comment-text reply">{{replytext}}
		{{#eqReplyer_id replyer_id}}
			<a class="pull-right" data-toggle="modal" data-target="#modifyModal"><i class="fa fa-gear"></i></a>
		{{/eqReplyer_id}}
	</div>
	<!-- /.comment-text -->
</div>

{{/each}}
</script>

<script id="templateAttach" type="text/x-handlebars-template">
<!-- <li data-src='{{fullName}}'>
	<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
	<div class="mailbox-attachment-info">
		<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</div>
</li> -->
<div data-src='{{fullName}}'>
	<img class="img-responsive pad" src="{{getLink}}" alt="Photo" style="margin:auto;">
</div>
</script>

<script>
	Handlebars.registerHelper("eqReplyer_id", function(replyer_id, block){
		var accum = '';
		if(replyer_id == '${login.uid}'){
			
			accum += block.fn();
		}
		return accum;
	})

	Handlebars.registerHelper("prettifyDate", function(timeValue) {

		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();

		return year + "/" + month + "/" + date;
	});

	var printData = function(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);

		$(".box-comment").remove();
		target.prepend(html);
	}

	var tno = ${techNewsVO.tno};
	var replyPage = 1;

	function getPage(pageInfo) {

		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#replylist"), $("#template"));
			printPaging(data.pageMaker_ten, $("#pagination"));
			
			$("#modifyModal").modal('hide');

		});
	}

	var printPaging = function(pageMaker_ten, target) {

		var str = "";

		if (pageMaker_ten.prev) {
			str += "<li><a href='" + (pageMaker_ten.startPage - 1)
					+ "'> << </a></li>";
		}

		for (var i = pageMaker_ten.startPage, len = pageMaker_ten.endPage; i <= len; i++) {
			var strClass = pageMaker_ten.cri_ten.page == i ? 'class=active'
					: '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}

		if (pageMaker_ten.next) {
			str += "<li><a href='" + (pageMaker_ten.endPage + 1)
					+ "'> >> </a></li>";
		}

		target.html(str);
	};

	getPage("/tech_replies/" + tno + "/1");

	$("#pagination").on("click", "li a", function(event) {

		event.preventDefault();
		replyPage = $(this).attr("href");

		getPage("/tech_replies/" + tno + "/" + replyPage);
	});

	$("#replyAddBtn").on("click", function() {
		var idObj = $("#inputReplyerId")
		var replyerObj = $("#inputReplyer");
		var replytextObj = $("#inputReplyText");
		
		var id = idObj.val();
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();

		$.ajax({
			type : 'post',
			url : '/tech_replies/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({
				tno : tno,
				replyer_id : id,
				nickname : replyer,
				replytext : replytext
			}),
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("ADD REPLY SUCCESS");
					replyPage = 1;
					getPage("/tech_replies/" + tno + "/" + replyPage);
					/* replyerObj.val(""); */
					replytextObj.val("");
					
					var replyCnt = $('#replyCnt').text();
					replyCnt = parseInt(replyCnt)+1;
					$('#replyCnt').text(replyCnt);
				}
			}
		});
	});

	$("#replylist").on("click", ".box-comment", function(event) {

		var reply = $(this);

		$("#replytext").val(reply.find(".reply").text());
		$(".modal-title").html(reply.attr("data-rno"));
	});

	$("#replyModBtn").on("click", function() {

		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'put',
			url : '/tech_replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify({
				replytext : replytext
			}),
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					alert("MODIFY SUCCESS");
					getPage("/tech_replies/" + tno + "/" + replyPage);
				}
			}
		});
	});

	$("#replyDelBtn").on("click", function() {
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'delete',
			url : '/tech_replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("REMOVE SUCCESS");
					getPage("/tech_replies/" + tno + "/" + replyPage);
					
					var replyCnt = $('#replyCnt').text();
					replyCnt = parseInt(replyCnt)-1;
					$('#replyCnt').text(replyCnt);

				}
			}
		});
	});
	
</script>

<script>

	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);
		
		$("#modifyBtn").on("click", function() {
			formObj.attr("action", "/tech/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#removeBtn").on("click", function() {
			
			var replyCnt = $("#replyCnt").html();
			console.log(replyCnt);
			console.log(replyCnt>0);
			
			if(replyCnt > 0){
				
				alert("댓글이 달린 게시물을 삭제할 수 없습니다.");
				
				return;
				
			} else {
				
				var msg = "삭제하시겠습니까?";
				
				if (confirm(msg) != 0) {
					
					var arr = [];
					
					$(".uploadedList li").each(function(index){
						
						arr.push($(this).attr("data-src"));
					});
					
					if(arr.length > 0) {
						$.post("/tech_delAll", {files:arr}, function(){
							
						});
					}
					
					formObj.attr("action", "/tech/remove");
					formObj.submit();
				} else {
					return;
				}
			}
		});

/* 		$("#backBtn").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/tech/");
			formObj.submit();

		}); */
		
		var tno = ${techNewsVO.tno};
		var template = Handlebars.compile($("#templateAttach").html());
		
		$.getJSON("/tech/getAttach/" + tno, function(list){
			$(list).each(function(){
				
				var fileInfo = getTechFileInfo(this);
				
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			});
		});
		
		$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
			
			var fileLink = $(this).attr("href");
			
			if(checkImageType(fileLink)){
				
				event.preventDefault();
				
				var imgTag = $("#popup_img");
				imgTag.attr("src", fileLink);
				
				console.log(imgTag.attr("src"));
				
				$(".popup").show('slow');
				imgTag.addClass("show");
			}
		});
		
		$("#popup_img").on("click", function(){
			
			$(".popup").hide('slow');
			
		});
		
		
		function calcRate(){
			var negativeRate = 100 - ${techNewsVO.vote_rate};
			console.log(negativeRate);
			document.getElementById("negativeRate").innerHTML = negativeRate;
		}
		calcRate();
		
		/* $(".info-box-icon").on("click", function() {
			console.log("positiveBtn");
			
			console.log($(this)[0]);
			
			console.log($(this).attr("data-choice"));
			
			var votedMap = new Map();
			
			votedMap.set("1111", "positive");
			votedMap.set("2222", "negative");
			votedMap.set("3333", "positive");
			votedMap.set("4444", "negative");

			console.log(votedMap);
			
			var sno = ${societyNewsVO.sno};
			var voter = "4444";
			var choice = $(this).attr("data-choice");
			
			if(voter in votedMap) {
				console.log(voter in votedMap);
				console.log("result::::::");
				
				
				console.log(votedMap.get(voter));
				
			}
			
			/* if(voter in votedMap == false) {
				
				$.ajax({
					type : 'post',
					url : '/society_vote/',
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : 'text',
					data : JSON.stringify({
						sno : sno,
						voter : voter,
						choice : choice
					}),
					success : function(result) {
						console.log("result: " + result);
						if (result == 'SUCCESS') {
							alert("VOTE SUCCESS");
						}
					}
				}); 
				
				voteMap[voter] = {choice:choice};
			} else(voter in votedMap == true) {
				
			}
			
			console.log("after~~~~~");
			console.log(votedMap);
			
			
		}); */
		
	});
</script>
<%@ include file="../include/footer.jsp"%>