package com.bbva.zic.globalposition.dao.model.ozn0;

import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestTransaccionOzn0 extends SpringContextBbvaTest {

	private ServicioTransacciones servicioTransacciones;

	private TransaccionOzn0 transaccion;

	@Before
	public void init(){
		transaccion = new TransaccionOzn0();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzn0 peticionTransaccionOzn0 = new PeticionTransaccionOzn0();
		RespuestaTransaccionOzn0 respuestaTransaccionOzno = new RespuestaTransaccionOzn0();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class,
				peticionTransaccionOzn0)).thenReturn(respuestaTransaccionOzno);

		RespuestaTransaccionOzn0 result = transaccion.invocar(peticionTransaccionOzn0);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class,
				peticionTransaccionOzn0);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzn0 peticionTransaccionOzn0 = new PeticionTransaccionOzn0();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class,
				peticionTransaccionOzn0)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOzn0);
	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzn0 peticionTransaccionOzn0 = new PeticionTransaccionOzn0();
		RespuestaTransaccionOzn0 respuestaTransaccionOzno = new RespuestaTransaccionOzn0();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class,
				peticionTransaccionOzn0)).thenReturn(respuestaTransaccionOzno);

		RespuestaTransaccionOzn0 result = transaccion.invocarCache(peticionTransaccionOzn0);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class,
				peticionTransaccionOzn0);

		Assert.assertNotNull(result);
	}



}