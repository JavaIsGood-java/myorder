package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dao.OrderaDao;
import com.dao.OrderbDao;
import com.dao.OrdercDao;
import com.dao.UserDao;
import com.po.Ordera;
import com.po.Orderb;
import com.po.Orderc;
import com.po.User;
import com.util.pojo.OrderbPage;

@Service
@Transactional
public class OrderbServiceImpl implements OrderbService{
	
	@Autowired
	private OrderbDao orderbDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private OrderaDao orderaDao;
	
	@Autowired
	private OrdercDao ordercDao;
	
	
	@Override//查询出每一个用户的下单记录，并进行分页处理
	public OrderbPage getAllOrderb(String username,int start) throws Exception{
		OrderbPage op=new OrderbPage();
		int size=5;
		op.setSize(size);
		op.setStart(start);
		op.setIndex(start*size);
		int total=this.orderbDao.getCountByUsername(username);
		int totalPage=total%size==0?total/size:total/size+1;
		op.setTotalPage(totalPage);
		op.setKeyword(username);
		List<Orderb> allOrderb=this.orderbDao.getAllOrderb(op);
		if(allOrderb.isEmpty()) {
			return null;
		}else {
			op.setAllOb(allOrderb);
		}
		return op;
	}


	@Override//根据订单号得到订单信息
	public Orderb getOrderbBybid(String bid)  throws Exception{
		return this.orderbDao.getOrderbBybid(bid);
	}
	
	
	@Override//用户取消订单行为
	public boolean cancelOrderb(String bid,String username) throws Exception{
		
		Ordera oa=new Ordera();
		oa.setAid(bid);
		
		Orderb ob=this.orderbDao.getOrderbBybid(bid);;
		ob.setBstatus("已取消");
		
		User u=new User();
		u.setUsername(username);
		u=this.userDao.selectByUsername(u);
		u.setSal(u.getSal()+ob.getBprice());
		
		if(this.orderaDao.deleteOrdera(oa)==1&&this.userDao.updateSal(u)==1&&this.orderbDao.updateOrderb(ob)==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}


	@Override//用户收货行为
	public boolean showOrderb(String bid)  throws Exception{
		Orderb ob=new Orderb();
		ob.setBid(bid);
		ob.setBstatus("完成");
		int x=this.orderbDao.updateOrderb(ob);
		
		ob=this.orderbDao.getOrderbBybid(bid);
		User u=new User();
		u.setUsername(ob.getBjusername());
		u=this.userDao.selectByUsername(u);
		u.setLsal(u.getLsal()-ob.getBprice());
		u.setSal(u.getSal()+ob.getBprice());
		int y=this.userDao.updateSalAndL(u);
		
		Orderc oc=new Orderc();
		oc.setCid(bid);
		oc.setCstatus("完成");
		int z=this.ordercDao.changeCstatus(oc);
		
		if(x==1&&y==1&&z==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}	
}
