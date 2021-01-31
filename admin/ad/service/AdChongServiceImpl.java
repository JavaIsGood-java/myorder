package ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.dao.AdChongDao;
import ad.dao.AdDrawhDao;
import ad.dao.AdOrderaDao;
import ad.dao.AdfuserDao;
import ad.po.Ordera;
import ad.util.pojo.AdChongPage;
import ad.util.pojo.Sal;



@Service
@Transactional
public class AdChongServiceImpl implements AdChongService{

	@Autowired
	private AdChongDao adChongDao;
	
	@Autowired
	private AdDrawhDao adDrawhDao;
	
	@Autowired
	private AdfuserDao adFuserDao;

	@Autowired
	private AdOrderaDao adOrderaDao;
	

	@Override
	public AdChongPage getChongByKey(String keyword,int start) throws Exception {
		AdChongPage a=new AdChongPage();
		a.setSize(5);
		a.setStart(start);
		a.setIndex(5*start);
		a.setKeyword(keyword);
		int count=this.adChongDao.selectByKeyCount(a);
		if(count%a.getSize()==0) {
			a.setTotalPage(count/a.getSize());
		}else {
			a.setTotalPage(count/a.getSize()+1);
		}
		a.setAllC(this.adChongDao.selectBykey(a));
		if(a.getAllC().size()==0) {
			a.setAllC(null);
		}else {
			a.setResult(a.getAllC().size());
		}
		return a;
	}


	@Override//得到系统金额
	public Sal getSystemSal() throws Exception {
		Sal s=new Sal();
		s.setSalAndLsal(this.adFuserDao.getSalAndLsal());
		double dsal=0.0;
		try {
			dsal=this.adDrawhDao.getDsal();
		}catch(Exception e) {
		}
		s.setDrawhSal(dsal);
		double orderaSum=0.0;
		List<Ordera> allOrdera=this.adOrderaDao.getAll();
		for(int i=0;i<allOrdera.size();i++) {
			orderaSum+=allOrdera.get(i).getAprice();
		}
		s.setOrderaSal(orderaSum);
		return s;
	}
}
