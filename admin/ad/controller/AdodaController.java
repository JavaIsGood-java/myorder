package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.po.Ordera;
import ad.service.AdOrderaService;

@Controller
@RequestMapping(value="/a")
public class AdodaController {
	
	@Autowired
	private AdOrderaService adOrderaService;
	
	@RequestMapping(value="/adoda")
	public String doGetPost(Model model) throws Exception {
		model.addAttribute("href","/a/index");
		List<Ordera> allo=this.adOrderaService.getAllOrdera();
		if(allo.isEmpty()) {
			model.addAttribute("msg","空");
		}else {
			model.addAttribute("allo",allo);
		}
		return "admin/adoda.jsp";
	}

}
