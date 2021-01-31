package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.po.Ordera;

@Repository
@Mapper
public interface OrderaDao {
	
	public abstract int createOrdera(Ordera oa) throws Exception;
	public abstract int deleteOrdera(Ordera oa) throws Exception;
	public abstract List<Ordera> getAllOrdera() throws Exception;
	public abstract Ordera getOrderaById(int id) throws Exception;
}
