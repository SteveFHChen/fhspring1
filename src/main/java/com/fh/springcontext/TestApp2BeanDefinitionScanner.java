package com.fh.springcontext;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class TestApp2BeanDefinitionScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Spring function - component scan:");
		
		String[] basePackages = {"com.fh.service","com.fh.postprocessor"};
		BeanDefinitionRegistry dbr = new DefaultListableBeanFactory();
		FHBeanDefinitionScanner scanner = new FHBeanDefinitionScanner(dbr);
		
		Set<BeanDefinitionHolder> dbhs = scanner.fhScan(basePackages);
		
		for(BeanDefinitionHolder dbh : dbhs)
			System.out.println(dbh);
	}

}
