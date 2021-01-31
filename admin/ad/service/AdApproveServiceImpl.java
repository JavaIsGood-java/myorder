package ad.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ad.dao.AdApproveDao;
import ad.dao.AdfuserDao;
import ad.po.Approve;
import ad.po.User;

@Service
@Transactional
public class AdApproveServiceImpl implements AdApproveService {
	
	@Autowired
	private AdApproveDao adApproveDao;
	
	@Autowired
	private AdfuserDao adFuserDao;

	@Override//得到所有的待审核的认证申请
	public List<Approve> getAllApprove() throws Exception {
		return this.adApproveDao.getAll("待审核");
	}

	@Override//将用户申请的认证审核为认证失败
	public boolean approveFail(Approve a) throws Exception {
		a.setApstatus("认证失败");
		a.setAppass(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		if(this.adApproveDao.updateApprove(a)==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
		
	}
	
	@Override//将用户的认证审核为认证成功
	public boolean approveSuccess(Approve a) throws Exception {
		a.setApstatus("认证成功");
		a.setAppass(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		User u=new User();
		u.setUsername(a.getApusername());
		u.setIss("true");
		if(this.adApproveDao.updateApprove(a)==1&&this.adFuserDao.updateIss(u)==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	@Override//根据关键字进行查询
	public List<Approve> getSuccess(String keyword) throws Exception {
		return this.adApproveDao.selectBykey(keyword);
	}

	@Override//关闭用户的认证（接单权限）
	public int closeApprove(String username) throws Exception {
		
		User u=this.adFuserDao.getUserByUsername(username);
		if(u==null) {			//没有找到返回1，表示没有此用户
			return 1;
		}		
		if("false".equals(u.getIss())){			//如果找到了但是他没有接单权限，返回2,表示此用户未拥有接单权限
			return 2;
		}
		
		u.setIss("false");
		int x=this.adFuserDao.updateIss(u);
		
		Approve a=new Approve();
		a.setApusername(username);
		a.setAppass(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		a.setApstatus("认证失败");
		int y=this.adApproveDao.updateApprove(a);
		
		if(x==1||y==1) {				//如果关闭成功，返回3
			return 3;
		}else {							//关闭失败，返回4
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 4;
		}
	}
	
	
	

	
}
