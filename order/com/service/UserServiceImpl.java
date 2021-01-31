package com.service;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.dao.UserDao;
import com.po.User;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDao")
	private UserDao userDao;

	
	@Override	//用户登录
	public boolean UserLogin(User u) throws Exception{
		User o=this.userDao.selectByUsername(u);
		if(o==null) {
			return false;
		}
		String ddate=""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String ip="";
		try {
			ip=InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
		}
		o.setDdate(ddate);
		o.setIp(ip);
		if(o.getPassword().equals(u.getPassword())&&this.userDao.updateUser(o)==1){
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	
	@Override	//根据用户名得到用户的信息，供主页显示
	public User getUserInfo(String username) throws Exception{
		User u=new User();
		u.setUsername(username);
		u=this.userDao.selectByUsername(u);
		return u;
	}
	
	@Override	//用户修改密码
	public int changePassword(String password, String npassword, String username) throws Exception{
		User u=new User();
		u.setUsername(username);
		u=this.userDao.selectByUsername(u);			//得到当前用户信息
		
		if(!password.equals(u.getPassword())) {    //判断输入的密码是否和当前用户所对应的密码一致
			return 1;
		}
		u.setUsername(username);
		u.setPassword(npassword);
		if(this.userDao.updatePassword(u)!=0) {		//修改密码
			return 2;
		}
		return 3;
	}

	@Override//判断用户是否有接单权限
	public boolean getIss(String username) throws Exception{
		User o=new User();
		o.setUsername(username);
		o=this.userDao.selectByUsername(o);
		if("false".equals(o.getIss())) {
			return false;
		}
		return true;
	}

	@Override		//用户注册
	public int registerUser(User u) throws Exception{
		User o=this.userDao.selectByUsername(u);
		if(o!=null) {
			return 1;	//表示用户名已存在
		}
		u.setZdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		String ip="";
		try {
			ip=InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
		}
		u.setIp(ip);
		if(this.userDao.createUser(u)==1) {
			return 2;						//表示注册成功
		}else {								//否则注册失败，回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 3;
		}
	}
}
