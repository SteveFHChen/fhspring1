package com.fh.springaop.aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	//这句话是方法切入点，execution为执行的意思，public代表仅对public的方法，*代表任意返回值，然后是包名，.*意思是包下面的所有子包。(..)代表各种方法.
	@Pointcut("execution(public * com.fh.springaop.aop_annotation.StudentImpl.*(..))")
//	@Pointcut("execution(public * "+StudentImpl.class.getName()+".*(..))")//error, must be a constant
	private void anyMethod(){}
	/**
	 * org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'student' defined in file [D:\fhws11\fhspring1\target\classes\com\fh\springaop\aop_annotation\StudentImpl.class]: Initialization of bean failed; nested exception is java.lang.IllegalArgumentException: warning no match for this type name: com.aop_annotation.StudentImpl [Xlint:invalidAbsoluteTypeName]
	 * 从Error stack中很难看出错误是什么，直接debug spring source code，只发现catch exception的地方离错误发生地很远了，
	 * debug了一上午，只能跟踪到ThreadLocal执行m.remove(this);后就回退到之前一个调的函数据catch处了，也发现不了原因。
	 * 于是上网search Xlint:invalidAbsoluteTypeName，原来是pointcut设的要切入的类不存在，仔细一看上面那么错，warning no match for this type name: com.aop_annotation.StudentImpl，是自己没看仔细，这个package的路径不对。
	 */
	
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name){
		System.out.println("before method advice."+name);
	}
	
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("after around advice.");
	}
	
	@AfterThrowing("anyMethod()")
	public void doAfterThrow(){
		System.out.println("exception advice.");
	}
	
	@Around("anyMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Method Around advice begin...");
		Object result = pjp.proceed();
		System.out.println("Mehtod Around advice end...");
		return result;
	}
	
	@Around(value="anyMethod() && @annotation(anno) && args(obj,..)", argNames="anno,obj")
	public Object doAround2(ProceedingJoinPoint pjp, FHLogAnnotation anno, Object obj) throws Throwable{
		System.out.println("Method Around advice-log begin...");
		System.out.println("FH output log - moduleName:"+anno.moduleName()+"\tlogMessage:"+anno.logMessage());
		pjp.proceed();
		System.out.println("Method Around advice-log end...");
		return obj;
	}
	/**
	 * 可以有多个Around等advice，按照code的先后顺序依次执行。
	 */
	
	@AfterReturning("anyMethod()")
	public void doAfterReturn(){
		System.out.println("after return advice.");
	}
}
