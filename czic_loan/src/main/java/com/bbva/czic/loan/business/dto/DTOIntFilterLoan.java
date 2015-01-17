package com.bbva.czic.loan.business.dto;

import java.util.Date;



/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntFilterLoan {

    private Date fechaInicial;
    private Date fechaFianl;
    private String idLoan;
	private String transactionDate;
	/**
	 * @return the fechaFianl
	 */
	public Date getFechaFianl() {
		return fechaFianl;
	}
	/**
	 * @param fechaFianl the fechaFianl to set
	 */
	public void setFechaFianl(Date fechaFianl) {
		this.fechaFianl = fechaFianl;
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
}
