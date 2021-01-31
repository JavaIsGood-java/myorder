package com.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ApproveDao;
import com.po.Approve;

@Service
@Transactional
public class ApproveServiceImpl implements ApproveService {
	
	@Autowired
	private ApproveDao approveDao;
	
	
	@Override
	public int approveFront(String username)  throws Exception{
		Approve a=this.approveDao.selectByusername(username);
		if(a==null) {
			return 1;
		}
		if("待审核".equals(a.getApstatus())){
			return 2;
		}
		if("认证失败".equals(a.getApstatus())) {
			return 3;
		}
		return 4;
	}
	
	@Override
	public Approve getApprove(String username)  throws Exception{
		return this.approveDao.selectByusername(username);
	}

	@Override//用户上传认证图片
	public boolean uploading(List<MultipartFile> picFile, String username,String realpath)  throws Exception{
		//如果要保存图片的文件夹不存在，则创建
		File targetDir=new File(realpath);
		if(!targetDir.exists()) {
			targetDir.mkdirs();
		}
		String[] picPaths= {"",""};
		for(int i=0;i<picFile.size();i++) {
			MultipartFile file=picFile.get(i);
			String fileName=file.getOriginalFilename();
			fileName=username+(i+1)+fileName.substring(fileName.length()-4);
			File targetFile=new File(realpath,fileName);
			picPaths[i]=fileName;
			try {
				file.transferTo(targetFile);
			}catch(Exception e) {
				return false;
			}
		}
		int x=0;
		Approve a=this.approveDao.selectByusername(username);
		if(a==null) {
			a=new Approve();
			a.setApusername(username);
			a.setApdate(""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			a.setAppath1(picPaths[0]);
			a.setAppath2(picPaths[1]);
			a.setApstatus("待审核");
			x=this.approveDao.createApprove(a);
		}else {
			a.setApdate(""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			a.setApstatus("待审核");
			x=this.approveDao.updateApprove(a);
		}
		if(x==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}
	
}
