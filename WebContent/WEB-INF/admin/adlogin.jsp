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
		<style>
			#page {
				background-image:url(${pageContext.request.contextPath}/adimage/1.jpg);
			}
		</style>
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
				if($("#adusername").val()==null||$("#adusername").val().trim()==""){
					alert("用户名不能为空");
					return false;
				}
				if($("#adpassword").val()==null||$("#adpassword").val().trim()==""){
					alert("密码不能为空");
					return false;
				}
				return true;
			}
		</script>
		<title>后台登录</title>
	</head>
	
	<body>	
		<div data-role="page" id="page">
			
			<div data-role="main" class="ui-content">
				<br><br><br>
				<center><p id="msg" style="width:50%;height:30px;text-align:center;">${msg }</p></center>
				<form action="${pageContext.request.contextPath }/a/login" method="post" data-ajax="false" data-transition="none" onsubmit="return check()">
					<input type="text" name="adusername" id="adusername" value="${user.username }" placeholder="用户名" data-clear-btn="true"/>
					<input type="text" name="adpassword" id="adpassword" value="${user.password }" placeholder="密码" data-clear-btn="true"/>
					<input type="submit" value="登录"/>
				</form>
			</div>
		</div>
	</body>
</html>