package fhjunittest;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fh.forjunit.Calculator;

//@RunWith()
public class Test1HelloReturnFunction {
	
	/**
	 * Reference:
	 * JUnit单元测试框架的使用
	 * http://blog.csdn.net/mao520741111/article/details/51462215
	 * 
	 * Understand test model and test principle:
	 * Step 1: prepare environment: @BeforeClass
	 * Step 2: test case: setup(@Before) -> test(@Test) -> verify result(@Test) -> tear down(@After).
	 * Step 3: clean environment: @AfterClass
	 */

	@BeforeClass
	public static void load(){
		System.out.println(Test1HelloReturnFunction.class.getName()+"-load().");
	}
	
	@AfterClass
	public static void destroy(){
		System.out.println(Test1HelloReturnFunction.class.getName()+"-destroy().");
	}
	
	@Before
	public void setup(){
		System.out.println(this.getClass().getName()+"-setup().");
	}
	
	@Test
	public void testAdd(){
		System.out.println(this.getClass().getName()+"-testAdd().");
		Assert.assertEquals(3, Calculator.add(1, 2));
	}
	
	@Test
	public void testSubstract(){
		System.out.println(this.getClass().getName()+"-testSubstract().");
		Assert.assertEquals(1, Calculator.substract(3, 2));
	}
	
	@Test
	@Ignore("Not implemented yet.")
	public void testMultiple(){
		System.out.println(this.getClass().getName()+"-testMultiple().");
	}
	
	@Test(expected=RuntimeException.class)
	public void testDivide(){
		System.out.println(this.getClass().getName()+"-testDivide().");
		Assert.assertEquals(2, Calculator.divide(10, 0));
	}
	
	@After
	public void verfyResult(){
		System.out.println(this.getClass().getName()+"-verfyResult().");
	}
}
