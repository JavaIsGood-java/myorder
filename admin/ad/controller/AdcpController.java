package ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.service.AduserService;
import ad.util.validator.AdValidator;

@Controller
@RequestMapping("/a")
public class AdcpController {
	
	@Autowired
	private AduserService aduserService;
	
	
	@RequestMapping(value="/adcp",method=RequestMethod.GET)
	public String doGet()  throws Exception{
		return "admin/adcp.jsp";
	}
	
	@RequestMapping(value="/adcp",method=RequestMethod.POST)
	public String doPost(String password,String npassword,String qpassword,HttpSession session,Model model) throws Exception{
		//数据验证
		String s=new AdValidator().validator2(password,npassword,qpassword);
		if(s!=null) {
			model.addAttribute("msg",s);
			model.addAttribute("href","/a/adcp");
			return "forward:/a/tip";
		}
		
		//业务结果交接
		int result=this.aduserService.changeP(password,qpassword,(String)session.getAttribute("adusername"));
		if(result==1) {
			model.addAttribute("msg","原密码错误");
		}else if(result==2) {
			model.addAttribute("msg","修改成功");
		}else {
			model.addAttribute("msg","修改失败");
		}
		model.addAttribute("href","/a/adcp");
		return "forward:/a/tip";
	}
}
