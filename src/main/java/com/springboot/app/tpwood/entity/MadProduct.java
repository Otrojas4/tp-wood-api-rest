package com.springboot.app.tpwood.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "mad")
public class MadProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "codProducto", length = 60, nullable = false)
	private String codProduct;
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodGuiaForestal", length = 60, nullable = false)
	private String codForestGuide;
	
	@Size(min=2 ,max=50)
	@NotEmpty(message="No puede estar vacío")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "NombreProducto", length = 50, nullable = false)
	private String productName;
	
	@Size (min=2 ,max=50)
	@NotEmpty(message="No puede estar vacío")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "NombreAserradero", length = 50, nullable = false)
	private String sawmillName;
	
	
	@NotNull
	@Past(message = "No puedes seleccionar un dia que todavia no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "Fechaelaboracion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfElaboration;
	
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "codPlancha", length = 60, nullable = false)
	private String codPlate;
	
	
	@Column(name = "TiempoElabo")
	private Double elaborationTime;
	
	
	@Size (min=2 ,max=50)
	@NotEmpty(message="No puede estar vacío")
	@NotBlank(message="No puede estar en blanco")
	@Column(name = "TipoMadera", length = 50, nullable = false)
	private String woodType;
	
	
	@Column(name = "foto")
	private String photo;
	
	@ManyToOne()
	@JoinColumn(name = "idPri", nullable = false)
	private PrimaryTrans primaryTrans;
	
	@ManyToOne()
	@JoinColumn(name = "idSec", nullable = false)
	private SecondaryTrans secondaryTrans;

	
	// main constructor
	public MadProduct() {
		
	}
	
	//getters and setters
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
