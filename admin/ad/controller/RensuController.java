package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.po.Approve;
import ad.service.AdApproveService;

@Controller
@RequestMapping(value="/a")
public class RensuController {

	@Autowired
	private AdApproveService adApproveService;
	
	
	//进入认证查询页面
	@RequestMapping(value="/adrs",method=RequestMethod.GET)
	public String doGet() throws Exception {
		return "admin/adrs.jsp";
	}
	
	
	//接收关键字，进行查询
	@RequestMapping(value="/adrs",method=RequestMethod.POST)
	public String doPost(String keyword,Model model) throws Exception {
		//模糊查询，不需要验证
		model.addAttribute("keyword",keyword);
		List<Approve> all=this.adApproveService.getSuccess(keyword);
		if(all.isEmpty()) {
			model.addAttribute("msg","空空如也");
		}else {
			model.addAttribute("count",all.size());
			model.addAttribute("all",all);
		}
		return "admin/adrs.jsp";
	}
	
	
	//查看具体的认证详情
	@RequestMapping(value="/cappr")
	public String capprGP(Approve a,Model model) throws Exception {
		if(a.getApusername()==null) {
			return "redirect:/a/adrs";
		}
		model.addAttribute("href","/a/adrs");
		model.addAttribute("ap",a);
		return "admin/adrs.jsp";
	}

}
