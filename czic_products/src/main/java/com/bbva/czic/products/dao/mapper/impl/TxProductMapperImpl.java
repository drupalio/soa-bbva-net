package com.bbva.czic.products.dao.mapper.impl;

import java.util.StringTokenizer;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;

@Mapper(value = "txProductMapper")
public class TxProductMapperImpl extends AbstractBbvaTxConfigurableMapper  implements TxProductsMapper{

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		
		/**
		 * MAPEO DE ENTRADAS
		 */
		// Map DTOIntFilter <-> FormatoOZNCENT0 (OZNT)
		factory.classMap(DTOIntProduct.class, FormatoOZECNTE0.class).field("id", "numprod").byDefault()
				.register();
		
		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNTS0 <-> DTOIntConditions (OZNT)
		factory.classMap(DTOIntConditions.class, FormatoOZECNTS0.class).field("alias", "tialias").field("category", "categor")
				.field("description", "desprod").field("openingDate", "fechape")
				.field("commission", "comprod").field("mobilizationConditions", "conprod")
				.field("office.name", "nomofic").field("office.postalAddress", "dirofic")
				.field("office.location.city.name", "ciudofi").field("office.location.country.name", "paisofi")
				.byDefault()
				.register();
	}
	
	@Override
	public FormatoOZECNTE0 mapInOznt(DTOIntProduct dtoIn) {
        return map(dtoIn,FormatoOZECNTE0.class);
	}

	@Override
	public DTOIntConditions mapOutOznt(FormatoOZECNTS0 formatOutput) {
		DTOIntConditions dtoIntConditions = map(formatOutput,DTOIntConditions.class);

//        Uso posterior para la funcionalidad de lista de actividades
        
        /*DTOIntActivity dtoIntActivity = new DTOIntActivity();
        dtoIntActivity.setOperationDate(formatOutput.getFecoper().toString());
        dtoIntActivity.setExecutionDate(formatOutput.getFecejec().toString());

        DTOIntFunction dtoIntFunction = new DTOIntFunction();
        dtoIntFunction.setId(formatOutput.getTipfunc());

        DTOIntEnumFunctionType dtoIntEnumFunctionType = new DTOIntEnumFunctionType();
        dtoIntEnumFunctionType.setEnumValue(formatOutput.getCategor());

        dtoIntFunction.setType(dtoIntEnumFunctionType);

        dtoIntActivity.setFunction(dtoIntFunction);
        dtoIntActivity.setAmount(formatOutput.getCantdad());
        dtoIntActivity.setReference(formatOutput.getReffunc());

        dtoIntConditions.setActivities(dtoIntActivity);*/
        return dtoIntConditions;
	}
	
	@Override
	public FormatoOZECN2E0 mapInOznt(DTOIntFilterExtract dtoIn) {
		FormatoOZECN2E0 formato = new FormatoOZECN2E0();
		//Se inicializa el string parseable con la cabecera
		String parser = headList;
		String cadena = null;
		StringTokenizer aux1=new StringTokenizer(cadena,"|");
		while(aux1.hasMoreElements())
		{
			String aux2=aux1.nextToken();
			StringTokenizer aux3=new StringTokenizer(aux2,"$");
			parser=parser+"<ExtractoSolicitadoVO>";
			while(aux3.hasMoreElements())
			{
				String r=aux3.nextToken();
				parser=parser+"<stringRefPro>"+dtoIn.getProductId()+"</stringRefPro>";
				parser=parser+"<stringAnio>"+dtoIn.getEndYear()+"</stringAnio>";
				 r=aux3.nextToken();
				parser=parser+"<stringMes>"+dtoIn.getEndMonth()+"</stringMes>";
				r=aux3.nextToken();
				if(r.length()>1)
				{
					parser=parser+"<stringCodigoExt>"+r+"</stringCodigoExt>";
					r=aux3.nextToken();
					r=aux3.nextToken();
				}
				else
				{
					parser=parser+"<stringCodigoExt></stringCodigoExt>";
					r=aux3.nextToken();
				}
					
			}
			parser=parser+"</ExtractoSolicitadoVO>";
			
	
		}
		parser=parser+tailList;
		return formato;
	}

	@Override
	public DTOIntExtract mapOutOznt(FormatoOZECN2S0 formatOutput) {
		// TODO Auto-generated method stub
		return null;
	}

}
