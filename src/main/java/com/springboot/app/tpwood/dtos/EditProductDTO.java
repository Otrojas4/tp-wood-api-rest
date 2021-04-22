package com.springboot.app.tpwood.dtos;

import java.util.Date;

import com.springboot.app.tpwood.entity.PrimaryTrans;
import com.springboot.app.tpwood.entity.SecondaryTrans;

public class EditProductDTO {
	private int id;
	
	private String codProduct;
	
	private String codForestGuide;
	
	private String productName;
	
	private String sawmillName;
	
	private Date dateOfElaboration;
	
	private String codPlate;
	
	private Double elaborationTime;
	
	private String woodType;
	
	private String imageBase;
	
	private PrimaryTrans primaryTrans;
	
	private SecondaryTrans secondaryTrans;

	public EditProductDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodProduct() {
		return codProduct;
	}

	public void setCodProduct(String codProduct) {
		this.codProduct = codProduct;
	}

	public String getCodForestGuide() {
		return codForestGuide;
	}

	public void setCodForestGuide(String codForestGuide) {
		this.codForestGuide = codForestGuide;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSawmillName() {
		return sawmillName;
	}

	public void setSawmillName(String sawmillName) {
		this.sawmillName = sawmillName;
	}

	public Date getDateOfElaboration() {
		return dateOfElaboration;
	}

	public void setDateOfElaboration(Date dateOfElaboration) {
		this.dateOfElaboration = dateOfElaboration;
	}

	public String getCodPlate() {
		return codPlate;
	}

	public void setCodPlate(String codPlate) {
		this.codPlate = codPlate;
	}

	public Double getElaborationTime() {
		return elaborationTime;
	}

	public void setElaborationTime(Double elaborationTime) {
		this.elaborationTime = elaborationTime;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public String getImageBase() {
		return imageBase;
	}

	public void setImageBase(String imageBase) {
		this.imageBase = imageBase;
	}

	public PrimaryTrans getPrimaryTrans() {
		return primaryTrans;
	}

	public void setPrimaryTrans(PrimaryTrans primaryTrans) {
		this.primaryTrans = primaryTrans;
	}

	public SecondaryTrans getSecondaryTrans() {
		return secondaryTrans;
	}

	public void setSecondaryTrans(SecondaryTrans secondaryTrans) {
		this.secondaryTrans = secondaryTrans;
	}
	
	

}
