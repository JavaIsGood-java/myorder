package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Chong;
import com.service.ChongService;

@Controller
public class ChonghController {

	@Autowired
	private ChongService chongService;
	
	/**
	 * @description 进入[充值记录]页
	 */
	@RequestMapping(value="/chongh")
	public String doGetPost(Model model,HttpSession session) throws Exception{
		System.out.println("进入[充值记录]页");
		
		//得到所有的充值记录,如果一条充值记录也没有,则告诉用户：空,否则罗列出所有的充值记录,不分页
		List<Chong> all=this.chongService.getChongByUsername((String)session.getAttribute("username"));
		if(all.isEmpty()) {
			model.addAttribute("msg","空");
		}else {
			model.addAttribute("all",all);
		}
		return "order/chongh.jsp";
	}
}
