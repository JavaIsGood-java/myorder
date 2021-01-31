package ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ad.dao.AdfuserDao;
import ad.po.User;

@Service
@Transactional
public class AdFuserServiceImpl implements AdFuserService {

	@Autowired
	private AdfuserDao adFuserDao;
	
	
	@Override
	public int changeUP(String username) throws Exception {
		int i=this.adFuserDao.changePassword(username);
		if(i==0) {
			return 1;
		}else if (i==1) {
			return 2;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 3;
		}
	}


	@Override
	public List<User> getUserBykey(String keyword) throws Exception {
		return this.adFuserDao.getUserByKey(keyword);
	}
	
}
