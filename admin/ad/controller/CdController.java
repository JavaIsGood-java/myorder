package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.po.Drawh;
import ad.service.AdDrawhService;

@Controller
@RequestMapping(value="/a")
public class CdController {
	
	@Autowired
	private AdDrawhService adDrawhService;
	
	
	//得到所有待处理的提现申请
	@RequestMapping(value="/cd",method=RequestMethod.GET)
	public String doGet(Model model) throws Exception {
		List<Drawh> all=this.adDrawhService.getAllDrawh();
		if(all.isEmpty()) {
			model.addAttribute("msg","空");
		}else {
			model.addAttribute("count",all.size());
			model.addAttribute("alldrawh",all);
		}
		return "admin/cd.jsp";
	}
	
	//查看该提现申请的具体信息
	@RequestMapping(value="/cd",method=RequestMethod.POST)
	public String doPost(int id,Model model) throws Exception {
		model.addAttribute("href","/a/cd");
		model.addAttribute("dh",this.adDrawhService.getById(id));
		model.addAttribute("sm",this.adDrawhService.getSystemTotalMoney());
		return "admin/cd.jsp";
	}
	
	//对提现进行审核
	@RequestMapping(value="/cd1",method=RequestMethod.POST)
	public String cddPost(int id,Model model) throws Exception {
		model.addAttribute("href","/a/cd");
		if(this.adDrawhService.updateDstatus(id)) {
			model.addAttribute("msg","操作成功");
		}else {
			model.addAttribute("msg","操作失败");
		}
		return "forward:/a/tip";
	}
}
