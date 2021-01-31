<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="c.tld" %>
<%@taglib prefix="fn" uri="fn.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>接单历史</title>
	</head>
	
	<body>	
		<div data-role="page">
			<div data-role="header">
			    <a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }${href}">返回</a>
			    <h1></h1>
		  	</div>
			
			<div data-role="main" class="ui-content">
				<p>${msg }</p>
				
				<c:if test="${op==null&&oc==null&&msg==null }">
					<p>空</p>
				</c:if>
				
				<c:if test="${op!=null&&oc==null }">
					<c:forEach items="${op.allOc }" var="o">
						<div style="background:black;color:white;">
							<br>
							<form action="${pageContext.request.contextPath }/och" method="post" data-ajax="false">
								<input type="hidden" value="${op.start }" name="start"/>
								<input type="hidden" value="${o.cid }" name="cid"/>
								<span>&nbsp;&nbsp;&nbsp;接单时间：${o.cdate }</span>
								<br>
								<span>&nbsp;&nbsp;&nbsp;当前状态：${o.cstatus }</span>
								<span style="float:right;margin-right:5%;"><input type="submit" value="查看" data-role="none"/></span>
							</form>
							<br>
						</div>
						<br>
					</c:forEach>
					<center>
						<a href="?start=${op.start-1<=0?0:op.start-1 }" data-ajax="false">上一页</a> 
						<span>${op.start+1 }</span>
						<a href="?start=${op.start+1>=op.totalPage?op.start:op.start+1 }" data-ajax="false">下一页</a>
					</center>
				</c:if>
				
				<c:if test="${oc!=null&&op==null }">
					<span>订单号：${oc.cid }</span><br>
					<span>时间：${oc.cdate }</span><br><br>
					<span>取件码：${oc.ccode }</span><br>
					<span>姓名：${oc.cname }</span><br>
					<span>号码：${oc.cphone }</span><br>
					<span>地点：${oc.cplace }</span><br>
					<span>价格：${oc.cprice }</span><br>
					<span>备注：${oc.cremarks }</span><br><br>
					<span>状态：${oc.cstatus }</span><br><br>
					<c:if test="${fn:contains(oc.cstatus,\"待取件\") }">
						<form action="${pageContext.request.contextPath }/qoch" method="post" data-ajax="false">
							<input type="hidden" value="${href }" name="href"/>
							<input type="hidden" value="${oc.cid }" name="cid"/>
							<input type="submit" value="我已取件"/>
						</form>
					</c:if>
				</c:if>
			</div>
		</div> 
	</body>
</html>