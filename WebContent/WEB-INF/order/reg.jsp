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
			$(function(){
				$("#username").focus(function(){
					$("#msg").text("");
				});
			})
			function check(){
				if(!(/^1[3-9]\d{9}$/.test($("#username").val()))){ 
			        alert("请输入正确的用户名");
			        return false;
			    }
				if($("#password").val()==null||$("#password").val().trim()==""){
					alert("密码不能为空");
					return false;
				}
				if($("#qpassword").val()==null||$("#qpassword").val().trim()==""){
					alert("确认密码不能为空");
					return false;
				}
				if($("#password").val()!=$("#qpassword").val()){
					alert("两次密码输入不同");
					return false;
				}
				if($("#password").val().length<6||$("#password").val().length>16){
					alert("密码为6~16位");
					return false;
				}
				return true;
				
			}
		</script>
		<title>注册</title>
	</head>
	
	<body>	
		<div data-role="page" id="page">
		
			<div data-role="main" class="ui-content">
				<!-- 提示框 -->
				<div id="tip" style="opacity:0.9;border:1px solid;background:white;width:50%;height:50px;line-height:50px;margin-left:20%;height:50px;text-align:center;display:none;margin-top:0px;position:absolute;">
				</div>
				
				<br><br><br>
				<center><p id="msg" style="width:50%;height:30px;text-align:center;">${msg }</p></center>
				<form action="${pageContext.request.contextPath }/reg" method="post" data-ajax="false" onsubmit="return check()">
					<input type="text" name="username" id="username" value="${u.username }" placeholder="手机号(用户名)" data-clear-btn="true" maxlength="11"/>
					<input type="password" name="password" id="password" value="${u.password }" placeholder="密码" data-clear-btn="true" maxlength="16"/>
					<input type="password" name="qpassword" id="qpassword" value="${qpassword }" placeholder="确认密码" data-clear-btn="true" maxlength="16"/>
					<input type="submit" value="注册"/>
					<a href="${pageContext.request.contextPath }/login" data-ajax="false" data-transition="none">登录</a>
				</form>
			</div>
		</div>
	</body>
</html>