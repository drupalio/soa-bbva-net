package com.bbva.czic.products.dao.model.oznm;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ExcepcionRespuestaHost;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;

/**
 * Test de la transacci&oacute;n <code>OZNM</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	loader = BusinessServiceTestContextLoader.class, 
	locations = {
        "classpath*:/META-INF/spring/applicationContext-*.xml", 
        "classpath:/META-INF/spring/business-service.xml",
        "classpath:/META-INF/spring/business-service-test.xml"
    }
)
@TestExecutionListeners(listeners = { MockInvocationContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class })
public class TestTransaccionOznm {
	
	private static final Log LOG = I18nLogFactory.getLog(TestTransaccionOznm.class);
		
	@Autowired
	private TransaccionOznm transaccion;
	
	@Test
	public void test() throws ExcepcionTransaccion {
		
		PeticionTransaccionOznm peticion = new PeticionTransaccionOznm();		
		
		/*
		 * TODO: poblar la peticion con valores adecuados
		 */
		
		try {
			LOG.info("Invocando transaccion, peticion: " + peticion);
			RespuestaTransaccionOznm respuesta = transaccion.invocar(peticion);
			LOG.info("Recibida respuesta: " + respuesta);
		} catch ( ExcepcionRespuestaHost e ) {
			LOG.error("Error recibido desde host, codigoError: " + e.getCodigoError() + ", descripcion: " + e.getMessage());
		} catch ( ExcepcionTransporte e ) {
			LOG.error("Error de transporte", e);
		}
	}
}