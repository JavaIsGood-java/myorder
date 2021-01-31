package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.UserService;
import com.util.validator.DataValidator;

@Controller
public class CpController {
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	/**
	 * @description 进入[修改密码]页
	 */
	@RequestMapping(value="/cp",method=RequestMethod.GET)
	public String doGet() throws Exception{
		System.out.println("进入[修改密码]页");
		
		return "order/cp.jsp";
	}
	
	/**
	 * @description 执行[修改密码]操作
	 * @param password 旧密码
	 * @param npassword 新密码
	 * @param qpassword 确认新密码
	 */
	@RequestMapping(value="/cp",method=RequestMethod.POST)
	public String doPost(String password,String npassword,String qpassword,Model model,HttpServletRequest request) throws Exception{
		System.out.println("执行了[修改密码]操作");
		
		//进行数据验证,对用户输入的旧密码进行验证,对输入的新密码和确认密码进行验证
		String s=new DataValidator().validator2(password,npassword,qpassword);
		if(s!=null) {
			model.addAttribute("msg",s);
			return "order/cp.jsp";
		}
		
		int result=0;
		String username=(String)request.getSession().getAttribute("username");
		result=this.userService.changePassword(password,npassword,username);
		model.addAttribute("href","/cp");
		if(result==1) {
			model.addAttribute("msg","原密码错误");
		}else if(result==2){
			model.addAttribute("msg","修改成功");
		}else {
			model.addAttribute("msg","修改失败");
		}
		return "forward:/tip";
	}
}
