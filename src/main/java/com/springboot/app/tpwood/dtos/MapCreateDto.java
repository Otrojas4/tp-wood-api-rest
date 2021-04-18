package com.springboot.app.tpwood.dtos;

public class MapCreateDto {

	public String codProduct;
	public String codForestGuide;
	public String productName;
	public String sawmillName;
	public String dateOfElaboration;
	public String codPlate;
	public double elaborationTime;
	public String woodType;
	public String imageBase;
	public int idPri;
	public int idSec;

	public String getImageBase() {
		return imageBase;
	}

	public void setImageBase(String imageBase) {
		this.imageBase = imageBase;
	}

	public MapCreateDto() {
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

	public String getDateOfElaboration() {
		return dateOfElaboration;
	}

	public void setDateOfElaboration(String dateOfElaboration) {
		this.dateOfElaboration = dateOfElaboration;
	}

	public String getCodPlate() {
		return codPlate;
	}

	public void setCodPlate(String codPlate) {
		this.codPlate = codPlate;
	}

	public double getElaborationTime() {
		return elaborationTime;
	}

	public void setElaborationTime(double elaborationTime) {
		this.elaborationTime = elaborationTime;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public int getIdPri() {
		return idPri;
	}

	public void setIdPri(int idPri) {
		this.idPri = idPri;
	}

	public int getIdSec() {
		return idSec;
	}

	public void setIdSec(int idSec) {
		this.idSec = idSec;
	}

}
