package com.bbva.czic.products.dao.model.oznl;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestTransaccionOznl extends SpringContextBbvaTest{

	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznl.class);

	private TransaccionOznl transaccion;
	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init(){
		transaccion = new TransaccionOznl();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}


	@Test
	public void checkInvocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznl peticionTransaccionOznl = new PeticionTransaccionOznl();
		RespuestaTransaccionOznl respuestaTransaccionOznl = new RespuestaTransaccionOznl();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class,
				peticionTransaccionOznl)).thenReturn(respuestaTransaccionOznl);

		RespuestaTransaccionOznl result = transaccion.invocar(peticionTransaccionOznl);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class,
				peticionTransaccionOznl);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznl peticionTransaccionOznl = new PeticionTransaccionOznl();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class,
				peticionTransaccionOznl)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznl);

	}

	@Test
	public void checkInvocarCacheOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznl peticionTransaccionOznl = new PeticionTransaccionOznl();
		RespuestaTransaccionOznl respuestaTransaccionOznl = new RespuestaTransaccionOznl();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class,
				peticionTransaccionOznl)).thenReturn(respuestaTransaccionOznl);

		RespuestaTransaccionOznl result = transaccion.invocarCache(peticionTransaccionOznl);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class,
				peticionTransaccionOznl);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznl peticionTransaccionOznl = new PeticionTransaccionOznl();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class,
				peticionTransaccionOznl)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznl);

	}




}