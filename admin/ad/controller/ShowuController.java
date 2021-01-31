package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ad.po.User;
import ad.service.AdFuserService;

@Controller
@RequestMapping(value="/a")
public class ShowuController {
	
	@Autowired
	private AdFuserService adFuserService;
	
	
	//进入用户查询页
	@RequestMapping(value="/showu",method=RequestMethod.GET)
	public String doGet() throws Exception {
		return "admin/showu.jsp";
	}
	
	
	//根据关键字查询用户的信息
	@RequestMapping(value="/showu",method=RequestMethod.POST)
	public String doPost(String keyword,Model model) throws Exception {
		//模糊查询，所以不需要数据验证
		model.addAttribute("keyword",keyword);
		List<User> all=this.adFuserService.getUserBykey(keyword);
		if(all.isEmpty()) {
			model.addAttribute("msg","空空如也");
		}else {
			model.addAttribute("count",all.size());
			model.addAttribute("all",all);
		}
		return "admin/showu.jsp";
	}
}
