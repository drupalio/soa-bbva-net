package com.bbva.czic.products.dao.mapper.impl;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.dao.mapper.TxProductMapper;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;

@Mapper(value = "tx-product-mapper")
public class TxProductMapperImpl extends AbstractBbvaTxConfigurableMapper  implements TxProductMapper{

        /**
         *
         */
        @Override
        protected void configure(MapperFactory factory) {

                /**
                 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
                 */
                factory.getConverterFactory().registerConverter(new StringMoneyConverter());

                /**
                 * MAPEO DE ENTRADAS
                 */
                // Map DTOIntFilter <-> FormatoOZNCENA0 (OZNL)
            //    factory.classMap(DTOIntFilterMovements.class, FormatoOZNCENM0.class).field("id", "nocuent").field("movementId", "nummov")
              //          .byDefault()
                //        .register();

                /**
                 * MAPEO DE SALIDAS
                 */
                // Map FormatoOZECNVS0 <-> DTOIntMonthlyBalances (OZNA)
         //       factory.classMap(DTOIntExecutive.class, FormatoOZECNRS0.class).field("executiveId", "idejecu").field("name", "nomejec")
           //             .field("phone", "telejec").field("office.name", "ofiejec")
             //           .field("email", "emailej").byDefault().register();


        }



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
