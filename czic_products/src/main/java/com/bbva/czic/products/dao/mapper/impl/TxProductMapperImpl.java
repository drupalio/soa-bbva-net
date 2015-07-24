package com.bbva.czic.products.dao.mapper.impl;


import java.util.ArrayList;
import java.util.StringTokenizer;

import com.bbva.czic.dto.net.Holder;
import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2E0;
import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS1;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.CustomMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;


@Mapper(value = "txProductMapper")
public class TxProductMapperImpl extends AbstractBbvaTxConfigurableMapper implements TxProductsMapper{

	private static I18nLog log = I18nLogFactory
			.getLogI18n(TxProductMapperImpl.class, "META-INF/spring/i18n/log/mensajesLog");
	
	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		log.info(" Gettin'into TxProductMapperImpl:configure ");
		
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
		
		//Para efectos de orden se construyó un custom mapper para la entrada del servicio
		// Map  DTOIntFilterExtract <-> FormatoOZECN2S0(OZN2)
		factory.classMap(FormatoOZECN2E0.class, DTOIntFilterExtract.class)
						.customize(new ExtractListMapperIn()).byDefault().register();
		
		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNTS0 <-> DTOIntConditions (OZNT)****************
		factory.classMap(DTOIntConditions.class, FormatoOZECNTS0.class)
				.field("type", "tipprod")
				.field("alias", "tialias")
				.field("category", "categor")
				.field("description", "desprod")
				.field("openingDate", "fechape")
				.field("commission", "comprod")
				.field("mobilizationConditions", "conprod")
				.field("office.name", "nomofic")
				.field("office.postalAddress", "dirofic")
				.field("office.location.city.name", "ciudofi")
				.field("office.location.country.name", "paisofi")
				.field("activity.operationDate","fecoper")
				.field("activity.executionDate","fecejec")
				.field("activity.function.id","tipfunc")
				.field("activity.function.type","desfunc")
				.field("activity.amount","cantdad")
				.field("activity.reference","reffunc")
				.byDefault()
				.register();

		// Map FormatoOZECNTS1 <-> DTOIntConditions (OZNT)****************
		factory.classMap(FormatoOZECNTS1.class, DTOIntHolder.class)
				.field("titular", "alias").byDefault().register();
		
		// Map FormatoOZNCSNM0 <-> DTOIntMovement (OZNM)
		factory.classMap(FormatoOZNCSNM0.class, DTOIntMovement.class)
				//TODO Mapear saldo con valor origen
				.field("numecta", "id")
				.field("resto", "concept")
				.field("valor", "value")
				.field("baloper", "balance")
				.field("tipo", "operation.code")
				.field("descodi", "operation.description")
				.field("fchoper", "transactionDate")
				.field("fchvalr", "operationDate")
				.field("ctroorg", "office.postalAddress")
				.field("ctroorg", "office.name")
				.field("saldo", "office.name") //-------------------
				.field("plaza", "office.location.city.name")
				.field("plaza", "office.location.dtoIntState.name")
				.field("saldo", "originValue")
				.byDefault()
				.register();
		
		// Map FormatoOZECNTS0 <-> DTOIntConditions (OZNL)
		factory.classMap(FormatoOZECNLS0.class, DTOIntMovement.class)
				.field("numoper", "id")
				.field("numoper", "operation.code")
				.field("fechope", "transactionDate")
				.field("descopr", "operation.description")
				.field("valorop", "value")
				.field("balance", "balance")
				.field("concept", "concept")
				.field("tipoopr", "productType")
				.byDefault()
				.register();
		
		//Para efectos de orden se construyó un custom mapper para la salida del servicio
		// Map FormatoOZECN2S0 <-> DTOIntExtractOutput (OZN2)
		factory.classMap(DTOIntExtractOutput.class,FormatoOZECN2S0.class)
				.customize(new ExtractListMapperOut()).register();
		
		log.info(" Exittin'into TxProductMapperImpl:configure ");
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
	public DTOIntHolder mapOutOznt1(FormatoOZECNTS1 formatOutput) {
		return  map(formatOutput, DTOIntHolder.class);
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
		log.info("Gettin' into mapInOzn2: "+dtoIn.toString());
		return map(dtoIn,FormatoOZECN2E0.class);
	}

	@Override
	public DTOIntExtractOutput mapOutOzn2(FormatoOZECN2S0 formatOutput) {
		log.info("Gettin' into mapOutOzn2: "+formatOutput.getSaltr01()+formatOutput.getSaltr02()+formatOutput.getSaltr03()+formatOutput.getSaltr04());
		return map(formatOutput,DTOIntExtractOutput.class);
	}
	
	/**Inner Class de tipo customMapper para el mapeo de la entrada a la transacción OZN2 por trama plana
	 * 
	 * @author Entelgy
	 *
	 */
	public class ExtractListMapperIn extends CustomMapper<FormatoOZECN2E0,DTOIntFilterExtract>{
		
		/**Método abstracto de mapeo del DTO interno al Formato de entrada de la transacción,
		 * aquí se realiza el llamado a todos los diferentes métodos que seleccionan los modos del servicio.
		 * 
		 */
		@Override
		public void mapBtoA(final DTOIntFilterExtract dtoIntFilterExtract,final FormatoOZECN2E0 formatoEntrada,MappingContext context) {
			log.info("Gettin' into ExtractListMapperIn.mapBtoA: DTO="+dtoIntFilterExtract.toString());
			if(dtoIntFilterExtract.getExtractId()==null){
				mapInOzn2ListExtracts(dtoIntFilterExtract,formatoEntrada);
			}else{
				mapInOzn2getExtracts(dtoIntFilterExtract,formatoEntrada);
			}
			log.info("Gettin' out ExtractListMapperIn.mapBtoA: trama="+formatoEntrada.getSubtrm0()+formatoEntrada.getSubtrm1()+formatoEntrada.getSubtrm2()+formatoEntrada.getSubtrm3());
		}
		
		/**Mapeo de entrada para el modo del servicio de obtención de extracto, para ello el toma la información del filtro
		 * y mediante Tokens y concatenaciones introduce la información en la trama plana en la variable parser
		 * para luego ser procesada
		 * 
		 * @param dtoIntExtract dtoInterno con la información para obtener el extracto
		 * @param formatoEntrada Formato de entrada de la transacción OZN2
		 * @return
		 */
		private FormatoOZECN2E0 mapInOzn2getExtracts(DTOIntFilterExtract dtoIntExtract,FormatoOZECN2E0 formatoEntrada) {
			log.info("Gettin' into ExtractListMapperIn.mapInOzn2getExtracts: DTO="+dtoIntExtract.toString());
			String parser = headGenerate
					+ REQUEST_EXTRACT.replace("$",""
						+ IDPRODUCT.replace("$", dtoIntExtract.getProductId())
						+ YEAR.replace("$", dtoIntExtract.getYear())
						+ MONTH.replace("$", dtoIntExtract.getMonth())
						+ EXTERNAL_CODE.replace("$",dtoIntExtract.getExtractId())) 
					+ tailGenerate;
			formatoEntrada.setLongtra(parser.length());
			log.info("Gettin' out ExtractListMapperIn.mapInOzn2getExtracts: trama="+parser);
			return processPlot(formatoEntrada, parser);
		}

		/**Mapeo de entrada para el modo del servicio de listado de extractos, para ello toma el número de producto y lo concatena
		 * con la trama XML plana y lo coloca en la variable parser para luego ser procesada.
		 * 
		 *@param dtoIntExtract dtoInterno con la información para obtener el listado de extractos
		 * @param formatoEntrada Formato de entrada de la transacción OZN2
		 * @return
		 */
		private FormatoOZECN2E0 mapInOzn2ListExtracts(DTOIntFilterExtract dtoIntExtract,FormatoOZECN2E0 formatoEntrada) {
			log.info("Gettin' into ExtractListMapperIn.mapInOzn2ListExtracts: DTO="+dtoIntExtract.toString());
			String parser = headGet + dtoIntExtract.getProductId() + tailGet;
			formatoEntrada.setLongtra(parser.length());
			log.info("Gettin' out ExtractListMapperIn.mapInOzn2ListExtracts: trama="+parser);
			return processPlot(formatoEntrada,parser);
		}
		
		/**Procesa la trama, cortandola en cadenas de 100 para poder mapearlas en las variables del formato de entrada
		 * 
		 * @param formatoEntrada Formato de entrada de la transacción OZN2
		 * @param parser Trama XML concatenada
		 * @return
		 */
		private FormatoOZECN2E0 processPlot(FormatoOZECN2E0 formatoEntrada,String parser) {
			log.info("Gettin' into ExtractListMapperIn.processPlot: DTO="+parser.toString());
			int longitud=parser.length();
			int plotLength=PLOT_LENGTH;
			formatoEntrada.setSubtrm0("");
			formatoEntrada.setSubtrm1("");
			formatoEntrada.setSubtrm2("");
			formatoEntrada.setSubtrm3("");
			formatoEntrada.setSubtrm4("");
			formatoEntrada.setSubtrm5("");
			formatoEntrada.setSubtrm6("");
			formatoEntrada.setSubtrm7("");
			formatoEntrada.setSubtrm8("");
			formatoEntrada.setSubtrm9("");
			for (int i = 0; i < longitud; i++) {
				if(plotLength>parser.length()){
					plotLength=parser.length();
				}
				switch (i) {
				case 0:
					formatoEntrada.setSubtrm1(parser.substring(0, plotLength));
					break;
				case 101:
					formatoEntrada.setSubtrm2(parser.substring(0, plotLength));
					break;
				case 202:
					formatoEntrada.setSubtrm3(parser.substring(0, plotLength));
					break;
				case 303:
					formatoEntrada.setSubtrm4(parser.substring(0, plotLength));
					break;
				case 404:
					formatoEntrada.setSubtrm5(parser.substring(0, plotLength));
					break;
				case 505:
					formatoEntrada.setSubtrm6(parser.substring(0, plotLength));
					break;
				case 606:
					formatoEntrada.setSubtrm7(parser.substring(0, plotLength));
					break;
				case 707:
					formatoEntrada.setSubtrm8(parser.substring(0, plotLength));
					break;
				case 808:
					formatoEntrada.setSubtrm9(parser.substring(0, plotLength));
					break;
				case 909:
					formatoEntrada.setSubtrm0(parser.substring(0, plotLength));
					break;
				}
				parser = parser.substring(plotLength);
				i += plotLength;
			}
			log.info("Gettin' out ExtractListMapperIn.processPlot: trama="+formatoEntrada.getSubtrm0()+formatoEntrada.getSubtrm1()+formatoEntrada.getSubtrm2()+formatoEntrada.getSubtrm3());
			return formatoEntrada;
		}
	}
	
	/**Inner Class de tipo customMapper para el mapeo de la salida a la transacción OZN2 por trama plana
	 * 
	 * @author Entelgy
	 *
	 */
	public class ExtractListMapperOut extends CustomMapper<DTOIntExtractOutput,FormatoOZECN2S0> {
		
		/**Clase genérica del mapeo. Allí primero se concatena las cadenas de las salidas del servicio, si vienen nula, se coloca un espacio.
		 * Posteriormente se selecciona el método de mapeo basado en la evaluación de la trama.
		 * 
		 */
		@Override
		public void mapBtoA(final FormatoOZECN2S0 formatoSalida,final DTOIntExtractOutput dtoIntExtractOutput,MappingContext context) {
			log.info("Gettin' into ExtractListMapperOut.mapBtoA: Trama="+formatoSalida.toString());
			String plot = dnull(formatoSalida.getSaltr01()) + dnull(formatoSalida.getSaltr02()) + dnull(formatoSalida.getSaltr03())
					+ dnull(formatoSalida.getSaltr04()) + dnull(formatoSalida.getSaltr05()) + dnull(formatoSalida.getSaltr06())
					+ dnull(formatoSalida.getSaltr07()) + dnull(formatoSalida.getSaltr08()) + dnull(formatoSalida.getSaltr09())
					+ dnull(formatoSalida.getSaltr10()) + dnull(formatoSalida.getSaltr11()) + dnull(formatoSalida.getSaltr12())
					+ dnull(formatoSalida.getSaltr13()) + dnull(formatoSalida.getSaltr14()) + dnull(formatoSalida.getSaltr15())
					+ dnull(formatoSalida.getSaltr16()) + dnull(formatoSalida.getSaltr17()) + dnull(formatoSalida.getSaltr18());
			if (evaluatePlot(formatoSalida)) {
				mapGetExtracts(dtoIntExtractOutput, plot);
			} else {
				mapListExtracts(dtoIntExtractOutput, plot);
			}
			log.info("Gettin' out ExtractListMapperOut.mapBtoA: DTO="+dtoIntExtractOutput.toString());
		}

		/**Verifica que la cadena no venga nula, si lo es, retorna una cadena vacía.
		 * 
		 * @param string cadena de entrada
		 * @return
		 */
		private String dnull(String string) {
			if(string==null){
				return "";
			}
			return string;
		}

		/**Mapeo de salida para el modo de listado de extractos. La captura de datos se hace mediante StringTokenizers
		 * ya que la trama viene partida con '|' y ';' entonces con esto se captura toda la información
		 * 
		 * @param dtoIntExtractOut Dto de salida
		 * @param plot trama plana de salida
		 */
		private void mapListExtracts(DTOIntExtractOutput dtoIntExtractOut, String plot) {
			log.info("Gettin' into ExtractListMapperOut.mapListExtracts: Trama="+plot);
			dtoIntExtractOut.setExtracts(new ArrayList<DTOIntExtract>());
			plot=plot.replaceAll("!","|");
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
					dtoIntExtractOut.getExtracts().add(aux);
				}
			}
			log.info("Gettin' out ExtractListMapperOut.mapListExtracts: DTO="+dtoIntExtractOut.toString());
			
		}

		/**Mapeo de salida para el modo de obtención de extractos. La captura de datos se hace mediante StringTokenizers
		 * ya que la trama viene partida con '|' y ';' entonces con esto se captura toda la información
		 * 
		 * @param dtoIntExtractOut Dto de salida
		 * @param plot trama plana de salida
		 */
		private void mapGetExtracts(DTOIntExtractOutput dtoIntExtractOut, String plot) {
			log.info("Gettin' into ExtractListMapperOut.mapGetExtracts: Trama="+plot);
			dtoIntExtractOut.setExtracts(new ArrayList<DTOIntExtract>());
			StringTokenizer listExtracts = new StringTokenizer(plot, "|");
			listExtracts.nextToken();
			while (listExtracts.hasMoreElements()) {
				String extractInfo = listExtracts.nextToken();
				StringTokenizer extract = new StringTokenizer(extractInfo, ";");
				while (extract.hasMoreElements()) {
					DTOIntExtract aux = new DTOIntExtract();
					aux.setExtCode(extract.nextToken());
					aux.setUrl(extract.nextToken());
					dtoIntExtractOut.getExtracts().add(aux);
				}
			}
			log.info("Gettin' out ExtractListMapperOut.mapGetExtracts: DTO="+dtoIntExtractOut.toString());
		};
	}

	/**Evalua si la trama contiene una URL mediante la busqueda de la palabra 'http'
	 * Esta palabra puede ser cambiada en la interfaz de esta clase
	 * 
	 * @param formatOutput Formato de salida
	 * @return booleano que es verdadero si encuentra la palabra
	 */
	private static boolean evaluatePlot(FormatoOZECN2S0 formatOutput) {
		return (formatOutput.getSaltr01()!=null && formatOutput.getSaltr01().contains(WORD)) || 
				(formatOutput.getSaltr02()!=null && formatOutput.getSaltr02().contains(WORD)) || 
				(formatOutput.getSaltr03()!=null && formatOutput.getSaltr03().contains(WORD)) ||
				(formatOutput.getSaltr04()!=null && formatOutput.getSaltr04().contains(WORD)) ||
				(formatOutput.getSaltr05()!=null && formatOutput.getSaltr05().contains(WORD)) ||
				(formatOutput.getSaltr06()!=null && formatOutput.getSaltr06().contains(WORD)) ||
				(formatOutput.getSaltr07()!=null && formatOutput.getSaltr07().contains(WORD)) ||
				(formatOutput.getSaltr08()!=null && formatOutput.getSaltr08().contains(WORD)) ||
				(formatOutput.getSaltr09()!=null && formatOutput.getSaltr09().contains(WORD)) ||
				(formatOutput.getSaltr10()!=null && formatOutput.getSaltr10().contains(WORD)) ||
				(formatOutput.getSaltr11()!=null && formatOutput.getSaltr11().contains(WORD)) ||
				(formatOutput.getSaltr12()!=null && formatOutput.getSaltr12().contains(WORD)) ||
				(formatOutput.getSaltr13()!=null && formatOutput.getSaltr13().contains(WORD)) ||
				(formatOutput.getSaltr14()!=null && formatOutput.getSaltr14().contains(WORD)) ||
				(formatOutput.getSaltr15()!=null && formatOutput.getSaltr15().contains(WORD)) ||
				(formatOutput.getSaltr16()!=null && formatOutput.getSaltr16().contains(WORD)) ||
				(formatOutput.getSaltr17()!=null && formatOutput.getSaltr17().contains(WORD)) ||
				(formatOutput.getSaltr18()!=null && formatOutput.getSaltr18().contains(WORD));
	}
	
}
