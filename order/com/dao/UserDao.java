package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.po.User;


@Repository
@Mapper
public interface UserDao {
	public abstract User selectByUsername(User u) throws Exception;
	public abstract int updatePassword(User u) throws Exception;
	public abstract int updateUser(User u) throws Exception;
	public abstract int updateSal(User u) throws Exception;
	public abstract int updateLsal(User u) throws Exception;
	public abstract int updateSalAndL(User u) throws Exception;
	public abstract int createUser(User u) throws Exception;
}
