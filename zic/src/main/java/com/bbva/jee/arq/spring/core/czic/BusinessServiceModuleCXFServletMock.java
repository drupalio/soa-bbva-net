package com.bbva.jee.arq.spring.core.zic;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.common.classloader.ClassLoaderUtils;
import org.apache.cxf.common.classloader.ClassLoaderUtils.ClassLoaderHolder;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.transport.http.DestinationRegistry;
import org.apache.cxf.transport.http.HTTPTransportFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.apache.cxf.transport.servlet.ServletContextResourceResolver;
import org.apache.cxf.transport.servlet.ServletController;
import org.apache.cxf.transport.servlet.servicelist.ServiceListGeneratorServlet;
import org.apache.log4j.MDC;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import com.bbva.jee.arq.spring.core.auditoria.AdministradorEventos;
import com.bbva.jee.arq.spring.core.auditoria.InvocacionAuditable;
import com.bbva.jee.arq.spring.core.auditoria.TipoRemotizacion;
import com.bbva.jee.arq.spring.core.auditoria.evento.EventoError;
import com.bbva.jee.arq.spring.core.auditoria.evento.HttpRequestFinishedEvent;
import com.bbva.jee.arq.spring.core.auditoria.evento.HttpRequestStartedEvent;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.context.ContextProvider;
import com.bbva.jee.arq.spring.core.servicing.context.TestContextManager;
import com.bbva.jee.arq.spring.core.servicing.startup.BusinessServiceContainerContextLoaderListener;
import com.bbva.jee.arq.spring.core.servicing.startup.BusinessServiceLogLoaderListener;
import com.bbva.jee.arq.spring.core.servicing.startup.BusinessServiceModuleApplicationContext;
import com.bbva.jee.arq.spring.core.servicing.startup.BusinessServiceModuleCXFServlet;

public class BusinessServiceModuleCXFServletMock extends CXFNonSpringServlet {

	private static final Log LOG = LogFactory.getLog(BusinessServiceModuleCXFServlet.class);

	private static final long serialVersionUID = 1L;

	private static final String CXF_BUS_BEAN_NAME = "cxf";

	private static final String CONFIGURATION_MANAGER_BEAN_NAME = "configurationManager";

	private static final String DELEGATE_CONFIGURATION_MANAGER_BEAN_NAME = "delegateConfigurationManager";

	private static final String AUDITING_EVENTS_MANAGER_BEAN_NAME = "administradorEventosImpl";

	private static final String CONTEXT_PROVIDER_BEAN_NAME = "contextProvider";

	private static final String WS_REMOTIZATION_NAME = "ws";

	private final Map<String, ChildContextHolder> childContextHolderMap = new HashMap<String, ChildContextHolder>();

	private ChildContextHolder createChildContextHolder(BusinessServiceModuleApplicationContext bsmContext) {
		ChildContextHolder childContextHolder = new ChildContextHolder();
		childContextHolder.setApplicationContext(bsmContext);

		MockServletContext servletContext = new MockServletContext();
		bsmContext.setServletContext(servletContext);
		bsmContext.refresh();
		bsmContext.registerShutdownHook();

		if (bsmContext != null) {

			try {
				TestContextManager testContextManager = bsmContext.getBean("contextManager", TestContextManager.class);
				testContextManager.createTestContext();
				ContextProvider contextProvider = bsmContext.getBean("contextProvider", ContextProvider.class);
				contextProvider.getInvocationContext().setApplicationContext(bsmContext);
			} catch (BeansException e) {
				throw new IllegalStateException(
						"Incorrect business service test, check if <servicing:test-metadata> is present in one of the configured config locations");
			}
		}

		Bus bus = null;
		try {
			bus = bsmContext.getBean(CXF_BUS_BEAN_NAME, Bus.class);
		} catch (BeansException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("No CXF bus bean found in business service module application context", e);
			}
			childContextHolder.setCorrupted(true);
		}
		ConfigurationManager configurationManager = null;
		try {
			configurationManager = bsmContext.getBean(CONFIGURATION_MANAGER_BEAN_NAME, ConfigurationManager.class);
		} catch (BeansException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("No ConfigurationManager bean found in business service module application context", e);
			}
			childContextHolder.setCorrupted(true);
		}
		AdministradorEventos auditingEventsManager = null;
		try {
			auditingEventsManager = bsmContext.getBean(AUDITING_EVENTS_MANAGER_BEAN_NAME, AdministradorEventos.class);
		} catch (BeansException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("No AdministradorEventos bean found in business service module application context", e);
			}
			childContextHolder.setCorrupted(true);
		}
		ContextProvider contextProvider = null;
		try {
			contextProvider = bsmContext.getBean(CONTEXT_PROVIDER_BEAN_NAME, ContextProvider.class);
		} catch (BeansException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("No ContextProvider bean found in business service module application context", e);
			}
			childContextHolder.setCorrupted(true);
		}
		if (!childContextHolder.isCorrupted()) {
			ClassLoader classLoader = bus.getExtension(ClassLoader.class);
			ResourceManager resourceManager = bus.getExtension(ResourceManager.class);
			resourceManager.addResourceResolver(new ServletContextResourceResolver(getServletConfig()
					.getServletContext()));
			DestinationRegistry destinationRegistry = getDestinationRegistryFromBus(bus);
			HttpServlet serviceListGeneratorServlet = new ServiceListGeneratorServlet(destinationRegistry, bus);
			ServletController servletController = new ServletController(destinationRegistry, getServletConfig(),
					serviceListGeneratorServlet);
			childContextHolder.setBus(bus);
			childContextHolder.setClassLoader(classLoader);
			childContextHolder.setDestinationRegistry(destinationRegistry);
			childContextHolder.setServletController(servletController);
			childContextHolder.setConfigurationManager(configurationManager);
			childContextHolder.setAuditingEventsManager(auditingEventsManager);
			childContextHolder.setContextProvider(contextProvider);
		}
		return childContextHolder;
	}

	private class ChildContextHolder {

		private ApplicationContext applicationContext;

		private Bus bus;

		private ClassLoader classLoader;

		private DestinationRegistry destinationRegistry;

		private ServletController servletController;

		private ConfigurationManager configurationManager;

		private AdministradorEventos auditingEventsManager;

		private ContextProvider contextProvider;

		private boolean corrupted;

		private ChildContextHolder() {
		}

		public ApplicationContext getApplicationContext() {
			return applicationContext;
		}

		public void setApplicationContext(ApplicationContext applicationContext) {
			this.applicationContext = applicationContext;
		}

		public Bus getBus() {
			return bus;
		}

		public void setBus(Bus bus) {
			this.bus = bus;
		}

		public ClassLoader getClassLoader() {
			return classLoader;
		}

		public void setClassLoader(ClassLoader classLoader) {
			this.classLoader = classLoader;
		}

		public DestinationRegistry getDestinationRegistry() {
			return destinationRegistry;
		}

		public void setDestinationRegistry(DestinationRegistry destinationRegistry) {
			this.destinationRegistry = destinationRegistry;
		}

		public ServletController getServletController() {
			return servletController;
		}

		public void setServletController(ServletController servletController) {
			this.servletController = servletController;
		}

		public ConfigurationManager getConfigurationManager() {
			return configurationManager;
		}

		public void setConfigurationManager(ConfigurationManager configurationManager) {
			this.configurationManager = configurationManager;
		}

		public AdministradorEventos getAuditingEventsManager() {
			return auditingEventsManager;
		}

		public void setAuditingEventsManager(AdministradorEventos auditingEventsManager) {
			this.auditingEventsManager = auditingEventsManager;
		}

		public ContextProvider getContextProvider() {
			return contextProvider;
		}

		public void setContextProvider(ContextProvider contextProvider) {
			this.contextProvider = contextProvider;
		}

		public boolean isCorrupted() {
			return corrupted;
		}

		public void setCorrupted(boolean corrupted) {
			this.corrupted = corrupted;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ChildContextHolder [applicationContext=");
			builder.append(applicationContext);
			builder.append(", bus=");
			builder.append(bus);
			builder.append(", classLoader=");
			builder.append(classLoader);
			builder.append(", destinationRegistry=");
			builder.append(destinationRegistry);
			builder.append(", servletController=");
			builder.append(servletController);
			builder.append(", configurationManager=");
			builder.append(configurationManager);
			builder.append(", auditingEventsManager=");
			builder.append(auditingEventsManager);
			builder.append(", contextProvider=");
			builder.append(contextProvider);
			builder.append(", corrupted=");
			builder.append(corrupted);
			builder.append("]");
			return builder.toString();
		}
	}

	private class ReadableStatusHttpServletResponse extends HttpServletResponseWrapper {

		private int status;

		public ReadableStatusHttpServletResponse(HttpServletResponse response) {
			super(response);
		}

		@Override
		public void setStatus(int status) {
			super.setStatus(status);
			this.status = status;
		}

		@Override
		public void setStatus(int status, String message) {
			super.setStatus(status, message);
			this.status = status;
		}

		public int getStatus() {
			return status;
		}
	}

	private class UrlInfo {

		private TipoRemotizacion remotingType;

		private String serviceLogicalId;

		private boolean auditingExcluded;

		// url pattern is:
		// ws: /ws/[logicalId]/V[nn]
		// rs: /[logicalId]/V[nn], /[logicalId]/api-docs/...
		public UrlInfo(HttpServletRequest request) {
			String pathInfo = request.getPathInfo() == null ? "" : request.getPathInfo();
			String remotingName = null;
			try {
				String[] tokens = pathInfo.split("/");
				if (tokens != null) {
					if (tokens.length > 1) remotingName = tokens[1];
					serviceLogicalId = "";
					if (WS_REMOTIZATION_NAME.equals(remotingName)) {
						// ws
						if (tokens.length > 2) {
							for (int i = 2; i < tokens.length; i++)
								if (i == 2) {
									serviceLogicalId += tokens[i];
								} else {
									if (tokens[i].matches("V[0-9][0-9]")) {
										break;
									}
									serviceLogicalId += "." + tokens[i];
								}
						}
					} else {
						// rs
						if (tokens.length > 1) {
							for (int i = 1; i < tokens.length; i++) {
								if (i == 1) {
									serviceLogicalId += tokens[i];
								} else {
									if (tokens[i].matches("V[0-9][0-9]") || tokens[i].matches("api-docs.*")) {
										break;
									}
									serviceLogicalId += "." + tokens[i];
								}
							}
						}
					}
				}
				if (WS_REMOTIZATION_NAME.equals(remotingName)) {
					remotingType = TipoRemotizacion.SERVICIO_WEB;
					if (serviceLogicalId != null) {
						Pattern apiDocsPattern = Pattern.compile("/" + WS_REMOTIZATION_NAME + "/"
								+ serviceLogicalId.replace('.', '/') + "/api-docs.*");
						Pattern rootDescriptorPattern = Pattern.compile("/" + WS_REMOTIZATION_NAME + "/"
								+ serviceLogicalId.replace('.', '/'));
						Pattern versionDescriptorPattern = Pattern.compile("/" + WS_REMOTIZATION_NAME + "/"
								+ serviceLogicalId.replace('.', '/') + "/[vV]\\d+");
						if (apiDocsPattern.matcher(pathInfo).matches()) {
							auditingExcluded = true;
						} else if (rootDescriptorPattern.matcher(pathInfo).matches()
								|| versionDescriptorPattern.matcher(pathInfo).matches()) {
							if ("GET".equals(request.getMethod())
									&& (request.getParameter("wsdl") != null || request.getParameter("_wadl") != null))
								auditingExcluded = true;
						} else
							auditingExcluded = false;
					}
				} else {
					remotingType = TipoRemotizacion.SERVICIO_REST;
					if (serviceLogicalId != null) {
						Pattern apiDocsPattern = Pattern.compile("/" + serviceLogicalId.replace('.', '/')
								+ "/api-docs.*");
						Pattern rootDescriptorPattern = Pattern.compile("/" + serviceLogicalId.replace('.', '/'));
						Pattern versionDescriptorPattern = Pattern.compile("/" + serviceLogicalId.replace('.', '/')
								+ "/[vV]\\d+");
						if (apiDocsPattern.matcher(pathInfo).matches()) {
							auditingExcluded = true;
						} else if (rootDescriptorPattern.matcher(pathInfo).matches()
								|| versionDescriptorPattern.matcher(pathInfo).matches()) {
							if ("GET".equals(request.getMethod())
									&& (request.getParameter("wsdl") != null || request.getParameter("_wadl") != null))
								auditingExcluded = true;
						} else
							auditingExcluded = false;
					}
				}
			} catch (PatternSyntaxException e) {

			}
		}

		public TipoRemotizacion getRemotingType() {
			return remotingType;
		}

		public String getServiceLogicalId() {
			return serviceLogicalId;
		}

		public boolean isAuditingExcluded() {
			return auditingExcluded;
		}
	}

	private DestinationRegistry getDestinationRegistryFromBus(Bus bus) {
		DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);
		try {
			DestinationFactory df = dfm.getDestinationFactory("http://cxf.apache.org/transports/http/configuration");
			if (df instanceof HTTPTransportFactory) {
				HTTPTransportFactory transportFactory = (HTTPTransportFactory)df;
				return transportFactory.getRegistry();
			} else
				return null;
		} catch (BusException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List<BusinessServiceModuleApplicationContext> getBusinessServiceModuleApplicationContexts() {
		ServletConfig servletConfig = getServletConfig();
		ServletContext servletContext = servletConfig.getServletContext();
		List<BusinessServiceModuleApplicationContext> bsmContextList = null;
		try {
			bsmContextList = (List<BusinessServiceModuleApplicationContext>)servletContext
					.getAttribute(BusinessServiceContainerContextLoaderListener.BUSINESS_SERVICE_APPLICATION_CONTEXT_LIST_ATTRIBUTE);
		} catch (ClassCastException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Could not access business service module context list from servlet context", e);
			}
		}
		if (bsmContextList == null) bsmContextList = new ArrayList<BusinessServiceModuleApplicationContext>();
		return bsmContextList;
	}

	private ChildContextHolder getChildContextHolder(String serviceLogicalId) {
		ChildContextHolder childContextHolder = childContextHolderMap.get(serviceLogicalId);
		if (childContextHolder == null) {
			for (BusinessServiceModuleApplicationContext bsmContext : getBusinessServiceModuleApplicationContexts()) {
				if (bsmContext.getLogicalId().equals(serviceLogicalId)) {
					if (bsmContext.checkStarted()) {
						childContextHolder = createChildContextHolder(bsmContext);
					} else {
						childContextHolder = new ChildContextHolder();
						childContextHolder.setCorrupted(true);
					}
					childContextHolderMap.put(serviceLogicalId, childContextHolder);
					break;
				}
			}
		}
		return childContextHolder;
	}

	@Override
	protected void invoke(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		// creates url info
		UrlInfo urlInfo = new UrlInfo(request);
		// gets child context holder
		ChildContextHolder childContextHolder = getChildContextHolder(urlInfo.getServiceLogicalId());
		// child context found
		if (urlInfo.getRemotingType() != null && childContextHolder != null && !childContextHolder.isCorrupted()) {

			// configuration: get invocation context from ContextProvider and set current applicationContext
			ContextProvider contextProvider = childContextHolder.getContextProvider();
			contextProvider.getInvocationContext().setApplicationContext(childContextHolder.getApplicationContext());

			// auditing: set remoting type
			if (!urlInfo.isAuditingExcluded()) {
				// auditing: set remoting type
				request.setAttribute(InvocacionAuditable.PARAMETRO_REQUEST_TIPO_REMOTIZACION, urlInfo.getRemotingType());
			}

			// configuration: get ConfigurationManager and store it in the request
			ConfigurationManager configurationManager = childContextHolder.getConfigurationManager();
			request.setAttribute(DELEGATE_CONFIGURATION_MANAGER_BEAN_NAME, configurationManager);

			// log4j: set values for logicalId
			String serviceLogicalId = configurationManager.getServiceLogicalId();
			MDC.put(BusinessServiceLogLoaderListener.MDC_PROPERTY_SERVICE_LOGICAL_ID, serviceLogicalId == null ? ""
					: serviceLogicalId);

			// auditing: notify request started event
			if (!urlInfo.isAuditingExcluded())
				childContextHolder.getAuditingEventsManager().registrar(new HttpRequestStartedEvent(request));

			ReadableStatusHttpServletResponse responseWrapper = new ReadableStatusHttpServletResponse(response);

			ClassLoaderHolder originalClassLoader = null;
			try {
				if (childContextHolder.getClassLoader() != null) {
					originalClassLoader = ClassLoaderUtils.setThreadContextClassloader(childContextHolder
							.getClassLoader());
				}
				if (childContextHolder.getBus() != null) {
					BusFactory.setThreadDefaultBus(childContextHolder.getBus());
				}
				childContextHolder.getServletController().invoke(request, responseWrapper);
			} catch (Throwable t) {
				// auditing: notify error
				if (!urlInfo.isAuditingExcluded())
					childContextHolder.getAuditingEventsManager().registrar(new EventoError(t));
			} finally {

				// auditing: notify request finished event
				int httpStatus = responseWrapper.getStatus();
				String warningCode = contextProvider.getInvocationContext().getWarningCode();
				String warningDescription = contextProvider.getInvocationContext().getWarningDescription();
				HttpRequestFinishedEvent httpRequestFinishedEvent = new HttpRequestFinishedEvent(httpStatus,
						warningCode, warningDescription);
				if (!urlInfo.isAuditingExcluded())
					childContextHolder.getAuditingEventsManager().registrar(httpRequestFinishedEvent);

				BusFactory.setThreadDefaultBus(null);

				if (originalClassLoader != null) {
					originalClassLoader.reset();
				}
			}
		} else {
			// service not found
			generateNotFound(request, response);
		}
	}

	@Override
	public void destroy() {
		for (ChildContextHolder childContextHolder : childContextHolderMap.values()) {
			DestinationRegistry destinationRegistry = childContextHolder.getDestinationRegistry();
			if (destinationRegistry != null) {
				for (String path : destinationRegistry.getDestinationsPaths()) {
					AbstractHTTPDestination destination = destinationRegistry.getDestinationForPath(path);
					synchronized (destination) {
						destinationRegistry.removeDestination(path);
						destination.releaseRegistry();
					}
				}
			}
			Bus bus = childContextHolder.getBus();
			bus.shutdown(true);
		}
		childContextHolderMap.clear();
	}

	protected void generateNotFound(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			response.setStatus(404);
			response.setContentType("text/html");
			response.getWriter().write("<html><body>No service was found</body></html>");
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	private class MockServletContext implements ServletContext {

		private Map<String, String> initParameters = new HashMap<String, String>();

		private Map<String, Object> attributes = new HashMap<String, Object>();

		@Override
		public String getContextPath() {
			return null;
		}

		@Override
		public ServletContext getContext(String uripath) {
			return null;
		}

		@Override
		public int getMajorVersion() {
			return 0;
		}

		@Override
		public int getMinorVersion() {
			return 0;
		}

		@Override
		public String getMimeType(String file) {
			return null;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Set getResourcePaths(String path) {
			return null;
		}

		@Override
		public URL getResource(String path) throws MalformedURLException {
			return null;
		}

		@Override
		public InputStream getResourceAsStream(String path) {
			return null;
		}

		@Override
		public RequestDispatcher getRequestDispatcher(String path) {
			return null;
		}

		@Override
		public RequestDispatcher getNamedDispatcher(String name) {
			return null;
		}

		@Override
		public Servlet getServlet(String name) throws ServletException {
			return null;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Enumeration getServlets() {
			return null;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Enumeration getServletNames() {
			return null;
		}

		@Override
		public void log(String msg) {
		}

		@Override
		public void log(Exception exception, String msg) {
		}

		@Override
		public void log(String message, Throwable throwable) {
		}

		@Override
		public String getRealPath(String path) {
			return null;
		}

		@Override
		public String getServerInfo() {
			return null;
		}

		@Override
		public String getInitParameter(String name) {
			return initParameters.get(name);
		}

		protected void setInitParameter(String name, String value) {
			this.initParameters.put(name, value);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Enumeration getInitParameterNames() {
			return new Vector<String>(initParameters.keySet()).elements();
		}

		@Override
		public Object getAttribute(String name) {
			return attributes.get(name);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Enumeration getAttributeNames() {
			return new Vector<Object>(attributes.keySet()).elements();
		}

		@Override
		public void setAttribute(String name, Object object) {
			this.attributes.put(name, object);
		}

		@Override
		public void removeAttribute(String name) {
		}

		@Override
		public String getServletContextName() {
			return null;
		}

	}

}
