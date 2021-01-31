package com.util.validator;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.po.Drawh;
import com.po.Ordera;
import com.po.User;

public class DataValidator {
	
	//用户登录时，对用书输入的用户名和密码进行验证
	public String validator1(User u) {
		if(u.getUsername()==null||"".equals(u.getUsername().trim())) {
			return "用户名不能为空";
		}
		if(u.getPassword()==null||"".equals(u.getPassword().trim())) {
			return "密码不能为空";
		}
		return null;
	}
	
	//用户在修改密码时，对输入的密码进行验证
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
		if(!npassword.trim().equals(qpassword.trim())) {
			return "两次密码输入不同";
		}
		if(npassword.trim().length()>16||npassword.trim().length()<6) {
			return "新密码为6~16位";
		}
		return null;
	}
	
	public String validator3(Ordera o) {
		if(o.getAcode()==null||"".equals(o.getAcode().trim())) {
			return "取件码不能为空";
		}
		if(o.getAcode().length()>6) {
			return "取件码过长";
		}
		if(o.getAname()==null||"".equals(o.getAname().trim())) {
			return "姓名不能为空";
		}
		if(o.getAname().length()>10) {
			return "姓名过长";
		}
		
		if("^1[3-9]\\d{9}$".matches(o.getAphone())) {
			return "手机号码格式错误";
		}
		if(o.getAplace()==null||"".equals(o.getAplace().trim())) {
			return "地址不能为空";
		}
		if(o.getAplace().length()>10) {
			return "地址过长";
		}
		if(o.getAprice()==10.0) {
			return "请选择价格";
		}
		if(o.getAremarks().length()>100) {
			return "备注过长";
		}
		return null;
	}
	
	public String validator4(String page) {
		if(page!=null&&page.matches("[0-9]+")) {
			return "请选择适合的页数";
		}
		return null;
	}
	
	public String validator5(Drawh d) {
		if(!(d.getDsal()==30.0||d.getDsal()==50.0)) {
			return "请选择金额";
		}
		if(d.getDzhi()==null||"".equals(d.getDzhi().trim())||d.getDzhi().trim().length()>20) {
			return "请输入正确的支付宝账户";
		}
		return null;
	}
	
	//对用户认证时上传的图片进行验证
	public String validator6(List<MultipartFile> picFile) {
		for(int i=0;i<picFile.size();i++) {
			MultipartFile file=picFile.get(i);
			if(file.isEmpty()) {
				return "图片不能为空";
			}
			if(file.getSize()>5300000) {
				return "图片大小过大";
			}
			String fileName=file.getOriginalFilename();
			if(!("JPG".equalsIgnoreCase(fileName.substring(fileName.length()-3)))) {
				return "图片只能是jpg类型的";
			}
		}
		return null;
	}
	
	public String validator7(User u,String qpassword) {
		
		if(u.getUsername()==null||"".equals(u.getUsername().trim())) {
			return "用户名不能为空";
		}
		if(!(u.getUsername().matches("^1[3-9]\\d{9}$"))) {
			return "请输入正确的用户名";
		}
		if(u.getPassword()==null||"".equals(u.getPassword().trim())) {
			return "密码不能为空";
		}
		if(qpassword==null||"".equals(qpassword.trim())) {
			return "确认密码不能为空";
		}
		if(!u.getPassword().equals(qpassword)) {
			return "两次密码输入不同";
		}
		if(u.getPassword().length()>16||u.getPassword().length()<6) {
			return "密码长度为6~16位";
		}
		return null;
	}
}
