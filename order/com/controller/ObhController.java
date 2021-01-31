package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.OrderbService;
import com.util.validator.DataValidator;

@Controller
public class ObhController {
	
	@Autowired
	private OrderbService orderbService;
	
	/**
	 * @description 进入[下单记录]页
	 */
	@RequestMapping(value="/obh",method=RequestMethod.GET)
	public String doGet(Model model,HttpSession session,HttpServletRequest request) throws Exception{
		System.out.println("进入[下单记录]页");
		
		//分页
		int start=request.getParameter("start")==null?0:Integer.parseInt(request.getParameter("start"));
		String username=(String)session.getAttribute("username");
		model.addAttribute("href","/index");
		model.addAttribute("op",this.orderbService.getAllOrderb(username,start));
		return "order/obh.jsp";
	}
	
	/**
	 * @description 执行[查看订单详情]操作
	 * @param bid 订单号
	 * @param start 分页页码
	 */
	@RequestMapping(value="/obh",method=RequestMethod.POST)
	public String doPost(String bid,String start,Model model) throws Exception{
		System.out.println("执行[查看订单详情]操作");
		
		model.addAttribute("href","/obh?start="+start);
		model.addAttribute("ob",this.orderbService.getOrderbBybid(bid));
		return "order/obh.jsp";
	}
	
	
	/**
	 * @description 执行[取消订单]操作，如果用户下的单没被接的话，用户可以取消
	 * @param bid 订单号
	 */
	@RequestMapping(value="/cob",method=RequestMethod.POST)	//参数href用户辅助页面操作,动态改变链接
	public String cobPost(String bid,String href,Model model,HttpSession session) throws Exception{
		System.out.println("执行[取消订单]操作");
		
		model.addAttribute("href",href);
		if(this.orderbService.cancelOrderb(bid,(String)session.getAttribute("username"))) {
			model.addAttribute("msg","取消成功");
		}else {
			model.addAttribute("msg","取消失败");
		}
		return "forward:/tip";
	}
	
	/**
	 * @description 进入[下单记录]页
	 */
	@RequestMapping(value="/cob",method=RequestMethod.GET)
	public String cobGet() throws Exception{
		return "redirect:/obh";
	}
	
	/**
	 * @description 执行[收货]操作
	 * @param bid 订单号
	 */
	@RequestMapping(value="/sob",method=RequestMethod.POST)
	public String sobPost(String href,String bid,Model model) throws Exception{
		System.out.println("执行[确认收货]操作");
		
		model.addAttribute("href",href);
		if(this.orderbService.showOrderb(bid)) {
			model.addAttribute("msg","收货成功");
		}else {
			model.addAttribute("msg","收货失败");
		}
		return "forward:/tip";
	}
	
	/**
	 * @description 进入[下单记录]页
	 */
	@RequestMapping(value="/sob",method=RequestMethod.GET)
	public String sobGet() throws Exception{
		return "redirect:/obh";
	}
}
