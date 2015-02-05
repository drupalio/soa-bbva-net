package com.bbva.czic.loan.dao.model.oznj;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

public class TransaccionOznjTest extends SpringContextBbvaTest {

	private static final Log LOG = I18nLogFactory.getLog(TransaccionOznjTest.class);

	private TransaccionOznj transaccion;

	private ServicioTransacciones servicioTransacciones;

	@Before
	public void init(){
		transaccion = new TransaccionOznj();
		servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
		transaccion.setServicioTransacciones(servicioTransacciones);
	}

	@Test
	public void invocarOK() throws ExcepcionTransaccion {

		PeticionTransaccionOznj peticionTransaccionOznj = new PeticionTransaccionOznj();
		RespuestaTransaccionOznj respuestaTransaccionOznj = new RespuestaTransaccionOznj();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class,
				peticionTransaccionOznj)).thenReturn(respuestaTransaccionOznj);

		RespuestaTransaccionOznj result = transaccion.invocar(peticionTransaccionOznj);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class,
				peticionTransaccionOznj);

		Assert.assertNotNull(result);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void invocarThrowsException() throws ExcepcionTransaccion {

		PeticionTransaccionOznj peticionTransaccionOznj = new PeticionTransaccionOznj();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class,
				peticionTransaccionOznj)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocar(peticionTransaccionOznj);
	}

	@Test
	public void invocarCacheOK() throws ExcepcionTransaccion{

		PeticionTransaccionOznj peticionTransaccionOznj = new PeticionTransaccionOznj();
		RespuestaTransaccionOznj respuestaTransaccionOznj = new RespuestaTransaccionOznj();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class,
				peticionTransaccionOznj)).thenReturn(respuestaTransaccionOznj);

		RespuestaTransaccionOznj result = transaccion.invocar(peticionTransaccionOznj);

		Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class,
				peticionTransaccionOznj);

		Assert.assertNotNull(result);

		transaccion.invocarCache(peticionTransaccionOznj);
	}

	@Test(expected = ExcepcionTransaccion.class)
	public void invocarCacheThrowExcepcion()throws ExcepcionTransaccion{

		PeticionTransaccionOznj peticionTransaccionOznj = new PeticionTransaccionOznj();

		Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class,
				peticionTransaccionOznj)).thenThrow(new ExcepcionTransaccion());

		transaccion.invocarCache(peticionTransaccionOznj);
	}
}