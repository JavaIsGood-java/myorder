package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.service.ApproveService;
import com.util.validator.DataValidator;

@Controller
public class RenController {
	
	@Autowired
	private ApproveService approveService;
	
	/**
	 * @description 进入[认证中心]页
	 */
	@RequestMapping(value="/ren",method=RequestMethod.GET)
	public String doGet(HttpSession session,Model model) throws Exception{
		System.out.println("进入[认证中心]页");
		
		int result=this.approveService.approveFront((String)session.getAttribute("username"));
		if(result==1) {
			return "order/ren.jsp";
		}else if(result==2){
			model.addAttribute("msg","您已提交过申请，请等待审核。");
		}else if(result==3){
			model.addAttribute("msg","您的上一次申请认证失败。");
		}else {
			model.addAttribute("msg","您已认证成功。");
			model.addAttribute("ap",this.approveService.getApprove((String)session.getAttribute("username")));
		}
		return "order/ren.jsp";
	}
	
	
	/**
	 * @description 执行[申请认证]操作
	 * @param picFile 认证材料图片
	 */
	@RequestMapping(value="/ren",method=RequestMethod.POST)
	public String doPost(List<MultipartFile> picFile,HttpSession session,Model model,HttpServletRequest request)
			throws Exception{
		System.out.println("执行[申请认证]操作");
		
		//对上传的文件进行验证
		String s=new DataValidator().validator6(picFile);
		if(s!=null) {
			model.addAttribute("href","/ren");
			model.addAttribute("msg",s);
			return "forward:/tip";
		}
		//业务开始
		boolean result=this.approveService.uploading(picFile,(String)session.getAttribute("username"),request.getServletContext().getRealPath("WEB-INF/upload"));
		if(result) {
			model.addAttribute("msg","上传成功，等待审核");
		}else {
			model.addAttribute("msg","上传失败");
		}
		model.addAttribute("href","/index");
		return "forward:/tip";
	}
}
