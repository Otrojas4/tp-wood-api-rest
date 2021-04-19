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

import com.springboot.app.tpwood.entity.PrimaryTrans;
import com.springboot.app.tpwood.service.IPrimaryTransService;

@RestController
@RequestMapping("/primary-trans")
public class PrimaryTransController {
	
	@Autowired
	private IPrimaryTransService primaryTransService;

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<PrimaryTrans>> findAll() {
		List<PrimaryTrans> primaryTransLst = this.primaryTransService.list();
		return ResponseEntity.status(HttpStatus.OK).body(primaryTransLst);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<PrimaryTrans> findOneById(@PathVariable int id) {
		PrimaryTrans primaryTrans = this.primaryTransService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(primaryTrans);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		boolean deleted = this.primaryTransService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<PrimaryTrans> create(@RequestBody PrimaryTrans primaryTrans) throws Exception {
		PrimaryTrans primaryTransCreated = this.primaryTransService.insert(primaryTrans);
		return ResponseEntity.status(HttpStatus.OK).body(primaryTransCreated);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<PrimaryTrans> update(@RequestBody PrimaryTrans primaryTrans) {
		PrimaryTrans primaryTransUpdated = this.primaryTransService.edit(primaryTrans);
		return ResponseEntity.status(HttpStatus.OK).body(primaryTransUpdated);
	}
	

}
