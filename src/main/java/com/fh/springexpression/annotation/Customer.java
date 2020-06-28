package com.fh.springexpression.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	//SpEL call method
	@Value("#{'Lucy'.toUpperCase()+itemBean.name+'_'+itemBean.getInfo()}")
	private String name;
	
    @Value("#{itemBean}")//SpEL call Object
    private Item item;
    
    @Value("#{itemBean.name}")//SpEL call property
    private String itemName;
    /**
     * Be careful: itemBean.name is private, 
     * when using SpEL, it will change to itemBean.getName()
     */

	@Override
	public String toString() {
		return "Name="+this.name+" itemName=" +this.itemName+" "+"Item.total="+this.item.getTotal()+" MapA="+this.mapA+" List="+this.list;
	}

    //Relational operators
	 
    @Value("#{1 == 1}") //true
    private boolean testEqual;
 
    @Value("#{1 != 1}") //false
    private boolean testNotEqual;
 
    @Value("#{1 < 1}") //false
    private boolean testLessThan;
 
    @Value("#{1 <= 1}") //true
    private boolean testLessThanOrEqual;
 
    @Value("#{1 > 1}") //false
    private boolean testGreaterThan;
 
    @Value("#{1 >= 1}") //true
    private boolean testGreaterThanOrEqual;
 
    //Logical operators , numberBean.no == 999
 
    @Value("#{numberBean.no == 999 and numberBean.no < 900}") //false
    private boolean testAnd;
 
    @Value("#{numberBean.no == 999 or numberBean.no < 900}") //true
    private boolean testOr;
 
    @Value("#{!(numberBean.no == 999)}") //false
    private boolean testNot;
 
    //Mathematical operators
 
    @Value("#{1 + 1}") //2.0
    private double testAdd;
 
    @Value("#{'1' + '@' + '1'}") //1@1
    private String testAddString;
 
    @Value("#{1 - 1}") //0.0
    private double testSubtraction;
 
    @Value("#{1 * 1}") //1.0
    private double testMultiplication;
 
    @Value("#{10 / 2}") //5.0
    private double testDivision;
 
    @Value("#{10 % 10}") //0.0
    private double testModulus ;
 
    @Value("#{2 ^ 2}") //4.0
    private double testExponentialPower;
 
    public String toString(String dummy) {
    	System.out.println(dummy);
        return "Customer [testEqual=" + testEqual + ", testNotEqual="
                + testNotEqual + ", testLessThan=" + testLessThan
                + ", testLessThanOrEqual=" + testLessThanOrEqual
                + ", testGreaterThan=" + testGreaterThan
                + ", testGreaterThanOrEqual=" + testGreaterThanOrEqual
                + ", testAnd=" + testAnd + ", testOr=" + testOr + ", testNot="
                + testNot + ", testAdd=" + testAdd + ", testAddString="
                + testAddString + ", testSubtraction=" + testSubtraction
                + ", testMultiplication=" + testMultiplication
                + ", testDivision=" + testDivision + ", testModulus="
                + testModulus + ", testExponentialPower="
                + testExponentialPower + "]";
    }

    //SpEL uses map/list
    @Value("#{testBean.map['MapA']}")
    private String mapA;
 
    @Value("#{testBean.list[0]}")
    private String list;
    
	public void setName(String name) {
		this.name = name;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setTestEqual(boolean testEqual) {
		this.testEqual = testEqual;
	}

	public void setTestNotEqual(boolean testNotEqual) {
		this.testNotEqual = testNotEqual;
	}

	public void setTestLessThan(boolean testLessThan) {
		this.testLessThan = testLessThan;
	}

	public void setTestLessThanOrEqual(boolean testLessThanOrEqual) {
		this.testLessThanOrEqual = testLessThanOrEqual;
	}

	public void setTestGreaterThan(boolean testGreaterThan) {
		this.testGreaterThan = testGreaterThan;
	}

	public void setTestGreaterThanOrEqual(boolean testGreaterThanOrEqual) {
		this.testGreaterThanOrEqual = testGreaterThanOrEqual;
	}

	public void setTestAnd(boolean testAnd) {
		this.testAnd = testAnd;
	}

	public void setTestOr(boolean testOr) {
		this.testOr = testOr;
	}

	public void setTestNot(boolean testNot) {
		this.testNot = testNot;
	}

	public void setTestAdd(double testAdd) {
		this.testAdd = testAdd;
	}

	public void setTestAddString(String testAddString) {
		this.testAddString = testAddString;
	}

	public void setTestSubtraction(double testSubtraction) {
		this.testSubtraction = testSubtraction;
	}

	public void setTestMultiplication(double testMultiplication) {
		this.testMultiplication = testMultiplication;
	}

	public void setTestDivision(double testDivision) {
		this.testDivision = testDivision;
	}

	public void setTestModulus(double testModulus) {
		this.testModulus = testModulus;
	}

	public void setTestExponentialPower(double testExponentialPower) {
		this.testExponentialPower = testExponentialPower;
	}
    
}