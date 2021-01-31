package ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.service.AdFuserService;
import ad.util.validator.AdValidator;

@Controller
@RequestMapping(value="/a")
public class AducpController {
	
	@Autowired
	private AdFuserService adFuserService;
	
	@RequestMapping(value="/aducp",method=RequestMethod.GET)
	public String doGet() throws Exception {
		return "admin/aducp.jsp";
	}
	
	
	//重置用户密码
	@RequestMapping(value="/aducp",method=RequestMethod.POST)
	public String doPost(String username,Model model) throws Exception {
		//数据验证
		String s=new AdValidator().validator3(username);
		if(s!=null) {
			model.addAttribute("msg","请输入用户名");
			return "admin/aducp.jsp";
		}
		
		
		//业务结果交接
		int result=this.adFuserService.changeUP(username);
		if(result==1) {
			model.addAttribute("msg","没有找到此用户");
		}else if(result==2) {
			model.addAttribute("msg",username+"用户的密码重置成功，新密码为123456");
		}else {
			model.addAttribute("msg","重置失败");
		}
		model.addAttribute("href","/a/aducp");
		return "forward:/a/tip";
	}
}
