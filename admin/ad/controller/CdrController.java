package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ad.po.Drawh;
import ad.service.AdDrawhService;

@Controller
@RequestMapping(value="/a")
public class CdrController {
	
	
	@Autowired
	private AdDrawhService AdDrawhService;
	
	//进入提现记录查询页面
	@GetMapping(value="/cdr")
	public String doGet(Model model) throws Exception {
		return "admin/cdr.jsp";
	}
	
	
	//根据关键字查询提现记录
	@PostMapping(value="/cdr")
	public String doPost(String keyword,Model model) throws Exception {
		model.addAttribute("keyword",keyword);
		List<Drawh> all=this.AdDrawhService.getDrawhBykey(keyword);
		if(all.isEmpty()) {
			model.addAttribute("msg","空");
		}else {
			model.addAttribute("count",all.size());
			model.addAttribute("all",all);
		}
		return "admin/cdr.jsp";
	}
}
