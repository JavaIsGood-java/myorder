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
public class ApmController {
	
	@Autowired
	private AdApproveService adApproveService;
	
	//读取所有待认证
	@RequestMapping(value="/apm",method=RequestMethod.GET)
	public String doGet(Model model) throws Exception {
		model.addAttribute("href","/a/index");
		List<Approve> allApp=this.adApproveService.getAllApprove();
		if(allApp.isEmpty()) {
			model.addAttribute("msg","空");
		}else {
			model.addAttribute("all",allApp);
		}
		return "admin/apm.jsp";
	}
	
	//查看认证详情
	@RequestMapping(value="/apm",method=RequestMethod.POST)
	public String doPost(Approve a,Model model) throws Exception{
		//这里可以不加数据验证
		model.addAttribute("href","/a/apm");
		model.addAttribute("ap",a);
		return "admin/apm.jsp";
	}
	
	//处理认证
	@RequestMapping(value="/af",method=RequestMethod.POST)
	public String afPost(Approve a,String kind,Model model) throws Exception {
		if("失败".equals(kind)) {
			if(this.adApproveService.approveFail(a)) {
				model.addAttribute("msg","处理成功,结果为“认证失败”");
			}else {
				model.addAttribute("msg","处理失败");
			}
		}
		if("成功".equals(kind)) {
			if(this.adApproveService.approveSuccess(a)) {
				model.addAttribute("msg","处理成功,结果为“认证成功”");
			}else {
				model.addAttribute("msg","处理失败");
			}
		}
		model.addAttribute("href","/a/apm");
		return "forward:/a/tip";
	}
	
}
