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
		<title>待处理认证</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }${href}">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<p>${msg }</p>
				<c:forEach items="${all }" var="a">
					<div style="background:black;color:white;">
						<br>
						<form action="${pageContext.request.contextPath }/a/apm" method="post" data-ajax="false">
							<input type="hidden" value="${a.apusername }" name="apusername"/>
							<input type="hidden" value="${a.apdate }" name="apdate"/>
							<input type="hidden" value="${a.appath1 }" name="appath1"/>
							<input type="hidden" value="${a.appath2 }"/ name="appath2">
							<span>&nbsp;&nbsp;&nbsp;申请时间：${a.apdate }</span>
							<br>
							<span>&nbsp;&nbsp;&nbsp;用户名：${a.apusername }</span>
							<input type="submit" value="查看" style="float:right;margin-right:10px;" data-role="none" data-ajax="false"/>
						</form>
						<br>
					</div>
					<br>
				</c:forEach>
				
				<c:if test="${ap!=null }">
					<p>用户名：${ap.apusername }</p>
					<p>申请时间：${ap.apdate }</p>
					<br>
					<p>身份证：</p>
					<center><img src="${pageContext.request.contextPath }/img/${ap.appath1}" width="50%"  data-ajax="false"/></center>
					<br>
					<p>学生证：</p>
					<center><img src="${pageContext.request.contextPath }/img/${ap.appath2}" width="50%"  data-ajax="false"/></center>
					<br><br><br><br><br>
					<form action="${pageContext.request.contextPath }/a/af" method="post" data-ajax="false">
						<input type="hidden" value="失败" name="kind"/>
						<input type="hidden" value="${ap.apusername }" name="apusername"/>
						<input type="submit" value="认证失败"/>
					</form>
					<br>
					<form action="${pageContext.request.contextPath }/a/af" method="post" data-ajax="false">
						<input type="hidden" value="成功" name="kind"/>
						<input type="hidden" value="${ap.apusername }" name="apusername"/>
						<input type="submit" value="认证成功"/>
		 			</form>
		 			<br>
				</c:if>
			</div>
		</div> 
	</body>
</html>