package com.bbva.czic.executives.dao.model.oznr;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test de la transacci&oacute;n <code>OZNR</code>
 *
 * @author Arquitectura Spring BBVA
 */
public class TestTransaccionOznr extends SpringContextBbvaTest {

	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznr.class);

	private TransaccionOznr transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init(){
		transaccion = new TransaccionOznr();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}


	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznr peticionTransaccionOznr = new PeticionTransaccionOznr();
		RespuestaTransaccionOznr respuestaTransaccionOznr = new RespuestaTransaccionOznr();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class,
				peticionTransaccionOznr)).thenReturn(respuestaTransaccionOznr);

		RespuestaTransaccionOznr result = transaccion.invocar(peticionTransaccionOznr);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class,
				peticionTransaccionOznr);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznr peticionTransaccionOznr = new PeticionTransaccionOznr();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class,
				peticionTransaccionOznr)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznr);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznr peticionTransaccionOznr = new PeticionTransaccionOznr();
		RespuestaTransaccionOznr respuestaTransaccionOznr = new RespuestaTransaccionOznr();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class,
				peticionTransaccionOznr)).thenReturn(respuestaTransaccionOznr);

		RespuestaTransaccionOznr result = transaccion.invocarCache(peticionTransaccionOznr);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class,
				peticionTransaccionOznr);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznr peticionTransaccionOznr = new PeticionTransaccionOznr();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class,
				peticionTransaccionOznr)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznr);

	}





}