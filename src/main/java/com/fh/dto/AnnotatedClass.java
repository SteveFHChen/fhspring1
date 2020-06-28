package com.fh.dto;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.fh.annotation.Hello;

@Lazy(false)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Primary
@Description("This class is used to test the spring annotation utils class AnnotationConfigUtils")
@Hello
public class AnnotatedClass {

	@Lazy(true)
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	@Description("test function")
	@Hello
	public void init(){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called.");
	}
}
