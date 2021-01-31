package ad.service;

import java.util.List;

import ad.po.Drawh;

public interface AdDrawhService {
	public abstract List<Drawh> getAllDrawh() throws Exception;
	public abstract Drawh getById(int id) throws Exception;
	public abstract double getSystemTotalMoney() throws Exception;
	public abstract boolean updateDstatus(int id) throws Exception;
	public abstract List<Drawh> getDrawhBykey(String key) throws Exception;
}	
