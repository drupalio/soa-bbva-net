package com.bbva.czic.accounts.dao.model.oznu;

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
 * Test de la transacci&oacute;n <code>OZNU</code>
 * 
 * @author Arquitectura Spring BBVA
 */

public class TestTransaccionOznu extends SpringContextBbvaTest {
	
	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznu.class);
	private TransaccionOznu transaccion;
		private ServicioTransacciones servicioTransacciones;

		@Before
		public void init(){
			transaccion = new TransaccionOznu();
			servicioTransacciones = Mockito.mock(ServicioTransacciones.class);
			transaccion.setServicioTransacciones(servicioTransacciones);
		}

		@Test
		public void checkInvocarOK() throws ExcepcionTransaccion {

			PeticionTransaccionOznu peticionTransaccionOznu = new PeticionTransaccionOznu();
			RespuestaTransaccionOznu respuestaTransaccionOznu = new RespuestaTransaccionOznu();

			Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class,
					peticionTransaccionOznu)).thenReturn(respuestaTransaccionOznu);

			RespuestaTransaccionOznu result = transaccion.invocar(peticionTransaccionOznu);

			Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class,
					peticionTransaccionOznu);

			Assert.assertNotNull(result);
		}

		@Test(expected = ExcepcionTransaccion.class)
		public void checkInvocarThrowsException() throws ExcepcionTransaccion {

			PeticionTransaccionOznu peticionTransaccionOznu = new PeticionTransaccionOznu();

			Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class,
					peticionTransaccionOznu)).thenThrow(new ExcepcionTransaccion());

			transaccion.invocar(peticionTransaccionOznu);

		}

		@Test
		public void checkInvocarCacheOK() throws ExcepcionTransaccion {

			PeticionTransaccionOznu peticionTransaccionOznu = new PeticionTransaccionOznu();
			RespuestaTransaccionOznu respuestaTransaccionOznu = new RespuestaTransaccionOznu();

			Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class,
					peticionTransaccionOznu)).thenReturn(respuestaTransaccionOznu);

			RespuestaTransaccionOznu result = transaccion.invocarCache(peticionTransaccionOznu);

			Mockito.verify(servicioTransacciones).invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class,
					peticionTransaccionOznu);

			Assert.assertNotNull(result);
		}

		@Test(expected = ExcepcionTransaccion.class)
		public void checkInvocarCacheThrowsException() throws ExcepcionTransaccion {

			PeticionTransaccionOznu peticionTransaccionOznu = new PeticionTransaccionOznu();

			Mockito.when(servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class,
					peticionTransaccionOznu)).thenThrow(new ExcepcionTransaccion());

			transaccion.invocarCache(peticionTransaccionOznu);

		}

}