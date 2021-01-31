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
		<title>处理申请</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }${href!=null?href:'/a/index'}">返回</a>
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<c:if test="${count!=null }">
					<p>共${count }条申请等待处理</p>
				</c:if>
				<p>${msg }</p>
				<c:forEach items="${alldrawh}" var="d">
					<div style="background:black;color:white;">
						<br>
						<form action="${pageContext.request.contextPath }/a/cd" method="post" data-ajax="false">
							<span><input type="hidden" value="${d.id}" name="id"/></span>
							<span>&nbsp;&nbsp;申请时间：${d.ddate }</span><br>
							<span>&nbsp;&nbsp;金额：${d.dsal }</span>
							<input type="submit" value="查看" style="float:right;margin-right:5%;" data-role="none"/>
							<br>
						</form>
						<br>
					</div>
					<br>
				</c:forEach>
				
				<c:if test="${dh!=null }">
					<span>用户：${dh.dusername }</span><br><br>
					<span>提现金额：${dh.dsal }</span><br><br>
					<span>申请时间：${dh.ddate }</span><br><br>
					<span>支付宝：${dh.dzhi}</span><br><br>
					<h3>系统总余额：${sm }</h3>
					<br><br><br>
					<form action="${pageContext.request.contextPath }/a/cd1" method="post" data-ajax="false">
						<input type="hidden" value="${dh.id }" name="id"/>
						<input type="submit" value="审核成功"/>
					</form>
				</c:if>
			</div>
		</div> 
	</body>
</html>