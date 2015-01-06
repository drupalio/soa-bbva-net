package com.bbva.czic.globalposition.dao;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntPhoneNumber;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.model.ozn0.FormatoOZNCEOM0;
import com.bbva.czic.globalposition.dao.model.ozn0.PeticionTransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn0.RespuestaTransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn0.TransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn1.*;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Component
public class GlobalPositionDAOImpl implements GlobalPositionDAO {

	public static final String PERSONAL_ACCOUNT = "01";
	public static final String ELECTRONIC_DEPOSIT = "02";
	public static final String TC = "03";
	public static final String LOAN = "04";
	public static final String SI = "05";
	public static final String ROTARY_QUOTA = "06";
	public static final String LEISING = "07";
	public static final String AQUISITION = "08";
	@Autowired
	private TransaccionOzn1 transaccionGetGlobalPosition;

	@Autowired
	private TransaccionOzn0 transaccionOzn0;

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	private static final String VISIBLE = "SHOW";
	private static final String HIDDEN = "HIDE";

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(final String customerId) throws ExcepcionTransporte {

		String intProductType = "";
		PeticionTransaccionOzn1 peticion = new PeticionTransaccionOzn1();
		FormatoOZECN1E0 formatoEntrada = new FormatoOZECN1E0();

		List<DTOIntProduct> intProducts = new ArrayList<DTOIntProduct>();
		// TODO Cuando se envien el tipo de producto, se debe realizar un IF para validar


		formatoEntrada.setNumclie(customerId);
		peticion.getCuerpo().getPartes().add(formatoEntrada);

		RespuestaTransaccionOzn1 respuesta = transaccionGetGlobalPosition.invocar(peticion);

		BusinessServiceException businessServiceException = errorMappingHelper.toBusinessServiceException(respuesta);

		if (businessServiceException != null) {
			throw businessServiceException;
		}
		List<CopySalida> copiesSalida = respuesta.getCuerpo().getPartes(CopySalida.class);
		for (CopySalida copySalida : copiesSalida) {
			// 1. Si es PG completa, se coloca el tipo de salida 1 (No comunes)
			// 2. Si es un tipo de producto diferente a tarjetas se mapea a el tipo de salida 0 (comunes)
			DTOIntProduct intProduct = new DTOIntProduct();
			if (intProductType == null) {
				FormatoOZECN1S1 formatoSalida = copySalida.getCopy(FormatoOZECN1S1.class);
				intProduct.setId(formatoSalida.getNumprod());
				String productType = formatoSalida.getTipprod();

				if(productType.equals(PERSONAL_ACCOUNT)) {
					intProduct.setProductType(EnumProductType.PC);
				} else if(productType.equals(ELECTRONIC_DEPOSIT)) {
					intProduct.setProductType(EnumProductType.ED);
				} else if(productType.equals(TC)) {
					intProduct.setProductType(EnumProductType.TC);
				} else if(productType.equals(LOAN)) {
					intProduct.setProductType(EnumProductType.LO);
				} else if(productType.equals(SI)) {
					intProduct.setProductType(EnumProductType.SI);
				} else if(productType.equals(ROTARY_QUOTA)) {
					intProduct.setProductType(EnumProductType.RQ);
				} else if(productType.equals(LEISING)) {
					intProduct.setProductType(EnumProductType.LI);
				} else if(productType.equals(AQUISITION)) {
					intProduct.setProductType(EnumProductType.AQ);
				}

				intProduct.setName(formatoSalida.getNomprod());
				intProduct.setAlias(formatoSalida.getAlias());
				intProduct.getBalance().setTotal(new Money(Currency.getInstance("COP"), new BigDecimal(formatoSalida.getSaltota())));
				intProduct.getBalance().setAvailableBalance(new Money(Currency.getInstance("COP"), new BigDecimal(formatoSalida.getSaldisp())));
				if (formatoSalida.getIndvisi().equals("f")) {
					intProduct.setVisible(false);
				} else {
					intProduct.setVisible(true);
				}

				if (formatoSalida.getIndoper().equals("f")) {
					intProduct.setOperable(false);
				} else {
					intProduct.setOperable(true);
				}

				intProduct.
						getContactInfo().
						getPhoneNumbers().
						add(new DTOIntPhoneNumber(formatoSalida.getNumcelu()));

			} else if(!intProductType.equals(EnumProductType.TC)){
				FormatoOZECN1S0 formatoSalida = copySalida.getCopy(FormatoOZECN1S0.class);
				intProduct.setId(formatoSalida.getNumprod());
				String productType = formatoSalida.getTipprod();

				if(productType.equals(PERSONAL_ACCOUNT)) {
					intProduct.setProductType(EnumProductType.PC);
				} else if(productType.equals(ELECTRONIC_DEPOSIT)) {
					intProduct.setProductType(EnumProductType.ED);
				} else if(productType.equals(TC)) {
					intProduct.setProductType(EnumProductType.TC);
				} else if(productType.equals(LOAN)) {
					intProduct.setProductType(EnumProductType.LO);
				} else if(productType.equals(SI)) {
					intProduct.setProductType(EnumProductType.SI);
				} else if(productType.equals(ROTARY_QUOTA)) {
					intProduct.setProductType(EnumProductType.RQ);
				} else if(productType.equals(LEISING)) {
					intProduct.setProductType(EnumProductType.LI);
				} else if(productType.equals(AQUISITION)) {
					intProduct.setProductType(EnumProductType.AQ);
				}

				intProduct.setName(formatoSalida.getNomprod());
				intProduct.setAlias(formatoSalida.getAlias());
				intProduct.getBalance().setTotal(new Money(Currency.getInstance("COP"), new BigDecimal(formatoSalida.getSaltota())));
				intProduct.getBalance().setAvailableBalance(new Money(Currency.getInstance("COP"), new BigDecimal(formatoSalida.getSaldisp())));
				if (formatoSalida.getIndvisi().equals("f")) {
					intProduct.setVisible(false);
				} else {
					intProduct.setVisible(true);
				}

				if (formatoSalida.getIndoper().equals("f")) {
					intProduct.setOperable(false);
				} else {
					intProduct.setOperable(true);
				}
			}
		}
		return intProducts;
	}

	@Override
	public void updateProductVisibility(final String idProduct, final Boolean visible) {

		PeticionTransaccionOzn0 peticion = new PeticionTransaccionOzn0();
		FormatoOZNCEOM0 formatoEntrada = new FormatoOZNCEOM0();

		formatoEntrada.setNumcta(idProduct);
		if (visible) {
			formatoEntrada.setIndcta(VISIBLE);
		} else {
			formatoEntrada.setIndcta(HIDDEN);
		}

		peticion.getCuerpo().getPartes().add(formatoEntrada);

		RespuestaTransaccionOzn0 respuesta = transaccionOzn0.invocar(peticion);

		BusinessServiceException businessServiceException = errorMappingHelper.toBusinessServiceException(respuesta);

		if (businessServiceException == null) {
			throw businessServiceException;
		}
	}

	@Override
	public void updateProductOperability(String idProduct, Boolean operable) {
/*
		PeticionTransaccionOzn0 peticion = new PeticionTransaccionOzn0();
		FormatoOZNCEOM0 formatoEntrada = new FormatoOZNCEOM0();

		formatoEntrada.setNumcta(idProduct);
		if (operable) {
			formatoEntrada.setIndcta();
		} else {
			formatoEntrada.setIndcta();
		}

		peticion.getCuerpo().getPartes().add(formatoEntrada);

		transaccionOzn0.invocar(peticion);
*/
	}

}
