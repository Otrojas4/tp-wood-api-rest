package com.springboot.app.tpwood.client.models;

public class ImageToResponse {
	public String _id;
	public String imageBase;
	public String codProduct;
	public int idProduct;
	
	
	
	public ImageToResponse() {
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getImageBase() {
		return imageBase;
	}
	public void setImageBase(String imageBase) {
		this.imageBase = imageBase;
	}
	public String getCodProduct() {
		return codProduct;
	}
	public void setCodProduct(String codProduct) {
		this.codProduct = codProduct;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
}
