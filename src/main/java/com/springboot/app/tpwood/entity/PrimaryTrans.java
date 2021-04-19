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
@Table(name = "transprimaria")
public class PrimaryTrans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPri;

	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodTransPri", length = 60, nullable = false, unique=true)
	private String codTransPri;
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodMaquinaria1", length = 60, nullable = false)
	private String codMachineryOne;
	
	@Size (min=2 ,max=4)
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "Porcentaje1", length = 4, nullable = false)
	private String percentageOne;
	
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "CodMaquinaria2", length = 60, nullable = false)
	private String codMachineryTwo;
	
	@Size (min=2 ,max=4)
	@NotEmpty(message = "No puede estar vacío")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name = "Porcentaje2", length = 4, nullable = false)
	private String percentageTwo;
	
	@NotNull
	@Past(message = "No puedes seleccionar un dia que todavia no existe")
	@Temporal(TemporalType.DATE)
	@Column(name = "Fechaelaboracionp")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateElaborationP;
	
	
	@Column(name = "TiempoElabop")
	private Double timeElaborationP;


	public PrimaryTrans() {

	}


	public int getIdPri() {
		return idPri;
	}


	public void setIdPri(int idPri) {
		this.idPri = idPri;
	}


	public String getCodTransPri() {
		return codTransPri;
	}


	public void setCodTransPri(String codTransPri) {
		this.codTransPri = codTransPri;
	}


	public String getCodMachineryOne() {
		return codMachineryOne;
	}


	public void setCodMachineryOne(String codMachineryOne) {
		this.codMachineryOne = codMachineryOne;
	}


	public String getPercentageOne() {
		return percentageOne;
	}


	public void setPercentageOne(String percentageOne) {
		this.percentageOne = percentageOne;
	}


	public String getCodMachineryTwo() {
		return codMachineryTwo;
	}


	public void setCodMachineryTwo(String codMachineryTwo) {
		this.codMachineryTwo = codMachineryTwo;
	}


	public String getPercentageTwo() {
		return percentageTwo;
	}


	public void setPercentageTwo(String percentageTwo) {
		this.percentageTwo = percentageTwo;
	}


	public Date getDateElaborationP() {
		return dateElaborationP;
	}


	public void setDateElaborationP(Date dateElaborationP) {
		this.dateElaborationP = dateElaborationP;
	}


	public Double getTimeElaborationP() {
		return timeElaborationP;
	}


	public void setTimeElaborationP(Double timeElaborationP) {
		this.timeElaborationP = timeElaborationP;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	
}
