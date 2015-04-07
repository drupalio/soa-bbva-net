package com.bbva.zic.accounts.dao.model.oznx;

import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test de la transacci&oacute;n <code>OZNX</code>
 * 
 * @author Arquitectura Spring BBVA
 */
public class TestTransaccionOznx  extends SpringContextBbvaTest {
	
	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznx.class);
	private TransaccionOznx transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init() {
		transaccion = new TransaccionOznx();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznx peticionTransaccionOznx = new PeticionTransaccionOznx();
		RespuestaTransaccionOznx respuestaTransaccionOznx = new RespuestaTransaccionOznx();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class,
				peticionTransaccionOznx)).thenReturn(respuestaTransaccionOznx);

		RespuestaTransaccionOznx result = transaccion.invocar(peticionTransaccionOznx);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class,
				peticionTransaccionOznx);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznx peticionTransaccionOznx = new PeticionTransaccionOznx();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class,
				peticionTransaccionOznx)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznx);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznx peticionTransaccionOznx = new PeticionTransaccionOznx();
		RespuestaTransaccionOznx respuestaTransaccionOznx = new RespuestaTransaccionOznx();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class,
				peticionTransaccionOznx)).thenReturn(respuestaTransaccionOznx);

		RespuestaTransaccionOznx result = transaccion.invocarCache(peticionTransaccionOznx);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class,
				peticionTransaccionOznx);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznx peticionTransaccionOznx = new PeticionTransaccionOznx();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class,
				peticionTransaccionOznx)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznx);
	}

}