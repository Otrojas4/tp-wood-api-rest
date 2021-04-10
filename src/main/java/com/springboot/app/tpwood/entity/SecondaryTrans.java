package com.springboot.app.tpwood.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "transsecundaria")
public class SecondaryTrans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSec;

	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodTransSec", length = 60, nullable = false)
	private String codTransSec;
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodMaquinaria1", length = 60, nullable = false)
	private String codMachinaryOne;
	
	@Size (min=2 ,max=4)
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "Porcentaje1", length = 4, nullable = false)
	private String percentageOne;
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodMaquinaria2", length = 60, nullable = false)
	private String codMachinaryTwo;
	
	@Size (min=2 ,max=4)
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "Porcentaje2", length = 4, nullable = false)
	private String percentageTwo;
	
	@NotNull
	@Past(message = "No puedes seleccionar un dia que todavia no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "Fechaelaboracions")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateElaborations;
	
	
	@Column(name = "TiempoElabos")
	private Double timeElaborations;


	public SecondaryTrans() {
	}


	public int getIdSec() {
		return idSec;
	}


	public void setIdSec(int idSec) {
		this.idSec = idSec;
	}


	public String getCodTransSec() {
		return codTransSec;
	}


	public void setCodTransSec(String codTransSec) {
		this.codTransSec = codTransSec;
	}


	public String getCodMachinaryOne() {
		return codMachinaryOne;
	}


	public void setCodMachinaryOne(String codMachinaryOne) {
		this.codMachinaryOne = codMachinaryOne;
	}


	public String getPercentageOne() {
		return percentageOne;
	}


	public void setPercentageOne(String percentageOne) {
		this.percentageOne = percentageOne;
	}


	public String getCodMachinaryTwo() {
		return codMachinaryTwo;
	}


	public void setCodMachinaryTwo(String codMachinaryTwo) {
		this.codMachinaryTwo = codMachinaryTwo;
	}


	public String getPercentageTwo() {
		return percentageTwo;
	}


	public void setPercentageTwo(String percentageTwo) {
		this.percentageTwo = percentageTwo;
	}


	public Date getDateElaborations() {
		return dateElaborations;
	}


	public void setDateElaborations(Date dateElaborations) {
		this.dateElaborations = dateElaborations;
	}


	public Double getTimeElaborations() {
		return timeElaborations;
	}


	public void setTimeElaborations(Double timeElaborations) {
		this.timeElaborations = timeElaborations;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


}
