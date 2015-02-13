package com.bbva.czic.accounts.dao.model.oznv;

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
 * Test de la transacci&oacute;n <code>OZNV</code>
 *
 * @author Arquitectura Spring BBVA
 */
public class TestTransaccionOznv extends SpringContextBbvaTest {

	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznv.class);

	private TransaccionOznv transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init() {
		transaccion = new TransaccionOznv();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznv peticionTransaccionOznv = new PeticionTransaccionOznv();
		RespuestaTransaccionOznv respuestaTransaccionOznv = new RespuestaTransaccionOznv();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class,
				peticionTransaccionOznv)).thenReturn(respuestaTransaccionOznv);

		RespuestaTransaccionOznv result = transaccion.invocar(peticionTransaccionOznv);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class,
				peticionTransaccionOznv);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznv peticionTransaccionOznv = new PeticionTransaccionOznv();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class,
				peticionTransaccionOznv)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznv);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznv peticionTransaccionOznv = new PeticionTransaccionOznv();
		RespuestaTransaccionOznv respuestaTransaccionOznv = new RespuestaTransaccionOznv();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class,
				peticionTransaccionOznv)).thenReturn(respuestaTransaccionOznv);

		RespuestaTransaccionOznv result = transaccion.invocarCache(peticionTransaccionOznv);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class,
				peticionTransaccionOznv);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznv peticionTransaccionOznv = new PeticionTransaccionOznv();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class,
				peticionTransaccionOznv)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznv);
	}

}