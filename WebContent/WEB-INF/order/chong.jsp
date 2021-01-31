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
		<title>充值</title>
	</head>
		
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a href="${pageContext.request.contextPath }/index" class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none">返回</a>
			    <h1></h1>
			    <a href="${pageContext.request.contextPath }/chongh" class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-r ui-btn-icon-left" data-ajax="false" data-transition="none">充值记录</a>
		    </div>
		    
			<div data-role="main" class="ui-content">
				<form action="" method="post">
					<label for="osal">充值金额：</label>
					<select name="osal">
						<option value="5.0">5.0</option>
					</select>
					<input type="submit" value="充值"/>
				</form>
			</div>
		</div>
	</body>
</html>