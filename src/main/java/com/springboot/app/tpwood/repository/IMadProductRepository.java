package com.springboot.app.tpwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.tpwood.entity.MadProduct;

@Repository
public interface IMadProductRepository extends JpaRepository<MadProduct, Integer> {

	public MadProduct findByCodProduct(String codProduct);
}
