package com.fh.springbeans;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FHClassPathXmlApplicationContext extends
		ClassPathXmlApplicationContext {

	@Override
	protected DefaultListableBeanFactory createBeanFactory() {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called. Use fh BeanFactory.");
		return new FHDefaultListableBeanFactory(getInternalParentBeanFactory());
	}
	
	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		// TODO Auto-generated method stub
		super.customizeBeanFactory(beanFactory);
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called. Here add fh logic to customize the BeanFactory.");
	}

	@Override
	protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
		// TODO Auto-generated method stub
//		super.initBeanDefinitionReader(reader);
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called. Here add fh logic to init the reader.");
	}

	@Override
	protected void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called. Here add fh logic to post process to BeanFactory (Before invoking BeanFactory post processor)");
	}

	
}
