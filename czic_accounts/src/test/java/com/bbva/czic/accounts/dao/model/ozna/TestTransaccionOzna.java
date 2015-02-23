package com.bbva.czic.accounts.dao.model.ozna;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test de la transacci&oacute;n <code>OZNA</code>
 * 
 * @author Arquitectura Spring BBVA
 */
public class TestTransaccionOzna extends SpringContextBbvaTest{
	
	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOzna.class);

	private TransaccionOzna transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init(){
		transaccion = new TransaccionOzna();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzna peticionTransaccionOzna = new PeticionTransaccionOzna();
		RespuestaTransaccionOzna respuestaTransaccionOzna = new RespuestaTransaccionOzna();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class,
				peticionTransaccionOzna)).thenReturn(respuestaTransaccionOzna);

		RespuestaTransaccionOzna result = transaccion.invocar(peticionTransaccionOzna);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class,
				peticionTransaccionOzna);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzna peticionTransaccionOzna = new PeticionTransaccionOzna();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class,
				peticionTransaccionOzna)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOzna);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzna peticionTransaccionOzna = new PeticionTransaccionOzna();
		RespuestaTransaccionOzna respuestaTransaccionOzna = new RespuestaTransaccionOzna();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class,
				peticionTransaccionOzna)).thenReturn(respuestaTransaccionOzna);

		RespuestaTransaccionOzna result = transaccion.invocarCache(peticionTransaccionOzna);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class,
				peticionTransaccionOzna);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzna peticionTransaccionOzna = new PeticionTransaccionOzna();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class,
				peticionTransaccionOzna)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOzna);

	}


}








