<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="c.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>接单大厅</title>
	</head>
		
	<body>	
		<div data-role="page">
			
		  	<div data-role="header">
		  		<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<p>${msg }</p>
				<c:forEach items="${orderas}" var="ordera">
					<div style="background:black;color:white;">	
						<br>
						<form action="${pageContext.request.contextPath }/take" method="post" data-ajax="false">
							<input type="hidden" value="${ordera.id }" name="id" />
							<span>&nbsp;&nbsp;&nbsp;&nbsp;价格：${ordera.aprice }</span>
							<br>
							<span>&nbsp;&nbsp;&nbsp;&nbsp;地址：${ordera.aplace }</span>
							<span style="right:10px;float:right"><input type="submit" value="接单" data-role="none"/>&nbsp;&nbsp;</span>
						</form>
						<br>
					</div>
					<br>
				</c:forEach>
			</div>
			
			<div data-role="footer" data-position="fixed">
		    	<div data-role="navbar" data-ajax="false">
			      	<ul>
				        <li><a href="${pageContext.request.contextPath }/take" data-icon="star" class="ui-btn-active ui-state-persist ui-alt-icon" data-transition="none" data-ajax="false">大厅</a></li>
				        <li><a href="${pageContext.request.contextPath }/index" data-icon="home" data-transition="none" data-ajax="false">个人中心</a></li>
				        <li><a href="${pageContext.request.contextPath }/send" data-icon="plus" data-transition="none" data-ajax="false">下单</a></li>
			      	</ul>
		    	</div>
		  	</div>
		</div> 
	</body>
</html>