<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>充值记录</title>
	</head>
		
	<body>	
		<div data-role="page">
			
			<div data-role="header">
				<a href="${pageContext.request.contextPath }/chong" class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none">返回</a>
			    <h1></h1>
		    </div>
		    
			<div data-role="main" class="ui-content">
				<p>${msg }</p>
				<c:forEach items="${all }" var="c">
					<div style="background:black;color:white;">
						<br>
						<span>&nbsp;&nbsp;金额：${c.sal }</span><br>
						<span>&nbsp;&nbsp;时间：${c.date }</span><br>
						<br>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
	</body>
</html>