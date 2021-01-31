package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.Ordera;
import com.service.OrderaService;
import com.service.OrdercService;
import com.service.UserService;

@Controller
public class TakeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderaService orderaService;
	
	@Autowired
	private OrdercService ordercService;
	
	/**
	 * @description 进入[接单]页
	 */
	@RequestMapping(value="/take",method=RequestMethod.GET)
	public String doGet(Model model,HttpSession session) throws Exception{
		System.out.println("进入[接单]页");
		
		if(!this.userService.getIss((String)session.getAttribute("username"))) {
			model.addAttribute("msg","请先认证");
		}else {
			List<Ordera> all=this.orderaService.getAllOrdera();
			if(all.isEmpty()) {
				model.addAttribute("msg","空");
			}else {
				model.addAttribute("orderas",all);
			}
		}
		return "order/take.jsp";
	}
	
	
	/**
	 * @description 执行[接单]操作
	 * @param id 订单号
	 */
	@RequestMapping(value="/take",method=RequestMethod.POST)
	public String doPost(String id,HttpSession session,Model model) throws Exception{
		System.out.println("执行[接单]操作");
		
		String username=(String)session.getAttribute("username");
		int result=this.ordercService.take(id,username);
		if(result==1) {
			model.addAttribute("msg","不能接自己下的单");
		}else if(result==2){
			model.addAttribute("msg","接单成功");
		}else {
			model.addAttribute("msg","你来晚了");
		}
		model.addAttribute("href","/take");
		return "forward:/tip";
	}
}
