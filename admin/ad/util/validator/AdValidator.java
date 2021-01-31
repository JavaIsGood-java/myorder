package ad.util.validator;

import ad.po.Aduser;

public class AdValidator {
	public String validator1(Aduser a) {
		if(a.getAdusername()==null||"".equals(a.getAdusername().trim())) {
			return "用户名不能为空";
		}
		if(a.getAdpassword()==null||"".equals(a.getAdpassword().trim())) {
			return "密码不能为空";
		}
		return null;
	}
	
	
	public String validator2(String password,String npassword,String qpassword) {
		if(password==null||"".equals(password.trim())) {
			return "原密码不能为空";
		}
		if(npassword==null||"".equals(npassword.trim())) {
			return "新密码不能为空";
		}
		if(qpassword==null||"".equals(qpassword.trim())) {
			return "确认密码不能为空";
		}
		if(!npassword.equals(qpassword)) {
			return "两次密码输入不同";
		}
		if(npassword.length()>16||npassword.length()<6) {
			return "新密码长度为6~16位";
		}
		return null;
	}
	
	public String validator3(String username) {
		if(username==null||"".equals(username.trim())) {
			return "用户名不能为空";
		}
		return null;
	}
	
	public String validator4(String username) {
		if(username==null||"".equals(username.trim())){
			return "用户名不能为空";
		}
		return null;
	}
	
	public String validator5(String bid) {
		if(bid==null||"".equals(bid.trim())) {
			return "请输入订单号";
		}
		
		return null;
	}
}
