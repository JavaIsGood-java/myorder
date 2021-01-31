package com.service;

import com.po.User;

public interface UserService {
	public abstract boolean UserLogin(User u)throws Exception;
	public abstract int changePassword(String password, String npassword, String username)throws Exception;
	public abstract User getUserInfo(String username)throws Exception;
	public abstract boolean getIss(String username) throws Exception;
	public abstract int registerUser(User u) throws Exception;
}
