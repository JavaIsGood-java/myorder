package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Orderc;
import com.util.pojo.OrdercPage;

@Repository
@Mapper
public interface OrdercDao {
	public abstract int createOrderc(Orderc oc) throws Exception;
	public abstract int getCountByUsername(String username) throws Exception;
	public abstract List<Orderc> getAllOrderc(OrdercPage op) throws Exception;	
	public abstract Orderc getOrderc(String cid) throws Exception;
	public abstract int changeCstatus(Orderc oc) throws Exception;
}
