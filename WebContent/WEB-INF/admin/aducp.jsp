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
			function check(){
				if($("#search").val()==null||$("#search").val().trim()==""){
					alert("用户名不能为空");
					return false;
				}
				return true;
			}
		</script>
		<title>重置用户密码</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/a/index">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<center><p>${msg }&nbsp;</p></center>
				<form action="${pageContext.request.contextPath }/a/aducp" method="post" data-ajax="false" onsubmit="return check()">
					<input type="search" name="username" id="search"  placeholder="输入用户名">
					<input type="submit" value="重置"/>
				</form>
			</div>
		</div> 
	</body>
</html>