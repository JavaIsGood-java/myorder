package ad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.service.AdOrderbService;

@Controller
@RequestMapping(value="/a")
public class OcController {
	
	@Autowired
	private AdOrderbService adOrderbService;
	
	//进入订单查询页面
	@RequestMapping(value="/co",method=RequestMethod.GET)
	public String doGet(String keyword,String start,Model model) throws Exception {
		if(keyword==null||start==null) {
			return "admin/co.jsp";
		}else {
			model.addAttribute("p",this.adOrderbService.getOrderbBykey(keyword,Integer.parseInt(start)));//start不为纯数字时出现异常
		}
		return "admin/co.jsp";
	}
	
	
	
	@RequestMapping(value="/co",method=RequestMethod.POST)
	public String doPost(String keyword,HttpServletRequest request,Model model) throws Exception {
		int start=request.getAttribute("start")==null?0:Integer.parseInt((String)request.getAttribute("start"));
		model.addAttribute("p",this.adOrderbService.getOrderbBykey(keyword,start));
		return "admin/co.jsp";
	}
}
