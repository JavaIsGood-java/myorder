package ad.service;

import ad.po.Orderc;

public interface AdOrdercService {
	public abstract Orderc getOrdercByCid(String cid) throws Exception;
}
