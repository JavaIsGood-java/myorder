package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Approve;

@Repository
@Mapper
public interface ApproveDao {
	public abstract Approve selectByusername(String username) throws Exception;
	public abstract int createApprove(Approve a) throws Exception;
	public abstract int updateApprove(Approve a) throws Exception;
}
