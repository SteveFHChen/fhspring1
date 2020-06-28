package com.fh.configxml;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class HiBeanDefinitionParser implements BeanDefinitionParser {

	//Also can extends from AbstractSingleBeanDefinitionParser
	
	/**
	 * Reference ComponentScanBeanDefinitionParser
	 */
	
	private static final String MSG = "msg";
	
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// TODO Auto-generated method stub
		System.out.println("Find <hi> element. Attribute ["+MSG+"] "+element.getAttribute(MSG));
		return null;
	}

}
