<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c.tld" %>
<%@ taglib prefix="fn" uri="fn.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<script type="text/javascript">
			function changeImg(file,i){
				var img=document.getElementById(('img'+i));
				if (file.files&&file.files[0]) {
					var reader = new FileReader();
					reader.onload = function(evt) {
					img.src = evt.target.result;
				}
				reader.readAsDataURL(file.files[0]);
				}else {
					img.style = "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\" + file.value + \")";
				}
			}
			
			$(document).ready(function(){
			    $('#img1').click(function(){
			        $('#img-upload1').click();
			    });
			    $('#img2').click(function(){
			        $('#img-upload2').click();
			    });
			});
		</script>
		<title>认证中心</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/index">返回</a>
			    <h1></h1>
		    </div>
		    
			<div data-role="main" class="ui-content">
				<p>${msg }</p>
				
				<c:if test="${ap!=null }">
					<p>身份证照片：</p>
					<center><img width="60%" src="${pageContext.request.contextPath }/img/${ap.appath1 }"  data-ajax="false"/></center>
					<p>学生证：</p>
					<center><img width="60%" src="${pageContext.request.contextPath }/img/${ap.appath2 }"  data-ajax="false"/></center>
				</c:if>
				
				<c:if test="${fn:contains(msg,\"认证失败\")||msg==null }">
					<form action="${pageContext.request.contextPath }/ren" method="post" enctype="multipart/form-data" data-ajax="false">
						<label for="img-upload1">身份证正面：</label>
				  		<input type="file"  id="img-upload1" name="picFile" style="display:none;" onchange="changeImg(this,1)" accept="image/jpg" data-ajax="false"/>
				  		<center><img id="img1"  width="50%" src="${pageContext.request.contextPath }/image/2.png" data-ajax="false"/></center>
				  		<br>
				  		<label for="img-upload2">学生证：</label>	
				  		<input type="file"  id="img-upload2" name="picFile" style="display:none;" onchange="changeImg(this,2)" accept="image/jpg" data-ajax="false"/>
				  		<center><img id="img2" width="50%" src="${pageContext.request.contextPath }/image/2.png" data-ajax="false"/></center>
				  		<input type="submit" value="上传"/>
					</form>
				</c:if>
			</div>
		</div>
	</body>
</html>