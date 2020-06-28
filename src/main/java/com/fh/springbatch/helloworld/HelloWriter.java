package com.fh.springbatch.helloworld;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class HelloWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub

		Thread.sleep(2000);
		System.out.println(this.getClass().getName() + " is finished.");
		
	}

}
