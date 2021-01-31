package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Orderb;
import com.util.pojo.OrderbPage;

@Repository
@Mapper
public interface OrderbDao {
	
	public abstract int createOrderb(Orderb ob) throws Exception;
	
	public abstract List<Orderb> getAllOrderb(OrderbPage op) throws Exception;
	
	public abstract int getCountByUsername(String busername) throws Exception;
	
	public abstract Orderb getOrderbBybid(String bid) throws Exception;
	
	public abstract int updateOrderb(Orderb ob) throws Exception;
}
