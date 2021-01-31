<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<style>
			#page {
				background-image:url(image/3.jpg);
			}
		</style>
		<script>
			$(document).ready(function(){
				$("#username").focus(function(){
					$("#msg").text("");
				});
				$("#password").focus(function(){
					$("#msg").text("");
				});
			});
			function check(){
				if($("#username").val()==null||$("#username").val().trim()==""){
					alert("用户名不能为空");
					return false;
				}
				if($("#password").val()==null||$("#password").val().trim()==""){
					alert("密码不能为空");
					return false;
				}
				return true;
			}
		</script>
		<title>登录</title>
	</head>
		
	<body>
		<div data-role="page" id="page">
			
			<div data-role="main" class="ui-content">
				<br><br><br>
				<center><p id="msg" style="width:50%;height:30px;text-align:center;">${msg }</p></center>
				<form action="${pageContext.request.contextPath }/login" method="post" data-ajax="false" data-transition="none" onsubmit="return check()">
					<input type="text" name="username" id="username" value="${user.username }" placeholder="用户名" data-clear-btn="true" maxlength="11"/>
					<input type="text" name="password" id="password" value="${user.password }" placeholder="密码" data-clear-btn="true" maxlength="16"/>
					<input type="submit" value="登录"/>
					<a href="${pageContext.request.contextPath }/reg" data-ajax="false" data-transition="none">注册</a>
				</form>
			</div>
		</div>
	</body>
</html>