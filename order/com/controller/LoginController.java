package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.User;
import com.service.UserService;
import com.util.validator.DataValidator;

@Controller
public class LoginController {
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	/**
	 * @description 进入[登录]页
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String doGet() throws Exception{
		System.out.println("进入[登录]页");
		
		return "order/login.jsp";
	}
	
	/**
	 * @description 执行[登录]操作
	 * @param u 实体对象,封装了用户名和密码
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doPost(User u,HttpSession session,Model model) throws Exception{
		System.out.println("执行[登录]操作");
		
		//数据验证,验证用户名和密码是否符合数据规范
		String s=new DataValidator().validator1(u);
		if(s!=null) {
			model.addAttribute("msg",s);
			return "order/login.jsp";
		}
		
		//执行登录
		if(this.userService.UserLogin(u)) {
			session.setAttribute("username", u.getUsername());
			return "redirect:/index";
		}else {
			model.addAttribute("user",u);
			model.addAttribute("msg","用户名或密码错误");
			return "order/login.jsp";
		}
	}
	
	/**
	 * @description 执行[退出]操作
	 */
	@RequestMapping(value="/exist")
	public String doGet(HttpServletRequest request) throws Exception{
		System.out.println("执行[退出]操作");
		
		request.getSession().invalidate();
		return "redirect:/login";
	}
}
