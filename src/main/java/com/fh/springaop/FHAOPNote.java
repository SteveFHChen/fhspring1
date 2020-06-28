package com.fh.springaop;

public class FHAOPNote {
	/**
	 * AOP concept
	 * 
	 * Join Point: 指的是程序运行中的某个阶段点，如某个方法调用、异常抛出等。前面示例中的doAuditing()方法就是一个Join Point，表示程序是要在这个地方加入Advice。
	 * Pointcut: 是Join Point的集合，它是程序中需要注入Advice的位置的集合，指明Advice要在什么样的条件下才能被触发，通过实现Advice的子接口来编写逻辑。
	 * Advice: Advice是某个连接点所采用的处理逻辑，也就是向连接点注入的代码。前面示例中提取出来输出日志信息的代码就是一个Advice，表示要在Join Point加入这段代码。
	 * Advisor: Advisor是Pointcut和Advice的配置器，它包括Pointcut和Advice，是将Advice注入程序中Pointcut位置的代码。
	 * Aspect: 同Advice一样，也是某个连接点所采用的处理逻辑，只是写代码和Advice不一样，不需要实现接口，任何方法都可以，参数就是一个JoinPoint或ProceedingJoinPoint。
	 * 
	 * 区别：Join Point和PointCut, Advice和Advisor, Advice和Aspect
	 * 
	 * Advice使用aopalliance;
	 * Aspect使用aspectj;
	 * 
	 * 其它concept: Advice, Aspect, Interceptor
	 */
	
	/**
	 * 静态切入点
	 *    静态切入点只限于给定的方法和目标类，而不考虑方法的参数。Spring在调用静态切入点时只在第一次的时候计算静态切入点的位置，然后把它缓存起来，
	 * 后就不需要再进行计算。使用org.springframework.aop.support.RegexpMethodPointcut 可以实现静态切入点，RegexpMethodPointcut是一个通用的正则表达
	 * 式切入点，它是通过Jakarta ORO来实现的，需要把jakarta-oro-2.0.8.jar加入到ClassPath中，它的正则表达式语法和Jakarta ORO的正则表达式语法是一样的。
	 * 
	 * 2  动态切入点
	 *     动态切入点与静态切入点的区别是，它不仅限定于给点的方法和类，动态切入点还可以指定方法的参数。因为参数的变化性，所以动态切入点不能缓存，需要每次调用的时候都进行计算，
	 * 因此使用动态切入点有很大的性能损耗。当切入点需要在执行时根据参数值来调用通知时，就需要使用动态切入点。Spring提供了一个内建的动态切入点：控制流切入点。此切入点匹配基于
	 * 当前线程的调用堆栈。开发人员只有在当前线程执行时找到特定的类和特定的方法才返回true。其实大多数的切入点可以使用静态切入点，所以很少有机会创建动态切入点。
	 *     
	 * 3  自定义切入点
	 *     因为Spring中的切入点是Java类，而不是语言特性（如AspectJ），因此可以定义自定义切入点。因为AOP还没有完全成熟，Spring提供的文档在这方面也没有提供更详细的解释，
	 * 所以这里将不再对动态切入点和自定义切入点进行更加详细的介绍。
	 */
}
