package ad.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/a")
public class AdtipController {
	
	@RequestMapping(value="/tip")
	public String doGet() throws Exception {
		return "admin/adtip.jsp";
	}
}