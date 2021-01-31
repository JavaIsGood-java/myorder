package ad.service;

import ad.po.Orderb;
import ad.util.pojo.AdOrderbPage;

public interface AdOrderbService {
	public abstract Orderb getOrderbByBid(String bid) throws Exception;
	
	public abstract AdOrderbPage getOrderbBykey(String keyword,int start) throws Exception;
}
