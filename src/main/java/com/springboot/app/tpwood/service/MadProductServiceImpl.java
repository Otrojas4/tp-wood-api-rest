package com.springboot.app.tpwood.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.tpwood.client.models.ImageToCreate;
import com.springboot.app.tpwood.client.models.ImageToResponse;
import com.springboot.app.tpwood.dtos.MapCreateDto;
import com.springboot.app.tpwood.entity.MadProduct;
import com.springboot.app.tpwood.entity.PrimaryTrans;
import com.springboot.app.tpwood.entity.SecondaryTrans;
import com.springboot.app.tpwood.repository.IMadProductRepository;
import com.springboot.app.tpwood.repository.IPrimaryTransRepository;
import com.springboot.app.tpwood.repository.ISecondaryTransRepository;
import com.springboot.app.tpwood.serviceFeign.IIImageService;

@Service
public class MadProductServiceImpl implements IMadProductService {

	@Autowired
	private IMadProductRepository madProductRepo;
	
	@Autowired
	private IIImageService imageService;
	
	@Autowired
	private IPrimaryTransRepository primaryTransRepo;
	
	@Autowired
	private ISecondaryTransRepository secondaryTransRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public MadProduct insert(MapCreateDto madProductDto) throws Exception {
		 //por si cree que idSec y idPri son el id de ellos.
		 modelMapper.getConfiguration().setAmbiguityIgnored(true);
		 
		 MadProduct duplicateCode = this.madProductRepo.findByCodProduct(madProductDto.getCodProduct());
			
			if (duplicateCode != null) {
				throw new Exception("Duplicate");
		}
		 
		 String imageBase = madProductDto.getImageBase();

		 MadProduct madProductToCreate = this.modelMapper.map(madProductDto, MadProduct.class);
		 
		 int primaryTransId = madProductDto.getIdPri();
		 int secondaryTransId = madProductDto.getIdSec();
		 
		 PrimaryTrans primaryTransFinded = primaryTransRepo.findById(primaryTransId).orElse(null);
		 
		 SecondaryTrans secondaryTransFinded = secondaryTransRepo.findById(secondaryTransId).orElse(null);
		 
		 
		 madProductToCreate.setPrimaryTrans(primaryTransFinded);
		 
		 madProductToCreate.setSecondaryTrans(secondaryTransFinded);
		 
		
		 MadProduct productCreate = this.madProductRepo.save(madProductToCreate);
		 
		 if (imageBase != null) {
			 this.sendToImageService(productCreate, imageBase);
		 }
	
		return productCreate;
	}
	
	private void sendToImageService(MadProduct productCreate, String imageBase) {
		 ImageToCreate imageToCreate = new ImageToCreate();
		 
		 imageToCreate.imageBase = imageBase;
		 imageToCreate.codProduct = productCreate.getCodProduct();
		 imageToCreate.idProduct = productCreate.getId();
		 
		 this.imageService.create(imageToCreate);
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
		
		MadProduct madFinded = this.madProductRepo.findById(id).orElse(null);
		
		if (madFinded != null) {
			ImageToResponse imageBaseFinded = this.imageService.getOne(madFinded.getId(), madFinded.getCodProduct());
			if (imageBaseFinded != null) {
				madFinded.setPhoto(imageBaseFinded.getImageBase());

			}
		}
		
		return madFinded;
	}

}
