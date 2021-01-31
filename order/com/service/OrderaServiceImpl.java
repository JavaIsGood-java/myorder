package com.service;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dao.OrderaDao;
import com.dao.OrderbDao;
import com.dao.UserDao;
import com.po.Ordera;
import com.po.Orderb;
import com.po.User;



@Service
@Transactional
public class OrderaServiceImpl implements OrderaService {

	@Autowired
	private OrderaDao orderaDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderbDao orderbDao;
	
	
	@Override//用户下单
	public int sendOrdera(Ordera o) throws Exception{
			User u=new User();
			u.setUsername(o.getAusername());
			u=this.userDao.selectByUsername(u);
			double sal=u.getSal();
			if(o.getAprice()>sal) {					
				return 1;
			}else {
				u.setSal(sal-o.getAprice());
			}
			String bdate=""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			o.setAdate(bdate);						//设置发单时间
			StringBuffer buf=new StringBuffer();
			for(int i=0;i<3;i++) {
				buf.append(new Random().nextInt(10));
			}
			buf.append(o.getAusername()+bdate.substring(2,14));
			o.setAid(buf.toString());				//设置订单编号
			String ip="";
			try {
				ip=InetAddress.getLocalHost().getHostAddress();
			} catch (Exception e) {
				return 3;
			}
			o.setAip(ip);
			Orderb ob=new Orderb();
			ob.setBusername(o.getAusername());
			ob.setBid(o.getAid());
			ob.setBip(o.getAip());
			ob.setBdate(o.getAdate());
			ob.setBcode(o.getAcode());
			ob.setBname(o.getAname());
			ob.setBphone(o.getAphone());
			ob.setBplace(o.getAplace());
			ob.setBprice(o.getAprice());
			ob.setBremarks(o.getAremarks());
			ob.setBstatus("正在等待对方接单");
			if(this.orderaDao.createOrdera(o)==1&&this.userDao.updateSal(u)==1&&this.orderbDao.createOrderb(ob)==1) {
				return 2;
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return 3;
			}
	}
	
	@Override//得到所有未被接的订单，呈现在接单大厅中
	public List<Ordera> getAllOrdera() throws Exception{
		return this.orderaDao.getAllOrdera();
	}

}
