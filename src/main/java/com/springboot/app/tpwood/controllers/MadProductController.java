package com.springboot.app.tpwood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.tpwood.dtos.EditProductDTO;
import com.springboot.app.tpwood.dtos.MapCreateDto;
import com.springboot.app.tpwood.entity.MadProduct;
import com.springboot.app.tpwood.service.IMadProductService;

@RestController
@RequestMapping("/mad-product")
public class MadProductController {

	@Autowired
	private IMadProductService madProductService;
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<MadProduct>> findAll() {
		List<MadProduct> madProducts = this.madProductService.list();
		return ResponseEntity.status(HttpStatus.OK).body(madProducts);
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MadProduct> findOneById(@PathVariable int id) {
		MadProduct madProduct = this.madProductService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(madProduct);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		boolean deleted = this.madProductService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<?> create(@RequestBody MapCreateDto mapCreateDto) {
		try {
			MadProduct madProductCreated = this.madProductService.insert(mapCreateDto);
			return ResponseEntity.status(HttpStatus.OK).body(madProductCreated);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<MadProduct> update(@RequestBody EditProductDTO ediCreateDto) {
		MadProduct madProductUpdated = this.madProductService.edit(ediCreateDto);
		return ResponseEntity.status(HttpStatus.OK).body(madProductUpdated);
	}
	
}
