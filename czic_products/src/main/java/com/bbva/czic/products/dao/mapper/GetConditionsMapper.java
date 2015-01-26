package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.dto.net.EnumFunctionType;
import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-conditions-mapper")
public class GetConditionsMapper
        implements ISimpleTransactionMapper<DTOIntProduct, FormatoOZECNTE0, DTOIntConditions, FormatoOZECNTS0> {

    @Override
    public FormatoOZECNTE0 mapToInner(DTOIntProduct dtoIn) {
        FormatoOZECNTE0 formatoEntrada = new FormatoOZECNTE0();
        formatoEntrada.setNumprod(dtoIn.getId());
        return formatoEntrada;
    }

    @Override
    public DTOIntConditions mapToOuter(FormatoOZECNTS0 outFormat, DTOIntProduct dtoIn) {
        DTOIntConditions dtoIntConditions = new DTOIntConditions();

        // Todos los campos comentados son campos para uso futuro
        //dtoIntConditions.setAlias(outFormat.getTialias());
        dtoIntConditions.setCategory("01"/*outFormat.getTipprod()*/);
        dtoIntConditions.setDescription("CUENTA CORRIENTE"/*outFormat.getDesprod()*/);
        dtoIntConditions.setOpeningDate(new Date()/*outFormat.getFechape()*/);
        dtoIntConditions.setCommission("9000"/*outFormat.getComprod()*/);
        //dtoIntConditions.setMobilizationConditions(outFormat.getConprod());

        DTOIntOffice dtoIntOffice = new DTOIntOffice();
        dtoIntOffice.setName("AVENIDA CHILE"/*outFormat.getNomofic()*/);
        dtoIntOffice.setPostalAddress("CARRERA 9 72 35"/*outFormat.getDirofic()*/);

        DTOIntLocation dtoIntLocation = new DTOIntLocation();

        DTOIntCity dtoIntCity = new DTOIntCity();
        dtoIntCity.setName("BOGOTA DC"/*outFormat.getCiudofi()*/);

        dtoIntLocation.setCity(dtoIntCity);

        DTOIntCountry dtoIntCountry = new DTOIntCountry();
        dtoIntCountry.setName("COLOMBIA"/*outFormat.getPaisofi()*/);

        dtoIntLocation.setCountry(dtoIntCountry);

        dtoIntOffice.setLocation(dtoIntLocation);

        dtoIntConditions.setOffice(dtoIntOffice);

        //DTOIntActivity dtoIntActivity = new DTOIntActivity();
        //dtoIntActivity.setOperationDate(outFormat.getFecoper().toString());
        //dtoIntActivity.setExecutionDate(outFormat.getFecejec().toString());

        //DTOIntFunction dtoIntFunction = new DTOIntFunction();
        //dtoIntFunction.setId(outFormat.getTipfunc());

        //DTOIntEnumFunctionType dtoIntEnumFunctionType = new DTOIntEnumFunctionType();
        //dtoIntEnumFunctionType.setEnumValue(outFormat.getCategor());

        //dtoIntFunction.setType(dtoIntEnumFunctionType);

        //dtoIntActivity.setFunction(dtoIntFunction);
        //dtoIntActivity.setAmount(outFormat.getCantdad());
        //dtoIntActivity.setReference(outFormat.getReffunc());

        //dtoIntConditions.setActivities(dtoIntActivity);

        return dtoIntConditions;
    }

}