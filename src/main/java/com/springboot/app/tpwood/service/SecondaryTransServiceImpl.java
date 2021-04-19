package com.springboot.app.tpwood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.tpwood.entity.SecondaryTrans;
import com.springboot.app.tpwood.repository.ISecondaryTransRepository;

@Service
public class SecondaryTransServiceImpl implements ISecondaryTransService {
	
	@Autowired
	private ISecondaryTransRepository secondaryTransRepo;

	@Override
	public SecondaryTrans insert(SecondaryTrans secondaryTrans) throws Exception {
		SecondaryTrans duplicateCode = this.secondaryTransRepo.findByCodTransSec(secondaryTrans.getCodTransSec());
		
		if (duplicateCode != null) {
			throw new Exception("Duplicate");
		}

		return this.secondaryTransRepo.save(secondaryTrans);
	}

	@Override
	public SecondaryTrans edit(SecondaryTrans secondaryTrans) {
				
		SecondaryTrans secondaryTransFinded = secondaryTransRepo.findById(secondaryTrans.getIdSec()).orElse(null);
		
		if (secondaryTransFinded == null) {
			return null;
		}
		
		return secondaryTransRepo.save(secondaryTrans);
	}

	@Override
	public boolean delete(int id) {
		try {
			this.secondaryTransRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<SecondaryTrans> list() {
		List<SecondaryTrans> listSecondaryTrans = this.secondaryTransRepo.findAll();
		return listSecondaryTrans;
	}

	@Override
	public SecondaryTrans findOne(int id) {
		return this.secondaryTransRepo.findById(id).orElse(null);
	}

}
