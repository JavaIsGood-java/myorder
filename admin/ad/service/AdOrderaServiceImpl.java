package ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.dao.AdOrderaDao;
import ad.po.Ordera;


@Service
@Transactional
public class AdOrderaServiceImpl implements AdOrderaService {

	@Autowired
	private AdOrderaDao adOrderaDao;
		
	@Override
	public List<Ordera> getAllOrdera() throws Exception {
		return this.adOrderaDao.getAll();
	}
	
	
}
