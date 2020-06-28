package com.fh.springbatch.helloworld;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class HelloReader implements ItemReader<String> {

	private int count = 4;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub

		Thread.sleep(2000);
		System.out.println(this.getClass().getName() + " is finished.");
		
		return count-- > 0 ? "Hello["+count+"]" : null;
	}

}
