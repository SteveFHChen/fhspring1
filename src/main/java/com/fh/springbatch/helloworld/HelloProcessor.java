package com.fh.springbatch.helloworld;

import org.springframework.batch.item.ItemProcessor;

public class HelloProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub

		Thread.sleep(2000);
		System.out.println(this.getClass().getName() + " is finished.");
		
		return "HelloProcessor";
	}

}
