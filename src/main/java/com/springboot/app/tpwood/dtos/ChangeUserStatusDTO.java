package com.springboot.app.tpwood.dtos;

public class ChangeUserStatusDTO {
	private int id;
	
	private String status;
	
	public ChangeUserStatusDTO() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
