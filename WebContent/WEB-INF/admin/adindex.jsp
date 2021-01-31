<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/adjs/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/adjs/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<title>个人中心</title>
	</head>
		
	<body>	
		<div data-role="page">
			<div data-role="header">
				<h3><center>后台管理中心</center></h3>
		    </div>
			
			<div data-role="main" class="ui-content">
			      <div data-role="collapsible">
				    <h4>订单中心</h4>
					    <ul data-role="listview">
					    	<li><a href="${pageContext.request.contextPath }/a/adoda" data-ajax="false" data-transition="none">查看单池</a></li>
					    	<li><a href="${pageContext.request.contextPath }/a/og" data-ajax="false" data-transition="none">订单跟踪</a></li>
					    	<li><a href="${pageContext.request.contextPath }/a/co" data-ajax="false" data-transition="none">订单查询</a></li>
					    </ul>
				  </div>
				  
				 <div data-role="collapsible">
				    <h4>充值管理</h4>
					    <ul data-role="listview">
					   		<li><a href="${pageContext.request.contextPath }/a/cch" data-ajax="false" data-transition="none">充值记录</a></li>
			      			<li><a href="${pageContext.request.contextPath }/a/zs" data-ajax="false" data-transition="none">系统余额</a></li>
					    </ul>
				   </div>
				  
				  
			      <div data-role="collapsible">
				    <h4>提现中心</h4>
					    <ul data-role="listview">
					    	<li><a href="${pageContext.request.contextPath }/a/cd" data-ajax="false" data-transition="none">待审核</a></li>
					    	<li><a href="${pageContext.request.contextPath }/a/cdr" data-ajax="false" data-transition="none">记录查询</a></li>
					    </ul>
				  </div>
				  
			      <div data-role="collapsible">
				    <h4>用户管理</h4>
					    <ul data-role="listview">
					    	<li><a href="${pageContext.request.contextPath }/a/showu" data-ajax="false" data-transition="none">用户查询</a></li>
			      			<li><a href="${pageContext.request.contextPath }/a/aducp" data-ajax="false" data-transition="none">重置密码</a></li>
					    </ul>
				   </div>
				   
			      <div data-role="collapsible">
				    <h4>认证管理</h4>
					    <ul data-role="listview">
					    	<li><a href="${pageContext.request.contextPath }/a/apm" data-ajax="false" data-transition="none">待认证</a></li>
					    	<li><a href="${pageContext.request.contextPath }/a/adrs" data-ajax="false" data-transition="none">认证查询</a></li>
					    	<li><a href="${pageContext.request.contextPath }/a/cla" data-ajax="false" data-transition="none">关闭认证</a></li>			   		 		
					    </ul>
				   </div>
				   
				   <div data-role="collapsible">
				    <h4>后台设置</h4>
					    <ul data-role="listview">
					   		<li><a href="${pageContext.request.contextPath }/a/adcp" data-ajax="false" data-transition="none">修改密码</a></li>
			      			<li><a href="${pageContext.request.contextPath }/a/exit" data-ajax="false" data-transition="none">退出</a></li>
					    </ul>
				   </div>
				   
			</div>
		</div> 
	</body>
</html>