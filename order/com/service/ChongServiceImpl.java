package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChongDao;
import com.po.Chong;



@Service
@Transactional
public class ChongServiceImpl implements ChongService{

	@Autowired
	private ChongDao chongDao;
	
	
	@Override
	public List<Chong> getChongByUsername(String username)  throws Exception{
		return this.chongDao.getChongByUsername(username);
	}
	
}
