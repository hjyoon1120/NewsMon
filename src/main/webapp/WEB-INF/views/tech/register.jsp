<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-8">
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">REGISTER</h3>
				</div>
				<!-- /.box-header -->
				<form id='registerForm' role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label>TITLE</label> <input type="text" name="title"
								class="form-control" placeholder="Enter TITLE" /> <label>SUBTITLE</label>
							<input type="text" name="subtitle" class="form-control"
								placeholder="Enter SUBTITLE" />
							<div class="row">
								<div class="col-xs-4">
									<label>PRESS</label> <input type="text" name="press"
										class="form-control" placeholder="Enter PRESS" />
								</div>
								<div class="col-xs-4">
									<label>REPOTER</label> <input type="text" name="reporter_id"
										class="form-control" placeholder="Enter REPOTER" value="${login.uid}" readonly/>
								</div>
								
								<div class="col-xs-4">
									<label>Attach Image</label>
									<div class="form-group">
										<div class="btn btn-default btn-file">
											<i class="fa fa-paperclip"></i>
											<input class="fileUpload" type="file" accept="image/*" name="attachment">
										</div>
									</div>
								</div>
							
							</div>
							<ul class="mailbox-attachments clearfix uploadedList"></</ul>
							<hr>
							<label>CONTENT</label>
							<textarea class="form-control" name="content" rows="10"
								placeholder="Enter Content..."></textarea>
							<!-- <textarea class="textarea" name="content" placeholder="Place some text here" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea> -->
							<hr>
							<label>QUERY</label> <input type="text" name="query"
								class="form-control" placeholder="Enter QUERY" />
								
							
						</div>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-success pull-right">SUBMIT</button>
					</div>
					<!-- /.box-footer -->
				</form>
				<!-- /.form -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!--./row-->
</section>
<!-- /.content -->

<script id="template" type="text/x-handlebars-template">
<li>
	<span class="mailbox-attachment-icon has-img">
		<img src="{{imgsrc}}" alt="Attachment">
	</span>
	<div class="mailbox-attachment-info">
		<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
		<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn">
			<i class="fa fa-fw fa-remove"></i>
		</a>
	</div>
</li>
<input type='hidden' name='fullName' value='{{getLink}}'>

</script>


<script>
	
	var template = Handlebars.compile($("#template").html());
	
	$(".fileUpload").change(function(event){
		
		var files = event.currentTarget.files;
		var file = files[0];
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url: '/tech_upload',
			data: formData,
			dataType: 'text',
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data){
				
				var fileInfo = getTechFileInfo(data);
				
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			}
		});
	});
	
	$("#registerForm").submit(function(event) {
		
		event.preventDefault();
		
		var that = $(this);
		
		var str = "";
		
		$(".uploadedList .delbtn").each(function(index){
			
			str += "<input type='hidden' name='files[" + index
			    	+ "]' value='" + $(this).attr("href") + "'>";
			    	
			console.log("str" + str);
		});
		
		that.append(str);
		that.get(0).submit();
	});
	
	$(".uploadedList").on("click", ".delbtn", function(event){
		
		event.preventDefault();
		
		var that = $(this);
		
		$.ajax({
			
			url:"/tech_delete",
			type:"POST",
			data:{fileName:$(this).attr("href")},
			dataType:"text",
			success:function(result){
				if(result == 'deleted') {
					that.closest("li").remove();
				}
			}
		});
	});
</script>


<%@ include file="../include/footer.jsp"%>