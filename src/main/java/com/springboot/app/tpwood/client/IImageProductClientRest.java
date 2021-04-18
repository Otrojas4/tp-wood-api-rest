package com.springboot.app.tpwood.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.app.tpwood.client.models.ImageToCreate;
import com.springboot.app.tpwood.client.models.ImageToResponse;

@FeignClient(name="product-image", url="https://tp-wood-images-node.azurewebsites.net/api-images")
public interface IImageProductClientRest {
	
	@GetMapping("/create")
	public ResponseEntity<ImageToResponse> create(@RequestBody ImageToCreate imageToCreate);

	@GetMapping("/{idProduct}/{codProduct}")
	public ResponseEntity<ImageToResponse> getOne(@PathVariable int idProduct, @PathVariable String codProduct);
}
