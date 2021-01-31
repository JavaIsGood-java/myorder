package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dao.DrawhDao;
import com.dao.UserDao;
import com.po.Drawh;
import com.po.User;

@Service
@Transactional
public class DrawhServiceImpl implements DrawhService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DrawhDao drawhDao;
	
	@Override//创建提现记录
	public int createDrawhOrder(Drawh d,String username)  throws Exception{
		User u=new User();
		u.setUsername(username);
		u=this.userDao.selectByUsername(u);
		if(u.getSal()<d.getDsal()) {
			return 1;
		}
		
		d.setDusername(username);
		d.setDfsal(u.getSal());
		d.setDasal(u.getSal()-d.getDsal());
		u.setSal(u.getSal()-d.getDsal());
		d.setDdate(""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		d.setDstatus("待审核");
		
		int x=this.drawhDao.createDrawh(d);
		int y=this.userDao.updateSal(u);
		
		if(x==1&&y==1) {
			return 2;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 3;
		}
	}
	
	public List<Drawh> getDrawhByusername(String username)  throws Exception{
		return this.drawhDao.selectByDusername(username);
	}
}
