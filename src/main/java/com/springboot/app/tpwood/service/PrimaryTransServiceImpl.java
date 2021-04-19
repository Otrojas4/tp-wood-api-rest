package com.springboot.app.tpwood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.tpwood.entity.PrimaryTrans;
import com.springboot.app.tpwood.repository.IPrimaryTransRepository;

@Service
public class PrimaryTransServiceImpl implements IPrimaryTransService {

	@Autowired
	private IPrimaryTransRepository primaryTransRepo;
	
	@Override
	public PrimaryTrans insert(PrimaryTrans primaryTrans) throws Exception {
		
		
		PrimaryTrans duplicateCode = this.primaryTransRepo.findByCodTransPri(primaryTrans.getCodTransPri());
		
		if (duplicateCode != null) {
			throw new Exception("Duplicate");
		}

		return this.primaryTransRepo.save(primaryTrans);
	}

	@Override
	public PrimaryTrans edit(PrimaryTrans primaryTrans) {
		
		PrimaryTrans secondaryTransFinded = primaryTransRepo.findById(primaryTrans.getIdPri()).orElse(null);
		
		if (secondaryTransFinded == null) {
			return null;
		}
		
		return primaryTransRepo.save(primaryTrans);
	}

	@Override
	public boolean delete(int id) {
		try {
			this.primaryTransRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<PrimaryTrans> list() {
		return this.primaryTransRepo.findAll();
	}

	@Override
	public PrimaryTrans findOne(int id) {
		return this.primaryTransRepo.findById(id).orElse(null);
	}

}
