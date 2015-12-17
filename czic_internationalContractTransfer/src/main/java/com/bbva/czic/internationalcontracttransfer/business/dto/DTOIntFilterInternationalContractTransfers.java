package com.bbva.czic.internationalcontracttransfer.business.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 29/01/2015.
 */
public class DTOIntFilterInternationalContractTransfers {

	private String referencesValue;

	private String typeName;

	private String dateStart;

	private String dateEnd;

	@NotNull
	private String senderContractParticipantsId;

	@NotNull
	private Integer paginationKey;

	@NotNull
	private Integer pageSize;

	private String expands;

	public String getReferencesValue() {
		return referencesValue;
	}

	public void setReferencesValue(String referencesValue) {
		this.referencesValue = referencesValue;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getSenderContractParticipantsId() {
		return senderContractParticipantsId;
	}

	public void setSenderContractParticipantsId(String senderContractParticipantsId) {
		this.senderContractParticipantsId = senderContractParticipantsId;
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

	public String getExpands() {
		return expands;
	}

	public void setExpands(String expands) {
		this.expands = expands;
	}

}
