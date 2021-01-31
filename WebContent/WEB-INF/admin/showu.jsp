<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/adjs/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>查询用户</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/a/index">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<form action="${pageContext.request.contextPath }/a/showu" method="post" data-ajax="false">
					<input type="search" name="keyword" id="search" value="${keyword }" placeholder="输入关键字"/>
					<input type="submit" value="查询"/>
				</form>
				<c:if test="${count!=null }">
					<p>共${count }条数据</p>
				</c:if>
				<p>${msg }</p>
				<c:forEach items="${all }" var="a">
					<div style="background:black;color:white;">
						<br>
						<span>&nbsp;&nbsp;ID：${a.id }</span><br>
						<span>&nbsp;&nbsp;用户名：${a.username }</spanp><br>
						<span>&nbsp;&nbsp;余额：${a.sal }</span><br>
						<span>&nbsp;&nbsp;临额：${a.lsal }</span><br>
						<span>&nbsp;&nbsp;注册时间：${a.zdate }</span><br>
						<span>&nbsp;&nbsp;最近登录时间：${a.ddate }</span><br>
						<span>&nbsp;&nbsp;登录IP：${a.ip }</span><br>
						<span>&nbsp;&nbsp;是否接单：${a.iss }</span><br>
						<br>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
	</body>
</html>