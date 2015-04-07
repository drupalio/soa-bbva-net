package com.bbva.zic.globalposition.dao.model.ozn1;

import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestTransaccionOzn1 extends SpringContextBbvaTest {

	private ServicioTransacciones servicioTransacciones;

	private TransaccionOzn1 transaccion;

	@Before
	public void init(){
		transaccion = new TransaccionOzn1();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzn1 peticionTransaccionOzn1 = new PeticionTransaccionOzn1();
		RespuestaTransaccionOzn1 respuestaTransaccionOzn1 = new RespuestaTransaccionOzn1();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class,
				peticionTransaccionOzn1)).thenReturn(respuestaTransaccionOzn1);

		RespuestaTransaccionOzn1 result = transaccion.invocar(peticionTransaccionOzn1);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class,
				peticionTransaccionOzn1);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOzn1 peticionTransaccionOzn1 = new PeticionTransaccionOzn1();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class,
				peticionTransaccionOzn1)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOzn1);
	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOzn1 peticionTransaccionOzn1 = new PeticionTransaccionOzn1();
		RespuestaTransaccionOzn1 respuestaTransaccionOzn1 = new RespuestaTransaccionOzn1();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class,
				peticionTransaccionOzn1)).thenReturn(respuestaTransaccionOzn1);

		RespuestaTransaccionOzn1 result = transaccion.invocarCache(peticionTransaccionOzn1);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class,
				peticionTransaccionOzn1);

		Assert.assertNotNull(result);
	}

}