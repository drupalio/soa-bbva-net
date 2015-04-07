package com.bbva.zic.routine.commons.rm.utils.test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.jee.arq.spring.core.auditoria.AdministradorEventos;
import com.bbva.jee.arq.spring.core.servicing.context.ContextProvider;
import com.bbva.jee.arq.spring.core.servicing.context.InvocationContext;

/**
 * Clase abstracta necesaria para aquellos tests unitarios que necesiten el uso de exceptiones de negocio
 * (BusinessServiceException) Pueden añadirse Mocks de beans empleados por la aplicación
 * 
 * @author Entelgy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public abstract class SpringContextBbvaTest {

	// Configuración de fichero obligatoria para:
	//
	// 1. Cargar ficheros de properties en "src/test/resources"
	// 2. Activar inyección dependencias en clases configuradas @Configured (p.e BusinessServiceException)
	// 3. Interceptar beans con anotaciones para el contexto de spring del test.
	// 4. Configurar aspectos AspectJ
	//
	@Configuration
	@ImportResource("classpath*:META-INF/spring/*test.xml")
	static class Beans {

		/**
		 * Mock del administrador de eventos utilizado en BusinsessServiceException
		 * 
		 * @return AdminstradorEventosMock Mock
		 */
		@Bean
		public AdministradorEventos createAdminstradorEventos() {
			return Mockito.mock(AdministradorEventos.class);
		}

		/**
		 * Mock del ContextProvider utilizado en BusinessServiceException
		 * 
		 * @return ContextProvider Mock
		 */
		@Bean
		public ContextProvider createContextProvider() {

			final InvocationContext invocationContext = new InvocationContext();
			final ContextProvider contextProvider = Mockito.mock(ContextProvider.class);
			Mockito.when(contextProvider.getInvocationContext()).thenReturn(invocationContext);
			return contextProvider;
		}
	}

}