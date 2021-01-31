package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChongController {
	
	/**
	 * @description 进入[充值]页
	 */
	@RequestMapping(value="/chong",method=RequestMethod.GET)
	public String doGet() throws Exception{
		System.out.println("进入[充值]页");
		
		return "order/chong.jsp";
	}
}
