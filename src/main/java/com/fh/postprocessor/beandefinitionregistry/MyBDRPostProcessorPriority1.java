package com.fh.postprocessor.beandefinitionregistry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBDRPostProcessorPriority1 implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

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

	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called."+registry);
	}

}
