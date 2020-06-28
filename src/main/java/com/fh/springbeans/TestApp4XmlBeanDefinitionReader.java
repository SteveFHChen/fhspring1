package com.fh.springbeans;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class TestApp4XmlBeanDefinitionReader {
	/**
	 * Study Spring load and parse xml configure file;
	 * Concept: Reader, Namespace, NamespaceHandler, NamespaceHandlerResolver, Parser
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanDefinitionRegistry simpleBDR = new SimpleBeanDefinitionRegistry();
		BeanDefinitionReader bdr = new XmlBeanDefinitionReader(simpleBDR);
		
		XmlBeanDefinitionReader xml_bdr = (XmlBeanDefinitionReader)bdr;
		NamespaceHandlerResolver nshr = xml_bdr.getNamespaceHandlerResolver();
		/**
		 * we can see, if there is a default handler resolver in XmlBeanDefinitionReader.
		 * DefaultNamespaceHandlerResolver
		 * In default, Spring uses it to load xml;
		 * It also loads user defined elements in META-INFO/spring.handles
		 */
//		bdr.setNamespaceHandlerResolver(null);
		bdr.loadBeanDefinitions("classpath:springbeans/userDefineSpringXmlElement.xml");
		
		/**
		 * How to design user's handler resolver?
		 * How to load and parse user defined xml in any path?
		 * Reference DefaultNamespaceHandlerResolver - resolve() and handleMapping().
		 * Inteface NamespaceHandlerResolver has only one implement, just DefaultNamespaceHandlerResolver.
		 */
		
		System.out.println("Load and parse spring xml completed.");
	}

}
