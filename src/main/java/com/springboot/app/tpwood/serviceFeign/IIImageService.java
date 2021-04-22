package com.springboot.app.tpwood.serviceFeign;

import com.springboot.app.tpwood.client.models.ImageToCreate;
import com.springboot.app.tpwood.client.models.ImageToResponse;

public interface IIImageService {

	public ImageToResponse create(ImageToCreate imageToCreate);
	
	public ImageToResponse getOne(int idProduct, String codProduct);
	
	public ImageToResponse edit(ImageToCreate imageToCreate);
	
}
