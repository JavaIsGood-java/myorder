<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="c.tld" %>
<%@ taglib prefix="fn" uri="fn.tld" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>个人中心</title>
	</head>
		
	<body>	
		<div data-role="page">
			<div data-role="header">
				<h1></h1>
		    </div>
			
			<div data-role="main" class="ui-content">
				<br><br>
				<table>
					<tr>
						<td width="45%" align="center"><img src="${pageContext.request.contextPath }/image/1.jpg" width="70%"/></td>
						<td align="left">
							<h4>用户名：${user.username }</h4>
							<h4>余额：${user.sal }</h4>
							<c:if test="${fn:contains(user.iss,\"true\") }">
								<h4>临额： ${user.lsal }</h4>
							</c:if>
						</td>
					</tr>
				</table>
				<br><br>
				<ul data-role="listview">
			      <li><a href="${pageContext.request.contextPath }/obh" data-ajax="false" data-transition="none">下单记录</a></li>
			      <li><a href="${pageContext.request.contextPath }/och" data-ajax="false" data-transition="none">接单记录</a></li>
			      <li><a href="${pageContext.request.contextPath }/chong" data-ajax="false" data-transition="none">余额充值</a></li>
			      <li><a href="${pageContext.request.contextPath }/dra" data-ajax="false" data-transition="none">余额提现</a></li>
			      <li><a href="${pageContext.request.contextPath }/ren" data-ajax="false" data-transition="none">认证中心</a></li>
			      <li><a href="${pageContext.request.contextPath }/cp" data-ajax="false" data-transition="none">修改密码</a></li>
			      <li><a href="${pageContext.request.contextPath }/contack" data-ajax="false" data-transition="none">客服中心</a></li>
			      <li><a href="${pageContext.request.contextPath }/exist" data-ajax="false" data-transition="none">退出</a></li>
		    	</ul>
		    	<br><br><br>
			</div>
			
			<div data-role="footer" data-position="fixed">
		    	<div data-role="navbar">
			      	<ul>
				        <li><a href="${pageContext.request.contextPath }/take" data-icon="star" data-transition="none" data-ajax="false">大厅</a></li>
				        <li><a href="${pageContext.request.contextPath }/index" data-icon="home" class="ui-btn-active ui-state-persist ui-alt-icon" data-transition="none" data-ajax="false">个人中心</a></li>
				        <li><a href="${pageContext.request.contextPath }/send" data-icon="plus" data-transition="none" data-ajax="false">下单</a></li>
			      	</ul>
		    	</div>
		  	</div>
		</div> 
	</body>
</html>