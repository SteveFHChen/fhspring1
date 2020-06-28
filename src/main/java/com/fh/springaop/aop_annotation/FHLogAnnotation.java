package com.fh.springaop.aop_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface FHLogAnnotation {
	String moduleName();
	String logMessage();
	/*
	 * (1)RetentionPolicy(保留策略)是一个enum类型，共有三个值，分别是SOURCE,CLASS 和 RUNTIME。
		SOURCE 代表的是这个Annotation类型的信息只会保留在程序源码里，源码如果经过了编译之后，Annotation的数据就会消失,并不会保留在编译好的.class文件里面。 
		ClASS的 代表的是这个Annotation类型的信息保留在程序源码里,同时也会保留在编译好的.class文件里面,在执行的时候，并不会把这一些信息加载到虚拟机(JVM)中去.注意一下，当你没有设定一个Annotation类型的Retention值时，系统默认值是CLASS。
		RUNTIME代表的是表示在源码、编译好的.class文件中保留信息，在执行的时候会把这一些信息加载到JVM中去的。
		
		(2)ElementType
		＠Target里面的ElementType是用来指定Annotation类型可以用在哪一些元素上的.
		TYPE(类型)是指可以用在Class,Interface,Enum和Annotation类型上. 
		FIELD(属性)
		METHOD(方法)
		PARAMETER(参数)
		CONSTRUCTOR(构造函数)
		LOCAL_VARIABLE(局部变量)
		ANNOTATION_TYPE
		PACKAGE(包)
		 
		(3)@Documented
		@Documented的目的就是让这一个Annotation类型的信息能够显示在javaAPI说明文档上;没有添加的话，使用javadoc生成API文档的时候就会找不到这一个类型生成的信息。
		 
		(4)@Inherited
		如果需要把Annotation的数据继承给子类，那么就会用到@Inherited这一个Annotation类型。
	*/
}
