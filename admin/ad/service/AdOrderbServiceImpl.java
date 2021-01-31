package ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.dao.AdOrderbDao;
import ad.po.Orderb;
import ad.util.pojo.AdOrderbPage;

@Service
@Transactional
public class AdOrderbServiceImpl implements AdOrderbService{

	@Autowired
	private AdOrderbDao adOrderbDao;
	
	
	@Override	//根据订单号得到下单方中此订单的信息
	public Orderb getOrderbByBid(String bid) throws Exception {
		return this.adOrderbDao.getObByBid(bid);
	}


	@Override//查询所有订单
	public AdOrderbPage getOrderbBykey(String keyword,int start) throws Exception {
		AdOrderbPage p=new AdOrderbPage();
		p.setSize(5);
		p.setStart(start);
		p.setIndex(5*start);
		p.setKeyword(keyword);
		int count=this.adOrderbDao.getOrderbBykeyCount(p.getKeyword());
		if(count%p.getSize()==0) {
			p.setTotalPage(count/p.getSize());
		}else {
			p.setTotalPage(count/p.getSize()+1);
		}
		List<Orderb> all=this.adOrderbDao.getOrderbBykey(p);
		if(all.size()==0) {
			p.setAllOb(null);
		}else {
			p.setAllOb(all);
		}
		p.setResult(count);
		return p;
	}
	
}
