package com.bbva.zic.accounts.business.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class DTOIntAccount {

	public final static long serialVersionUID = 1L;

	@NotNull
	@Size(min = 20, max = 20)
	private String idAccount;

	@NotNull
	private String type;

	@NotNull
	private String name;

	@NotNull
	private DTOIntBalance balance;

	private List<DTOIntCheckbook> listaCheckBook;

	public DTOIntAccount() {
		this.listaCheckBook = new ArrayList<DTOIntCheckbook>();
	}

	public DTOIntBalance getBalance() {
		return balance;
	}

	public void setBalance(DTOIntBalance balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public List<DTOIntCheckbook> getListaCheckBook() {
		return listaCheckBook;
	}

	public void setListaCheckBook(List<DTOIntCheckbook> listaCheckBook) {
		this.listaCheckBook = listaCheckBook;
	}
}
