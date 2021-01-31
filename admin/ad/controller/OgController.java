package ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.service.AdOrderbService;
import ad.service.AdOrdercService;
import ad.util.validator.AdValidator;

@Controller
@RequestMapping(value="/a")
public class OgController {
	
	
	@Autowired
	private AdOrderbService adOrderbService;
	
	@Autowired
	private AdOrdercService adOrdercService;
	
	
	//进入订单跟踪页面
	@RequestMapping(value="/og",method=RequestMethod.GET)
	public String doGet() throws Exception {
		return "admin/og.jsp";
	}
	
	
	//根据输入的订单号查询订单
	@RequestMapping(value="/og",method=RequestMethod.POST)
	public String doPost(String bid,Model model) throws Exception {
		String s=new AdValidator().validator5(bid);
		if(s!=null) {
			model.addAttribute("msg","订单号不能为空");
			return "admin/og.jsp";
		}
		model.addAttribute("bid",bid);
		model.addAttribute("ob",this.adOrderbService.getOrderbByBid(bid));
		model.addAttribute("oc",this.adOrdercService.getOrdercByCid(bid));
		return "admin/og.jsp";
	}
}
