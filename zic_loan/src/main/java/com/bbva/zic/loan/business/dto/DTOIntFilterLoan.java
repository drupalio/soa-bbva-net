package com.bbva.zic.loan.business.dto;

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
	private Integer pageSize;

	@NotNull
    private String idLoan;

	private String transactionDate;

	private String idMovement;

	@NotNull
	private String movementInd;

	@NotNull
	private String extractInd;

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

	public String getMovementInd() {
		return movementInd;
	}

	public void setMovementInd(String movementInd) {
		this.movementInd = movementInd;
	}

	public String getExtractInd() {
		return extractInd;
	}

	public void setExtractInd(String extractInd) {
		this.extractInd = extractInd;
	}
}
