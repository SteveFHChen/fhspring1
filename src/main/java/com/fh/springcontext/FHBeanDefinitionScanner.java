package com.fh.springcontext;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class FHBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

	public FHBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		super(registry);
		// TODO Auto-generated constructor stub
	}

	public Set<BeanDefinitionHolder> fhScan(String... basePackages) {
		// TODO Auto-generated method stub
		return this.doScan(basePackages);
	}
	
	

}
