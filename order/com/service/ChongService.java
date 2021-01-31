package com.service;

import java.util.List;

import com.po.Chong;

public interface ChongService {
	public abstract List<Chong> getChongByUsername(String username) throws Exception;
}
