package ad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.dao.AdOrdercDao;
import ad.po.Orderc;

@Service
@Transactional
public class AdOrdercServiceImpl implements AdOrdercService{

	@Autowired
	private AdOrdercDao adOrdercDao;
	
	@Override
	public Orderc getOrdercByCid(String cid) throws Exception {
		return this.adOrdercDao.getOcByCid(cid);
	}
	
}
