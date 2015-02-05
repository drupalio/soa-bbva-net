package com.bbva.czic.loan.dao.model.ozni;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public class TransaccionOzniTest extends SpringContextBbvaTest {

	private static final Log LOG = I18nLogFactory.getLog(TransaccionOzniTest.class);

	private TransaccionOzni transaccion;

	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init() {
		transaccion = new TransaccionOzni();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	 public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzni peticionTransaccionOzni = new PeticionTransaccionOzni();
		RespuestaTransaccionOzni respuestaTransaccionOzni = new RespuestaTransaccionOzni();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class,
				peticionTransaccionOzni)).thenReturn(respuestaTransaccionOzni);

		RespuestaTransaccionOzni result = transaccion.invocar(peticionTransaccionOzni);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class,
				peticionTransaccionOzni);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzni peticionTransaccionOzni = new PeticionTransaccionOzni();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class,
				peticionTransaccionOzni)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOzni);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzni peticionTransaccionOzni = new PeticionTransaccionOzni();
		RespuestaTransaccionOzni respuestaTransaccionOzni = new RespuestaTransaccionOzni();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class,
				peticionTransaccionOzni)).thenReturn(respuestaTransaccionOzni);

		RespuestaTransaccionOzni result = transaccion.invocarCache(peticionTransaccionOzni);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class,
				peticionTransaccionOzni);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzni peticionTransaccionOzni = new PeticionTransaccionOzni();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class,
				peticionTransaccionOzni)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOzni);

	}
}