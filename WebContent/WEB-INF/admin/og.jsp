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
		<title>订单跟踪</title>
	</head>
		
	<body>	
		<div data-role="page">
			
			<div data-role="header">
				<a class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none" href="${pageContext.request.contextPath }/a/index">返回</a>
				<h1></h1>
		    </div>
			
			
			<div data-role="main" class="ui-content">
				<center><p>${msg }&nbsp;</p></center>
				<form action="${pageContext.request.contextPath }/a/og" method="post" data-ajax="false">
					<input type="search" name="bid" id="search" value="${bid!=null?bid:'' }" placeholder="输入订单号"  data-clear-btn="true"/>
					<input type="submit" value="查询"/>
				</form>
				
				<c:if test="${ob!=null }">
					<br>	
					<h3>下单方：</h3>
					<div style="background:black;color:white;">
						<br>
						<span>&nbsp;&nbsp;订单号：${ob.bid }</span><br>
						<span>&nbsp;&nbsp;用户：${ob.busername }</span><br>
						<span>&nbsp;&nbsp;IP：${ob.bip }</span><br>
						<span>&nbsp;&nbsp;时间：${ob.bdate }</span><br>
						<span>&nbsp;&nbsp;姓名：${ob.bname }</span><br>
						<span>&nbsp;&nbsp;号码：${ob.bphone }</span><br>
						<span>&nbsp;&nbsp;地点：${ob.bplace }</span><br>
						<span>&nbsp;&nbsp;价格：${ob.bprice }</span><br>
						<span>&nbsp;&nbsp;备注：${ob.bremarks }</span><br>
						<span>&nbsp;&nbsp;状态：${ob.bstatus }</span><br>
						<c:if test="${!fn:contains(ob.bjusername,\"无\") }">
							<span>&nbsp;&nbsp;接单用户：${ob.bjusername }</span><br>
							<span>&nbsp;&nbsp;接单时间：${ob.bjdate }</span><br>
						</c:if>
						<br>
					</div>
					<br>
				</c:if>
				
				<c:if test="${oc!=null }">
					<br>
					<h3>接单方：</h3>
						<div style="background:black;color:white;">
							<br>
							<span>&nbsp;&nbsp;订单号：${oc.cid }</span><br>
							<span>&nbsp;&nbsp;用户：${oc.cusername }</span>
							<span>&nbsp;&nbsp;IP：${oc.cip }</span><br>
							<span>&nbsp;&nbsp;时间：${oc.cdate }</span><br>
							<span>&nbsp;&nbsp;姓名：${oc.cname }</span><br>
							<span>&nbsp;&nbsp;号码：${oc.cphone }</span><br>
							<span>&nbsp;&nbsp;地点：${oc.cplace }</span><br>
							<span>&nbsp;&nbsp;价格：${oc.cprice }</span><br>
							<span>&nbsp;&nbsp;备注：${oc.cremarks }</span><br>
							<span>&nbsp;&nbsp;状态：${oc.cstatus }</span><br>
							<span>&nbsp;&nbsp;下单用户：${oc.cfusername }</span><br>
							<span>&nbsp;&nbsp;下单时间：${oc.cfdate }</span><br>
							<br>
						</div>
					<br>
				</c:if>
			</div>
		</div> 
	</body>
</html>