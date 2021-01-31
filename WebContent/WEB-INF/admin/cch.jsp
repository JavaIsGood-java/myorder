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
		<title>充值查询</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/a/index">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				 <form action="${pageContext.request.contextPath }/a/cch" method="post" data-ajax="false">
					<input type="search" name="keyword" id="search" value="${a.keyword }" placeholder="输入关键字"/>
					<input type="submit" value="查询"/>
				</form>
				
				<c:if test="${a.allC!=null }">
					<p>共${a.result }条数据</p>
				</c:if>
				
				<c:forEach items="${a.allC }" var="c">
					<div style="background:black;color:white;">
						<br>
						<span>&nbsp;&nbsp;ID：${c.id }</span><br>
						<span>&nbsp;&nbsp;用户：${c.username }</span><br>
						<span>&nbsp;&nbsp;充值金额：${c.sal }</span><br>
						<span>&nbsp;&nbsp;充值时间：${c.date }</span><br>
						<br>
					</div>
					<br>
				</c:forEach>
				
				<c:if test="${a.allC!=null }">
					<center>
						<a href="?start=${a.start-1<0?0:a.start-1}&keyword=${a.keyword}" data-ajax="false" data-transition="none">上一页</a>
						<span>${a.start+1 }</span>
						<a href="?start=${a.start+1>a.totalPage-1?a.totalPage-1:a.start+1}&keyword=${a.keyword}" data-ajax="false" data-transition="none">下一页</a>
						<center><p>共${a.totalPage }页</p></center>
					</center>
				</c:if>
			</div>
		</div> 
	</body>
</html>