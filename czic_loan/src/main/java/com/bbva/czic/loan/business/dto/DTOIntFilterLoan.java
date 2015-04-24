package com.bbva.czic.loan.business.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;



/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntFilterLoan {

	@NotNull
    private Date fechaInicial;

	@NotNull
    private Date fechaFinal;


	@NotNull
	@Length(min = 10, max = 10)
    private String paginationKey;

	@NotNull
	private String pageSize;

	@NotNull
    private String idLoan;

	@NotNull
	private String idExtracto;

	@NotNull
	private String idMovement;

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}
	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	/**
	 * @return the idLoan
	 */  
	public String getIdLoan() { 
		return idLoan;
	}
	/**
	 * @param idLoan the idLoan to set
	 */
	public void setIdLoan(String idLoan) {
		this.idLoan = idLoan;
	}
	/**
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}
	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getPaginationKey() {
		return paginationKey;
	}

	public void setPaginationKey(String paginationKey) {
		this.paginationKey = paginationKey;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(String idMovement) {
		this.idMovement = idMovement;
	}

	public String getIdExtracto() {
		return idExtracto;
	}

	public void setIdExtracto(String idExtracto) {
		this.idExtracto = idExtracto;
	}
}
