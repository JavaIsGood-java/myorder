package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.util.pojo.OrdercPage;

@Service
@Transactional
public class OrdercServiceImpl implements OrdercService {
	
	@Autowired
	private OrderaDao orderaDao;
	
	@Autowired
	private OrderbDao orderbDao;
	
	@Autowired
	private OrdercDao ordercDao;
	
	@Autowired
	private UserDao userDao;
	
	
	
	@Override		//用户接单行为
	public int take(String id,String username)  throws Exception{
		Ordera oa=this.orderaDao.getOrderaById(Integer.parseInt(id));
		if(oa==null) {
			return 3;
		}
		if(username.equals(oa.getAusername())){
			return 1;
		}
		Orderc oc=new Orderc();
		oc.setCusername(username);
		oc.setCid(oa.getAid());
		oc.setCip("");
		oc.setCdate(""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		oc.setCcode(oa.getAcode());
		oc.setCname(oa.getAname());
		oc.setCphone(oa.getAphone());
		oc.setCplace(oa.getAplace());
		oc.setCprice(oa.getAprice());
		oc.setCremarks(oa.getAremarks());
		oc.setCstatus("待取件");
		oc.setCfusername(oa.getAusername());
		oc.setCfdate(oa.getAdate());
		
		Orderb ob=new Orderb();
		ob.setBstatus("对方已接单");
		ob.setBjdate(oc.getCdate());
		ob.setBid(oc.getCid());
		ob.setBjusername(oc.getCusername());
		
		User u=new User();
		u.setUsername(username);
		u.setLsal(oa.getAprice());
		
		if(this.orderaDao.deleteOrdera(oa)==1&&this.orderbDao.updateOrderb(ob)==1&&this.ordercDao.createOrderc(oc)==1&&this.userDao.updateLsal(u)==1) {
			return 2;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 3;
		}
		
	}

	
	//得到用户接单记录并进行分页处理
	@Override
	public OrdercPage getAllOrderc(String username, int start)  throws Exception{
		OrdercPage op=new OrdercPage();
		int size=5;
		op.setSize(size);
		op.setStart(start);
		op.setIndex(start*size);
		int total=this.ordercDao.getCountByUsername(username);
		int totalPage=total%size==0?total/size:total/size+1;
		op.setTotalPage(totalPage);
		op.setKeyword(username);
		List<Orderc> allOrderc=this.ordercDao.getAllOrderc(op);
		if(allOrderc.isEmpty()) {
			return null;
		}else {
			op.setAllOc(allOrderc);
		}
		return op;
	}
	
	@Override//用户查看接单详情
	public Orderc getOrdercByCid(String cid)  throws Exception{
		return this.ordercDao.getOrderc(cid); 
	}
	
	@Override
	public boolean takeOrderc(String cid)  throws Exception{
		Orderc oc=new Orderc();
		oc.setCid(cid);
		oc.setCstatus("等待派送");
		
		Orderb ob=new Orderb();
		ob.setBid(cid);
		ob.setBstatus("对方已取件,等待收货");
		
		if(this.ordercDao.changeCstatus(oc)==1&&this.orderbDao.updateOrderb(ob)==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}
}
