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
		<title>订单查询</title>
	</head>
		
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/a/index">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
			    <form action="${pageContext.request.contextPath }/a/co" method="post" data-ajax="false">
					<input type="search" name="keyword" id="search" value="${p.keyword }" placeholder="输入关键字"/>
					<input type="submit" value="查询"/>
				</form>
				<c:if test="${p.result!=null }">
					<p>共${p.result }条数据</p>
				</c:if>
				<c:forEach items="${p.allOb }" var="b">
					<div style="background:black;color:white;">
						<br>
						<span>&nbsp;&nbsp;订单号：${b.bid }</span><br>
						<span>&nbsp;&nbsp;下单用户：${b.busername }</span><br>
						<span>&nbsp;&nbsp;IP：${b.bip }</span><br>
						<span>&nbsp;&nbsp;时间：${b.bdate }</span><br>
						<span>&nbsp;&nbsp;姓名：${b.bname }</span><br>
						<span>&nbsp;&nbsp;号码：${b.bphone }</span><br>
						<span>&nbsp;&nbsp;地点：${b.bplace }</span><br>
						<span>&nbsp;&nbsp;价格：${b.bprice }</span><br>
						<span>&nbsp;&nbsp;备注：${b.bremarks }</span><br>
						<span>&nbsp;&nbsp;状态：${b.bstatus }</span><br>
						<span>&nbsp;&nbsp;接单用户：${b.bjusername }</span><br>
						<span>&nbsp;&nbsp;接单时间：${b.bjdate }</span><br>
						<br>
					</div>
					<br>
				</c:forEach>
				<c:if test="${p.allOb!=null }">
					<center>
					<a href="?start=${p.start-1<p.totalPage?0:p.start-1 }&keyword=${p.keyword}" data-ajax="false" data-transition="none">上一页</a>
					<span>${p.start+1 }</span>
					<a href="?start=${p.start+1>p.totalPage-1?p.totalPage-1:p.start+1 }&keyword=${p.keyword}" data-ajax="false" data-transition="none">下一页</a>
					<p>共${p.totalPage }页</p>
					</center>
				</c:if>
			</div>
		</div> 
	</body>
</html>