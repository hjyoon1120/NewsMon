<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<body>
	<h2> Ajax Test Page</h2>
	<ul id="voteList">
	
	</ul>
	
	<div id="voteDiv">
		<div>VOTER <input type='text' name='voter_id' id='voter_id'></div>
		<span class="voteBtn" id="positiveBtn" data-result = "positive">POSITIVE</span>
		<span class="voteBtn" id="positiveBtn" data-result = "negative">NEGATIVE</span>
	</div>
	
	
	
	<script>
	
	$(document).ready(function(){
		
		var eno = 4;
		var str = "";
		getAllVoteList();
		
		
		$(".voteBtn").on("click", function(){
			var voter_id = $("#voter_id").val();
			var result = $(this).attr("data-result");
			console.log("result: "+ result + "voter_id: " + voter_id);
			
			$.ajax({
				type:'post',
				url : '/enm_vote',
				headers : {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"POST"
				},
				dataType:'text',
				data : JSON.stringify({
					eno : eno,
					voter_id : voter_id,
					result : result
				}),
				success : function(result){
					if (result == 'SUCCESS'){
						$("#voteDiv").hide();												
						getAllVoteList();
						alert("OK");
					}
				}
			});
		});
		
		
		function getAllVoteList(){
			$.getJSON("/enm_vote/all/" + eno, function(data) {
				console.log(data.length);
				
				$(data).each(function(){
					str += "<li data-vno='" + this.vno + "' class='voteLi'>" + "voter_id: " + this.voter_id + " | " + "result: " + this.result + " | " + "regdate: " + this.regdate + "</li>";
				});
				
				$("#voteList").html(str);
			});
			
		}
	});
	</script>
</body>
</html>