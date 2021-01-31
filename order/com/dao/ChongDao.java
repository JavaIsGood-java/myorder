package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Chong;



@Repository
@Mapper
public interface ChongDao {
	public abstract List<Chong> getChongByUsername(String username) throws Exception;
}
