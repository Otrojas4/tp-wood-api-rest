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
import com.springboot.app.tpwood.entity.SecondaryTrans;
import com.springboot.app.tpwood.service.ISecondaryTransService;

@RestController
@RequestMapping("/secondary-trans")
public class SecondaryTransController {
	
	@Autowired
	private ISecondaryTransService secondaryService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<SecondaryTrans>> findAll() {
		List<SecondaryTrans> secondaryTransLst = this.secondaryService.list();
		return ResponseEntity.status(HttpStatus.OK).body(secondaryTransLst);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<SecondaryTrans> findOneById(@PathVariable int id) {
		SecondaryTrans secondaryTrans = this.secondaryService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(secondaryTrans);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		boolean deleted = this.secondaryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<SecondaryTrans> create(@RequestBody SecondaryTrans secondaryTrans) throws Exception {
		SecondaryTrans secondaryTransCreated = this.secondaryService.insert(secondaryTrans);
		return ResponseEntity.status(HttpStatus.OK).body(secondaryTransCreated);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<SecondaryTrans> update(@RequestBody SecondaryTrans secondaryTrans) {
		SecondaryTrans secondaryTransUpdated = this.secondaryService.edit(secondaryTrans);
		return ResponseEntity.status(HttpStatus.OK).body(secondaryTransUpdated);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value="/list-json")
	public ResponseEntity<PrimaryTrans> createInSerie(@RequestBody List<SecondaryTrans> secondaryTransList) throws Exception {
		
		secondaryTransList.stream().forEach(s -> {
			try {
				this.secondaryService.insert(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
