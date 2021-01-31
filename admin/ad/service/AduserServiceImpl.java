package ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ad.dao.AduserDao;
import ad.po.Aduser;
import ad.po.User;

@Service
@Transactional
public class AduserServiceImpl implements AduserService{

	@Autowired
	private AduserDao aduserDao;
	
	@Override
	public boolean login(Aduser a) throws Exception {
		Aduser u=this.aduserDao.selectByadusername(a.getAdusername());
		if(u!=null&&a.getAdpassword().equals(u.getAdpassword())) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int changeP(String password, String npassword, String adusername) throws Exception {
		Aduser a=this.aduserDao.selectByadusername(adusername);
		
		if(a==null||!a.getAdpassword().equals(password)) {
			return 1;
		}
		
		a.setAdpassword(npassword);
		if(this.aduserDao.updateAdp(a)==1) {
			return 2;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 3;
		}
	}
}
