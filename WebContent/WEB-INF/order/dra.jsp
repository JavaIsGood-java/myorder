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
			//表单提交前对数据进行验证,返回true则通过
			function check(){
				if($("#dsal").val()<=0){
					alert("请选择要提现的金额");
					return false;
				}
				if($("#dzhi").val()==null||$("#dzhi").val().trim().length==0||$("#dzhi").val().length>18){
					alert("请输入正确的支付宝账户");
					return false;
				}
				return true;
			}
		</script>
		<title>提现</title>
	</head>
	
	<body>	
		<div data-role="page">
			
			<div data-role="header">
				<a href="${pageContext.request.contextPath }/index" class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-l ui-btn-icon-left" data-ajax="false" data-transition="none">返回</a>
			    <h1></h1>
			    <a href="${pageContext.request.contextPath }/drah" class="ui-btn ui-corner-all ui-shadow ui-icon-arrow-r ui-btn-icon-right" data-ajax="false" data-transition="none">提现记录</a>
		    </div>
		    
			<div data-role="main" class="ui-content">
				<!-- 可提现余额 -->
				<p>当前可提现：${user.sal }</p>
				<form action="${pageContext.request.contextPath }/dra"  method="post" data-ajax="false" data-transition="none" onsubmit="return check()">
					
					<!-- 选择要提现的金额 -->
					<label for="dsal">金额：</label>
					<select name="dsal" id="dsal">
						<option value="0.0">== 请选择 ==</option>
						<option value="30.0">30.0</option>
						<option value="50.0">50.0</option>
					</select>
					
					<!-- 输入支付宝账户 -->
					<label for="dzhi" >支付宝账户：</label>
					<input type="text" name="dzhi" id="dzhi" maxlength="18"/> 
					<input type="submit" value="提现"/>
				</form>
			</div>
		</div>
	</body>
</html>