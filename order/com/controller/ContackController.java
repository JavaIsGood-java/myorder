package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContackController {
	
	/**
	 * @description 进入[客服]页
	 */
	@RequestMapping(value="/contack")
	public String doGet() throws Exception{
		System.out.println("进入[客服]页");
		
		return "order/contack.jsp";
	}
}
