package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserDao;
import com.po.User;

@Controller
public class IndexController {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	
	/**
	 * @description 进入[主页]
	 */
	@RequestMapping(value="/index")
	public String doGet(HttpSession session,Model model) throws Exception{
		System.out.println("进入[主页]");
		
		User u=new User();
		u.setUsername((String)session.getAttribute("username"));
		u=this.userDao.selectByUsername(u);
		model.addAttribute("user",u);
		return "order/index.jsp";
	}
}
