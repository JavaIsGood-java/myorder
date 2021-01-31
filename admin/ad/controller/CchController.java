package ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.service.AdChongService;

@Controller
@RequestMapping(value="/a")
public class CchController {
	
	@Autowired
	private AdChongService adChongService;
	
	//查看充值记录
	@RequestMapping(value="/cch",method=RequestMethod.GET)
	public String doGet(String keyword,String start,Model model) throws Exception {
		if(keyword==null||start==null) {
			return "admin/cch.jsp";
		}else {
			model.addAttribute("a",this.adChongService.getChongByKey(keyword,Integer.parseInt(start)));//这里会出现转型异常
		}
		return "admin/cch.jsp";
	}
	
	//查看充值记录
	@RequestMapping(value="/cch",method=RequestMethod.POST)
	public String doPost(String keyword,String start,Model model) throws Exception {
		int i=0;
		if(start==null||"".equals(start)) {
			i=0;
		}else {
			i=Integer.parseInt(start);
		}
		model.addAttribute("a",this.adChongService.getChongByKey(keyword,i));
		return "admin/cch.jsp";
		
	}
}
