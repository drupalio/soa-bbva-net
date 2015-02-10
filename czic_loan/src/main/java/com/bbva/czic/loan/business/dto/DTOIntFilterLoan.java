package com.bbva.czic.loan.business.dto;

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
    private Integer paginationKey;

	@NotNull
	private Integer pageSize;

	@NotNull
    private String idLoan;

	private String transactionDate;

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


	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getPaginationKey() {
		return paginationKey;
	}

	public void setPaginationKey(Integer paginationKey) {
		this.paginationKey = paginationKey;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(String idMovement) {
		this.idMovement = idMovement;
	}
}
