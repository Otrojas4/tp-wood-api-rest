package com.springboot.app.tpwood.serviceFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.tpwood.client.IImageProductClientRest;
import com.springboot.app.tpwood.client.models.ImageToCreate;
import com.springboot.app.tpwood.client.models.ImageToResponse;

@Service
public class ImageServiceImpl implements IIImageService {
	
	@Autowired
	private IImageProductClientRest productClientRest;


	@Override
	public ImageToResponse getOne(int idProduct, String codProduct) {
		return this.productClientRest.getOne(idProduct, codProduct).getBody();
	}

	@Override
	public ImageToResponse create(ImageToCreate imageToCreate) {
		return this.productClientRest.create(imageToCreate).getBody();
	}

	
}
