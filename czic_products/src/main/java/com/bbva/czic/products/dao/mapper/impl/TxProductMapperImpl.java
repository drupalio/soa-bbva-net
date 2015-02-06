package com.bbva.czic.products.dao.mapper.impl;


import java.util.ArrayList;
import java.util.StringTokenizer;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntExtractOutput;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.CustomMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.MappingContext;


@Mapper(value = "txProductMapper")
public class TxProductMapperImpl extends AbstractBbvaTxConfigurableMapper implements TxProductsMapper{

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		
		/**
		 * MAPEO DE ENTRADAS
		 */
		// Map DTOIntFilter <-> FormatoOZNCENT0 (OZNT)
		factory.classMap(DTOIntProduct.class, FormatoOZECNTE0.class).field("id", "numprod").byDefault()
				.register();
		
		// Map DTOIntFilter <-> FormatoOZNCENM0 (OZNM)
		factory.classMap(DTOIntFilterMovements.class, FormatoOZNCENM0.class)
				.field("productId", "nocuent").byDefault()
				.field("productType", "tiprod")
				.field("movementId", "nummov")
				.field("customerId", "numcli")
				.register();

		// Map DTOIntFilter <-> FormatoOZNCENM0 (OZNL)
		factory.classMap(DTOIntFilterMovements.class, FormatoOZECNLE0.class)
				.field("productId", "numprod")
				.field("paginationKey", "indpagi")
				.field("pageSize", "tampagi")
				.field("transactionDateStart", "fecini")
				.field("transactionDateEnd", "fecfin")
				.field("valueStart", "salinc")
				.field("valueEnd", "salfin").byDefault()
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
		// Map FormatoOZECNTS0 <-> DTOIntConditions (OZNM)
		factory.classMap(FormatoOZNCSNM0.class, DTOIntMovement.class)
				.field("numecta", "id")
				.field("fchoper", "transactionDate")
				.field("resto", "concept")
				.field("valor", "value")
				.field("baloper", "balance")
				.field("tipo", "productType")
				.field("descodi", "operation.description")
				.field("fchvalr", "operationDate")
				.byDefault()
				.register();
		// Map FormatoOZECNTS0 <-> DTOIntConditions (OZNL)
		factory.classMap(FormatoOZECNLS0.class, DTOIntMovement.class)
				.field("numoper", "operation.code")
				.field("fechope", "transactionDate")
				.field("descopr", "operation.description")
				.field("valorop", "value")
				.field("balance", "balance")
				.field("concept", "concept")
				.field("tipoopr", "productType")
				.byDefault()
				.register();
		// Map FormatoOZECN2S0 <-> DTOIntExtractOutput (OZN2)
		factory.classMap(DTOIntExtractOutput.class,FormatoOZECN2S0.class)
				.customize(new ExtractListMapper()).byDefault().register();
	}


	@Override
	public FormatoOZNCENM0 mapInOznm(DTOIntFilterMovements dtoIn) {
		return map(dtoIn, FormatoOZNCENM0.class);
	}

	@Override
	public DTOIntMovement mapOutOznm(FormatoOZNCSNM0 formatOutput) {
		return map(formatOutput, DTOIntMovement.class);
	}

	@Override
	public FormatoOZECNLE0 mapInOznl(DTOIntFilterMovements dtoIn) {
		return map(dtoIn, FormatoOZECNLE0.class);
	}

	@Override
	public DTOIntMovement mapOutOznl(FormatoOZECNLS0 formatOutput) {
		return map(formatOutput, DTOIntMovement.class);
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
	public FormatoOZECN2E0 mapInOzn2(DTOIntFilterExtract dtoIn) {
		if(dtoIn.getExtractId()==null){
			return mapInOzn2ListExtracts(dtoIn);
		}
		return mapInOzn2getExtracts(dtoIn);
	}

	@Override
	public DTOIntExtractOutput mapOutOzn2(FormatoOZECN2S0 formatOutput) {
		return map(formatOutput,DTOIntExtractOutput.class);
	}

	private FormatoOZECN2E0 mapInOzn2getExtracts(DTOIntFilterExtract dtoIn) {
		FormatoOZECN2E0 formato = new FormatoOZECN2E0();
		String parser = headGenerate
				+ REQUEST_EXTRACT.replace("$",""
					+ IDPRODUCT.replace("$", dtoIn.getProductId())
					+ YEAR.replace("$", dtoIn.getEndYear())
					+ MONTH.replace("$", dtoIn.getEndMonth())
					+ EXTERNAL_CODE.replace("$",dtoIn.getExtractId())) 
				+ tailGenerate;
		formato.setLongtra(parser.length());
		return processPlot(formato, parser);
	}

	private FormatoOZECN2E0 mapInOzn2ListExtracts(DTOIntFilterExtract dtoIn) {
		FormatoOZECN2E0 formato = new FormatoOZECN2E0();
		String parser = headGet + dtoIn.getProductId() + tailGet;
		formato.setLongtra(parser.length());
		return processPlot(formato,parser);
	}
	
	public static class ExtractListMapper extends CustomMapper<DTOIntExtractOutput,FormatoOZECN2S0> {
		@Override
		public void mapBtoA(FormatoOZECN2S0 b, DTOIntExtractOutput a,MappingContext context) {
			String plot = b.getSaltr01() + b.getSaltr02() + b.getSaltr03()
					+ b.getSaltr04() + b.getSaltr05() + b.getSaltr06()
					+ b.getSaltr07() + b.getSaltr08() + b.getSaltr09()
					+ b.getSaltr10() + b.getSaltr11() + b.getSaltr12()
					+ b.getSaltr13() + b.getSaltr14() + b.getSaltr15()
					+ b.getSaltr16() + b.getSaltr17() + b.getSaltr18();
			if (evaluatePlot(b)) {
				mapGetExtracts(a, plot);
			} else {
				mapListExtracts(a, plot);
			}
		}

		private void mapListExtracts(DTOIntExtractOutput a, String plot) {
			a.setExtracts(new ArrayList<DTOIntExtract>());
			StringTokenizer listExtracts = new StringTokenizer(plot, "|");
			listExtracts.nextToken();
			while (listExtracts.hasMoreElements()) {
				String extractInfo = listExtracts.nextToken();
				StringTokenizer extract = new StringTokenizer(extractInfo, ";");
				while(extract.hasMoreElements()){
					DTOIntExtract aux = new DTOIntExtract();
					aux.setExtCode(extract.nextToken());
					aux.setAuxCode(extract.nextToken());
					extract.nextToken();
					extract.nextToken();
					aux.setYear(extract.nextToken());
					aux.setMonth(extract.nextToken());
					extract.nextToken();
					extract.nextToken();
					a.getExtracts().add(aux);
				}
			}
		}

		private void mapGetExtracts(DTOIntExtractOutput a, String plot) {
			a.setExtracts(new ArrayList<DTOIntExtract>());
			StringTokenizer listExtracts = new StringTokenizer(plot, "|");
			StringTokenizer extract = new StringTokenizer(plot, ";");
			listExtracts.nextToken();
			while (listExtracts.hasMoreElements()) {
				DTOIntExtract aux = new DTOIntExtract();
				aux.setExtCode(extract.nextToken());
				aux.setUrl(extract.nextToken());
				listExtracts.nextToken();
				a.getExtracts().add(aux);
			}
		};
	}

	private FormatoOZECN2E0 processPlot(FormatoOZECN2E0 formato,String parser) {
		for (int i = 0; i < parser.length(); i++) {
			switch (i) {
			case 0:
				formato.setSubtrm0(parser.substring(0, PLOT_LENGTH));
				break;
			case 101:
				formato.setSubtrm1(parser.substring(0, PLOT_LENGTH));
				break;
			case 201:
				formato.setSubtrm2(parser.substring(0, PLOT_LENGTH));
				break;
			case 301:
				formato.setSubtrm3(parser.substring(0, PLOT_LENGTH));
				break;
			case 401:
				formato.setSubtrm4(parser.substring(0, PLOT_LENGTH));
				break;
			case 501:
				formato.setSubtrm5(parser.substring(0, PLOT_LENGTH));
				break;
			case 601:
				formato.setSubtrm6(parser.substring(0, PLOT_LENGTH));
				break;
			case 701:
				formato.setSubtrm7(parser.substring(0, PLOT_LENGTH));
				break;
			case 801:
				formato.setSubtrm8(parser.substring(0, PLOT_LENGTH));
				break;
			case 901:
				formato.setSubtrm9(parser.substring(0, PLOT_LENGTH));
				break;
			}
			parser = parser.substring(PLOT_LENGTH + 1);
			i += PLOT_LENGTH;
		}
		return formato;
	}

	private static boolean evaluatePlot(FormatoOZECN2S0 formatOutput) {
		return formatOutput.getSaltr01().contains(WORD)
				|| formatOutput.getSaltr02().contains(WORD)
				|| formatOutput.getSaltr03().contains(WORD)
				|| formatOutput.getSaltr04().contains(WORD)
				|| formatOutput.getSaltr05().contains(WORD)
				|| formatOutput.getSaltr06().contains(WORD)
				|| formatOutput.getSaltr07().contains(WORD)
				|| formatOutput.getSaltr08().contains(WORD)
				|| formatOutput.getSaltr09().contains(WORD)
				|| formatOutput.getSaltr10().contains(WORD)
				|| formatOutput.getSaltr11().contains(WORD)
				|| formatOutput.getSaltr12().contains(WORD)
				|| formatOutput.getSaltr13().contains(WORD)
				|| formatOutput.getSaltr14().contains(WORD)
				|| formatOutput.getSaltr15().contains(WORD)
				|| formatOutput.getSaltr16().contains(WORD)
				|| formatOutput.getSaltr17().contains(WORD)
				|| formatOutput.getSaltr18().contains(WORD);
	}
	
}
