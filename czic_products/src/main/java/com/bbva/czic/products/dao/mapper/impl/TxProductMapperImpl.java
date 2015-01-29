package com.bbva.czic.products.dao.mapper.impl;

import com.bbva.czic.products.business.dto.DTOIntCity;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntCountry;
import com.bbva.czic.products.business.dto.DTOIntLocation;
import com.bbva.czic.products.business.dto.DTOIntOffice;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.mapper.TxProductMapper;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;

@Mapper(value = "txProductMapper")
public class TxProductMapperImpl extends AbstractBbvaTxConfigurableMapper  implements TxProductMapper{

	
	@Override
	public FormatoOZECNTE0 mapInOznt(DTOIntProduct dtoIn) {
		FormatoOZECNTE0 formatoEntrada = new FormatoOZECNTE0();
        formatoEntrada.setNumprod(dtoIn.getId());
        return formatoEntrada;
	}

	@Override
	public DTOIntConditions mapOutOznt(FormatoOZECNTS0 formatOutput) {
		DTOIntConditions dtoIntConditions = new DTOIntConditions();

        // Todos los campos comentados son campos para uso futuro
        dtoIntConditions.setAlias(formatOutput.getTialias());
        dtoIntConditions.setCategory(formatOutput.getTipprod());
        dtoIntConditions.setDescription(formatOutput.getDesprod());
        dtoIntConditions.setOpeningDate(formatOutput.getFechape());
        dtoIntConditions.setCommission(formatOutput.getComprod());
        //dtoIntConditions.setMobilizationConditions(formatOutput.getConprod());

        DTOIntOffice dtoIntOffice = new DTOIntOffice();
        dtoIntOffice.setName(formatOutput.getNomofic());
        dtoIntOffice.setPostalAddress(formatOutput.getDirofic());

        DTOIntLocation dtoIntLocation = new DTOIntLocation();

        DTOIntCity dtoIntCity = new DTOIntCity();
        dtoIntCity.setName(formatOutput.getCiudofi());

        dtoIntLocation.setCity(dtoIntCity);

        DTOIntCountry dtoIntCountry = new DTOIntCountry();
        dtoIntCountry.setName(formatOutput.getPaisofi());

        dtoIntLocation.setCountry(dtoIntCountry);

        dtoIntOffice.setLocation(dtoIntLocation);

        dtoIntConditions.setOffice(dtoIntOffice);

        //DTOIntActivity dtoIntActivity = new DTOIntActivity();
        //dtoIntActivity.setOperationDate(formatOutput.getFecoper().toString());
        //dtoIntActivity.setExecutionDate(formatOutput.getFecejec().toString());

        //DTOIntFunction dtoIntFunction = new DTOIntFunction();
        //dtoIntFunction.setId(formatOutput.getTipfunc());

        //DTOIntEnumFunctionType dtoIntEnumFunctionType = new DTOIntEnumFunctionType();
        //dtoIntEnumFunctionType.setEnumValue(formatOutput.getCategor());

        //dtoIntFunction.setType(dtoIntEnumFunctionType);

        //dtoIntActivity.setFunction(dtoIntFunction);
        //dtoIntActivity.setAmount(formatOutput.getCantdad());
        //dtoIntActivity.setReference(formatOutput.getReffunc());

        //dtoIntConditions.setActivities(dtoIntActivity);

        return dtoIntConditions;
	}

}
