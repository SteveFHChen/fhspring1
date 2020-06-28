package com.fh.springcontext;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

import com.fh.dto.AnnotatedClass;

public class TestApp3AnnotationConfigUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.Use util class AnnotationConfigUtils to regist annotation internal processor...");
		BeanDefinitionRegistry simpleBDR = new SimpleBeanDefinitionRegistry();
		
		AnnotationConfigUtils.registerAnnotationConfigProcessors(simpleBDR);
		
		System.out.println("How many bean definition in register? "+simpleBDR.getBeanDefinitionCount());
		for(String name : simpleBDR.getBeanDefinitionNames())
		{
			BeanDefinition dbi = simpleBDR.getBeanDefinition(name);
			System.out.println("Bean definition name:["+name
					+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
					+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()+"]");
		}
		
		System.out.println("2.Use util class AnnotationConfigUtils to process annotated bean definition...");
		AnnotatedBeanDefinition abd1 = new AnnotatedGenericBeanDefinition(AnnotatedClass.class);
//		AnnotatedBeanDefinition sbd1 = new ScannedGenericBeanDefinition(new SimpleMetadataReader());
		
		BeanDefinition dbi = abd1;
		System.out.println("Bean definition name:["+dbi.getBeanClassName()
				+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
				+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()+"]");
		
		AnnotationConfigUtils.processCommonDefinitionAnnotations(abd1);
		
		dbi = abd1;
		System.out.println("Bean definition name:["+dbi.getBeanClassName()
				+"]Scope:["+dbi.getScope()+"]Source:["+dbi.getSource()
				+"]isSingleton:["+dbi.isSingleton()+"]isProptotype:["+dbi.isPrototype()+"]isPrimary:["+dbi.isPrimary()+"]");
	}

}
