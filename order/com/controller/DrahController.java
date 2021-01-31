package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Drawh;
import com.service.DrawhService;

@Controller
public class DrahController {
	
	@Autowired
	private DrawhService drawhService;
	
	/**
	 * @description 进入[提现记录]页
	 */
	@RequestMapping(value="/drah")
	public String doGetPOST(Model model,HttpSession session) throws Exception{
		System.out.println("进入[提现记录]页");
		
		List<Drawh> all=this.drawhService.getDrawhByusername((String)session.getAttribute("username"));
		if(all.isEmpty()) {
			model.addAttribute("msg","空");
		}else {
			model.addAttribute("all",all);
		}
		return "order/drah.jsp";
	}
}
