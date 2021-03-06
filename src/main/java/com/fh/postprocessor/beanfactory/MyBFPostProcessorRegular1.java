package com.fh.postprocessor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBFPostProcessorRegular1 implements BeanFactoryPostProcessor, Ordered {

	public int getOrder() {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called.");
		return 1;
	}

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called."+beanFactory);
	}

}
