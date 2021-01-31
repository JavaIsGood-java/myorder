package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.Ordera;
import com.service.OrderaService;
import com.util.validator.DataValidator;

@Controller
public class SendController {

	@Resource(name="orderaServiceImpl")
	private OrderaService orderaService;
	
	/**
	 * @description 进入[下单]页
	 */
	@RequestMapping(value="/send",method=RequestMethod.GET)
	public String doGet() throws Exception{
		System.out.println("进入[下单]页");
		
		return "order/send.jsp";
	}
	
	/**
	 * @description 执行[下单]操作
	 */
	@RequestMapping(value="/send",method=RequestMethod.POST)
	@Transactional
	public String doPost(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		System.out.println("执行[下单]操作");
		
		//数据采集，之所以不用形参接收，是有原因的
		Ordera o=new Ordera();
		o.setAcode(request.getParameter("acode"));
		o.setAname(request.getParameter("aname"));
		o.setAphone(request.getParameter("aphone"));
		o.setAplace(request.getParameter("aplace"));
		o.setAprice(Double.parseDouble(request.getParameter("aprice")));
		o.setAremarks(request.getParameter("aremarks"));
		//数据验证
		String s=new DataValidator().validator3(o);
		if(s!=null) {
			return "order/send.jsp";
		}
		
		//业务开始，调用业务层进行业务
		int result=0;
		o.setAusername((String)session.getAttribute("username"));
		try {
			result=this.orderaService.sendOrdera(o);
		} catch (Exception e) {
		}
		model.addAttribute("href","/send");
		if(result==1) {
			model.addAttribute("msg","余额不足");
		}else if(result==2){
			model.addAttribute("msg","下单成功");
		}else {
			model.addAttribute("msg","下单失败");
		}
		return "forward:/tip";
	}
}
