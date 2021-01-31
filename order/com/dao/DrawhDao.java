package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Drawh;

@Repository
@Mapper
public interface DrawhDao {
	public abstract int createDrawh(Drawh d) throws Exception;
	public abstract List<Drawh> selectByDusername(String dusername) throws Exception;
}
