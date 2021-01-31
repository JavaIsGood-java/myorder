package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.OrdercService;
import com.service.UserService;

@Controller
public class OchController {
	
	@Autowired
	private OrdercService ordercService;
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * @description 进入[接单记录]页
	 */
	@RequestMapping(value="/och",method=RequestMethod.GET)
	public String doGet(Model model,HttpSession session,HttpServletRequest request) throws Exception{
		System.out.println("进入[接单记录]页");
		
		int start=request.getParameter("start")==null?0:Integer.parseInt(request.getParameter("start"));//此处当start不为整数时抛出异常
		String username=(String)session.getAttribute("username");
		if(!this.userService.getIss(username)) {
			model.addAttribute("msg","请先认证");
		}else {
			model.addAttribute("op",this.ordercService.getAllOrderc(username,start));
		}
		model.addAttribute("href","/index");
		return "order/och.jsp";
	}
	
	
	/**
	 * @description 执行[查看]订单详情操作 
	 */
	@RequestMapping(value="/och",method=RequestMethod.POST)
	public String doPost(String cid,String start,Model model) throws Exception{
		System.out.println("执行[查看订单详情]操作 ");
		
		model.addAttribute("href","/och?start="+start);
		model.addAttribute("oc",this.ordercService.getOrdercByCid(cid));
		return "/order/och.jsp";
	}
	
	/**
	 * @description 执行[我已取件]操作
	 */
	@RequestMapping(value="/qoch",method=RequestMethod.POST)
	public String qochPost(String cid,String href,Model model) throws Exception{
		System.out.println("执行[我已取件]操作");
		
		model.addAttribute("href",href);
		if(this.ordercService.takeOrderc(cid)) {
			model.addAttribute("msg","取件成功");
		}else {
			model.addAttribute("msg","取件失败");
		}
		return "forward:/tip";
	}
	
	/**
	 * @description 进入[接单记录]页
	 */
	@RequestMapping(value="/qoch",method=RequestMethod.GET)
	public String qochGet() throws Exception{
		return "redirect:/och";
	}
}	
