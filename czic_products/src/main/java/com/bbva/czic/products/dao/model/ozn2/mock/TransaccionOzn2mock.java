package com.bbva.czic.products.dao.model.ozn2.mock;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.dao.model.ozn2.FormatoOZECN2S0;
import com.bbva.czic.products.dao.model.ozn2.PeticionTransaccionOzn2;
import com.bbva.czic.products.dao.model.ozn2.RespuestaTransaccionOzn2;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZN2</code>
 * 
 * @see PeticionTransaccionOzn2
 * @see RespuestaTransaccionOzn2
 */
@Profile(value = "dev")
@Component(value = "transaccionOzn2")
public class TransaccionOzn2mock implements
		InvocadorTransaccion<PeticionTransaccionOzn2, RespuestaTransaccionOzn2> {

	String tramaLista = "0020001|922131073;0131111200339817;001306045000164491;0;2014;12;0;0|640984985;0131110420338271;001306045000164491;0;2014;11;0;0|325147069;0131109760342474;001306045000164491;0;2014;10;0;0|685008016;0131108940337745;001306045000164491;0;2014;9;0;0|985345885;0131108090333446;001306045000164491;0;2014;8;0;0|952444966;0131107340332572;001306045000164491;0;2014;7;0;0|118281352;0131106500327370;001306045000164491;0;2014;6;0;0|932328118;0131105900325271;001306045000164491;0;2014;5;0;0|636313962;0131105200341503;001306045000164491;0;2014;4;0;0|262599820;0131104490324354;001306045000164491;0;2014;3;0;0|185735589;0131103920318971;001306045000164491;0;2014;2;0;0|493545156;0131103300319700;001306045000164491;0;2014;1;0;0|442726575;0131102960317620;001306045000164491;0;2013;12;0;0|358347060;0131102710312573;001306045000164491;0;2013;11;0;0|359768189;0131102290310175;001306045000164491;0;2013;10;0;0|225985885;0131101960307523;001306045000164491;0;2013;9;0;0|328291911;0131101660305873;001306045000164491;0;2013;8;0;0|44048092;0131101130304933;001306045000164491;0;2013;7;0;0|418220899;0131100530302625;001306045000164491;0;2013;6;0;0|417712276;0131100260303630;001306045000164491;0;2013;5;0;0|498968076;150000017800867;001306045000164491;0;2013;4;0;0|489876721;150000015869597;001306045000164491;0;2013;3;0;0|870846336;150000012772213;001306045000164491;0;2013;2;0;0|287838379;150000013543187;001306045000164491;0;2013;1;0;0|225287426;150000007010487;001306045000164491;0;2012;12;0;0|64013439;150000006396565;001306045000164491;0;2012;11;0;0|194454580;150000015265940;001306045000164491;0;2012;10;0;0|589910086;150000010670660;001306045000164491;0;2012;9;0;0|286589305;150000015186984;001306045000164491;0;2012;8;0;0|150058636;150000010203232;001306045000164491;0;2012;7;0;0";
	String tramaExtractos = "01?0010001?0020001|922131073;https://ws1.e-bbva.com.co/extractox/DoxWeb/servlet/FileDownloaderServlet?soli=File20150201065825_KREDOK&fecha=1234&modo=desc;";
	String tramaError = "<indraExtXStreamParser><operation>4</operation><getExtractosDisponiblesXNoContratoXStreamParser><extRefpro>";

	int PLOT_SECTION = 100;

	@Override
	public RespuestaTransaccionOzn2 invocar(PeticionTransaccionOzn2 transaccion)
			throws ExcepcionTransaccion {
		RespuestaTransaccionOzn2 respuesta = new RespuestaTransaccionOzn2();
		FormatoOZECN2S0 formatoSalida = processPlot(tramaLista);
		final DataFactory dataFactory = new DataFactory();
		CopySalida salida = new CopySalida();
		salida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(salida);
		return respuesta;
	}

	private FormatoOZECN2S0 processPlot(String parser) {
		FormatoOZECN2S0 formato = new FormatoOZECN2S0();
		int iterator = parser.length();
		int i=0;
		while(parser.length()>0) {
			if(PLOT_SECTION>parser.length()){
				PLOT_SECTION=parser.length();
			}
			switch (i) {
			case 0:
				formato.setSaltr01(parser.substring(0, PLOT_SECTION));
				break;
			case 1:
				formato.setSaltr02(parser.substring(0, PLOT_SECTION));
				break;
			case 2:
				formato.setSaltr03(parser.substring(0, PLOT_SECTION));
				break;
			case 3:
				formato.setSaltr04(parser.substring(0, PLOT_SECTION));
				break;
			case 4:
				formato.setSaltr05(parser.substring(0, PLOT_SECTION));
				break;
			case 5:
				formato.setSaltr06(parser.substring(0, PLOT_SECTION));
				break;
			case 6:
				formato.setSaltr07(parser.substring(0, PLOT_SECTION));
				break;
			case 7:
				formato.setSaltr08(parser.substring(0, PLOT_SECTION));
				break;
			case 8:
				formato.setSaltr09(parser.substring(0, PLOT_SECTION));
				break;
			case 9:
				formato.setSaltr10(parser.substring(0, PLOT_SECTION));
				break;
			case 10:
				formato.setSaltr11(parser.substring(0, PLOT_SECTION));
				break;
			case 11:
				formato.setSaltr12(parser.substring(0, PLOT_SECTION));
				break;
			case 12:
				formato.setSaltr13(parser.substring(0, PLOT_SECTION));
				break;
			case 13:
				formato.setSaltr14(parser.substring(0, PLOT_SECTION));
				break;
			case 14:
				formato.setSaltr15(parser.substring(0, PLOT_SECTION));
				break;
			case 15:
				formato.setSaltr16(parser.substring(0, PLOT_SECTION));
				break;
			case 16:
				formato.setSaltr17(parser.substring(0, PLOT_SECTION));
				break;
			case 17:
				formato.setSaltr18(parser.substring(0, PLOT_SECTION));
				break;
			case 18:
				formato.setSaltr01(parser.substring(0, PLOT_SECTION));
				break;
			}
			parser = parser.substring(PLOT_SECTION);
			i ++;
		}
		PLOT_SECTION=100;
		return formato;
	}

	@Override
	public RespuestaTransaccionOzn2 invocarCache(
			PeticionTransaccionOzn2 transaccion) throws ExcepcionTransaccion {
		return null;
	}

	@Override
	public void vaciarCache() {
	}

}