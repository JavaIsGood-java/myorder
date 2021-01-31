package com.service;

import com.po.Orderb;
import com.util.pojo.OrderbPage;

public interface OrderbService {
	public abstract OrderbPage getAllOrderb(String username,int index) throws Exception;
	
	public abstract Orderb getOrderbBybid(String bid) throws Exception;

	public abstract boolean cancelOrderb(String bid, String username) throws Exception;
	
	public abstract boolean showOrderb(String bid) throws Exception;
}
