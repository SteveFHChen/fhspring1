package com.fh.springbeans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class FHDefaultListableBeanFactory extends DefaultListableBeanFactory {
	/**
	 * Create a new DefaultListableBeanFactory.
	 */
	public FHDefaultListableBeanFactory() {
		super();
	}

	/**
	 * Create a new DefaultListableBeanFactory with the given parent.
	 * @param parentBeanFactory the parent BeanFactory
	 */
	public FHDefaultListableBeanFactory(BeanFactory parentBeanFactory) {
		super(parentBeanFactory);
	}
}
