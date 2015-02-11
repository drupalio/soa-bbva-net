package com.bbva.czic.loan.dao.model.oznk;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public class TestTransaccionOznk {

	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznk.class);

	private TransaccionOznk transaccion;


	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init(){
		transaccion = new TransaccionOznk();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}
	@Test
	public void invocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznk peticionTransaccionOznk = new PeticionTransaccionOznk();
		RespuestaTransaccionOznk respuestaTransaccionOznk = new RespuestaTransaccionOznk();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class,
				peticionTransaccionOznk)).thenReturn(respuestaTransaccionOznk);

		RespuestaTransaccionOznk result = transaccion.invocar(peticionTransaccionOznk);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class,
				peticionTransaccionOznk);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void invocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznk peticionTransaccionOznk = new PeticionTransaccionOznk();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class,
				peticionTransaccionOznk)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznk);
	}

	@Test
	public void invocarCacheOK() throws ExcepcionTransaccion{

		PeticionTransaccionOznk peticionTransaccionOznk = new PeticionTransaccionOznk();
		RespuestaTransaccionOznk respuestaTransaccionOznk = new RespuestaTransaccionOznk();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class,
				peticionTransaccionOznk)).thenReturn(respuestaTransaccionOznk);

		RespuestaTransaccionOznk result = transaccion.invocar(peticionTransaccionOznk);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class,
				peticionTransaccionOznk);

		Assert.assertNotNull(result);

		transaccion.invocarCache(peticionTransaccionOznk);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void invocarCacheThrowExcepcion()throws ExcepcionTransaccion{

		PeticionTransaccionOznk peticionTransaccionOznk = new PeticionTransaccionOznk();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class,
				peticionTransaccionOznk)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznk);
	}
}