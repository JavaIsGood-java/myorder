package com.service;

import java.util.List;

import com.po.Ordera;


public interface OrderaService {
	
	public abstract int sendOrdera(Ordera o) throws Exception;
	
	public abstract List<Ordera> getAllOrdera() throws Exception;
}
