package com.fh.postprocessor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessorRegular2 implements BeanPostProcessor, Ordered {

	public int getOrder() {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called.");
		return 2;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called."+bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called."+bean);
		return bean;
	}

}
