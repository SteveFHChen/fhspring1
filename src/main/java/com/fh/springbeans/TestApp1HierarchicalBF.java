package com.fh.springbeans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import com.fh.dto.Person;
import com.fh.postprocessor.bean.MyPostProcessorRegular2;

public class TestApp1HierarchicalBF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 1.Study using BF directly instead of ApplicationContext
		 */
		BeanFactory parentBF = new DefaultListableBeanFactory();
		BeanFactory childBF = new DefaultListableBeanFactory();
		
		/**
		 * 2.Study how to use Hierarchical BF
		 */
		AbstractBeanFactory aBF= (AbstractBeanFactory)childBF;
		aBF.setParentBeanFactory(parentBF);
		
		/**
		 * 3.Dynamic inject BeanDefinition into BF.
		 */
		BeanDefinitionRegistry parentBDR = (BeanDefinitionRegistry)parentBF;
		BeanDefinitionRegistry childBDR = (BeanDefinitionRegistry)childBF;
		
		/**
		 * Inject a BeanPostProcessor bean into BF.
		 */
		System.out.println("\nNew BeanDefintion and regist:");
		//You can create the bean by new class();
//		MyPostProcessorRegular2 pp = new MyPostProcessorRegular2();
		//Also you can use BF to create bean
		BeanDefinition bd_pp = new GenericBeanDefinition();
		bd_pp.setBeanClassName(MyPostProcessorRegular2.class.getName());
		parentBDR.registerBeanDefinition("bd_pp", bd_pp);
		
		System.out.println("\nStudy how to add PostProcessor into BF:");
		if(parentBF instanceof ConfigurableBeanFactory){
			ConfigurableBeanFactory cbf = (ConfigurableBeanFactory)parentBF;
			cbf.addBeanPostProcessor((BeanPostProcessor) parentBF.getBean("bd_pp"));
		}
		
		/**
		 * Understand what's BeanDefinition
		 */
		System.out.println("\nNew BeanDefintion");
		BeanDefinition bd1 = new GenericBeanDefinition();
		System.out.println("\nSet the properties of the BeanDefinition: (Such as: BeanClass, Scope, Lazy, initMethod...)");
		bd1.setBeanClassName(Person.class.getName());
//		System.out.println("Set scope of BeanDefiniton to SCOPE_SINGLETON");
//		bd1.setScope(BeanDefinition.SCOPE_SINGLETON);
		System.out.println("Set scope of BeanDefiniton to SCOPE_PROTOTYPE");
		bd1.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		bd1.setAttribute("myAttr1", "attr1-Value");//Using BD attribute, and use it later.
		if(bd1 instanceof AbstractBeanDefinition){
			AbstractBeanDefinition abd = (AbstractBeanDefinition) bd1;
			abd.setInitMethodName("init");
		}
		System.out.println("BeanDefinition has overwrite the toString():");
		System.out.println("So we can see all the attribute, property and BeanDefintion's properties:");
		System.out.println(bd1);
		
		/**
		 * Understand the step - register BeanDefinition
		 * It's just put the BD into BeanFactory.beanDefinitionMap;
		 * In Spring the default BeanFactory is DefaultListableBeanFactory.
		 */
		System.out.println("\nRegister BeanDefinition into BeanFactory:");
		parentBDR.registerBeanDefinition("beanLucy", bd1);
		/**
		 * Here, it's a little confuse:
		 * the name is bean defintion's name;
		 * and later, getBean(), the name I think also it's bean definition's name, not bean name.
		 * Event in spring applicationcontext.xml, one <bean> will generate one BeanDefintion. 
		 */
		
		System.out.println("\nNow we can get bean through BeanDefiniton:");
		Person Lucy = parentBF.getBean("beanLucy", Person.class);
		Person Lucy2 = parentBF.getBean("beanLucy", Person.class);
		System.out.println( "Lucy == Lucy2 is "+(Lucy==Lucy2 ? "true, it's using SCOPE_SINGLETON":"false, it's using SCOPE_PROTOTYPE"));
		
		Lucy.setId(1001);
		Lucy.setName("Lucy");
		System.out.println(Lucy);
		
		childBDR.registerBeanDefinition("beanLily", bd1);
		Person Lily = childBF.getBean("beanLily", Person.class);
		Lily.setId(1002);
		Lily.setName("Lily");
		/**
		 * Understand: Spring 创建Bean Instance，初始华Bean Instance的过程：
			AbstractAutowireCapableBeanFactory.doCreateBean
				AbstractAutowireCapableBeanFactory.createBeanInstance
				AbstractAutowireCapableBeanFactory.initializeBean
					AccessController.doPrivileged()
					invokeAwareMethods(beanName, bean);
					applyBeanPostProcessorsBeforeInitialization ---->How to use here?
					invokeInitMethods(beanName, wrappedBean, mbd);
					applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName); ---->How to use here?
					
					How to use?
					Define PostProcessor to implement BeanPostProcessor, then there are beforeInitialization() and afterInitialization();
					It will be called by Spring framework before and after initial bean as above shown.
		 */
		
		/**
		 * 4.Test: get bean from a Hierarchical BF, it can search to parent BF.
		 */
		System.out.println("\nGet bean in parent BF through child BF:");
		Lucy = childBF.getBean("beanLucy", Person.class);
		System.out.println(Lucy);
		
		/**
		 * 5.Check the bean definitions in each bean factory.
		 * Understand what's bean definition.
		 */
		ListableBeanFactory parentLBF = (ListableBeanFactory)parentBF;
		for(String dbName : parentLBF.getBeanDefinitionNames()){
			System.out.println("\nBean definition name in parent bean factory: "+dbName);
		}
		ListableBeanFactory childLBF = (ListableBeanFactory)childBF;
		for(String dbName : childLBF.getBeanDefinitionNames()){
			System.out.println("Bean definition name in child bean factory: "+dbName);
		}
	}

}
