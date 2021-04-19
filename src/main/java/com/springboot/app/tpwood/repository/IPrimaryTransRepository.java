package com.springboot.app.tpwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.tpwood.entity.PrimaryTrans;

@Repository
public interface IPrimaryTransRepository extends JpaRepository<PrimaryTrans, Integer> {
	public PrimaryTrans findByCodTransPri(String codTransPri);
}
