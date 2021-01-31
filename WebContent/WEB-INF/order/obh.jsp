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
		<title>下单历史</title>
	</head>
	
	<body>	
		<div data-role="page">
			
		  	<div data-role="header">
		  		<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }${href}">返回</a>
		  		<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<c:if test="${op==null&&ob==null }">
					<p>空</p>
				</c:if>
				
				<c:if test="${op!=null&&ob==null}">
					<c:forEach items="${op.allOb }" var="o">
						<div style="background:black;color:white;">
						<br>
						<form action="${pageContext.request.contextPath }/obh" method="post" data-ajax="false">
							<input type="hidden" value="${op.start }" name="start"/>
							<input type="hidden" value="${o.bid }" name="bid"/>
							<span>&nbsp;&nbsp;&nbsp;下单时间：${o.bdate }</span>
							<br>
							<span>&nbsp;&nbsp;&nbsp;当前状态：${o.bstatus }</span>
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
						<p>共${op.totalPage }页</p>
					</center>
				</c:if>
				
				<c:if test="${ob!=null&&op==null }">
					<div>
						<span>订单号：${ob.bid }</span><br>
						<span>时间：${ob.bdate }</span><br><br>	
						<span>取件码：${ob.bcode }</span><br>
						<span>姓名：${ob.bname }</span><br>
						<span>号码：${ob.bphone }</span><br>
						<span>地点：${ob.bplace }</span><br>
						<span>价格：${ob.bprice }</span><br>
						<span>备注：${ob.bremarks }</span><br><br>
						<span>状态：${ob.bstatus }</span><br>
						<c:choose>
							<c:when test="${fn:contains(ob.bstatus,\"正在等待对方接单\") }">
								<form action="${pageContext.request.contextPath }/cob" method="post" data-ajax="false" data-transition="none">
									<input type="hidden" value="${href }" name="href"/>
									<input type="hidden" value="${ob.bid }" name="bid"/>
									<input type="submit" value="取消订单"/>
								</form>
							</c:when>
							<c:when test="${fn:contains(ob.bstatus,\"对方已接单\")||fn:contains(ob.bstatus,\"完成\") }">
								<br>
								<span>用户：${ob.bjusername }</span><br>
								<span>时间：${ob.bjdate }</span><br>
							</c:when>
							<c:when test="${fn:contains(ob.bstatus,\"对方已取件,等待收货\") }">
								<br>
								<span>用户：${ob.bjusername }</span><br>
								<span>时间：${ob.bjdate }</span><br>
								<form action="${pageContext.request.contextPath }/sob" method="post" data-ajax="false">
									<input type="hidden" value="${href }" name="href"/>
									<input type="hidden" value="${ob.bid }" name="bid"/>
									<input type="submit" value="确认收货"/> 
								</form>
							</c:when>
						</c:choose>
					</div>
				</c:if>
			</div>
		</div> 
	</body>
</html>