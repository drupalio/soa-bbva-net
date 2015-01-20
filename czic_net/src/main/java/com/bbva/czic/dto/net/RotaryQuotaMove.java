package com.bbva.czic.dto.net;

public class RotaryQuotaMove extends Movement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private Operation operation;

	@Override  
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Operation getOperation() {
		return operation;
	}

	@Override
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
