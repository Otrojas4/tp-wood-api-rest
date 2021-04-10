package com.springboot.app.tpwood.service;

import java.util.List;

import com.springboot.app.tpwood.entity.SecondaryTrans;


public interface ISecondaryTransService {

	public SecondaryTrans insert(SecondaryTrans secondaryTrans);

	public SecondaryTrans edit(SecondaryTrans secondaryTrans);

	public boolean delete(int id);
	
	public List<SecondaryTrans> list();
	
	public SecondaryTrans findOne(int id);
}
