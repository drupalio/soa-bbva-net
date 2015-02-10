package com.bbva.czic.products.dao.model.oznm;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestTransaccionOznm extends SpringContextBbvaTest {

	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznm.class);

	private TransaccionOznm transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init(){
		transaccion = new TransaccionOznm();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}


	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznm peticionTransaccionOznm = new PeticionTransaccionOznm();
		RespuestaTransaccionOznm respuestaTransaccionOznm = new RespuestaTransaccionOznm();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class,
				peticionTransaccionOznm)).thenReturn(respuestaTransaccionOznm);

		RespuestaTransaccionOznm result = transaccion.invocar(peticionTransaccionOznm);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class,
				peticionTransaccionOznm);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznm peticionTransaccionOznm = new PeticionTransaccionOznm();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class,
				peticionTransaccionOznm)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznm);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznm peticionTransaccionOznm = new PeticionTransaccionOznm();
		RespuestaTransaccionOznm respuestaTransaccionOznm = new RespuestaTransaccionOznm();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class,
				peticionTransaccionOznm)).thenReturn(respuestaTransaccionOznm);

		RespuestaTransaccionOznm result = transaccion.invocarCache(peticionTransaccionOznm);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class,
				peticionTransaccionOznm);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznm peticionTransaccionOznm = new PeticionTransaccionOznm();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class,
				peticionTransaccionOznm)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznm);

	}



}