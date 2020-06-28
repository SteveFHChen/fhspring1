package com.fh.configxml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class FHNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		// TODO Auto-generated method stub
		registerBeanDefinitionParser("hi", new HiBeanDefinitionParser());
	}

}
