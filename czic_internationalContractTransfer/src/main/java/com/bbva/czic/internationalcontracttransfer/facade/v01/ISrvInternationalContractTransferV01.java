package com.bbva.czic.internationalcontracttransfer.facade.v01;

import javax.ws.rs.core.Response;

public interface ISrvInternationalContractTransferV01 {

	public Response listInternationalContractTransfer(String filter, String fields, String expands, String orderby);

}