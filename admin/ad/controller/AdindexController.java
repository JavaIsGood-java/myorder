package ad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/a")
public class AdindexController {
	
	@RequestMapping(value="/index")
	public String doGet() throws Exception{
		return "admin/adindex.jsp";
	}
}
