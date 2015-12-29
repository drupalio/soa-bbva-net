package com.bbva.czic.exchangeratesimulation.business.dto;

public class DTOIntSimulation {

	public final static long serialVersionUID = 1L;

	private String id;

	private String algorithm;

	public DTOIntSimulation() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
