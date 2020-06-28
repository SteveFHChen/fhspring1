package com.fh.springbeans.namespacehandlerresovler;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

public class FHNamespaceHandlerResolver implements NamespaceHandlerResolver {
	/**
	 * The location to look for the mapping files. Can be present in multiple JAR files.
	 */
	public static final String DEFAULT_HANDLER_MAPPINGS_LOCATION = "META-INF/spring.handlers";
	
	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	/** ClassLoader to use for NamespaceHandler classes */
	private final ClassLoader classLoader;
	
	/** Resource location to search for */
	private final String[] handlerMappingsLocations;

	/** Stores the mappings from namespace URI to NamespaceHandler class name / instance */
	private volatile Map<String, Object> handlerMappings;
	
	public FHNamespaceHandlerResolver(ClassLoader classLoader, String[] handlerMappingsLocations) {
		Assert.notNull(handlerMappingsLocations, "Handler mappings location must not be null");
		this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
		this.handlerMappingsLocations = handlerMappingsLocations;
	}

	public NamespaceHandler resolve(String namespaceUri) {
		// TODO Auto-generated method stub
		Map<String, Object> handlerMappings = getHandlerMappings();
		Object handlerOrClassName = handlerMappings.get(namespaceUri);
		if (handlerOrClassName == null) {
			return null;
		}
		else if (handlerOrClassName instanceof NamespaceHandler) {
			return (NamespaceHandler) handlerOrClassName;
		}
		else {
			String className = (String) handlerOrClassName;
			try {
				Class<?> handlerClass = ClassUtils.forName(className, this.classLoader);
				if (!NamespaceHandler.class.isAssignableFrom(handlerClass)) {
					throw new FatalBeanException("Class [" + className + "] for namespace [" + namespaceUri +
							"] does not implement the [" + NamespaceHandler.class.getName() + "] interface");
				}
				NamespaceHandler namespaceHandler = (NamespaceHandler) BeanUtils.instantiateClass(handlerClass);
				namespaceHandler.init();
				handlerMappings.put(namespaceUri, namespaceHandler);
				return namespaceHandler;
			}
			catch (ClassNotFoundException ex) {
				throw new FatalBeanException("NamespaceHandler class [" + className + "] for namespace [" +
						namespaceUri + "] not found", ex);
			}
			catch (LinkageError err) {
				throw new FatalBeanException("Invalid NamespaceHandler class [" + className + "] for namespace [" +
						namespaceUri + "]: problem with handler class file or dependent class", err);
			}
		}
	}
	
	/**
	 * Load the specified NamespaceHandler mappings lazily.
	 */
	private Map<String, Object> getHandlerMappings() {
		if (this.handlerMappings == null) {
			synchronized (this) {
				if (this.handlerMappings == null) {
					Map<String, Object> handlerMappings = new ConcurrentHashMap<String, Object>(/*mappings.size()*/);
					for(String handlerMappingsLocation : handlerMappingsLocations){
						try {
							Properties mappings =
									PropertiesLoaderUtils.loadAllProperties(handlerMappingsLocation, this.classLoader);
							if (logger.isDebugEnabled()) {
								logger.debug("Loaded NamespaceHandler mappings: " + mappings);
							}
							
							CollectionUtils.mergePropertiesIntoMap(mappings, handlerMappings);
						}
						catch (IOException ex) {
							throw new IllegalStateException(
									"Unable to load NamespaceHandler mappings from location [" + handlerMappingsLocation + "]", ex);
						}
					}
					this.handlerMappings = handlerMappings;
				}
			}
		}
		return this.handlerMappings;
	}


	@Override
	public String toString() {
		return "NamespaceHandlerResolver using mappings " + getHandlerMappings();
	}
}
