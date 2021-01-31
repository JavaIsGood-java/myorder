package ad.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ad.dao.AdDrawhDao;
import ad.dao.AdOrderaDao;
import ad.dao.AdfuserDao;
import ad.po.Drawh;
import ad.po.Ordera;

@Service
@Transactional
public class AdDrawhServiceImpl implements AdDrawhService{
	
	@Autowired
	private AdDrawhDao adDrawhDao;
	
	@Autowired
	private AdfuserDao adFuserDao;

	@Autowired
	private AdOrderaDao adOrderaDao;
	
	
	
	@Override	//得到所有待审核的提现记录
	public List<Drawh> getAllDrawh() throws Exception {
		return this.adDrawhDao.getAllDrawhByDstatus("待审核");
	}
	
	@Override			//根据提现记录的id得到提现记录
	public Drawh getById(int id) throws Exception {
		return this.adDrawhDao.getDrawhById(id);
	}

	@Override//得到系统总额，包括用户总余额、用户总临额、未被接的单中的余额总和、未审核的提现总金额
	public double getSystemTotalMoney() throws Exception {
		double salAndLsal=this.adFuserDao.getSalAndLsal();
		double dsal=this.adDrawhDao.getDsal();
		double orderaSum=0.0;
		List<Ordera> allOrdera=this.adOrderaDao.getAll();
		for(int i=0;i<allOrdera.size();i++) {
			orderaSum+=allOrdera.get(i).getAprice();
		}
		return salAndLsal+dsal+orderaSum;
	}
	
	@Override		//提现审核成功，将提现记录的状态修改为审核成功
	public boolean updateDstatus(int id) throws Exception {
		Drawh d=new Drawh();
		d.setId(id);
		d.setDstatus("审核成功");
		d.setDdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		if(this.adDrawhDao.updateDstatus(d)==1) {
			return true;
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	@Override
	public List<Drawh> getDrawhBykey(String keyword) throws Exception {
		return this.adDrawhDao.selectBykey(keyword);
	}	
}
