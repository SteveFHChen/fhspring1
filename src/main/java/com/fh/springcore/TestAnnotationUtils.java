package com.fh.springcore;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.fh.annotation.Hello;
import com.fh.dto.Person;
import com.fh.service.impl.PersonService;

public class TestAnnotationUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Test to use the spring annotation utils class
		 * Find the specific annotation, and get the attributes and values
		 */
		Component anns = AnnotationUtils.findAnnotation(Person.class, Component.class);
		System.out.println(anns);
		
		anns = AnnotationUtils.findAnnotation(PersonService.class, Component.class);
		Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(anns);
		System.out.println(anns + " attribues:"+attrs);
		
		Hello hello = AnnotationUtils.findAnnotation(PersonService.class, Hello.class);
		System.out.println(hello);
		
		for(Method m1 : PersonService.class.getDeclaredMethods()){
			Hello h1 = AnnotationUtils.findAnnotation(m1, Hello.class);
			System.out.println("Method:"+m1+" has annotation:"+h1);
		}
	}

}
