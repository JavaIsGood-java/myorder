<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<script>
			function check(){
				if($("#acode").val()==null||$("#acode").val().trim()==""){
					alert("请输入正确的取件码");
					return false;
				}
				if($("#acode").val().length>6){
					alert("取件码过长");
					return false;
				}
				if($("#aname").val()==null||$("#aname").val().trim()==""){
					alert("请输入正确的姓名");
					return false;
				}
				if($("#aname").val().length>6){
					alert("姓名过长");
					return false;
				}
				if(!(/^1[3-9]\d{9}$/.test($("#aphone").val()))){ 
			        alert("请输入正确的手机号码");
			        return false;
			    }
				if($("#aplace").val()==null||$("#aplace").val().trim()==""){
					alert("请输入正确的地址");
					return false;
				}
				if($("#apalce").val().length()>10){
					alert("地址过长");
					return false;
				}
				if($("#aprice").val()!=1.5&&$("#aprice").val()!=2.0){
					alert("请选择价格");
					return false;
				}
				if($("#aremarks").val()>100){
					alert("备注过长");
					return false;
				}
				return true;
			}
		</script>
		<title>下单页</title>
	</head>
	
	<body>	
		<div data-role="page">
			
			<div data-role="header">
				<h1></h1>
		  	</div>
		  	
			<div data-role="main" class="ui-content">
				<form action="${pageContext.request.contextPath }/send" method="post" data-ajax="false" data-transition="none" onsubmit="return check()">
					<label for="acode">取件码：</label>
					<input type="text" name="acode" id="acode" value="" maxlength="6"/><br>
					
					<label for="aname">姓名：</label>
					<input type="text" name="aname" id="aname" value="" maxlength="6"/><br>
					
					<label for="aphone">号码：</label>
					<input type="text" name="aphone" id="aphone" value="" maxlength="11"/><br>
					
					<label for="aplace">地址：</label>
					<input type="text" name="aplace" id="aplace" value="" maxlength="10"/><br>
					
					<label for="aprice">价格</label>
					<select name="aprice" id="aprice">
						<option value="10.0" selected>== 请选择价格  =</option>
						<option value="1.5">1.5</option>
						<option value="2.0">2.0</option>
					</select>
					
					<label for="aremarks">备注：</label>
					<textarea name="aremarks" id="aremarks" value="" maxlength="100"></textarea>
					<input type="submit" value="下单"/>
				</form>
			</div>
			
			<div data-role="footer" data-position="fixed">
		    	<div data-role="navbar" data-ajax="false">
			      	<ul>
				        <li><a href="${pageContext.request.contextPath }/take" data-icon="star" data-transition="none" data-ajax="false">大厅</a></li>
				        <li><a href="${pageContext.request.contextPath }/index" data-icon="home" data-transition="none" data-ajax="false">个人中心</a></li>
				        <li><a href="${pageContext.request.contextPath }/send" data-icon="plus" class="ui-btn-active ui-state-persist ui-alt-icon" data-transition="none" data-ajax="false">下单</a></li>
			      	</ul>
		    	</div>
		  	</div>
		</div> 
	</body>
</html>