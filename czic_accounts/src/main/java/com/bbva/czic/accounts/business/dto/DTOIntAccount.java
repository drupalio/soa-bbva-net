package com.bbva.czic.accounts.business.dto;

import java.util.ArrayList;
import java.util.List;

public class DTOIntAccount {

	public final static long serialVersionUID = 1L;

	private String idAccount;

	private String type;

	private String name;

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
