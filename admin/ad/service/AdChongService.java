package ad.service;

import ad.util.pojo.AdChongPage;
import ad.util.pojo.Sal;

public interface AdChongService {
	public abstract AdChongPage getChongByKey(String key,int start) throws Exception;
	public abstract Sal getSystemSal() throws Exception;
}
