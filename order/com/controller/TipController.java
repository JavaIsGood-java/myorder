package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TipController {

	/**
	 * @description 进入[提示]页，没有直接进入该页的方式，而是在其他控制器方法中实现跳转
	 */
	@RequestMapping(value="/tip")
	public String doGet() throws Exception{
		return "order/tip.jsp";
	}
}
