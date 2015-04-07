package com.bbva.zic.globalposition.dao.model.oznh;

import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;

public class TestTransaccionOznh extends SpringContextBbvaTest {

	private ServicioTransacciones servicioTransacciones;

	private TransaccionOznh transaccion;

	@Before
	public void init(){
		transaccion = new TransaccionOznh();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznh peticionTransaccionOznh = new PeticionTransaccionOznh();
		RespuestaTransaccionOznh respuestaTransaccionOznh = new RespuestaTransaccionOznh();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class,
				peticionTransaccionOznh)).thenReturn(respuestaTransaccionOznh);

		RespuestaTransaccionOznh result = transaccion.invocar(peticionTransaccionOznh);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class,
				peticionTransaccionOznh);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznh peticionTransaccionOznh = new PeticionTransaccionOznh();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class,
				peticionTransaccionOznh)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznh);
	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznh peticionTransaccionOznh = new PeticionTransaccionOznh();
		RespuestaTransaccionOznh respuestaTransaccionOznh = new RespuestaTransaccionOznh();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class,
				peticionTransaccionOznh)).thenReturn(respuestaTransaccionOznh);

		RespuestaTransaccionOznh result = transaccion.invocarCache(peticionTransaccionOznh);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class,
				peticionTransaccionOznh);

		Assert.assertNotNull(result);
	}


}