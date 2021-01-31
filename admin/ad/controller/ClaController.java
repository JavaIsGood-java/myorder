package ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.service.AdApproveService;
import ad.util.validator.AdValidator;

@Controller
@RequestMapping(value="/a")
public class ClaController {
	
	@Autowired
	private AdApproveService adApproveService;
	
	@RequestMapping(value="/cla",method=RequestMethod.GET)
	public String doGet() throws Exception {
		return "admin/cla.jsp";
	}
	
	@RequestMapping(value="/cla",method=RequestMethod.POST)
	public String doPost(String username,Model model) throws Exception {
		//数据验证
		String s=new AdValidator().validator4(username);
		if(s!=null) {
			model.addAttribute("msg","请输入用户名");
			return "admin/cla.jsp";
		}
		
		//业务结果交接
		model.addAttribute("username",username);
		int result=this.adApproveService.closeApprove(username);
		if(result==1) {
			model.addAttribute("msg","用户不存在");
		}else if(result==2) {
			model.addAttribute("msg","此用户没有接单权限");
		}else if(result==3) {
			model.addAttribute("msg","成功关闭"+username+"用户的接单权限");
		}else {
			model.addAttribute("msg","关闭失败");
		}
		return "admin/cla.jsp";
	}
}
