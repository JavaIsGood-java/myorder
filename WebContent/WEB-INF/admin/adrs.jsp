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
		<title>认证查询</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-transition="none" href="${pageContext.request.contextPath }${href!=null?href:'/a/index'}">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<c:if test="${ap==null }">
					<form action="${pageContext.request.contextPath }/a/adrs" method="post" data-ajax="false">
						<input type="search" name="keyword" id="search" value="${keyword }" placeholder="输入关键字">
						<input type="submit" value="查询"/>
					</form>
				</c:if>
				<c:if test="${count!=null }">
					<p>共${count }条数据</p>
				</c:if>
				<p>${msg }</p>
				<c:forEach items="${all }" var="a">
					<div style="background:black;color:white;">
						<br>
						<form action="${pageContext.request.contextPath }/a/cappr" method="post" data-ajax="false">
							<input type="hidden" value="${a.apusername }" name="apusername"/>
							<input type="hidden" value="${a.apdate }" name="apdate"/>
							<input type="hidden" value="${a.appath1 }" name="appath1"/>
							<input type="hidden" value="${a.appath2 }" name="appath2"/>
							<input type="hidden" value="${a.apstatus }" name="apstatus"/>
							<input type="hidden" value="${a.appass }" name="appass"/>
							<span>&nbsp;&nbsp;&nbsp;用户名：${a.apusername }</span>
							<br>
							<sapn>&nbsp;&nbsp;&nbsp;状态：${a.apstatus }</sapn>
							<br>
							<span>&nbsp;&nbsp;&nbsp;申请：${a.apdate }</span>
							<br>
							<span>&nbsp;&nbsp;&nbsp;处理：${a.appass }</span>
							<input type="submit" value="查看"  style="float:right;margin-right:5%;" data-role="none"/>
						</form>
						<br>
					</div>
					<br>
				</c:forEach>
				
				<c:if test="${ap!=null }">
					<p>用户名：${ap.apusername }</p>
					<p>申请时间：${ap.apdate }</p>
					<p>身份证：</p>
					<center><img src="${pageContext.request.contextPath }/img/${ap.appath1}" width="50%"/></center>
					<p>学生证：</p>
					<center><img src="${pageContext.request.contextPath }/img/${ap.appath2 }" width="50%"/></center>
					<p>状态：${ap.apstatus }</p>
					<c:if test="${!fn:contains(ap.appass, \"0000\")}">
						<p>处理时间：${ap.appass }</p>
					</c:if>
				</c:if>
			</div>
		</div> 
	</body>
</html>