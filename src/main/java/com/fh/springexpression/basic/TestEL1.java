package com.fh.springexpression.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.fh.springexpression.xml.Customer;

public class TestEL1 {

	/**
	 * FH understood: 
	 * Spring Expression can use string to finish all the operations.
	 * This like dynamic sql in DB.
	 * 
	 * How to use it? (2 ways)
	 * Way 1: single use Spring Expression;
	 * Way 2: using Spring Expression with Spring context.
	 * 
	 * Use regex to read line or text file, and store column value into variable.
	 * Also we can get the value from the variables, 
	 * All the code are string, no need hardcode variable.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionParser parser=new SpelExpressionParser();
		
		//Test 1 - Basic
		Expression exp=parser.parseExpression("'Hello '+' World!'");
		String result=exp.getValue().toString();
		System.out.println(result);
		
		System.out.println(parser.parseExpression("2 > 3").getValue());
		//false
		
		//Test 2 - Advance
		System.out.println(parser.parseExpression("T(com.fh.springexpression.basic.TestEL1).add(1,2)").getValue());
		
		//Test 3 - with SPEL Context - get/set value from SPEL Context
		EvaluationContext ctx = new StandardEvaluationContext();
		
		ctx.setVariable("value1", "VALUE1");
		System.out.println(parser.parseExpression("#value1").getValue(ctx));
		
		Student stu = new Student();
		stu.setId("1001");
		stu.setName("Lucy");
		
		ctx.setVariable("lucy", stu);
		System.out.println(parser.parseExpression("#lucy").getValue(ctx));
		System.out.println(parser.parseExpression("#lucy.name").getValue(ctx));
		System.out.println(parser.parseExpression("#lucy.name.toUpperCase()").getValue(ctx));
		parser.parseExpression("#lucy.name").setValue(ctx, "Steve");
		System.out.println(parser.parseExpression("#lucy.name").getValue(ctx));
		
		System.out.println(parser.parseExpression("new com.fh.springexpression.basic.Student()").getValue());
		
		//Test 4 - with Spring Context
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("classpath:com/fh/springexpression/xml/applicationContext_expression1.xml");
		Customer cust = ctx2.getBean("customerBean", Customer.class);
		System.out.println(cust);
		
		AbstractApplicationContext aac = (AbstractApplicationContext)ctx2;
		StandardEvaluationContext ctx3 = new StandardEvaluationContext();
		ctx3.setBeanResolver(new BeanFactoryResolver(aac.getBeanFactory()));
		System.out.println("Log1: "+parser.parseExpression("#customerBean").getValue(ctx3));
//		System.out.println("Log2: "+parser.parseExpression("&customerBean").getValue(ctx3));//Failed
		System.out.println("Log3: "+parser.parseExpression("@customerBean").getValue(ctx3));
		System.out.println("Log4: "+parser.parseExpression("@customerBean.itemName").getValue(ctx3));
		//Please take case how to get value from Spring application context by using Spring expression.
	}
	
	public static int add(int a, int b){
		System.out.println("Test add function, result:"+(a+b));
		return a+b;
	}

}
