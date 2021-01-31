<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c.tld" %>
<%@ taglib prefix="fn" uri="fn.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/adjs/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>单池</title>
	</head>
		
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }${href}">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<p>${msg }</p>
				<c:forEach items="${allo }" var="oa">
					<div style="background:black;color:white;">
						<span>&nbsp;&nbsp;ID：${oa.id }</span>
						<br>
						<span>&nbsp;&nbsp;订单号：${oa.aid }</span>
						<br>
						<span>&nbsp;&nbsp;用户：${oa.ausername }</span>
						<br>
						<span>&nbsp;&nbsp;ip：${oa.aip }</span>
						<br>
						<span>&nbsp;&nbsp;时间：${oa.adate }</span>
						<br>
						<span>&nbsp;&nbsp;手机：${oa.aphone }</span>
						<br>
						<span>&nbsp;&nbsp;地点：${oa.aplace }</span>
						<br>
						<span>&nbsp;&nbsp;价格：${oa.aprice }</span>
						<br>
						<span>&nbsp;&nbsp;备注：${oa.aremarks }</span>
						<br>
					</div>
					<br>
				</c:forEach>
			</div>
		</div> 
	</body>
</html>