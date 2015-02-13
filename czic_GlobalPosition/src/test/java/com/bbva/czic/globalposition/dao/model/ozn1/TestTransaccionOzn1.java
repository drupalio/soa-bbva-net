package com.bbva.czic.globalposition.dao.model.ozn1;

import com.bbva.czic.globalposition.dao.model.ozn0.PeticionTransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn0.RespuestaTransaccionOzn0;
import com.bbva.czic.globalposition.dao.model.ozn0.TransaccionOzn0;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ExcepcionRespuestaHost;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import junit.framework.Assert;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

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