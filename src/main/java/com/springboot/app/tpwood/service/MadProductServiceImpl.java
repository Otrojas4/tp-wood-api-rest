package com.springboot.app.tpwood.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.tpwood.dtos.MapCreateDto;
import com.springboot.app.tpwood.entity.MadProduct;
import com.springboot.app.tpwood.entity.PrimaryTrans;
import com.springboot.app.tpwood.entity.SecondaryTrans;
import com.springboot.app.tpwood.repository.IMadProductRepository;
import com.springboot.app.tpwood.repository.IPrimaryTransRepository;
import com.springboot.app.tpwood.repository.ISecondaryTransRepository;

@Service
public class MadProductServiceImpl implements IMadProductService {

	@Autowired
	private IMadProductRepository madProductRepo;
	
	@Autowired
	private IPrimaryTransRepository primaryTransRepo;
	
	@Autowired
	private ISecondaryTransRepository secondaryTransRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public MadProduct insert(MapCreateDto madProductDto) {
		 //por si cree que idSec y idPri son el id de ellos.
		 modelMapper.getConfiguration().setAmbiguityIgnored(true);

		 MadProduct madProductToCreate = this.modelMapper.map(madProductDto, MadProduct.class);
		 
		 int primaryTransId = madProductDto.getIdPri();
		 int secondaryTransId = madProductDto.getIdSec();
		 
		 PrimaryTrans primaryTransFinded = primaryTransRepo.findById(primaryTransId).orElse(null);
		 
		 SecondaryTrans secondaryTransFinded = secondaryTransRepo.findById(secondaryTransId).orElse(null);
		 
		 
		 madProductToCreate.setPrimaryTrans(primaryTransFinded);
		 
		 madProductToCreate.setSecondaryTrans(secondaryTransFinded);
		
	
		return this.madProductRepo.save(madProductToCreate);
	}

	@Override
	public MadProduct edit(MadProduct madProduct) {
		
		MadProduct secondaryTransFinded = madProductRepo.findById(madProduct.getId()).orElse(null);
		
		if (secondaryTransFinded == null) {
			return null;
		}
		
		return madProductRepo.save(madProduct);
	}

	@Override
	public boolean delete(int id) {
		try {
			this.madProductRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<MadProduct> list() {
		return this.madProductRepo.findAll();
	}

	@Override
	public MadProduct findOne(int id) {
		return this.madProductRepo.findById(id).orElse(null);
	}

}
