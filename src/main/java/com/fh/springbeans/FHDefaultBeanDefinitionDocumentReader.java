package com.fh.springbeans;

import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Element;

public class FHDefaultBeanDefinitionDocumentReader extends
		DefaultBeanDefinitionDocumentReader {

	@Override
	protected void preProcessXml(Element root) {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called. Here add fh logic to pre process.");
	}

	@Override
	protected void postProcessXml(Element root) {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called. Here add fh logic to post process.");
	}

}
