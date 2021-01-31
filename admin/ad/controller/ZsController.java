package ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ad.service.AdChongService;

@Controller
@RequestMapping(value="/a")
public class ZsController {
	
	@Autowired
	private AdChongService adChongService;
	
	@RequestMapping(value="/zs")
	public String doGetPost(Model model) throws Exception {
		model.addAttribute("s",this.adChongService.getSystemSal());
		return "admin/zs.jsp";
	}
}
