package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.User;
import com.service.UserService;
import com.util.validator.DataValidator;

@Controller
public class RegController {

	@Autowired 
	private UserService userService;
	
	/**
	 * @description 进入[注册]页
	 */
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public String doGet() throws Exception{
		System.out.println("进入[注册]页");
		
		return "order/reg.jsp";
	}
	
	/**
	 * @description 执行[注册]操作
	 * @param u 实体对象，封装了用户名和密码
	 * @param qpassword 确认密码
	 */
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String doPost(User u,String qpassword,Model model) throws Exception{
		System.out.println("执行[注册]操作");
	
		//回显
		model.addAttribute("u",u);
		model.addAttribute("qpassword",qpassword);
		
		//验证
		String s=new DataValidator().validator7(u,qpassword);
		if(s!=null) {
			model.addAttribute("msg",s);
			return "order/reg.jsp";
		}
		
		//开始
		int result=this.userService.registerUser(u);
		if(result==1) {
			model.addAttribute("msg","用户名已存在");
			return "order/reg.jsp";		
		}else if(result==2) {
			model.addAttribute("msg","注册成功");
			model.addAttribute("href","/reg");
		}else {
			model.addAttribute("msg","注册失败");
		}
		model.addAttribute("href","/login");
		return "forward:/tip";
	}
}
