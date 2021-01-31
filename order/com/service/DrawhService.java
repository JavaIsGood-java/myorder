package com.service;

import java.util.List;

import com.po.Drawh;

public interface DrawhService {
	
	public abstract int createDrawhOrder(Drawh d,String username) throws Exception;
	
	public abstract List<Drawh> getDrawhByusername(String username) throws Exception;
}
