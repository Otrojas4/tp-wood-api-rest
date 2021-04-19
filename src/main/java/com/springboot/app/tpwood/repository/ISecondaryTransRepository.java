package com.springboot.app.tpwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.tpwood.entity.SecondaryTrans;

@Repository
public interface ISecondaryTransRepository extends JpaRepository<SecondaryTrans, Integer> {
	
	public SecondaryTrans findByCodTransSec(String codTransSec);

}
