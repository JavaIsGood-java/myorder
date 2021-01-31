<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/adjs/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<script>
			$(function(){
				$("#adusername").focus(function(){
					$("#msg").text("");	
				});	
				$("#adpassword").focus(function(){
					$("#msg").text("");	
				});	
			});
			function check(){
				if($("#password").val()==null||$("#password").val().trim()==""){
					alert("原密码不能为空");
					return false;
				}
				if($("#npassword").val()==null||$("#npassword").val().trim()==""){
					alert("新密码不能为空");
					return false;
				}
				if($("#qpassword").val()==null||$("#qpassword").val().trim()==""){
					alert("确认密码不能为空");
					return false;
				}
				if($("#npassword").val().length>16||$("#npassword").val()<6){
					alert("新密码长度为6~16位");
					return false;
				}
				if($("#npassword").val()!=$("#qpassword").val()){
					alert("两次密码输入不同");
					return false;
				}
				return true;
			}
		</script>
		<title>修改密码</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/a/index">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<form action="${pageContext.request.contextPath }/a/adcp" method="post" data-ajax="false" onsubmit="return check()">
					<label for="password">原密码：</label>
					<input type="password" name="password" id="password"/>
					
					<label for="npassword">新密码：</label>
					<input type="password" name="npassword" id="npassword" maxlength="16"/>
					
					<label for="qpassword">确认密码：</label>
					<input type="password" name="qpassword" id="qpassword" maxlength="16"/>
					<input type="submit" value="提交"/>
				</form>
			</div>
		</div> 
	</body>
</html>