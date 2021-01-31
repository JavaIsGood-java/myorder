package com.service;

import com.po.Orderc;
import com.util.pojo.OrdercPage;

public interface OrdercService {
	public abstract int take(String id,String username) throws Exception;
	public abstract OrdercPage getAllOrderc(String username,int start) throws Exception;
	public abstract Orderc getOrdercByCid(String cid) throws Exception;
	public abstract boolean takeOrderc(String cid) throws Exception;
}
