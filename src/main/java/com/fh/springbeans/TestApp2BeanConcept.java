package com.fh.springbeans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;

import com.fh.dto.Person;
import com.fh.dto.Person2;

public class TestApp2BeanConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * BeanFactory, BeanDefinition, BeanDefinitionHodler, BeanDefinitionRegistry, Bean
		 * Register BeanDefinition by manual
		 * Use BeanDefinitionReaderUtils to manage bean 
		 * 
		 * BeanDefinitionHolder: 持有一个BeanDefinition，名称，和别名数组。在Spring内部，它用来临时保存BeanDefinition来传递BeanDefinition。 
		 */
		System.out.println("1.Use SimpleBeanDefinitionRegistry...");
		BeanDefinitionRegistry simpleBDR = new SimpleBeanDefinitionRegistry();
		BeanDefinition db = new GenericBeanDefinition();
		db.setBeanClassName(Person.class.getName());
		db.setScope(db.SCOPE_PROTOTYPE);
		simpleBDR.registerBeanDefinition("beanPerson", db);
		
		BeanDefinition db22 = new GenericBeanDefinition();
		db22.setBeanClassName(Person2.class.getName());
		db22.setScope(db.SCOPE_PROTOTYPE);
		simpleBDR.registerBeanDefinition("beanPerson2", db22);
		
		System.out.println("How many bean definition in register? "+simpleBDR.getBeanDefinitionCount());
		for(String name : simpleBDR.getBeanDefinitionNames())
		{
			BeanDefinition dbi = simpleBDR.getBeanDefinition(name);
			System.out.println("Bean definition name:["+name
					+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
					+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()+"]");
		}
		
		BeanDefinitionHolder bdh = new BeanDefinitionHolder(db, "Lucy");
		System.out.println("Get bean name from bean definition holder:"+bdh.getBeanName());
		
//		BeanFactory bf = new DefaultListableBeanFactory();
//		BeanDefinitionRegistry bdr = (BeanDefinitionRegistry)bf;
		
		System.out.println("2.Use BeanDefinitionReaderUtils to manage bean...");
		try {
			BeanDefinition db2 = BeanDefinitionReaderUtils.createBeanDefinition(null, Person.class.getName(), null);
			
			String beanName = BeanDefinitionReaderUtils.generateBeanName(db2, simpleBDR);
			System.out.println("Generate bean name:"+beanName);
			
			BeanDefinitionReaderUtils.registerBeanDefinition(bdh, simpleBDR);
			System.out.println("How many bean definition in register? "+simpleBDR.getBeanDefinitionCount());
			for(String name : simpleBDR.getBeanDefinitionNames())
			{
				BeanDefinition dbi = simpleBDR.getBeanDefinition(name);
				System.out.println("Bean definition name:["+name
						+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
						+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()
						+"]fhAttr1:["+dbi.getAttribute("fhAttr1")+"]");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("3.Try to find an exists bean definition and update it...");
		BeanDefinition bd1 = simpleBDR.getBeanDefinition("beanPerson");
		bd1.setAttribute("fhAttr1", "Hello");
		bd1.setPrimary(true);
		System.out.println("How many bean definition in register? "+simpleBDR.getBeanDefinitionCount());
		for(String name : simpleBDR.getBeanDefinitionNames())
		{
			BeanDefinition dbi = simpleBDR.getBeanDefinition(name);
			System.out.println("Bean definition name:["+name
					+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
					+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()
					+"]fhAttr1:["+dbi.getAttribute("fhAttr1")+"]");
		}
		/**
		 * we found that different bean definition from the same class will be updated.
		 */
		
		System.out.println("4.Try to remove bean definition from bean definition registry...");
		simpleBDR.removeBeanDefinition("beanPerson");
		System.out.println("How many bean definition in register? "+simpleBDR.getBeanDefinitionCount());
		for(String name : simpleBDR.getBeanDefinitionNames())
		{
			BeanDefinition dbi = simpleBDR.getBeanDefinition(name);
			System.out.println("Bean definition name:["+name
					+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
					+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()
					+"]fhAttr1:["+dbi.getAttribute("fhAttr1")+"]");
		}
	}

}
