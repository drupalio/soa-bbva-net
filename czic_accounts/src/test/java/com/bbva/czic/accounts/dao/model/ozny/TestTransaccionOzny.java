package com.bbva.czic.accounts.dao.model.ozny;

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
 * Test de la transacci&oacute;n <code>OZNY</code>
 *
 * @author Arquitectura Spring BBVA
 */
public class TestTransaccionOzny extends SpringContextBbvaTest {

	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOzny.class);
	private TransaccionOzny transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init() {
		transaccion = new TransaccionOzny();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzny peticionTransaccionOzny = new PeticionTransaccionOzny();
		RespuestaTransaccionOzny respuestaTransaccionOzny= new RespuestaTransaccionOzny();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class,
				peticionTransaccionOzny)).thenReturn(respuestaTransaccionOzny);

		RespuestaTransaccionOzny result = transaccion.invocar(peticionTransaccionOzny);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class,
				peticionTransaccionOzny);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzny peticionTransaccionOzny = new PeticionTransaccionOzny();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class,
				peticionTransaccionOzny)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOzny);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzny peticionTransaccionOzny = new PeticionTransaccionOzny();
		RespuestaTransaccionOzny respuestaTransaccionOzny = new RespuestaTransaccionOzny();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class,
				peticionTransaccionOzny)).thenReturn(respuestaTransaccionOzny);

		RespuestaTransaccionOzny result = transaccion.invocarCache(peticionTransaccionOzny);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class,
				peticionTransaccionOzny);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzny peticionTransaccionOzny = new PeticionTransaccionOzny();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class,
				peticionTransaccionOzny)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOzny);
	}

}