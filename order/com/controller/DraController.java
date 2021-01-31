package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.Drawh;
import com.service.DrawhService;
import com.service.UserService;
import com.util.validator.DataValidator;

@Controller
public class DraController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private DrawhService drawhService;
	
	/**
	 * @description 进入[余额提现]页
	 */
	@RequestMapping(value="/dra",method=RequestMethod.GET)
	public String doGet(Model model,HttpSession session) throws Exception{
		System.out.println("进入[余额提现]页");
		
		//如果用户没有认证,则说明没有接单权限,没有接单权限的用户不能将已充值的余额提现,
		if(!this.userService.getIss((String)session.getAttribute("username"))) {
			model.addAttribute("msg","请先认证");	
			model.addAttribute("href","/index");
			return "forward:/tip";
		}
		//如认证通过,有接单权限,则也表示用户可以提现
		//获取用户信息,这其中就包括了用户有多少余额可以提现
		model.addAttribute("user",this.userService.getUserInfo((String)session.getAttribute("username")));
		//跳转至余额提现页面
		return "order/dra.jsp";
	}
	
	/**
	 * @description 执行[提现]操作
	 * @param d 实体对象,封装了提现金额和支付宝账号
	 */
	@RequestMapping(value="/dra",method=RequestMethod.POST)
	public String doPost(Drawh d,Model model,HttpSession session) throws Exception{
		System.out.println("执行[提现]操作");
		
		//数据验证
		String s=new DataValidator().validator5(d);
		if(s!=null) {
			model.addAttribute("msg",s);
			model.addAttribute("href","/dra");
			return "forward:/tip";
		}
		
		//业务交接
		int result=this.drawhService.createDrawhOrder(d,(String)session.getAttribute("username"));
		if(result==1) {
			model.addAttribute("msg","余额不足");
		}else if(result==2) {
			model.addAttribute("msg","提现成功");
		}else {
			model.addAttribute("msg","提现失败");
		}
		model.addAttribute("href","/dra");
		return "forward:/tip";
	}
}
