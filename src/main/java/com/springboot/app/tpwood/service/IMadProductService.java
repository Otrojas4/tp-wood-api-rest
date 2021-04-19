package com.springboot.app.tpwood.service;

import java.util.List;

import com.springboot.app.tpwood.dtos.MapCreateDto;
import com.springboot.app.tpwood.entity.MadProduct;

public interface IMadProductService {

	public MadProduct insert(MapCreateDto madProduct) throws Exception;

	public MadProduct edit(MadProduct madProduct);

	public boolean delete(int id);
	
	public List<MadProduct> list();
	
	public MadProduct findOne(int id);
}
