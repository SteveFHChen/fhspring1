package com.fh.commonslog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestApp1CommonsLog {

	protected final Log logger = LogFactory.getLog(TestApp1CommonsLog.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestApp1CommonsLog t1 = new TestApp1CommonsLog();
		t1.hello();
	}
	
	public void hello(){
		this.logger.info("Hello world.");
	}

}
