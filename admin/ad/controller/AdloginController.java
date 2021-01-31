package ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.po.Aduser;
import ad.service.AduserService;
import ad.util.validator.AdValidator;

@Controller
@RequestMapping(value="/a")
public class AdloginController {
	
	@Autowired
	private AduserService aduserService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String doGet() throws Exception {
		return "admin/adlogin.jsp";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doPost(Aduser a,Model model,HttpSession session) throws Exception {
		//数据验证
		String s=new AdValidator().validator1(a);
		if(s!=null) {
			model.addAttribute("msg",s);
			return "admin/adlogin.jsp";
		}
		
		//业务结果交接
		if(this.aduserService.login(a)) {
			session.setAttribute("adusername",a.getAdusername());
			return "redirect:/a/index";
		}else {
			model.addAttribute("msg","用户名或密码错误");
			return "admin/adlogin.jsp";
		}
	}
	
	@RequestMapping(value="/exit",method=RequestMethod.GET)
	public String exit(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/a/login";
	}
}
