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
		<title>提现查询</title>
	</head>
		
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }${href!=null?href:'/a/index'}">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<form action="${pageContext.request.contextPath }/a/cdr" method="post" data-ajax="false">
					<input type="search" name="keyword" id="search" value="${keyword }" placeholder="输入关键字"/>
					<input type="submit" value="查询"/>
				</form>
				
				<c:if test="${count!=null }">
					<p>共${count }条数据</p>
				</c:if>
				
				<c:forEach items="${all }" var="a">
					<div style="background:black;color:white;">
						<br>
						<span>&nbsp;&nbsp;ID：${a.id }</span><br><br>
						<span>&nbsp;&nbsp;用户：${a.dusername }</span><br><br>
						<span>&nbsp;&nbsp;提现前金额：${a.dfsal }</span><br><br>
						<span>&nbsp;&nbsp;提现金额：${a.dsal }</span><br><br>
						<span>&nbsp;&nbsp;提现后金额：${a.dasal }</span><br><br>
						<span>&nbsp;&nbsp;时间：${a.ddate }</span><br><br>
						<span>&nbsp;&nbsp;支付宝：${a.dzhi }</span><br><br>
						<span>&nbsp;&nbsp;状态：${a.dstatus }</span><br><br>
						<c:if test="${fn:contains(a.dstatus,\"审核成功\") }">
							<span>&nbsp;&nbsp;处理时间：${a.dctime }</span><br><br>
						</c:if>
					</div>
					<br>
				</c:forEach>
			</div>
		</div> 
	</body>
</html>