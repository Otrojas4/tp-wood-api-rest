package com.springboot.app.tpwood.service;

import java.util.List;

import com.springboot.app.tpwood.entity.PrimaryTrans;



public interface IPrimaryTransService {
	public PrimaryTrans insert(PrimaryTrans primaryTrans) throws Exception;

	public PrimaryTrans edit(PrimaryTrans primaryTrans);

	public boolean delete(int id);
	
	public List<PrimaryTrans> list();
	
	public PrimaryTrans findOne(int id);
}
